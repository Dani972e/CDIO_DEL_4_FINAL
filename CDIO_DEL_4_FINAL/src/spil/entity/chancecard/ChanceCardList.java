package spil.entity.chancecard;

import spil.boundary.GUIBoundary;
import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.TextInfo;

public class ChanceCardList {

	private GameBoard gameBoard;

	private ChanceCard[] chanceCardList;

	public ChanceCardList(int numberOfChanceCards, GameBoard gameBoard) {
		this.gameBoard = gameBoard;

		chanceCardList = new ChanceCard[numberOfChanceCards];

		//Bonus and pay
		for (int i = 0; i < 12; ++i)
			chanceCardList[i] = new BonusChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);
		chanceCardList[12] = new PayChanceCard(TextInfo.chanceCardValue[12], TextInfo.chanceCardText[12], 12);

		//Tax
		for (int i = 13; i < 21; ++i)
			chanceCardList[i] = new TaxChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);

		//Place and move
		for (int i = 21; i < 24; ++i)
			chanceCardList[i] = new PlaceChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);
		for (int i = 24; i < 27; ++i)
			chanceCardList[i] = new MoveChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);

		//Jail
		for (int i = 27; i < numberOfChanceCards; ++i)
			chanceCardList[i] = new JailChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);

	}

	public ChanceCard[] getAllCards() {
		return chanceCardList;
	}

	public void shuffleCards() {
		ChanceCard[] temp = new ChanceCard[chanceCardList.length];
		int randomIndex = 0;

		for (int i = 0; i < chanceCardList.length; ++i) {
			while (temp[randomIndex] != null)
				randomIndex = (int) (Math.random() * temp.length);

			temp[randomIndex] = chanceCardList[i];
		}
		chanceCardList = temp;
	}

	public ChanceCard pickOneCard(Player player) {

		int newIndex;

		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		ChanceCard pickedCard = chanceCardList[chanceCardList.length - 1];

		useEffect(player, pickedCard); // Activate

		for (int i = 0; i < temp.length; ++i) {
			newIndex = i + 2; // use shift number to make the new position

			while (newIndex > temp.length) {
				newIndex = newIndex - (temp.length); // if we go out the array,
				// make a modulo
			}
			temp[newIndex - 1] = chanceCardList[i]; // apply the new position to every number (not the last)
		}

		chanceCardList = temp;

		return pickedCard;
	}

	private void useEffect(Player player, ChanceCard card) {

		if (card instanceof BonusChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			player.addBalance(card.getEffect());
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof TaxChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			player.removeBalance(card.getEffect());
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof MoveChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			GUIBoundary.removePlayerCar(player);
			gameBoard.movePlayer(player, card.getEffect());
			GUIBoundary.setPlayerVehicle(player);

			gameBoard.landOnField(player);
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof PayChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			for (int i = 0; i < gameBoard.getPlayerList().getTotalPlayers(); ++i)
				if (!player.equals(gameBoard.getPlayerList().getPlayer(i))
						&& gameBoard.getPlayerList().getPlayer(i) == null) {
					gameBoard.getPlayerList().getPlayer(i).removeBalance(card.getEffect());
					player.addBalance(card.getEffect());
					GUIBoundary.updatePlayer(gameBoard.getPlayerList().getPlayer(i));
				}
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof JailChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			GUIBoundary.removePlayerCar(player);
			player.setPosition(card.getEffect());
			GUIBoundary.setPlayerVehicle(player);
			GUIBoundary.updatePlayer(player);
			gameBoard.landOnField(player);
		}

		else if (card instanceof PlaceChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			while (player.getPosition() != card.getEffect()) {
				GUIBoundary.removePlayerCar(player);
				gameBoard.movePlayer(player, 1);
				GUIBoundary.updatePlayer(player);
			}
			GUIBoundary.setPlayerVehicle(player);
			gameBoard.landOnField(player);
		}
	}

}