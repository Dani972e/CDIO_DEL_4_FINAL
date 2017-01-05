package spil.entity.chancecard;

public class BonusChanceCard extends ChanceCard {

	public BonusChanceCard(int effect) {
		super(effect);
	}
	
	public String toString(){
		return "Bonus: kr"+effect;
	}
}
