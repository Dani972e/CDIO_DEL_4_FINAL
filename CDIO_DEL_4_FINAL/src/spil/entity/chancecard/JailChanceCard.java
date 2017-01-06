package spil.entity.chancecard;

public class JailChanceCard extends ChanceCard {

	public JailChanceCard(int effect) {
		super(effect);
		this.effect=0;
	}

	public String toString() {
		return "Jail";
	}

}