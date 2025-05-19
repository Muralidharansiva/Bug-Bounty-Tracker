import java.awt.*;
import javax.swing.*;
public class AddProgramScreen extends JFrame {
    public AddProgramScreen() {
        setTitle("Add Program");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        add(panel);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel platformLabel = new JLabel("Platform:");
        JTextField platformField = new JTextField();
        JLabel scopeLabel = new JLabel("Scope:");
        JTextField scopeField = new JTextField();
        JButton saveButton = new JButton("Save");
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(platformLabel);
        panel.add(platformField);
        panel.add(scopeLabel);
        panel.add(scopeField);
        panel.add(new JLabel()); // Empty cell
        panel.add(saveButton);
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String platform = platformField.getText();
            String scope = scopeField.getText();
            ProgramManager.addProgram(name, platform, scope);
            JOptionPane.showMessageDialog(null, "Program added successfully!");
            dispose();
        });
    }
}
