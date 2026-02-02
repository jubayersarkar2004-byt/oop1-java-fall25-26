package gui;

import javax.swing.*;
import java.awt.*;

public class WelcomeSplash extends JWindow {
    public WelcomeSplash() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(new Color(0, 51, 102));
        content.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

        JLabel lbl = new JLabel("  SARKAR BANK ", JLabel.CENTER);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lbl.setForeground(Color.WHITE);
        
        JLabel subLbl = new JLabel("Loading System...", JLabel.CENTER);
        subLbl.setForeground(Color.LIGHT_GRAY);

        JProgressBar progress = new JProgressBar();
        progress.setIndeterminate(true);
        progress.setForeground(new Color(76, 175, 80));

        content.add(lbl, BorderLayout.CENTER);
        content.add(subLbl, BorderLayout.NORTH);
        content.add(progress, BorderLayout.SOUTH);
        
        add(content);
        setSize(500, 300);
        setLocationRelativeTo(null);
        
        SwingUtilities.invokeLater(() -> setVisible(true));
        
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) { e.printStackTrace(); }
        dispose();
    }
}
