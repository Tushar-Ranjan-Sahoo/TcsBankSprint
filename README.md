# TCS Banking System

A Java-based banking system that implements various banking operations for both administrators and customers.

## Code Structure

```
bankingSystem/
├── Customer.java           # Customer data model
├── BankAdmin.java         # Admin operations
├── BankCustomer.java      # Customer operations
└── BankingSystem.java     # Main program

```

### Class Structure

1. **Customer Class**
   - Attributes: aadharNumber, firstName, lastName, email, dateOfBirth, address, contactNumber, accountNumber, balance, accountType, password, dateOfAccountCreation
   - Methods: Getters and Setters for all attributes

2. **BankAdmin Class**
   - Static Credentials: ADMIN_USERNAME = "admin", ADMIN_PASSWORD = "admin123"
   - Methods:
     - login()
     - createAccount()
     - viewAllCustomers()
     - updateCustomerDetails()
     - deleteCustomer()
     - findSecondHighestBalanceByRegion()
     - searchByAccountNumber()
     - updateBalanceByAccountType()

3. **BankCustomer Class**
   - Methods:
     - login()
     - deposit()
     - withdraw()
     - checkBalance()
     - logout()

4. **BankingSystem Class**
   - Main program with menu-driven interface
   - Handles user interactions and program flow

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Git (optional, for cloning the repository)

### Steps to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/Tushar-Ranjan-Sahoo/TcsBankSprint.git
   cd TcsBankSprint
   ```

2. **Compile the Java files**
   ```bash
   javac bankingSystem/*.java
   ```

3. **Run the program**
   ```bash
   java bankingSystem.BankingSystem
   ```

### Login Credentials

#### Admin Login
- Username: `admin`
- Password: `admin123`

#### Customer Login
- Use the account number and password provided during account creation

## Features

### Admin Features
1. Create new customer accounts
2. View all customers
3. Update customer details
4. Delete customer accounts
5. Find second highest balance by region
6. Search customers by account number
7. Update balance by account type
8. Logout

### Customer Features
1. Deposit money
2. Withdraw money
3. Check balance
4. Logout

## Account Types and Interest Rates
- Savings Account: 2% interest
- Joint Account: 3% interest
- Current Account: 5% interest
- Salary Account: 7% interest

## Requirements
- Minimum initial deposit: ₹500
- Minimum balance to maintain: ₹500
- Password requirements:
  - Minimum 8 characters
  - At least 1 uppercase letter
  - At least 1 lowercase letter
  - At least 1 special character

## Sample Data
The system comes pre-loaded with sample customer data for testing purposes.

## Contributing
Feel free to fork this repository and submit pull requests for any improvements.

## License
This project is open source and available under the MIT License.
