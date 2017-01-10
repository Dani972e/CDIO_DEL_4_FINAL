package spil.entity.chancecard;

public class TaxChanceCard extends ChanceCard {

	public TaxChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, effect);
	}

	public String toString() {
		return "Tax: kr" + effect;
	}

}