import java.awt.*;
import javax.swing.*;
public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);
        JLabel welcomeLabel = new JLabel("Welcome to the Dashboard", SwingConstants.CENTER);
        panel.add(welcomeLabel, BorderLayout.CENTER);
        JButton addProgramButton = new JButton("Add Program");
        JButton addReportButton = new JButton("Add Report");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addProgramButton);
        buttonPanel.add(addReportButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        // Add Program Button Action
        addProgramButton.addActionListener(e -> new AddProgramScreen().setVisible(true));
        // Add Report Button Action
        addReportButton.addActionListener(e -> new AddReportScreen().setVisible(true));
    }
    public static void main(String[] args) {        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
