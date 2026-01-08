package coe318.lab4;

/**
 * Represents a bank that manages multiple accounts
 * Prevents duplicate account numbers and enforces maximum capacity
 * 
 * @author Shriya Gill
 */
public class Bank {
    private String name;              // Bank's name
    private Account[] accounts;       // Array to store accounts
    private int numAccounts;          // Counter for active accounts

    /**
     * Constructor - creates a new Bank with a maximum capacity
     * 
     * @param name The bank's name
     * @param maxNumberAccounts Maximum number of accounts allowed
     */
    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts];  // Create array with max size
        numAccounts = 0;                            // Start with 0 accounts
    }

    /**
     * Returns the bank's name
     * 
     * @return The name of the bank
     */
    public String getName() {
        return name;  // Return the bank's name
    }

    /**
     * Returns the number of active accounts
     * 
     * @return The current number of accounts in the bank
     */
    public int getNumAccounts() {
        return numAccounts;  // Return the account counter
    }

    /**
     * Returns the array of accounts
     * 
     * @return The accounts array
     */
    public Account[] getAccounts() {
        return accounts;  // Return the array reference
    }

    /**
     * Checks if an account with the given number already exists
     * Uses a loop to search through all active accounts
     * 
     * @param accountNumber The account number to search for
     * @return true if account exists, false otherwise
     */
    public boolean hasAccountNumber(int accountNumber) {
        // Loop through all active accounts
        for (int i = 0; i < numAccounts; i++) {
            // Check if this account has the matching number
            if (accounts[i].getNumber() == accountNumber) {
                return true;  // Found a match
            }
        }
        return false;  // No match found
    }

    /**
     * Adds an account to the bank
     * Fails if: account number already exists OR bank is at capacity
     * 
     * @param account The account to add
     * @return true if successful, false if unable to add
     */
    public boolean add(Account account) {
        // Check if bank is already at maximum capacity
        if (numAccounts >= accounts.length) {
            return false;  // Bank is full
        }
        
        // Check if account number already exists in this bank
        if (hasAccountNumber(account.getNumber())) {
            return false;  // Duplicate account number not allowed
        }
        
        // Add the account to the next available slot
        accounts[numAccounts] = account;
        
        // Increment the counter
        numAccounts++;
        
        return true;  // Successfully added
    }

    /**
     * Returns a string representation of the bank and all its accounts
     * 
     * @return Formatted string with bank details and account list
     */
    @Override
    public String toString() {
        // DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n   " + account;
        }
        return s;
    }
}