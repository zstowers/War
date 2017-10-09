package war;

/**
 * Handles the logging of messages to standard output as well as methods for determining the winner of 
 * each hand and of the overall game 
 *
 */
public class GameLog {
	
	/**
	 * 
	 * @param player	One of the two game players 
	 * 	Prints the card is played by the player in the round 
	 */
	public static void printCardsPlayed(Player...args) {
		
		for(Player player : args) {
			Card playerCard = player.hand.playerHand.peek();
			if(playerCard == null)
				System.out.println(player.name + " is out of cards");
			System.out.println(player.name + " plays " + playerCard.rank + " of " + playerCard.suit + " as up card");
		}
	}

	/**
	 * Prints each player's score after the round 
	 * @param args
	 */
	protected static void printScore(Player...args) {
		
		System.out.print("Score is ");
		for(Player player : args) {
			System.out.print(player.name + " " + player.numberOfPoints);
			if(player == args[args.length -1])
				break;
			System.out.print(", ");
		}
		System.out.println();
	}
	
	
	/**
	 * Determines the leader between a pair of players in the variation games 
	 * @param firstPlayer
	 * @param secondPlayer
	 * @return player number as an int or 3 in the event of a tie 
	 */
	protected static int determineLeader(Player firstPlayer, Player secondPlayer) {
		
		if(firstPlayer.numberOfPoints > secondPlayer.numberOfPoints)
			return 1;
		else if(secondPlayer.numberOfPoints > firstPlayer.numberOfPoints)
			return 2;
		else
			return 3;
			
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
	protected static int determineHandWinner(Card playerOneCard, Card playerTwoCard) {
		
		if(playerOneCard.rank.getValue() > playerTwoCard.rank.getValue())
			return 1;
		else if (playerTwoCard.rank.getValue() > playerOneCard.rank.getValue())
			return 2;
		else
			return 3;
		
	}
	
	
	/**
	 * Prints the round winner's name 
	 * @param roundWinner
	 */
	protected static void printRoundWinner(Player roundWinner) {
		System.out.println(roundWinner.name + " wins the round!");
		System.out.println();
	}

	/**
	 * Prints the game winner's name 
	 * @param gameWinner
	 */
	protected static void printGameWinner(Player gameWinner) {
		System.out.println(gameWinner.name + " wins the game!");
	}
	
	/**
	 * Prints the score based on number of cards in each player's hand 
	 * @param playerOne
	 * @param playerTwo
	 */
	protected static void printOriginalGameScore(Player playerOne, Player playerTwo) {
		
		System.out.println("Score is " + playerOne.name + " " + playerOne.hand.playerHand.size() + 
				", " + playerTwo.name + " " + playerTwo.hand.playerHand.size());
		
	}
	
	/**
	 * Determines the winner of the game based on number of cards in each player's hand after a defined number of 
	 * iterations  
	 */
	public static void determineOriginalGameWinner(Player playerOne, Player playerTwo) {
		
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
