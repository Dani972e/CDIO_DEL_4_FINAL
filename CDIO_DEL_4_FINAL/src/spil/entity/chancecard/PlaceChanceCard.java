package spil.entity.chancecard;

public class PlaceChanceCard extends ChanceCard {

	public PlaceChanceCard(int effect, String desc, int uniqueID) {
		super(effect, desc, uniqueID);
	}

	public String toString() {
		return "Place: " + effect;
	}

}