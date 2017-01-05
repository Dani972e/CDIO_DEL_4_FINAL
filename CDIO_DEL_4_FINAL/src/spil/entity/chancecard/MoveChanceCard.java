package spil.entity.chancecard;

public class MoveChanceCard extends ChanceCard {

	public MoveChanceCard(int effect) {
		super(effect);
	}
	
	public String toString(){
		return "Move: "+effect;
	}
}
