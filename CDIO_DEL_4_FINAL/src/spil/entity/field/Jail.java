package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.JailedPlayers;
import spil.entity.Player;
import spil.entity.TextInfo;

public final class Jail extends Field {

	private JailedPlayers jailedPlayers;
	private boolean isJail;

	public Jail(JailedPlayers jailedPlayers, boolean isJail) {
		this.jailedPlayers = jailedPlayers;
		this.isJail = isJail;
	}

	@Override
	public void landOnField(Player player) {
		if (!isJail) {
			GUIBoundary.print(TextInfo.jailFieldMessage(player));
		} else if (isJail) {
			GUIBoundary.removePlayerCar(player);
			player.setPosition(10);
			GUIBoundary.placePlayerCar(player);
			GUIBoundary.print(TextInfo.jailedFieldMessage(player));
			jailedPlayers.jailPlayer(player);
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
