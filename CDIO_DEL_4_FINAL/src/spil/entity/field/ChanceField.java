package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;
import spil.entity.chancecard.ChanceCard;
import spil.entity.chancecard.ChanceCardList;

public class ChanceField extends Field {

	/*
	 * Global objects of ChanceCardList and
	 * ChanceCard classes.
	 */
	private ChanceCardList chanceCardList;
	private ChanceCard pickedCard;

	/*
	 * Constructor which sets the ChanceCardList.
	 */
	public ChanceField(ChanceCardList chanceCardList) {
		this.chanceCardList = chanceCardList;
	}

	/*
	 * The player object will pick a card when it lands
	 * on this field.
	 */
	@Override
	public void landOnField(Player player) {
		pickedCard = null;
		GUIBoundary.print(TextInfo.chanceCardMessage(player));
		pickedCard = chanceCardList.pickOneCard(player);
	}

	/*
	 * Getter for the currently picked card.
	 */
	public ChanceCard getPickedCard() {
		return pickedCard;
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