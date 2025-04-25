import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SignUpForm extends JFrame {
    private Font mainFont = new Font("Segoe UI", Font.BOLD, 18);
    private JTextField tfName, tfEmail;
    private JPasswordField pfPassword, pfConfirmPassword;
    private JButton btnRegister;
    public void initialize() {
        // ====== Title Label ======
        JLabel lbTitle = new JLabel("Sign Up Form", SwingConstants.CENTER);
        lbTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        // ====== Form Fields ======
        JLabel lbName = new JLabel("Full Name");
        lbName.setFont(mainFont);
        tfName = new JTextField();
        tfName.setFont(mainFont);
        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(mainFont);
        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);
        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);
        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);
        JLabel lbConfirmPassword = new JLabel("Confirm Password");
        lbConfirmPassword.setFont(mainFont);
        pfConfirmPassword = new JPasswordField();
        pfConfirmPassword.setFont(mainFont);
        btnRegister = new JButton("Sign Up");
        btnRegister.setFont(mainFont);
        btnRegister.setBackground(new Color(0, 153, 255));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.addActionListener(e -> registerAction());
        // ====== Layout ======
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.add(lbName);
        formPanel.add(tfName);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.add(lbConfirmPassword);
        formPanel.add(pfConfirmPassword);
        formPanel.add(new JLabel());
        formPanel.add(btnRegister);
        // ====== Main Container ======
        setTitle("Sign Up Form");
        setLayout(new BorderLayout());
        add(lbTitle, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null); // Center
        setVisible(true);
    }
    private void registerAction() {
        String name = tfName.getText();
        String email = tfEmail.getText();
        String password = new String(pfPassword.getPassword());
        String confirmPassword = new String(pfConfirmPassword.getPassword());
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration successful for " + name + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String[] args) {
        SignUpForm form = new SignUpForm();
        form.initialize();
    }
}
