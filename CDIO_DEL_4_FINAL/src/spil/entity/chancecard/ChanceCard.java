package spil.entity.chancecard;

public abstract class ChanceCard {

	protected int effect;
	protected int uniqueID;
	protected String desc;

	public ChanceCard(int effect, String desc, int uniqueID) {
		this.effect = effect;
		this.desc = desc;
		this.uniqueID = uniqueID;
	}
	
	public int getUniqueID(){
		return uniqueID;
	}

	public int getEffect() {
		return effect;
	}

	public String getDesc() {
		return desc;
	}

}