package spil.entity.chancecard;

public class MoveChanceCard extends ChanceCard {

	public MoveChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, uniqueID);
	}

	public String toString() {
		return "Move: " + effect;
	}

}