package coe318.lab5;

public class Card implements Comparable {
  //Symbolic constants
  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  // Instance variables
  private int rank;    // 2-14 (Jack=11, Queen=12, King=13, Ace=14)
  private int suit;    // 0-3 (Clubs, Diamonds, Hearts, Spades)
  private boolean faceUp;  // true if card is face up

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  public Card(int rank, int suit, boolean faceUp) {
    this.rank = rank;
    this.suit = suit;
    this.faceUp = faceUp;
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return faceUp;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rank;
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;
    // Two cards are equal if they have the same rank AND suit
    return this.rank == c.rank && this.suit == c.suit;
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  /**
   * Compare this card to another card.
   * First compare by rank (higher rank is "bigger")
   * If ranks are equal, compare by suit (Clubs < Diamonds < Hearts < Spades)
   * 
   * @param c the card to compare to
   * @return negative if this < c, zero if equal, positive if this > c
   */
  public int compareTo(Card c) {
    // First compare by rank
    if (this.rank != c.rank) {
      return this.rank - c.rank;
    }
    // If ranks are equal, compare by suit
    return this.suit - c.suit;
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
    switch (rank) {
      case 14:
        return "Ace";
      case 13:
        return "King";
      case 12:
        return "Queen";
      case 11:
        return "Jack";
      default:
        return String.valueOf(rank);  // Returns "2" through "10"
    }
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
    switch (suit) {
      case CLUB:
        return "Clubs";
      case DIAMOND:
        return "Diamonds";
      case HEART:
        return "Hearts";
      case SPADE:
        return "Spades";
      default:
        return "Unknown";
    }
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    if (!faceUp) {
      return "?";
    }
    return getRankString() + " of " + getSuitString();
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}