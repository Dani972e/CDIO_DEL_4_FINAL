package spil.entity.chancecard;

public class PlaceChanceCard extends ChanceCard {

	public PlaceChanceCard(int effect, String desc) {
		super(effect, desc);
	}

	public String toString() {
		return "Place: " + effect;
	}

}