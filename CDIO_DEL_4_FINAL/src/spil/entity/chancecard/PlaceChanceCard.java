package spil.entity.chancecard;

public class PlaceChanceCard extends ChanceCard {

	/*
	 * Constructor which sets the effect variable, description variable
	 * and unique identifier for the card.
	 */
	public PlaceChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, uniqueID);
	}

	/*
	 * Overwritten toString method used for debugging purposes.
	 */
	public String toString() {
		return "Place: " + effect;
	}

}