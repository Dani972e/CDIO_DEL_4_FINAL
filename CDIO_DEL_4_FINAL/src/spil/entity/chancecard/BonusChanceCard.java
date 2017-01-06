package spil.entity.chancecard;

public class BonusChanceCard extends ChanceCard {

	public BonusChanceCard(int effect, String desc) {
		super(effect, desc);
	}

	public String toString() {
		return "Bonus: kr" + effect;
	}

}