package bankingSystem;

import java.util.List;
import java.util.Scanner;

public class BankCustomer {
    private List<Customer> customers;
    private Scanner scanner;
    private Customer currentCustomer;

    public BankCustomer(List<Customer> customers) {
        this.customers = customers;
        this.scanner = new Scanner(System.in);
    }

    public boolean login(String accountNumber, String password) {
        currentCustomer = customers.stream()
                .filter(c -> c.getAccountNumber().equals(accountNumber) && 
                           c.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        
        return currentCustomer != null;
    }

    public void deposit() {
        if (currentCustomer == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Invalid amount! Amount must be positive.");
            return;
        }

        currentCustomer.setBalance(currentCustomer.getBalance() + amount);
        System.out.println("Deposit successful! New balance: " + currentCustomer.getBalance());
    }

    public void withdraw() {
        if (currentCustomer == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= 0) {
            System.out.println("Invalid amount! Amount must be positive.");
            return;
        }

        if (currentCustomer.getBalance() - amount < 500) {
            System.out.println("Insufficient balance! Minimum balance of 500 must be maintained.");
            return;
        }

        currentCustomer.setBalance(currentCustomer.getBalance() - amount);
        System.out.println("Withdrawal successful! New balance: " + currentCustomer.getBalance());
    }

    public void checkBalance() {
        if (currentCustomer == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.println("Current balance: " + currentCustomer.getBalance());
    }

    public void logout() {
        currentCustomer = null;
        System.out.println("Logged out successfully!");
    }
} 