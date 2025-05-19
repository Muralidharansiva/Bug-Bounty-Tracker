import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Bug Bounty Tracker - Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        add(panel);
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        JButton loginButton = new JButton("Login");
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel()); // Empty cell
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true);
                dispose();
            }
        });
        loginButton.addActionListener(e -> {
            new Dashboard().setVisible(true);
            dispose();
        });
        
        
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen().setVisible(true));
    }
}
