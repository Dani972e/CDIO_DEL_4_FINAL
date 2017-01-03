package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Refuge extends Field {

	/*
	 * Variable to hold the Field bonus amount.
	 */
	private int bonus;

	/*
	 * Refugee constructor which sets variable bonus.
	 */
	public Refuge(int bonus) {
		this.bonus = bonus;
	}

	/*
	 * Prints out information about receiving the bonus and adds it to the
	 * player coin sum.
	 */
	@Override
	public void landOnField(Player player) {
		GUIBoundary.print(TextInfo.bonusMessage(player, bonus));
		player.addBalance(bonus);
	}

	/*
	 * Returns the owner of the Field.
	 * 
	 * Returns null in this case, since Refugee is not able to be owned.
	 */
	@Override
	public Player getOwner() {
		return null;
	}

	/*
	 * Sets the owner object equal to null.
	 * 
	 * This method does nothing in this case, since Tax is not able to be owned.
	 */
	@Override
	public void deleteOwner() {

	}

}