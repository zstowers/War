package war;

/**
 *  Class for a three player variation of War 
 */
public class ThreePlayerVariation extends Game {
	
	protected static Player playerThree;
	protected static final int MAX_ROUNDS = 17;
	protected static int firstHandComparison;
	protected static int secondHandComparison;
	protected static Card playerThreeCard;
	
	public ThreePlayerVariation() {
		playGame();
	}
	
	/**
	 * Begins the game, adds a third player, deals the hands, and plays the game 
	 */
	@Override
	public void playGame() {
		beginNewGame();
		addPlayer();
		playerOne.hand = new Hand(playerOne, deck, 3);
		playerTwo.hand = new Hand(playerTwo, deck, 3);
		playerThree.hand = new Hand(playerThree, deck, 3);
		playRounds();
	}
	
	/**
	 * Adds a third player to the game 
	 */
	public static void addPlayer() {
		playerThree = new Player(3);
		System.out.println("Enter the name of player 3: ");
		playerThree.name = gameScanner.next();
	}
	
	/**
	 * 	Plays the game until max rounds are met or a player runs out of cards 
	 */
	@Override
	public void playRounds() {
		
		 for(int i = 0; i < MAX_ROUNDS; i++) {	
			if(playerOne.hand.playerHand.isEmpty() || playerTwo.hand.playerHand.isEmpty() || playerThree.hand.playerHand.isEmpty())
				break;
			playCard();
			finishHand();
			GameLog.printScore(playerOne, playerTwo, playerThree);
			System.out.println();
		}
		
		determineWinner();
	}

	/**
	 *  Determines the winner based on overall points when the game ends 
	 */
	@Override
	public void determineWinner() {
		
		int leaderOne = Math.max(playerOne.numberOfPoints, playerTwo.numberOfPoints);
		int overall = Math.max(leaderOne, playerThree.numberOfPoints);
		
		if(playerOne.numberOfPoints == overall)
			GameLog.printGameWinner(playerOne);
		else if(playerTwo.numberOfPoints == overall)
			GameLog.printGameWinner(playerTwo);
		else
			GameLog.printGameWinner(playerThree);
		
		System.exit(0);
	}
	
	/**
	 * Removes a card from the deck and adds it to the winning card pile 
	 */
	public static void playCard() {
		
		GameLog.printCardsPlayed(playerOne, playerTwo, playerThree);
		
		playerOneCard = playerOne.hand.playerHand.remove();
		playerTwoCard = playerTwo.hand.playerHand.remove();
		playerThreeCard = playerThree.hand.playerHand.remove();
		
		winnersCards.add(playerOneCard);
		winnersCards.add(playerTwoCard);
		winnersCards.add(playerThreeCard);
	}	
	
	/**
	 *  Compares the value of every player's card and determines who won the hand 
	 */
	@Override
	public void finishHand() {
		firstHandComparison = GameLog.determineHandWinner(playerOneCard, playerTwoCard);
		
		if(firstHandComparison == 1) {
			secondHandComparison = GameLog.determineHandWinner(playerOneCard, playerThreeCard);
			if(secondHandComparison == 1) {
				playerOne.numberOfPoints += addPoints();
				GameLog.printRoundWinner(playerOne);
			} else if(secondHandComparison == 2) {
				playerThree.numberOfPoints += addPoints();
				GameLog.printRoundWinner(playerThree);
			} else
				handleWar();
		} 
		else if(firstHandComparison == 2) {
			secondHandComparison = GameLog.determineHandWinner(playerTwoCard, playerThreeCard);
			if(secondHandComparison == 1) {
				playerTwo.numberOfPoints += addPoints();
				GameLog.printRoundWinner(playerTwo);
			} else if(secondHandComparison == 2) {
				playerThree.numberOfPoints += addPoints();
				GameLog.printRoundWinner(playerThree);
			} else
				handleWar();
		} 
		else if(firstHandComparison ==3) {
			secondHandComparison = GameLog.determineHandWinner(playerOneCard, playerThreeCard);
			if(secondHandComparison == 2) { 
				playerThree.numberOfPoints += addPoints();
				GameLog.printRoundWinner(playerThree);
			} 
		else 
				handleWar();
		}
		winnersCards.clear();
	}
	
	/**
	 *  Each player removes one card from their hand and adds it to the winner's card stack and then their next card is played 
	 */
	@Override
	public void handleWar() {
		System.out.println("War!");
		if(playerOne.hand.playerHand.isEmpty() || playerTwo.hand.playerHand.isEmpty() || playerThree.hand.playerHand.isEmpty())
			determineWinner();
		winnersCards.add(playerOne.hand.playerHand.remove());
		winnersCards.add(playerTwo.hand.playerHand.remove());
		winnersCards.add(playerThree.hand.playerHand.remove());
		playCard();
		finishHand();
	}
}
