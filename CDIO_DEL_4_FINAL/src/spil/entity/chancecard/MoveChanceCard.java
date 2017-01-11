package spil.entity.chancecard;

public class MoveChanceCard extends ChanceCard {

	/*
	 * Constructor which sets the effect variable, description variable
	 * and unique identifier for the card.
	 */
	public MoveChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, uniqueID);
	}

	/*
	 * Overwritten toString method used for debugging purposes.
	 */
	public String toString() {
		return "Move: " + effect;
	}

}