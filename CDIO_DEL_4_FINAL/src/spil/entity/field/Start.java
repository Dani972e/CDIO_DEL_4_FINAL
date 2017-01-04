package spil.entity.field;

import spil.entity.Player;

public final class Start extends Field {

	private int startBonus;

	public Start(int startBonus) {
		this.startBonus = startBonus;
	}

	@Override
	public void landOnField(Player player) {

	}

	@Override
	public Player getOwner() {

		return null;
	}

	@Override
	public void deleteOwner() {

	}

}
