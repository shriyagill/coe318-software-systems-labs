package coe318.lab5;

import java.util.ArrayList;
import java.util.Random;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;

    /**
     * Constructor - creates an empty pile of cards
     */
    public CardPile() {
        // Initialize the ArrayList to hold cards
        cards = new ArrayList<>();
    }
    
    /**
     * Add a card to the pile.
     * @param card the card to add
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return the randomly selected card
     */
    public Card removeRandom() {
        if (cards.isEmpty()) {
            return null;
        }
        
        // Create a Random object to generate random numbers
        Random random = new Random();
        
        // Generate a random index between 0 and cards.size()-1
        int randomIndex = random.nextInt(cards.size());
        
        // Remove and return the card at that random index
        return cards.remove(randomIndex);
    }

    /**
     * The string representation is a space separated list
     * of each card.
     * @return string representation of the pile
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < cards.size(); i++) {
            result.append(cards.get(i).toString());
            // Add a space after each card except the last one
            if (i < cards.size() - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
    
    /**
     * @return the cards ArrayList
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());
        }
    }
}