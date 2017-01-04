package spil.entity.field;

import spil.entity.Player;

public class Empty extends Field {

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
