package spil.entity.chancecard;

public class MoveChanceCard extends ChanceCard {

	public MoveChanceCard(int effect, String desc) {
		super(effect, desc);
	}

	public String toString() {
		return "Move: " + effect;
	}

}