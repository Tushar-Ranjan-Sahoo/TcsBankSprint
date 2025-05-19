package bankingSystem;

import java.util.*;
import java.text.SimpleDateFormat;

public class BankAdmin {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private List<Customer> customers;
    private Scanner scanner;

    public BankAdmin() {
        this.customers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        loadSampleData();
    }

    private void loadSampleData() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
            
            // Sample data
            String[][] sampleData = {
                {"180607", "Rahul Varma", "12.12.22", "Savings", "30000"},
                {"180608", "Sita Raman", "12.12.22", "Joint", "50000"},
                {"190607", "Sheetal Patil", "20.07.22", "Current", "40000"},
                {"190617", "Pooja Patil", "04.08.22", "Salary", "70000"},
                {"200607", "Rahul Sharma", "20.08.22", "SAVINGS", "20000"},
                {"210617", "Pooja Srikari", "20.08.22", "SALARY", "25000"},
                {"210607", "Pooja Rewa", "20.08.22", "joint", "35000"},
                {"210527", "Dan Stewart", "04.08.22", "current", "35000"},
                {"280707", "Sia R", "21.09.23", "Savings", "30000"},
                {"220888", "Sonali G", "01.05.23", "Savings", "15000"}
            };

            for (String[] data : sampleData) {
                String accountNumber = data[0];
                String[] nameParts = data[1].split(" ");
                String firstName = nameParts[0];
                String lastName = nameParts.length > 1 ? nameParts[1] : "";
                Date dateOfCreation = dateFormat.parse(data[2]);
                String accountType = data[3];
                double balance = Double.parseDouble(data[4]);

                Customer customer = new Customer(
                    "SAMPLE" + accountNumber, // Aadhar number
                    firstName,
                    lastName,
                    firstName.toLowerCase() + "@email.com", // Email
                    new Date(), // Date of birth
                    "Sample Address, " + accountType, // Address
                    "1234567890", // Contact number
                    accountNumber,
                    balance,
                    accountType,
                    "Password123!" // Default password
                );
                customer.setDateOfAccountCreation(dateOfCreation);
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Error loading sample data: " + e.getMessage());
        }
    }

    public boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public void createAccount() {
        System.out.println("\n=== Create New Account ===");
        
        System.out.print("Enter Aadhar Number: ");
        String aadharNumber = scanner.nextLine();
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dobStr = scanner.nextLine();
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);
        } catch (Exception e) {
            System.out.println("Invalid date format!");
            return;
        }
        
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        
        System.out.print("Enter Initial Deposit (minimum 500): ");
        double initialDeposit = Double.parseDouble(scanner.nextLine());
        
        if (initialDeposit < 500) {
            System.out.println("Initial deposit must be at least 500!");
            return;
        }
        
        System.out.print("Enter Account Type (Savings/Joint/Current/Salary): ");
        String accountType = scanner.nextLine();
        
        System.out.print("Enter Password (min 8 chars, 1 uppercase, 1 lowercase, 1 special): ");
        String password = scanner.nextLine();
        
        if (!isValidPassword(password)) {
            System.out.println("Invalid password format!");
            return;
        }
        
        String accountNumber = generateAccountNumber();
        
        Customer customer = new Customer(aadharNumber, firstName, lastName, email, 
                                       dateOfBirth, address, contactNumber, accountNumber, 
                                       initialDeposit, accountType, password);
        
        customers.add(customer);
        System.out.println("Account created successfully! Account Number: " + accountNumber);
    }

    public void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }
        
        // Sort by balance in descending order
        customers.sort((c1, c2) -> Double.compare(c2.getBalance(), c1.getBalance()));
        
        System.out.println("\n=== All Customers (Sorted by Balance) ===");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void updateCustomerDetails() {
        System.out.print("Enter Account Number to update: ");
        String accountNumber = scanner.nextLine();
        
        Customer customer = findCustomerByAccountNumber(accountNumber);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        System.out.println("Current details: " + customer);
        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Email");
        System.out.println("2. Contact Number");
        System.out.println("3. Address");
        
        int choice = Integer.parseInt(scanner.nextLine());
        
        switch (choice) {
            case 1:
                System.out.print("Enter new email: ");
                customer.setEmail(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter new contact number: ");
                customer.setContactNumber(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter new address: ");
                customer.setAddress(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.println("Customer details updated successfully!");
    }

    public void deleteCustomer() {
        System.out.print("Enter Account Number to delete: ");
        String accountNumber = scanner.nextLine();
        
        Customer customer = findCustomerByAccountNumber(accountNumber);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        
        System.out.println("Are you sure you want to delete this customer? (yes/no)");
        String confirmation = scanner.nextLine();
        
        if (confirmation.equalsIgnoreCase("yes")) {
            customers.remove(customer);
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public void findSecondHighestBalanceByRegion() {
        Map<String, List<Customer>> regionMap = new HashMap<>();
        
        // Group customers by region (assuming region is part of address)
        for (Customer customer : customers) {
            String region = customer.getAddress().split(",")[1].trim();
            regionMap.computeIfAbsent(region, k -> new ArrayList<>()).add(customer);
        }
        
        // Find second highest balance for each region
        for (Map.Entry<String, List<Customer>> entry : regionMap.entrySet()) {
            List<Customer> regionCustomers = entry.getValue();
            regionCustomers.sort((c1, c2) -> Double.compare(c2.getBalance(), c1.getBalance()));
            
            if (regionCustomers.size() >= 2) {
                Customer secondHighest = regionCustomers.get(1);
                System.out.println("\nRegion: " + entry.getKey());
                System.out.println("Second Highest Balance Customer: " + secondHighest);
            }
        }
    }

    public void searchByAccountNumber() {
        System.out.print("Enter Account Number to search: ");
        String accountNumber = scanner.nextLine();
        
        Customer customer = findCustomerByAccountNumber(accountNumber);
        if (customer == null) {
            System.out.println("Customer Details not available or Customer does not exist");
        } else {
            System.out.println("\nCustomer Details:");
            System.out.println("Account Number: " + customer.getAccountNumber());
            System.out.println("Name: " + customer.getFirstName() + " " + customer.getLastName());
            System.out.println("Account Type: " + customer.getAccountType());
            System.out.println("Balance: " + customer.getBalance());
            System.out.println("Date of Account Creation: " + customer.getDateOfAccountCreation());
        }
    }

    public void updateBalanceByAccountType() {
        for (Customer customer : customers) {
            double interestRate = 0;
            switch (customer.getAccountType().toLowerCase()) {
                case "savings":
                    interestRate = 0.02;
                    break;
                case "joint":
                    interestRate = 0.03;
                    break;
                case "current":
                    interestRate = 0.05;
                    break;
                case "salary":
                    interestRate = 0.07;
                    break;
            }
            
            double newBalance = customer.getBalance() * (1 + interestRate);
            customer.setBalance(newBalance);
        }
        
        System.out.println("Balances updated successfully!");
    }

    private Customer findCustomerByAccountNumber(String accountNumber) {
        return customers.stream()
                .filter(c -> c.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    private String generateAccountNumber() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isLowerCase(c)) hasLower = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        return hasUpper && hasLower && hasSpecial;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
} 