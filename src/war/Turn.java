package war;

import java.util.ArrayList;


/**
 * 
 * @author zstow
 *	Handles each round or iteration of gameplay 
 */

public final class Turn  {

	/**
	 * 
	 * @param playerOne   	First player entered in the console 
	 * @param playerTwo 	Second player entered in the console
	 * 	Checks the next card in each players deck and calls methods to determine the winner   	
	 */
	public static void playCard(Player playerOne, Player playerTwo, ArrayList<Card> winnersCards) {
		
		printCardPlayed(playerOne);
		printCardPlayed(playerTwo);
		
		
		Card playerOneCard = playerOne.hand.playerHand.remove();
		Card playerTwoCard = playerTwo.hand.playerHand.remove();
		
		winnersCards.add(playerOneCard);
		winnersCards.add(playerTwoCard);
		
		int result = determineHandWinner(playerOneCard, playerTwoCard);
		
		switch(result) {
			
			case 1:
				addToWinningPlayerHand(playerOne, winnersCards);
				break;
			case 2:
				addToWinningPlayerHand(playerTwo, winnersCards);
				break;
			case 3:
				System.out.println("War!");
				handleWar(playerOne, playerTwo, winnersCards);
				break;
			default:
				System.out.println("Error");
		}
	}
	
	/**
	 * 
	 * @param playerOneCard		The top card from player one's deck 
	 * @param playerTwoCard		The top card from player two's deck 
	 * @return		1 if player one is the winner
	 * 				2 if player two is the winner 
	 * 				3 if the players are tied and there is a war 
	 * Gets the value of each player's card and determines if there is a winner or a tie 
	 */
	public static int determineHandWinner(Card playerOneCard, Card playerTwoCard) {
		
		if(playerOneCard.rank.getValue() > playerTwoCard.rank.getValue())
			return 1;
		else if (playerTwoCard.rank.getValue() > playerOneCard.rank.getValue())
			return 2;
		else
			return 3;
		
	}
	

		
	
	/**
	 * 
	 * @param player	One of the two game players 
	 * 	Prints the card is played by the player in the round 
	 */
	public static void printCardPlayed(Player player) {
		
		Card playerCard = player.hand.playerHand.peek();
		
		System.out.println(player.name + " plays " + playerCard.rank + " of " + playerCard.suit + " as up card");
		
	}
	
	
	/**
	 * 
	 * @param roundWinner		Winner of the round 
	 * @param cardsWon			List of cards that the winner will add to their hand 
	 * 
	 * 		Adds winning cards to the winning player's hand and calls a method to print the results 
	 */
	public static void addToWinningPlayerHand(Player roundWinner, ArrayList<Card> cardsWon) {
		
		int numberOfCardsWon = cardsWon.size();
		
		for(int i = 0; i < cardsWon.size(); i++)
			roundWinner.hand.playerHand.add(cardsWon.get(i));
		
		printResults(roundWinner, numberOfCardsWon);
		
	}
	
	/**
	 * 
	 * @param playerOne		
	 * @param playerTwo
	 * @param winnersCards 		The list of cards that the player that wins this round will get to add to their hand 
	 */
	public static void handleWar(Player playerOne, Player playerTwo, ArrayList<Card> winnersCards) {
		
		winnersCards.add(playerOne.hand.playerHand.remove());
		winnersCards.add(playerTwo.hand.playerHand.remove());
		playCard(playerOne, playerTwo, winnersCards);
		
		
		
		
	}
	
	
	/**
	 * 
	 * @param roundWinner		Either player 1 or player 2 
	 * @param numberOfCardsWon	Number of cards won in this round 
	 */
	public static void printResults(Player roundWinner, int numberOfCardsWon) {
		
		System.out.println(roundWinner.name + " wins the round");
	}
	
	
	/**
	 * 
	 * @param playerOne
	 * @param playerTwo
	 * 	Prints the total score after each round 
	 */		
	public static void printScore(Player playerOne, Player playerTwo) {
		
		System.out.println("Score is " + playerOne.name + " " + playerOne.hand.playerHand.size() + 
				", " + playerTwo.name + " " + playerTwo.hand.playerHand.size());
	}
	
	
	
	
	
	
	
}
