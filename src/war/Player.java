package war;


/**
 * 
 * @author zstow
 * Player contains the players name, the order in which they were entered in the console, current number of 
 * points, and their current  hand 
 */
public class Player {
	
	protected String name;
	protected int playerNumber;
	protected int numberOfPoints;
	protected Hand hand;
	
	
	public Player(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	/*
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	public void setPlayerNumber(int number) {
		this.playerNumber = number;
	}
	
	*/

}
