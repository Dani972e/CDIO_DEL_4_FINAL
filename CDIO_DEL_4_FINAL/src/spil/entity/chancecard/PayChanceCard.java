package spil.entity.chancecard;

public class PayChanceCard extends ChanceCard {

	public PayChanceCard(int effect) {
		super(effect);
	}

	public String toString() {
		return "Pay: kr" + effect;
	}

}