import java.util.Scanner;
class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;} public String getAccountNumber() {
        return accountNumber;}
    public double getBalance() {return balance; }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;} else {
            System.out.println("Insufficient balance or invalid amount.");
            return false; }}}
public class BankSystem 
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 10000);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bank Withdrawal System");
        System.out.print("Please enter your account number: ");
        String inputAccountNumber = scanner.nextLine();
        if (account.getAccountNumber().equals(inputAccountNumber)) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);} else {
            System.out.println("Invalid account number.");}scanner.close();
  }}

