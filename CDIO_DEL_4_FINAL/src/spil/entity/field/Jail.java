package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

public final class Jail extends Field {

	@Override
	public void landOnField(Player player) {
		if (player.getPosition() == 10) {
			GUIBoundary.print(TextInfo.jailFieldMessage(player));
		} else if (player.getPosition() == 30) {
			GUIBoundary.removePlayerCar(player);
			player.setPosition(10);
			GUIBoundary.placePlayerCar(player);
			GUIBoundary.print(TextInfo.jailedFieldMessage(player));
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