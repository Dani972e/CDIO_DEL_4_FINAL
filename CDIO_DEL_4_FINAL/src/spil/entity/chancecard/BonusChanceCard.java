package spil.entity.chancecard;

public class BonusChanceCard extends ChanceCard {

	/*
	 * Constructor which sets the effect variable, description variable
	 * and unique identifier for the card.
	 */
	public BonusChanceCard(int effect, String desc, int uniqueID) {
		/* Uses the super class constructor */
		super(effect, desc, uniqueID);
	}

	/*
	 * Overwritten toString method used for debugging purposes.
	 */
	public String toString() {
		return "Bonus: kr" + effect;
	}

}