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

	/*
	 * Constructor that initializes the isStart variable.
	 */
	public Empty(boolean isStart) {
		this.isStart = isStart;
	}

	/*
	 * This method is invoked when a player lands on a field.
	 * Acts accordingly to whether the field is a parking or start field.
	 */
	@Override
	public void landOnField(Player player) {
		if (!isStart) {
			GUIBoundary.print(TextInfo.parkingMessage(player));
		} else {
			GUIBoundary.print(TextInfo.startFieldMessage(player));
		}
	}

	/*
	 * Getter for the owner object, which
	 * is not used in this class.
	 */
	@Override
	public Player getOwner() {
		return null;
	}

	/*
	 * Method that deletes the owner of a field, 
	 * which is not used in this class.
	 */
	@Override
	public void deleteOwner() {

	}

}