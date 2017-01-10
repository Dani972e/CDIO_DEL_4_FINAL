package spil.entity.chancecard;

public class JailChanceCard extends ChanceCard {

	public JailChanceCard(int effect, String desc, int uniqueID)  {
		super(effect, desc, uniqueID);
	}

	public String toString() {
		return "Jail " + this.desc;
	}

}