package spil.entity.chancecard;

public class BonusChanceCard extends ChanceCard {

	public BonusChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, uniqueID);
	}

	public String toString() {
		return "Bonus: kr" + effect;
	}

}