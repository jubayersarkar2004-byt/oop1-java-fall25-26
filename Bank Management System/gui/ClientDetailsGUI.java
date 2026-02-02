package gui;

import entity.Account;
import fileio.AccountFileHandler;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ClientDetailsGUI extends JFrame {
    private Account tempAccount;
    private Map<String, JTextField> fields = new HashMap<>();
    private JComboBox<String> accTypeCombo;
    private JCheckBox criminalRecordCheckbox;

    public ClientDetailsGUI(Account acc) {
        this.tempAccount = acc;
        setTitle("Finalize Client Details for " + acc.getName());
        setSize(500, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] labels = {"Age:", "Address:", "Email:", "Phone:", "Account Type:", "Annual Salary ($):", "Credit Score (0-850):"};
        for (String label : labels) {
            panel.add(new JLabel(label));
            if (label.equals("Account Type:")) {
                accTypeCombo = new JComboBox<>(new String[]{"Savings", "Current", "Loan"});
                panel.add(accTypeCombo);
            } else {
                JTextField field = new JTextField();
                fields.put(label, field);
                panel.add(field);
            }
        }
        
        panel.add(new JLabel("Has Criminal Record?"));
        criminalRecordCheckbox = new JCheckBox("Yes");
        panel.add(criminalRecordCheckbox);

        JButton saveButton = new JButton("Save and Finish");
        saveButton.addActionListener(e -> saveDetails());
        
        add(panel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.add(saveButton);
        add(southPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private void saveDetails() {
        String age = fields.get("Age:").getText().trim();
        String address = fields.get("Address:").getText().trim();
        String email = fields.get("Email:").getText().trim();
        String phone = fields.get("Phone:").getText().trim();
        String accType = (String) accTypeCombo.getSelectedItem();
        String salaryStr = fields.get("Annual Salary ($):").getText().trim();
        String scoreStr = fields.get("Credit Score (0-850):").getText().trim();
        boolean hasRecord = criminalRecordCheckbox.isSelected();

        if (age.isEmpty() || salaryStr.isEmpty() || scoreStr.isEmpty() || address.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Please fill all mandatory fields."); return;
        }

        try {
            Account finalAcc = new Account(
                tempAccount.getAccountNo(), tempAccount.getName(), tempAccount.getBalance(),
                age, address, email, phone, accType, 
                Double.parseDouble(salaryStr), Integer.parseInt(scoreStr), hasRecord
            );

            AccountFileHandler.addAccount(finalAcc);
            JOptionPane.showMessageDialog(this, "Account and details saved successfully!");
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for salary/score/age.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving account details: " + ex.getMessage());
        }
    }
}
