import java.awt.*;
import javax.swing.*;
public class AddReportScreen extends JFrame {
    public AddReportScreen() {
        setTitle("Add Report");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        add(panel);
        JLabel programIdLabel = new JLabel("Program ID:");
        JTextField programIdField = new JTextField();
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();
        JLabel severityLabel = new JLabel("Severity:");
        JTextField severityField = new JTextField();
        JLabel statusLabel = new JLabel("Status:");
        JTextField statusField = new JTextField();
        JLabel rewardLabel = new JLabel("Reward:");
        JTextField rewardField = new JTextField();
        JButton saveButton = new JButton("Save");
        panel.add(programIdLabel);
        panel.add(programIdField);
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(severityLabel);
        panel.add(severityField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(rewardLabel);
        panel.add(rewardField);
        panel.add(new JLabel()); // Empty cell
        panel.add(saveButton);
        saveButton.addActionListener(e -> {
            int programId = Integer.parseInt(programIdField.getText());
            String title = titleField.getText();
            String severity = severityField.getText();
            String status = statusField.getText();
            double reward = Double.parseDouble(rewardField.getText());
            // Call the ReportManager to save the report
            ReportManager.addReport(programId, title, severity, status, reward);
            JOptionPane.showMessageDialog(null, "Report added successfully!");
            dispose(); // Close the Add Report screen
        });
    }
}
