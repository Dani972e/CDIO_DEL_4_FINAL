package spil.entity.chancecard;

public class JailChanceCard extends ChanceCard {

	/*
	 * Constructor which sets the effect variable, description variable
	 * and unique identifier for the card.
	 */
	public JailChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, uniqueID);
	}

	/*
	 * Overwritten toString method used for debugging purposes.
	 */
	public String toString() {
		return "Jail " + this.desc;
	}

}