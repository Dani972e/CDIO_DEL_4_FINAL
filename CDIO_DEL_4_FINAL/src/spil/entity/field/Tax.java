package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.FieldInfo;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Tax extends Field {

	/*
	 * Tax amount of the field.
	 */
	private int tax;

	/*
	 * Constructor which sets the tax amount.
	 */
	public Tax(int tax) {
		this.tax = tax;
	}

	/*
	 * If the player lands on position TAX_SPECIAL_POS, then the player will be
	 * able to choose between two different effects for their coin sum. They can
	 * choose between getting tax or 10% of their coin sum removed. However, if
	 * the player does not land on TAX_SPECIAL_POS, just tax is removed.
	 */
	@Override
	public void landOnField(Player player) {
		if (player.getPosition() == FieldInfo.TAX_SPECIAL_POS) {
			if (GUIBoundary.chooseTaxEffect(player, tax)) {
				player.removeBalance(tax);
			} else {
				player.removeBalance((int) (FieldInfo.TAX_MULTIPLIER * player.getBalance()));
			}
		} else {
			GUIBoundary.print(TextInfo.taxMessage(player, tax));
			player.removeBalance(tax);
		}
	}

	/*
	 * Returns the owner of the Field.
	 * 
	 * Returns null in this case, since Tax is not able to be owned.
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