package war;

/**
 * Instantiates the game based on user's selection 
 *
 */

public class Main {

	public static void main(String[] args) {
		
		Game game;
		int gameType = Game.chooseGameType();
		
		switch(gameType) {
		
			case 1:
				game = new TwoPlayerClassic();
				break;
			case 2:
				game = new TwoPlayerVariation();
				break;
			case 3:
				game = new ThreePlayerVariation();
				break;
			default:
				System.out.println("Not a valid selection, exiting");
				System.exit(1);
				break;
		}
	
	
	}
}
