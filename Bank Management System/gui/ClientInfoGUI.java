package gui;

import entity.Account;
import fileio.AccountFileHandler;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ClientInfoGUI extends JFrame {
    private JTextField txtSearch;
    private JTextArea detailsArea;

    public ClientInfoGUI() {
        setTitle("Client Detailed Information");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        top.add(new JLabel("Enter Account No:"));
        txtSearch = new JTextField(15);
        JButton btnSearch = new JButton("SEARCH");
        btnSearch.addActionListener(e -> fetchDetails());
        top.add(txtSearch); top.add(btnSearch);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        detailsArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(detailsArea), BorderLayout.CENTER);
        setVisible(true);
    }

    private void fetchDetails() {
        String id = txtSearch.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Account number cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
            detailsArea.setText("");
            return;
        }

        try {
            ArrayList<Account> list = AccountFileHandler.getAllAccounts();
            boolean found = false;
            for (Account a : list) {
                if (a.getAccountNo().equalsIgnoreCase(id)) {
                    String loanStatus = checkLoanStatus(a); 
                    
                    String info = String.format(
                        "--- CUSTOMER PROFILE ---\n" +
                        "Name     : %s\n" +
                        "Account  : %s\n" +
                        "Balance  : $%,.2f\n" +
                        "Age      : %s\n" + 
                        "Address  : %s\n" +
                        "Email    : %s\n" +
                        "Phone    : %s\n" +
                        "Type     : %s\n" +
                        "Salary   : $%,.2f\n" + 
                        "Score    : %d\n" +     
                        "Record   : %b\n" +     
                        "------------------------\n" +
                        "LOAN STATUS:\n%s",
                        a.getName(), a.getAccountNo(), a.getBalance(), a.getAge(), a.getAddress(),
                        a.getEmail(), a.getPhone(), a.getAccType(), a.getSalary(), a.getCreditScore(), a.hasCriminalRecord(),
                        loanStatus
                    );
                    detailsArea.setText(info);
                    found = true;
                    break;
                }
            }
            if (!found) {
                detailsArea.setText("Client with Account No: " + id + " not found.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading account data from file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            detailsArea.setText("Error reading data.");
        } finally {
            txtSearch.setText("");
        }
    }
    
    private String checkLoanStatus(Account acc) {
        if (acc.hasCriminalRecord()) {
            return "DENIED: Flagged criminal record.";
        }
        if (acc.getCreditScore() < 600) {
            return "DENIED: Low credit score (<600).";
        }

        double maxLoan = acc.getSalary() * 0.5;
        String terms = "Interest Rate: 5.5% fixed. Term: 36 months.";

        if (acc.getCreditScore() >= 800) {
            maxLoan = acc.getSalary(); 
            terms = "Interest Rate: 3.0% fixed. Term: 60 months.";
        }
        
        if (maxLoan < 1000) {
            return "DENIED: Insufficient salary/balance for minimum loan amount.";
        }

        return String.format("Status: Approved\nMax Loan: $%,.2f\nTerms: %s", maxLoan, terms);
    }
}
