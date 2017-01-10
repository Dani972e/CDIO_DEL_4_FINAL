package spil.entity.chancecard;

public class PayChanceCard extends ChanceCard {

	public PayChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, effect);
	}

	public String toString() {
		return "Pay: kr" + effect;
	}

}