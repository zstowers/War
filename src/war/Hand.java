package war;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zstow
 * Keeps track of each of the players hands 
 */
public class Hand extends Deck {
	
	protected Queue<Card> playerHand;
	protected Deck deck;
	protected Player player;
	protected int beginningIndex;
	protected int currentCardCount;
	
	public Hand(Player player, Deck deck) {
		
		this.deck = deck;
		playerHand = new LinkedList<>();
		currentCardCount = 0;
		this.player = player;
		dealHand();
		
	}
	
	/**
	 *  Deals the shuffled deck of cards to each player, starting with player 1 and alternating each card
	 *  Each player gets 26 cards 
	 */
	private void dealHand() {	
		if(player.getPlayerNumber() == 1)
			beginningIndex = 0;
		else if(player.getPlayerNumber() == 2)
			beginningIndex = 1;
		
		for(int i = beginningIndex; i < 52; i+=2) {
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
