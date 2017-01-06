package spil.entity.chancecard;

public class PayChanceCard extends ChanceCard {

	public PayChanceCard(int effect, String desc) {
		super(effect, desc);
	}

	public String toString() {
		return "Pay: kr" + effect;
	}

}