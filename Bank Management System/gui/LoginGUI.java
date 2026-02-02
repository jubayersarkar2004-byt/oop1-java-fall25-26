package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class LoginGUI extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private static final String USER_FILE = "users.txt";

    public LoginGUI() {
        setTitle("Bank Login System");
        setSize(400, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel mainContainer = new JPanel(new GridLayout(2, 1, 5, 5));
        mainContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p1.add(new JLabel("Username: "));
        txtUser = new JTextField(15);
        p1.add(txtUser);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(new JLabel("Password: "));
        txtPass = new JPasswordField(15);
        p2.add(txtPass);

        mainContainer.add(p1); 
        mainContainer.add(p2);

        JButton btnLogin = new JButton("UNLOCK SYSTEM");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setPreferredSize(new Dimension(150, 40));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        
        getRootPane().setDefaultButton(btnLogin);
        btnLogin.addActionListener(e -> checkLogin());

        add(mainContainer, BorderLayout.CENTER);
        add(btnLogin, BorderLayout.SOUTH);
        
        ensureUserFileExists();
        setVisible(true);
    }

    private void ensureUserFileExists() {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                try (PrintWriter out = new PrintWriter(file)) {
                    out.println("admin,admin123"); 
                }
            } catch (IOException e) {
                System.err.println("Could not initialize credentials file.");
            }
        }
    }

    private void checkLogin() {
        String user = txtUser.getText().trim();
        String pass = new String(txtPass.getPassword());
        boolean found = false;

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both credentials.");
            return;
        }

        try (Scanner sc = new Scanner(new File(USER_FILE))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) continue;
                
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(user) && parts[1].equals(pass)) {
                    found = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Credentials file 'users.txt' is missing!");
            return;
        }

        if (found) {
            SwingUtilities.invokeLater(() -> {
                new BankManagementGUI(); 
                this.dispose(); 
            });
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            txtPass.setText("");
        }
    }
}
