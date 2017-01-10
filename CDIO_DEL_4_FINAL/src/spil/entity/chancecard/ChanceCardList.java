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
		for (int i = 1; i < 12; ++i)
			chanceCardList[i] = new BonusChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i]);
		chanceCardList[12] = new PayChanceCard(TextInfo.chanceCardValue[12], TextInfo.chanceCardText[12]);

		//Tax
		for (int i = 13; i < 21; ++i)
			chanceCardList[i] = new TaxChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i]);

		//Place and move
		for (int i = 21; i < 24; ++i)
			chanceCardList[i] = new PlaceChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i]);
		chanceCardList[24] = new MoveChanceCard(TextInfo.chanceCardValue[24], TextInfo.chanceCardText[24]);
		chanceCardList[25] = new MoveChanceCard(TextInfo.chanceCardValue[25], TextInfo.chanceCardText[25]);
		chanceCardList[26] = new MoveChanceCard(TextInfo.chanceCardValue[26], TextInfo.chanceCardText[26]);

		//Jail
		chanceCardList[27] = new JailChanceCard(TextInfo.chanceCardValue[27], TextInfo.chanceCardText[27]);
		chanceCardList[28] = new JailChanceCard(TextInfo.chanceCardValue[28], TextInfo.chanceCardText[28]);
		chanceCardList[29] = new JailChanceCard(TextInfo.chanceCardValue[29], TextInfo.chanceCardText[29]);

		shuffleCards();
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

	public void pickOneCard(Player player) {

		int newIndex;

		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		useEffect(player, chanceCardList[chanceCardList.length - 1]); // Activate

		for (int i = 0; i < temp.length; ++i) {
			newIndex = i + 2; // use shift number to make the new position

			while (newIndex > temp.length) {
				newIndex = newIndex - (temp.length); // if we go out the array,
				// make a modulo
			}
			temp[newIndex - 1] = chanceCardList[i]; // apply the new position to every number (not the last)
		}

		chanceCardList = temp;
	}

	private void useEffect(Player player, ChanceCard card) {

		if (gameBoard.equals(null))
			System.out.println("DEBUG");

		if (card instanceof BonusChanceCard) {
			GUIBoundary.print(player.getName() + " : " + card.getDesc());
			player.addBalance(card.getEffect());
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof TaxChanceCard) {
			GUIBoundary.print(player.getName() + " : " + card.getDesc());
			player.removeBalance(card.getEffect());
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof MoveChanceCard) {
			GUIBoundary.print(player.getName() + " : " + card.getDesc());

			GUIBoundary.removePlayerCar(player);
			gameBoard.movePlayer(player, card.getEffect());
			GUIBoundary.placePlayerCar(player);

			gameBoard.landOnField(player);
			GUIBoundary.updatePlayer(player);

		} else if (card instanceof PayChanceCard) {
			GUIBoundary.print(player.getName() + " : " + card.getDesc());
			for (int i = 0; i < gameBoard.getPlayerList().getTotalPlayers(); ++i)
				if (!player.equals(gameBoard.getPlayerList().getPlayer(i))
						&& gameBoard.getPlayerList().getPlayer(i) == null) {
					gameBoard.getPlayerList().getPlayer(i).removeBalance(card.getEffect());
					player.addBalance(card.getEffect());
					GUIBoundary.updatePlayer(gameBoard.getPlayerList().getPlayer(i));
				}

			GUIBoundary.updatePlayer(player);

		} else if (card instanceof JailChanceCard) {
			GUIBoundary.print(player.getName() + " : " + card.getDesc() + " [NOT IMPLEMENTED YET]");
			GUIBoundary.removePlayerCar(player);
			player.setPosition(card.getEffect());
			System.out.println("Debug: " + card.getEffect());
			GUIBoundary.placePlayerCar(player);
			GUIBoundary.updatePlayer(player);
			gameBoard.landOnField(player);

		}

		else if (card instanceof PlaceChanceCard) {
			GUIBoundary.print(player.getName() + " : " + card.getDesc() + " [NOT IMPLEMENTED YET]");
			while (player.getPosition() != card.getEffect()) {
				System.out.println(player.getName() + " DEBUG PLACE " + card.getEffect() + "/n" + card.getDesc());
				GUIBoundary.removePlayerCar(player);
				gameBoard.movePlayer(player, 1);
				GUIBoundary.updatePlayer(player);

			}

			GUIBoundary.placePlayerCar(player);
			gameBoard.landOnField(player);

		}
	}

}