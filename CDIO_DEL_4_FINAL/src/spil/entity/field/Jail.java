package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.JailedPlayers;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Jail extends Field {

	/*
	 * Global object of the JailedPlayers class 
	 * and boolean variable for jail control.
	 */
	private JailedPlayers jailedPlayers;
	private boolean isJail;

	/*
	 * Constructor that sets the jailedPlayers object as well
	 * as the boolean variable isJail.
	 */
	public Jail(JailedPlayers jailedPlayers, boolean isJail) {
		this.jailedPlayers = jailedPlayers;
		this.isJail = isJail;
	}

	/*
	 * If the player lands on the real Jail field, the player gets jailed.
	 * If not, a simple message is sent to the GUI.
	 */
	@Override
	public void landOnField(Player player) {
		if (!isJail) {
			GUIBoundary.print(TextInfo.jailFieldMessage(player));
		} else if (isJail) {
			GUIBoundary.print(TextInfo.jailedFieldMessage(player));
			jailedPlayers.jailPlayer(player);
		}
	}

	/*
	 * Method that deletes the owner of a field, 
	 * which is not used in this class.
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