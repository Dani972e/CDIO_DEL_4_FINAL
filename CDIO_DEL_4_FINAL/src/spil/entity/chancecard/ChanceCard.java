package spil.entity.chancecard;

public abstract class ChanceCard {
	protected int effect;
	
	
	public ChanceCard(int effectAmount){
	this.effect=effectAmount;
	}

	public int getEffect(){
		return effect;
	}

}
