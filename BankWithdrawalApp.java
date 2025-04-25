import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
public class BankWithdrawalApp {
    private static BankAccount account = new BankAccount("123456789", 10000);
    public static void main(String[] args) {
        // Create the JFrame for the application
        JFrame frame = new JFrame("Bank Withdrawal System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // Create components
        JLabel accountLabel = new JLabel("Account Number:");
        JTextField accountField = new JTextField(15);
        JLabel amountLabel = new JLabel("Withdrawal Amount:");
        JTextField amountField = new JTextField(15);
        JButton withdrawButton = new JButton("Withdraw");
        JLabel resultLabel = new JLabel();
        // Add Action Listener for the button
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountField.getText();
                double amount;
                try {
                    amount = Double.parseDouble(amountField.getText());
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid amount. Please enter a valid number.");
                    return;
                }
                if (account.getAccountNumber().equals(accountNumber)) {
                    boolean success = account.withdraw(amount);
                    if (success) {
                        resultLabel.setText("Withdrawal successful! New balance: " + account.getBalance());
                    } else {
                        resultLabel.setText("Insufficient balance or invalid amount.");
                    }
                } else {
                    resultLabel.setText("Invalid account number.");
                }
            }
        });
        // Create the layout for the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(accountLabel);
        panel.add(accountField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(new JLabel()); // Empty space
        panel.add(withdrawButton);
        panel.add(new JLabel()); // Empty space
        panel.add(resultLabel);
        // Add panel to frame and make it visible
        frame.add(panel);
        frame.setVisible(true);
    }
}
