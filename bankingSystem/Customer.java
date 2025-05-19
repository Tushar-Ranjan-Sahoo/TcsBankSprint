package bankingSystem;

import java.util.Date;

public class Customer {
    private String aadharNumber;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String address;
    private String contactNumber;
    private String accountNumber;
    private double balance;
    private String accountType;
    private String password;
    private Date dateOfAccountCreation;

    public Customer(String aadharNumber, String firstName, String lastName, String email, 
                   Date dateOfBirth, String address, String contactNumber, String accountNumber, 
                   double balance, String accountType, String password) {
        this.aadharNumber = aadharNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contactNumber = contactNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.password = password;
        this.dateOfAccountCreation = new Date();
    }

    // Getters and Setters
    public String getAadharNumber() { return aadharNumber; }
    public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getDateOfAccountCreation() { return dateOfAccountCreation; }
    public void setDateOfAccountCreation(Date dateOfAccountCreation) { 
        this.dateOfAccountCreation = dateOfAccountCreation; 
    }

    @Override
    public String toString() {
        return "Customer{" +
                "aadharNumber='" + aadharNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", dateOfAccountCreation=" + dateOfAccountCreation +
                '}';
    }
} 