package war;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author zstow
 *	Controls an entire game between player 1 and player 2 
 */
public final class Game {

	private static Scanner gameScanner;
	protected static Deck deck;
	protected static Player playerOne;
	protected static Player playerTwo;
	
	private static int currentIterations;
	private static final int MAX_ITERATIONS = 500;
	
	
	
	public static void playGame() {
		playerOne = new Player(1);
		playerTwo = new Player(2);
		gameScanner = new Scanner(System.in);
		deck = new Deck();
		currentIterations = 0;
		
		beginNewGame();
		playRounds();
	}
	
	
	/**
	 * 	Gets the entered player names from the console, shuffles the deck, and deals the 
	 *  cards to each player 
	 */
	private static void beginNewGame(){
		
		System.out.println("Enter the name of player 1: ");
		playerOne.setName(gameScanner.next());
		System.out.println("Enter the name of player 2: ");
		playerTwo.setName(gameScanner.next());
		
		deck.shuffleDeck();
		
		playerOne.hand = new Hand(playerOne, deck);
		playerTwo.hand = new Hand(playerTwo, deck);
	}
	
	
	/**
	 * 		Handles each round and ends the game if a player holds all of the cards or a set 
	 * 		number of iterations is reached 
	 */
	private static void playRounds() {
		
		while(currentIterations < MAX_ITERATIONS) {
			
			ArrayList<Card> winnersCards = new ArrayList<Card>();
			
			if(playerOne.hand.playerHand.isEmpty() || playerTwo.hand.playerHand.isEmpty())
				break;
			
			Turn.playCard(playerOne, playerTwo, winnersCards);
			currentIterations ++;
			Turn.printScore(playerOne, playerTwo);
		}
		
		determineWinner(playerOne, playerTwo);
		System.out.println("Total number of iterations = " + currentIterations);
	
	}
	
	
	/**
	 * 
	 * @param playerOne
	 * @param playerTwo
	 * Determines the winner of the completed game 
	 */
	private static void determineWinner(Player playerOne, Player playerTwo) {
		
		int playerOneCardsInHand = playerOne.hand.playerHand.size();
		int playerTwoCardsInHand = playerTwo.hand.playerHand.size();
		
		if(playerOneCardsInHand > playerTwoCardsInHand) {
			System.out.println(playerOne.name + " wins!");
		}
		
		else if(playerTwoCardsInHand > playerOneCardsInHand) {
			System.out.println(playerTwo.name + " wins!");
		}
		
		else {
			System.out.println("Game is a tie");
			return;
		}
		
		
		
	
		
	}
	
	
	
	
	
	
	

	

}
