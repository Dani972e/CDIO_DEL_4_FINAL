package spil.entity.chancecard;

public class TaxChanceCard extends ChanceCard {

	public TaxChanceCard(int effect) {
		super(effect);
	}
	
	public String toString(){
		return "Tax: kr"+effect;
	}
}
