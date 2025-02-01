import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PatientDiagnosisSystem {
    private JFrame frame;
    private JTextField patientNameField;
    private JTextField diagnosisField;
    private JComboBox<String> conditionCombo;
    private final String FILENAME = "patients.txt";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new PatientDiagnosisSystem().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame("Patient Diagnosis System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(new BorderLayout());

        createTopButtons();
        createMainForm();

        frame.setVisible(true);
    }

    private void createTopButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.CYAN);

        JButton aboutButton = new JButton("About Us");
        styleButton(aboutButton, 12);
        aboutButton.addActionListener(e -> aboutUs());
        buttonPanel.add(aboutButton);

        JButton exitButton = new JButton("Exit");
        styleButton(exitButton, 12);
        exitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(exitButton);

        JButton deleteButton = new JButton("Delete All Files");
        styleButton(deleteButton, 12);
        deleteButton.addActionListener(e -> deleteFiles());
        buttonPanel.add(deleteButton);

        frame.add(buttonPanel, BorderLayout.NORTH);
    }

    private void createMainForm() {
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 20, 20));
        formPanel.setBackground(Color.CYAN);
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        addFormField(formPanel, "Patient's Name:", patientNameField = new JTextField());
        addFormField(formPanel, "Diagnosed with:", diagnosisField = new JTextField());
        
        conditionCombo = new JComboBox<>(new String[]{"Select", "Low", "Mid", "Critical"});
        conditionCombo.setFont(new Font("Arial", Font.PLAIN, 16));
        addFormField(formPanel, "Condition:", conditionCombo);

        JButton submitButton = new JButton("Submit");
        styleButton(submitButton, 16);
        submitButton.addActionListener(e -> submitPatient());
        formPanel.add(submitButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.CYAN);
        centerPanel.add(formPanel);
        frame.add(centerPanel, BorderLayout.CENTER);
    }

    private void addFormField(JPanel panel, String label, JComponent field) {
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        jLabel.setBackground(Color.CYAN);
        panel.add(jLabel);
        panel.add(field);
    }

    private void styleButton(JButton button, int size) {
        button.setFont(new Font("Arial", Font.PLAIN, size));
        button.setBackground(new Color(173, 216, 230));
    }

    private void submitPatient() {
        String name = patientNameField.getText().trim();
        String diagnosis = diagnosisField.getText().trim();
        String condition = (String) conditionCombo.getSelectedItem();

        if (name.isEmpty() || diagnosis.isEmpty() || "Select".equals(condition)) {
            showWarning("Please fill in all fields.");
            return;
        }

        if (patientExists(name)) {
            showWarning("Patient's name already exists.");
            return;
        }

        try (FileWriter fw = new FileWriter(FILENAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(String.format("Patient: %s, Diagnose: %s, Condition: %s%n", 
                     name, diagnosis, condition));
            JOptionPane.showMessageDialog(frame, "Patient information submitted successfully!", 
                                        "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (IOException e) {
            showError("Error saving patient data: " + e.getMessage());
        }
    }

    private boolean patientExists(String name) {
        File file = new File(FILENAME);
        if (!file.exists()) return false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("Patient: " + name)) return true;
            }
        } catch (IOException e) {
            showError("Error reading patient data: " + e.getMessage());
        }
        return false;
    }

    private void aboutUs() {
        JOptionPane.showMessageDialog(frame, 
            "We are striving to improve the global healthcare system, advancing with every passing second.",
            "About Us", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteFiles() {
        JDialog passwordDialog = new JDialog(frame, "Authorization Access 001", true);
        passwordDialog.setSize(400, 200);
        passwordDialog.setLayout(new BorderLayout());
        passwordDialog.getContentPane().setBackground(Color.CYAN);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Enter password to delete all info");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(label);

        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton submitButton = new JButton("Submit");
        styleButton(submitButton, 14);
        submitButton.addActionListener(e -> {
            if (new String(passwordField.getPassword()).equals("NatzuiHealthIS")) {
                if (new File(FILENAME).delete()) {
                    JOptionPane.showMessageDialog(passwordDialog, 
                        "All files deleted successfully.", "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(passwordDialog, 
                        "Error: File not found.", "Info", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
                passwordDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(passwordDialog, 
                    "Incorrect password access.", "Warning", 
                    JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
            }
        });
        panel.add(submitButton);

        passwordDialog.add(panel, BorderLayout.CENTER);
        passwordDialog.setLocationRelativeTo(frame);
        passwordDialog.setVisible(true);
    }

    private void clearFields() {
        patientNameField.setText("");
        diagnosisField.setText("");
        conditionCombo.setSelectedIndex(0);
    }

    private void showWarning(String message) {
        JOptionPane.showMessageDialog(frame, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}