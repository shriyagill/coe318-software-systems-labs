package coe318.lab4;

/**
 * Test class for the Bank class
 * Demonstrates creating banks, adding accounts, and handling duplicates
 */
public class MainBank {

    public static void main(String[] args) {
        // Create an array of two banks
        Bank[] banks = {
            new Bank("Toronto Dominion", 3),  // Max 3 accounts
            new Bank("Bank of Montreal", 5)   // Max 5 accounts
        };
        
        // Create reference variables for easier access
        Bank td = banks[0];
        Bank bmo = banks[1];
        
        // Print TD bank (should show 0 accounts)
        System.out.println(td);
        
        // Create Charlie's account and add to TD
        Account charlie = new Account("Charles", 234, 200.00);
        td.add(charlie);
        System.out.println(td);  // Should show 1 account
        
        // Create Dora's account and add to TD
        Account dora = new Account("Dora", 456, 300.00);
        td.add(dora);
        
        // Check if TD has account number 456
        System.out.println("td has account # 456: " +
                td.hasAccountNumber(456));  // Should print true
        
        // Create Edward's account with same number as Dora (456)
        Account ed = new Account("Edward", 456, 400.00);
        
        // Try to add Ed to each bank until successful
        // TD will reject (duplicate number), BMO will accept
        for(Bank bank : banks) {
            if (bank.add(ed)) break;  // Stop after first successful add
        }
        
        // Print all banks to see final state
        for(Bank bank : banks) {
            System.out.println(bank);
        }
    }
}