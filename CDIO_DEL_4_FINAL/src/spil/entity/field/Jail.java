package spil.entity.field;

import spil.entity.Player;

public final class Jail extends Field {

	@Override
	public void landOnField(Player player) {
		if (player.getPosition() == 10) {
			// print message
		} else if (player.getPosition() == 30) {
			player.setPosition(10);
			
		}

	}

	@Override
	public Player getOwner() {
		return null;
	}

	@Override
	public void deleteOwner() {

	}

}