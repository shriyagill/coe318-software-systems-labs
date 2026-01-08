package coe318.lab4;

/**
 * Represents a bank account with a name, account number, and balance.
 * Supports deposit and withdrawal operations with validation.
 * 
 * @author Shriya Gill
 */
public class Account {
    // Instance variables - these store the state of each account
    private String name;           // Owner's name
    private int accountNumber;     // Unique account number
    private double balance;        // Current balance
    
    /**
     * Constructor - initializes a new Account object
     * 
     * @param name The owner's name
     * @param number The account number
     * @param initialBalance The starting balance
     */
    public Account(String name, int number, double initialBalance) {
        this.name = name;                    // Store the owner's name
        this.accountNumber = number;         // Store the account number
        this.balance = initialBalance;       // Set initial balance
    }
    
    /**
     * Returns the account owner's name
     * getter methods
     * @return The name of the account owner
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the current balance
     * 
     * @return The current account balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Returns the account number
     * 
     * @return The account number
     */
    public int getNumber() {
        return accountNumber;
    }
    
    /**
     * Deposits money into the account
     * Only allows positive amounts
     * 
     * @param amount The amount to deposit
     * @return true if successful, false if amount is zero or negative
     */
    public boolean deposit(double amount) {
        // Check if amount is valid (must be positive)
        if (amount <= 0) {
            return false;  // Reject zero or negative deposits
        }
        
        // Add the amount to the balance
        balance += amount;
        return true;  // Deposit successful
    }
    
    /**
     * Withdraws money from the account
     * Only allows positive amounts that don't exceed the balance
     * 
     * @param amount The amount to withdraw
     * @return true if successful, false if invalid amount or insufficient funds
     */
    public boolean withdraw(double amount) {
        // Check if amount is valid (must be positive)
        if (amount <= 0) {
            return false;  // Reject zero or negative withdrawals
        }
        
        // Check if there are sufficient funds
        if (amount > balance) {
            return false;  // Reject if trying to withdraw more than available
        }
        
        // Subtract the amount from the balance
        balance -= amount;
        return true;  // Withdrawal successful
    }
    
    /**
     * Returns a string representation of the account
     * Format: (Name, AccountNumber, $Balance)
     * 
     * @return Formatted string with account details
     */
    @Override
    public String toString() {  // DO NOT MODIFY
        return "(" + getName() + ", " + getNumber() + ", " +
                String.format("$%.2f", getBalance()) + ")";
    }
}