package war;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * Keeps track of each of the players hands 
 */
public class Hand extends Deck {
	
	protected Queue<Card> playerHand;
	protected Deck deck;
	protected Player player;
	protected int beginningIndex;
	protected int currentCardCount;
	protected int numPlayers;
	
	public Hand(Player player, Deck deck, int numPlayers) {
		
		this.deck = deck;
		playerHand = new LinkedList<>();
		currentCardCount = 0;
		this.player = player;
		this.numPlayers = numPlayers;
		dealHand();
		
	}
	
	/**
	 *  Deals the shuffled deck of cards to each player, starting with player 1 and alternating each card
	 *  Each player gets 26 cards 
	 */
	private void dealHand() {	
		
		if(player.playerNumber == 1)
			beginningIndex = 0;
		else if(player.playerNumber == 2)
			beginningIndex = 1;
		else if(player.playerNumber == 3)
			beginningIndex = 2;
		
		if(numPlayers == 3)
			dealThreePlayers();
		
		else { 
			for(int i = beginningIndex; i < 52; i+=2) {
				Card dealtCard = deck.getNextCard(i);
				playerHand.add(dealtCard);
				currentCardCount++;
			}
		}
	}
	
	
	/**
	 *  Deals the cards to 3 players, used in the three player variation 
	 */
	private void dealThreePlayers() {
		
		for(int i = beginningIndex; i < 51; i+=3) {
			Card dealtCard = deck.getNextCard(i);
			playerHand.add(dealtCard);
			currentCardCount++;
		}
		
	}
	
	
	
	/**
	 * Used for debugging 
	 * @param playerHand
	 */
	//public void printHand(Queue<Card> playerHand) {
	public void printHand(Hand playerHand) {
		for(Card item : playerHand.playerHand)
			System.out.println(item.suit + "\t" + item.rank);
	}

}

