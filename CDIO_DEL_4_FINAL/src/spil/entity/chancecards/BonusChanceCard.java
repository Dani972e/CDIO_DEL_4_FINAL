package spil.entity.chancecards;

public class BonusChanceCard extends ChanceCard {

	public BonusChanceCard(int effect) {
		super(effect);
	}
	
	public String toString(){
		return ""+effect;
	}
}
