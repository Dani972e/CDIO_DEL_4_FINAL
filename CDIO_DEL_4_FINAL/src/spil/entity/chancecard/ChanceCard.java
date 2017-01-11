package spil.entity.chancecard;

public abstract class ChanceCard {

	/*
	 * Global variables for the effect of the card, 
	 * the cards identifier and the cards description.
	 */
	protected int effect;
	protected int uniqueID;
	protected String desc;

	/*
	 * Constructor which sets the effect variable, description variable
	 * and unique identifier for the card.
	 */
	public ChanceCard(int effect, String desc, int uniqueID) {
		this.effect = effect;
		this.desc = desc;
		this.uniqueID = uniqueID;
	}

	/*
	 * Getter for the unique ID.
	 */
	public int getUniqueID() {
		return uniqueID;
	}

	/*
	 * Getter for the cards effect.
	 */
	public int getEffect() {
		return effect;
	}

	/*
	 * Getter for the cards description.
	 */
	public String getDesc() {
		return desc;
	}

}