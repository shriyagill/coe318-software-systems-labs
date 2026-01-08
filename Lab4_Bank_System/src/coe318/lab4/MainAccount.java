package coe318.lab4;

/**
 * Test class for the Account class
 * This runs various operations to verify Account functionality
 */
public class MainAccount {

    public static void main(String[] args) {
        // Create two accounts
        Account alice = new Account("Alice", 123, 100.00);
        Account bob = new Account("Bob", 789, 0);
        
        // Print Bob's account (should show $0.00)
        System.out.println(bob);
        
        // Print Alice's account (should show $100.00)
        System.out.println(alice);
        
        // Test valid withdrawal: Alice withdraws $15
        alice.withdraw(15);
        System.out.println(alice);  // Should show $85.00
        
        // Test invalid withdrawal: Alice tries to withdraw $200 (insufficient funds)
        alice.withdraw(200);
        System.out.println(alice);  // Should still show $85.00 (no change)
        
        // Test invalid withdrawal: Alice tries to withdraw -$1 (negative amount)
        alice.withdraw(-1);
        System.out.println(alice);  // Should still show $85.00 (no change)
        
        // Alice deposits $150, then withdraws $200
        alice.deposit(150);   // Balance becomes $235.00
        alice.withdraw(200);  // Balance becomes $35.00
        System.out.println(alice);  // Should show $35.00
        
        // Bob deposits $300
        bob.deposit(300);
        System.out.println(bob);  // Should show $300.00
        
        // Bob withdraws $100
        bob.withdraw(100);
        System.out.println(bob);  // Should show $200.00
    }
}