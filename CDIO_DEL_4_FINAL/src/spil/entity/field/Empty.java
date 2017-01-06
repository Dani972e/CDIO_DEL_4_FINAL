package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

public class Empty extends Field {

	@Override
	public void landOnField(Player player) {
		GUIBoundary.print(TextInfo.parkingMessage(player));
	}

	@Override
	public Player getOwner() {
		return null;
	}

	@Override
	public void deleteOwner() {

	}

}