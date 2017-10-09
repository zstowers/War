package war;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Abstract game class for each game type 
 *
 */
public abstract class Game {
	
	protected static Deck deck = new Deck();
	protected static Scanner gameScanner = new Scanner(System.in);
	protected static ArrayList<Card> winnersCards = new ArrayList<Card>();
	protected static Player playerOne;
	protected static Player playerTwo;
	protected static int handWinner;
	protected static int handResult;
	protected static Card playerOneCard;
	protected static Card playerTwoCard;
	
	
	public abstract void playGame();
	
	public abstract void playRounds();
	
	public abstract void determineWinner();
	
	public abstract void finishHand();
	
	public abstract void handleWar();
	
	/**
	 * Initializes the players and shuffles the deck 
	 */
	public static void beginNewGame() {
		
		playerOne = new Player(1);
		playerTwo = new Player(2);
		
		System.out.print("Enter the name of player 1: ");
		playerOne.name = gameScanner.next();
		System.out.print("\nEnter the name of player 2: ");
		playerTwo.name = gameScanner.next();
		System.out.println();
		deck.shuffleDeck();
	}
	
	/**
	 * Lets the user select the game type 
	 * @return game type based on user's input 
	 */
	public static int chooseGameType() {
		
		System.out.println("*****  1. Classic Two Player War: Place won cards on the bottom of hand    *****");
		System.out.println("*****  2. Two Player War: Place won cards in a separate points pile        *****");
		System.out.println("*****  3. Three Player War: Place won cards in a separate points pile      *****");
		
		System.out.print("Choose your game type: ");
		int gameType = gameScanner.nextInt();
		System.out.println();	
			
			switch(gameType) {
			
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 3;
				default:
					System.out.println("Not a valid selection");
					return gameType;
			}
		}
	
	/**
	 * Removes card from players hand and adds it to the winning player's stack 
	 */
	public static void playCard() {
	
		GameLog.printCardsPlayed(playerOne, playerTwo);
		
		playerOneCard = playerOne.hand.playerHand.remove();
		playerTwoCard = playerTwo.hand.playerHand.remove();
		
		winnersCards.add(playerOneCard);
		winnersCards.add(playerTwoCard);
	}
	
	/**
	 * Gets the number of points for the winner 
	 * @return number of points that the winning player will add to their total 
	 */
	protected int addPoints() {
		
		int points = 0;
		
		for(int i = 0; i < winnersCards.size(); i++) {
			points += winnersCards.get(i).rank.getValue();
		}
		
		return points;
		
	}
	
	/**
	 * Compares each player's card to determine a winner 
	 * @return 1 if player one has the higher card, 2 if player two has the higher card, or 3 for a tie 
	 */
	public int determineHandWinner() {
		
		if(playerOneCard.rank.getValue() > playerTwoCard.rank.getValue())
			return 1;
		else if (playerTwoCard.rank.getValue() > playerOneCard.rank.getValue())
			return 2;
		else
			return 3;
		
	}



}
