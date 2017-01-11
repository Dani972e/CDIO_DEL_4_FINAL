package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

public class Empty extends Field {

	/*
	 * Boolean variable that controls whether the field
	 * is a start field or not.
	 */
	private boolean isStart;

	public Empty(boolean isStart) {
		this.isStart = isStart;
	}

	@Override
	public void landOnField(Player player) {
		if (!isStart) {
			GUIBoundary.print(TextInfo.parkingMessage(player));
		} else if (isStart) {
			GUIBoundary.print(TextInfo.startFieldMessage(player));
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