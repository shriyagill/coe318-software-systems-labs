package coe318.lab5;

public class BlackjackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    // Create a standard 52-card deck
    // Ranks: 2-14 (where 11=Jack, 12=Queen, 13=King, 14=Ace)
    // Suits: 0-3 (Clubs, Diamonds, Hearts, Spades)
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    // Deal first card to house face down
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    
    // Deal second card to house face up
    getHouseCards().add(deck.removeRandom());
    
    // Deal two cards to player face up
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    
    // Display initial hands
    ui.display();
  }

  public void play() {
    while (!houseDone || !playerDone) {
      // House's turn
      if (!houseDone) {
        // House must draw if score is 17 or less
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
      
      // Player's turn
      if (!playerDone) {
        // Ask player if they want another card
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    // Reveal house's face-down card
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /**
   * Determine the score of a pile of cards.
   * According to the lab rules:
   * - Ace (rank 14) has a score of 1
   * - Jack (11), Queen (12), King (13) have scores of 10
   * - All other cards have score equal to their rank
   *
   * @param p the pile of cards to score
   * @return the total score
   */
  public int score(CardPile p) {
    int total = 0;
    
    for (Card card : p.getCards()) {
      int rank = card.getRank();
      
      if (rank == 14) {
        // Ace has a score of 1
        total += 1;
      } else if (rank >= 11 && rank <= 13) {
        // Jack, Queen, King have scores of 10
        total += 10;
      } else {
        // All other cards (2-10) have score equal to rank
        total += rank;
      }
    }
    
    return total;
  }

  /**
   * @return the houseCards
   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /**
   * @return the yourCards
   */
  public CardPile getYourCards() {
    return yourCards;
  }

  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}