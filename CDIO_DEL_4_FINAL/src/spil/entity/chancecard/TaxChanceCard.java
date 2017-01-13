package spil.entity.chancecard;

public class TaxChanceCard extends ChanceCard {

	/*
	 * Constructor which sets the effect variable, description variable
	 * and unique identifier for the card.
	 */
	public TaxChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, effect);
	}

	/*
	 * Overwritten toString method used for debugging purposes.
	 */
	public String toString() {
		return "Tax: kr" + effect;
	}

}