package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        // Display the House's cards
        System.out.println("House holds:");
        for (Card card : game.getHouseCards().getCards()) {
            System.out.println("  " + card);
        }
        
        // Display the player's cards
        System.out.println("You hold:");
        for (Card card : game.getYourCards().getCards()) {
            System.out.println("  " + card);
        }
        System.out.println();  // Blank line for readability
    }

    @Override
    public boolean hitMe() {
        // Ask the player if they want another card
        System.out.print("Another card? (y/n): ");
        String answer = user.nextLine().trim().toLowerCase();
        
        // Return true if they answered 'y' or 'yes'
        return answer.equals("y") || answer.equals("yes");
    }

    @Override
    public void gameOver() {
        // Display final state
        System.out.println("Game over!");
        System.out.println("House holds:");
        for (Card card : game.getHouseCards().getCards()) {
            System.out.println("  " + card);
        }
        
        System.out.println("You hold:");
        for (Card card : game.getYourCards().getCards()) {
            System.out.println("  " + card);
        }
        
        // Calculate and display scores
        int houseScore = game.score(game.getHouseCards());
        int yourScore = game.score(game.getYourCards());
        
        System.out.println("\nYour score: " + yourScore + ", House score: " + houseScore);
        
        // Determine and display the winner
        if (yourScore > 21) {
            System.out.println("You busted! The House wins.");
        } else if (houseScore > 21) {
            System.out.println("House busted! You win!");
        } else if (yourScore > houseScore) {
            System.out.println("You win!");
        } else if (yourScore == houseScore) {
            System.out.println("It's a tie! The House wins.");
        } else {
            System.out.println("The House wins.");
        }
    }
}