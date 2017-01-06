package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;
import spil.entity.chancecard.ChanceCardList;

public class ChanceField extends Field {

	private ChanceCardList chanceCardList;

	public ChanceField(ChanceCardList chanceCardList) {
		this.chanceCardList = chanceCardList;
	}

	@Override
	public void landOnField(Player player) {
		GUIBoundary.print(TextInfo.chanceCardMessage(player));
		chanceCardList.pickOneCard(player);
	}

	@Override
	public Player getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOwner() {
		// TODO Auto-generated method stub

	}

}