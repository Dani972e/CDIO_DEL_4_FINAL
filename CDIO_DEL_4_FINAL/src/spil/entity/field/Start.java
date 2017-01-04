package spil.entity.field;

import spil.controller.GameBoard;
import spil.entity.Player;

public final class Start extends Field {

	private int startBonus;

	public Start(int startBonus) {
		this.startBonus = startBonus;
	}

	public void roundBonus() {

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
