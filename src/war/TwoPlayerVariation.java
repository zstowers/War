package war;

/**
 * Variation of War where the winner is the player with the highest point total after all cards have been played 
 *
 */
public class TwoPlayerVariation extends Game {


	private final int MAX_ROUNDS = 26;

	public TwoPlayerVariation() {
		playGame();
	}

	
	/**
	 * 
	 */
	@Override
	public void playGame() {
		
		beginNewGame();
		playerOne.hand = new Hand(playerOne, deck, 2);
		playerTwo.hand = new Hand(playerTwo, deck, 2);
		playRounds();
	}

	
	/**
	 * 
	 */
	@Override
	public void playRounds() {
		
		for(int i = 0; i < MAX_ROUNDS; i++) {
			
			if(playerOne.hand.playerHand.isEmpty() || playerTwo.hand.playerHand.isEmpty())
				break;
			
			playCard();
			finishHand();
			GameLog.printScore(playerOne, playerTwo);
		}
		
		determineWinner();
		
	}
	
	/**
	 * 
	 */
	@Override
	public void determineWinner() {
		
		if(playerOne.numberOfPoints > playerTwo.numberOfPoints)
			System.out.println(playerOne.name + " wins!");
		else if(playerTwo.numberOfPoints > playerOne.numberOfPoints)
			System.out.println(playerTwo.name + " wins!");
		else
			System.out.println("Game is a tie");
	}

	
	/**
	 * Adds the total points for the round  
	 * @return total points won for the round 
	 */
	protected int addPoints() {
		
		int points = 0;
		
		for(int i = 0; i < winnersCards.size(); i++) {
			points += winnersCards.get(i).rank.getValue();
		}
		
		return points;
		
	}
	
	/**
	 * Handles a tie round 
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
	 *  Determines the hand winner and adds to their point total
	 */
	@Override
	public void finishHand() {
		
		handResult = determineHandWinner();
		
		switch(handResult) {
		
		case 1:
			playerOne.numberOfPoints += addPoints();
			GameLog.printRoundWinner(playerOne);
			break;
		
		case 2:
			playerTwo.numberOfPoints += addPoints();
			GameLog.printRoundWinner(playerTwo);
			break;
		
		case 3:
			handleWar();
			break;
		
		default:
			System.out.println("Error");
		}
	
		winnersCards.clear();
	
	}
	
}
