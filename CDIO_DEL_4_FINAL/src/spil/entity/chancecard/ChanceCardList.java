package spil.entity.chancecard;

import spil.boundary.GUIBoundary;
import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.TextInfo;

public class ChanceCardList {

	/*
	 * Global class variables of the GameBoard and ChanceCardList array.
	 */
	private GameBoard gameBoard;
	private ChanceCard[] chanceCardList;

	/*
	 * Constructor that initializes all the different ChanceCard objects.
	 */
	public ChanceCardList(int numberOfChanceCards, GameBoard gameBoard) {
		this.gameBoard = gameBoard;

		chanceCardList = new ChanceCard[numberOfChanceCards];

		// Bonus og betaling
		for (int i = 0; i < 12; ++i)
			chanceCardList[i] = new BonusChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);
		chanceCardList[12] = new PayChanceCard(TextInfo.chanceCardValue[12], TextInfo.chanceCardText[12], 12);

		// Tax
		for (int i = 13; i < 21; ++i)
			chanceCardList[i] = new TaxChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);

		// Placering og movePlayer
		for (int i = 21; i < 24; ++i)
			chanceCardList[i] = new PlaceChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);
		for (int i = 24; i < 27; ++i)
			chanceCardList[i] = new MoveChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);

		// Jail kort
		for (int i = 27; i < numberOfChanceCards; ++i)
			chanceCardList[i] = new JailChanceCard(TextInfo.chanceCardValue[i], TextInfo.chanceCardText[i], i);
	}

	/*
	 * Shuffle all the cards, so that they are in a random order
	 * at every new game.
	 */
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

	/*
	 * Method that picks the first card in the card stack
	 * for the player object.
	 */
	public ChanceCard pickOneCard(Player player) {
		int newIndex;

		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		ChanceCard pickedCard = chanceCardList[chanceCardList.length - 1];

		/* Use card effect on the player */
		useEffect(player, pickedCard);

		for (int i = 0; i < temp.length; ++i) {
			/* Create new index */
			newIndex = i + 2;

			/* If index out of bounds, use modulo */
			while (newIndex > temp.length) {
				newIndex = newIndex - (temp.length);
			}
			/* Apply the new position to every number (not the last) */
			temp[newIndex - 1] = chanceCardList[i];
		}

		chanceCardList = temp;

		return pickedCard;
	}

	/*
	 * Method to test specific card with index.
	 */
	public ChanceCard pickOneSpecialCard(Player player, int cardID) {

		/* Array Exception */
		if (cardID >= chanceCardList.length)
			cardID = 29;

		int newIndex;

		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		ChanceCard pickedCard = chanceCardList[cardID];

		/* Activate card */
		useEffect(player, pickedCard);

		/* Use shift number to make the new position */
		for (int i = 0; i < temp.length; ++i) {
			newIndex = i + 2;

			/* If we exceed the index, use a modulo */
			while (newIndex > temp.length) {
				newIndex = newIndex - (temp.length);
			}
			/* Apply the new position to every number (not the last) */
			temp[newIndex - 1] = chanceCardList[i];
		}

		chanceCardList = temp;

		return pickedCard;
	}

	/*
	 * Method that uses the effect of the card object on the 
	 * specified player object.
	 */
	private void useEffect(Player player, ChanceCard card) {

		/* BonusChanceCard effect */
		if (card instanceof BonusChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			player.addBalance(card.getEffect());
			GUIBoundary.updatePlayer(player);

			/* TaxChanceCard effect */
		} else if (card instanceof TaxChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			player.removeBalance(card.getEffect());
			GUIBoundary.updatePlayer(player);

			/* MoveChanceCard effect */
		} else if (card instanceof MoveChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			GUIBoundary.removePlayerCar(player);
			gameBoard.movePlayer(player, card.getEffect());
			GUIBoundary.setPlayerVehicle(player);

			gameBoard.landOnField(player);
			GUIBoundary.updatePlayer(player);

			/* PayChanceCard effect */
		} else if (card instanceof PayChanceCard) {
			
			GUIBoundary.showChanceCard(player, card.getDesc());
			for (int i = 0; i < gameBoard.getPlayerList().getTotalPlayers(); ++i){
				System.out.println("DEBUG ");
				if (!player.equals(gameBoard.getPlayerList().getPlayer(i))
						&& !(gameBoard.getPlayerList().getPlayer(i) == null)) {

					System.out.println("DEBUG : SUCCESS");
					gameBoard.getPlayerList().getPlayer(i).removeBalance(card.getEffect());
					player.addBalance(card.getEffect());
					GUIBoundary.updatePlayer(gameBoard.getPlayerList().getPlayer(i));
				}
			}
			GUIBoundary.updatePlayer(player);

			/* JailChanceCard effect */
		} else if (card instanceof JailChanceCard) {
			GUIBoundary.showChanceCard(player, card.getDesc());
			GUIBoundary.removePlayerCar(player);
			player.setPosition(card.getEffect());
			GUIBoundary.setPlayerVehicle(player);
			GUIBoundary.updatePlayer(player);
			gameBoard.landOnField(player);

			/* PlaceChanceCard effect */
		} else if (card instanceof PlaceChanceCard) {
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

	/*
	 * Getter for the chanceCardList array.
	 */
	public ChanceCard[] getChanceCardList() {
		return chanceCardList;
	}

	/*
	 * Getter for a ChanceCard
	 */
	public ChanceCard getCard(int cardID) {
		for (ChanceCard card : chanceCardList)
			if (card.getUniqueID() == cardID)
				return card;

		return null;
	}

}