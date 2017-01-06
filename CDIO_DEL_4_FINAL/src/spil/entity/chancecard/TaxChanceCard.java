package spil.entity.chancecard;

public class TaxChanceCard extends ChanceCard {

	public TaxChanceCard(int effect, String desc) {
		super(effect, desc);
	}

	public String toString() {
		return "Tax: kr" + effect;
	}

}