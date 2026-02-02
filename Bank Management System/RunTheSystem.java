import gui.LoginGUI;
import gui.WelcomeSplash;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RunTheSystem {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Could not set system look and feel.");
        }
        
        new WelcomeSplash();
        
        SwingUtilities.invokeLater(() -> {
            new LoginGUI();
        });
    }
}
    