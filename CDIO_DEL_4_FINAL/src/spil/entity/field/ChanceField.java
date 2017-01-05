package spil.entity.field;

import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.chancecard.ChanceCardList;

public class ChanceField extends Field {

	@Override
	public void landOnField(Player player) {
		
	}

	public void landOnChanceField(PlayerList playerList, int playerIndex, ChanceCardList chanceCardList) {
		chanceCardList.pickOneCard(playerList.getPlayer(playerIndex));

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
