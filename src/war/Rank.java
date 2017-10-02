package war;

/**
 * 
 * @author zstow
 *  Rank constants, along with their integer values 
 */
public enum Rank {
	
	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), 
		JACK(11), QUEEN(12), KING(13), ACE(14);
	
	private int value;
	
	private Rank(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	private void setValue(int value) {
		this.value = value;
	}

	



	

}