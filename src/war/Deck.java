package war;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Consists of a list of 52 cards
 */
public class Deck {
	
	protected ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		initializeDeck();
	}
	
	
	/**
	 *  Populates a deck with 13 cards of each suit, each having a value between 2 and 14 
	 */
	private void initializeDeck() {
		
		for(Suit suit : Suit.values() ) {
			for(Rank rank : Rank.values() ) {
				cards.add(new Card(suit, rank));
				
			}
		}
		
	}
	
	/** 
	 * Shuffles a deck, creating a list of cards in a random order 
	 */
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	
	/**
	 * Gets the card on top of the deck 
	 * @param index 	Location of the card in the deck 
	 * @return			Card in the deck at the specified index 
	 */
	public Card getNextCard(int index) {
		return cards.get(index);
	}
	
	
	/**
	 * Prints the deck, used for debugging purposes 
	 */
	public void printDeck(Deck deck) {
		
		for(int i = 0; i < deck.cards.size(); i++) {
			Card currentCard = deck.cards.get(i);
			System.out.print(currentCard.rank + "\t" + currentCard.suit + "\t" + currentCard.rank.getValue());
			System.out.println();
		}
		
	}
}

