package bankingSystem;

import java.util.Scanner;

public class BankingSystem {
    private static BankAdmin admin;
    private static BankCustomer customer;
    private static Scanner scanner;

    public static void main(String[] args) {
        admin = new BankAdmin();
        customer = new BankCustomer(admin.getCustomers());
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Banking System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    customerLogin();
                    break;
                case 3:
                    System.out.println("Thank you for using Banking System!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void adminLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            System.out.println("Admin login successful!");
            adminMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer Details");
            System.out.println("4. Delete Customer");
            System.out.println("5. Find Second Highest Balance by Region");
            System.out.println("6. Search Customer by Account Number");
            System.out.println("7. Update Balance by Account Type");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    admin.createAccount();
                    break;
                case 2:
                    admin.viewAllCustomers();
                    break;
                case 3:
                    admin.updateCustomerDetails();
                    break;
                case 4:
                    admin.deleteCustomer();
                    break;
                case 5:
                    admin.findSecondHighestBalanceByRegion();
                    break;
                case 6:
                    admin.searchByAccountNumber();
                    break;
                case 7:
                    admin.updateBalanceByAccountType();
                    break;
                case 8:
                    System.out.println("Logged out successfully!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void customerLogin() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (customer.login(accountNumber, password)) {
            System.out.println("Customer login successful!");
            customerMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void customerMenu() {
        while (true) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    customer.deposit();
                    break;
                case 2:
                    customer.withdraw();
                    break;
                case 3:
                    customer.checkBalance();
                    break;
                case 4:
                    customer.logout();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
} 