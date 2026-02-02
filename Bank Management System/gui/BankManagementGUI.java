package gui;

import entity.Account;
import fileio.AccountFileHandler;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BankManagementGUI extends JFrame {
    private JTextField txtAccNo, txtName, txtAmount;
    private JTextArea textArea;
    private BufferedImage backgroundImage;
    
    // Define color scheme
    Color clrPanelBg = new Color(255, 255, 255);      
    Color clrTextFg = Color.BLACK;                    
    Color clrPrimary = new Color(0, 102, 204);        
    Color clrSuccess = new Color(76, 175, 80);        
    Color clrDanger = new Color(244, 67, 54);         
    Color clrSecondary = new Color(255, 200, 0);      
    Color clrLabelText = Color.BLACK;                 

     // Constructor to set up the GUI
    public BankManagementGUI() {
        setTitle(" Bank Management System");
        setSize(950, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            backgroundImage = ImageIO.read(new File("images/bank_bg.jpg")); 
        } catch (IOException e) {
            System.out.println("Note: images/bank_bg.jpg not found. Using plain background.");
        }

        
        BackgroundPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));// Padding
        setContentPane(mainPanel);

        JLabel head = new JLabel(" BANKING DASHBOARD", JLabel.CENTER);
        head.setForeground(clrPrimary);
        head.setFont(new Font("Segoe UI", Font.BOLD, 32));
        head.setOpaque(false); 
        add(head, BorderLayout.NORTH);

        // Input Panel on the West side
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 15, 15));
        inputPanel.setBackground(clrPanelBg); 
        inputPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); 
        
        // Styled Text Fields
        txtAccNo = createStyledField();
        txtName = createStyledField();
        txtAmount = createStyledField();

        // Adding Labels and TextFields to Input Panel
        inputPanel.add(createLabel("ACCOUNT NUMBER:")); 
        inputPanel.add(txtAccNo);
        inputPanel.add(createLabel("HOLDER NAME:"));   
        inputPanel.add(txtName);
        inputPanel.add(createLabel("AMOUNT ($):"));    
        inputPanel.add(txtAmount);
        
    
        JPanel westWrapper = new JPanel(new BorderLayout());
        westWrapper.setOpaque(false); 
        westWrapper.add(inputPanel, BorderLayout.NORTH);
        add(westWrapper, BorderLayout.WEST);

        // Text Area in the Center
        textArea = new JTextArea();
        textArea.setBackground(clrPanelBg); 
        textArea.setForeground(clrTextFg); 
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        textArea.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBorder(BorderFactory.createLineBorder(clrPrimary, 1));
        add(scroll, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        btnPanel.setBackground(clrPanelBg); 
        btnPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        // Buttons with actions
        btnPanel.add(createButton("CREATE", clrPrimary, e -> addAccount()));
        btnPanel.add(createButton("DEPOSIT", clrSuccess, e -> handleTransaction(true)));
        btnPanel.add(createButton("WITHDRAW", clrDanger, e -> handleTransaction(false)));
        btnPanel.add(createButton("VIEW ALL", clrSecondary, e -> viewAccounts()));
        btnPanel.add(createButton("DELETE", Color.BLACK, e -> deleteAccount())); 
        btnPanel.add(createButton("CLIENT INFO", new Color(153, 50, 204), e -> openClientInfo()));

        add(btnPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    // Handles adding a new account
    private void addAccount() {
        try {
            String id = txtAccNo.getText().trim();
            String name = txtName.getText().trim();
            double bal = Double.parseDouble(txtAmount.getText().trim());
            
            if(id.isEmpty() || name.isEmpty() || bal <= 0) throw new IllegalArgumentException("ID, Name must be set, and initial balance must be positive.");

            Account tempAcc = new Account(id, name, bal);
            
            // Open the new GUI to capture remaining 11 details
            new ClientDetailsGUI(tempAcc); 

            clearFields();

        } catch (NumberFormatException e) { 
            JOptionPane.showMessageDialog(this, "Error: Invalid Amount Input!"); 
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        } catch (Exception ex) { 
            JOptionPane.showMessageDialog(this, "Error processing request!"); 
        }
    }



    // Handles deposit or withdrawal transactions
    private void handleTransaction(boolean isDeposit) {
        try {
            String id = txtAccNo.getText().trim();
            double amt = Double.parseDouble(txtAmount.getText().trim());
            
            AccountFileHandler.updateBalance(id, amt, isDeposit);
            JOptionPane.showMessageDialog(this, (isDeposit ? "Deposited $" : "Withdrawn $") + amt);
            viewAccounts();
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Transaction Failed: " + ex.getMessage()); }
    }

    // Displays all accounts in the text area
    private void viewAccounts() {
        try {
            textArea.setText(String.format("%-13s | %-17s | %-12s | %-15s\n", "ACC NO", "NAME", "TYPE", "BALANCE"));
            textArea.append("----------------------------------------------------------------------------------\n");
            for (Account acc : AccountFileHandler.getAllAccounts()) {
                if (acc != null) textArea.append(acc.toString() + "\n");
            }
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    // Deletes an account by account number
    private void deleteAccount() {
        try {
            String id = txtAccNo.getText().trim();
            AccountFileHandler.deleteAccount(id);
            JOptionPane.showMessageDialog(this, "Account Deleted!");
            viewAccounts();
        } catch (IOException ex) { JOptionPane.showMessageDialog(this, "Error deleting account."); }
    }

    private void openClientInfo() {
        new ClientInfoGUI();
    }


    private void clearFields() {
        txtAccNo.setText("");
        txtName.setText("");
        txtAmount.setText("");
    }

    private JLabel createLabel(String text) {
        JLabel l = new JLabel(text);
        l.setForeground(clrLabelText); 
        l.setFont(new Font("Segoe UI", Font.BOLD, 12));
        return l;
    }

    private JTextField createStyledField() {
        JTextField f = new JTextField(15); 
        f.setBackground(Color.WHITE); 
        f.setForeground(Color.BLACK); 
        f.setCaretColor(Color.BLACK); 
        f.setBorder(BorderFactory.createLineBorder(clrPrimary, 1));
        return f; 
    }
    
    private JButton createButton(String text, Color bg, java.awt.event.ActionListener action) {
        JButton b = new JButton(text); 
        b.setBackground(bg); 
        
        if (bg.equals(Color.BLACK) || bg.equals(clrDanger) || bg.equals(new Color(153, 50, 204))) {
             b.setForeground(Color.WHITE);
        } else {
             b.setForeground(Color.BLACK);
        }
        
        b.setFocusPainted(false); 
        b.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15)); 
        b.setFont(new Font("Segoe UI", Font.BOLD, 12));
        b.addActionListener(action);
        return b;
    }

    class BackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
            } else {
                g.setColor(new Color(240, 240, 240));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
}
