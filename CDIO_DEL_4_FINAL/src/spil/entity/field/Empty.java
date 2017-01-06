package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

public class Empty extends Field {

	private boolean isStart;

	public Empty(boolean isStart) {
		this.isStart = isStart;
	}

	@Override
	public void landOnField(Player player) {
		if (!isStart) {
			GUIBoundary.print(TextInfo.parkingMessage(player));
		} else if (isStart) {
			GUIBoundary.print("Du har landet på start! FIX DENNE BESKED");
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