package war;

/**
 * 
 * Class for the classic 2 player war game 
 *
 */
public class TwoPlayerClassic extends Game {

	protected static int currentIterations = 0;
	private static final int MAX_ITERATIONS = 100;


	public TwoPlayerClassic() {
		
		playGame();
	}
	
	/**
	 * Begins a new game and deals the player's hands 
	 */
	@Override
	public void playGame() {
		
		beginNewGame();
		playerOne.hand = new Hand(playerOne, deck, 2);
		playerTwo.hand = new Hand(playerTwo, deck, 2);
		playRounds();
	}

	
	/**
	 * Plays all of the rounds based on a set number of iterations 
	 */
	@Override
	public void playRounds() {
		
		while(currentIterations < MAX_ITERATIONS) {
			
			if(playerOne.hand.playerHand.isEmpty() || playerTwo.hand.playerHand.isEmpty())
				break;
			
			playCard();
			finishHand();
			currentIterations ++;
			GameLog.printOriginalGameScore(playerOne, playerTwo);
		}
		
		determineWinner();
	}
	
	/**
	 * Handles a tie in a round 
	 */
	@Override
	public void handleWar() {
		System.out.println("War!");
		winnersCards.add(playerOne.hand.playerHand.remove());
		winnersCards.add(playerTwo.hand.playerHand.remove());
		playCard();
		finishHand();
	}
	

	/**
	 * Determines the hand winner and adds to their total.  Also determines if there is a war 
	 */
	@Override
	public void finishHand() {
		
		handResult = GameLog.determineHandWinner(playerOneCard, playerTwoCard);
		
		switch(handResult) {
			case 1:
				addToWinningPlayerHand(playerOne);
				break;
			case 2:
				addToWinningPlayerHand(playerTwo);
				break;
			case 3:
				handleWar();
				break;
			default:
				System.out.println("Error");
		}
	
		winnersCards.clear();
		
	}
	
	/**
	 * Adds the cards to the bottom hand of the winner of the round 
	 * @param roundWinner - winner of the round 
	 */
	public void addToWinningPlayerHand(Player roundWinner) {
		
		for(int i = 0; i < winnersCards.size(); i++)
			roundWinner.hand.playerHand.add(winnersCards.get(i));
		
	}

	/**
	 * Determines the winner of the game 	
	 */
	@Override
	public void determineWinner() {
		
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