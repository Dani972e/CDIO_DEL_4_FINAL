package spil.entity.chancecard;

public class JailChanceCard extends ChanceCard {

	public JailChanceCard(int effect, String desc) {
		super(effect, desc);
		this.effect=0;
	}

	public String toString() {
		return "Jail";
	}

}