package spil.entity.chancecard;

public abstract class ChanceCard {

	protected int effect;
	protected String desc;

	public ChanceCard(int effect, String desc) {
		this.effect = effect;
		this.desc=desc;
	}

	public int getEffect() {
		return effect;
	}
	
	public String getDesc() {
		return desc;
	}

}