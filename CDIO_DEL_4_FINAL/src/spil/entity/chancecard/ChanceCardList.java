package spil.entity.chancecard;

import spil.boundary.GUIBoundary;
import spil.controller.GameBoard;
import spil.entity.Player;

public class ChanceCardList {

	private ChanceCard[] chanceCardList;
	private GameBoard gameBoard;

	public ChanceCardList(int numberOfChanceCards, GameBoard gameBoard) {
		this.gameBoard = gameBoard;

		chanceCardList = new ChanceCard[numberOfChanceCards];

		for (int i = 0; i < (int) (numberOfChanceCards / 4); ++i)
			chanceCardList[i] = new BonusChanceCard(i * 100 + 1);

		for (int i = (int) (numberOfChanceCards / 4); i < (int) (2 * (numberOfChanceCards / 4)); ++i)
			chanceCardList[i] = new TaxChanceCard(i * 50);

		for (int i = (int) (2 * (numberOfChanceCards / 4)); i < (int) (3 * (numberOfChanceCards / 4)); ++i)
			chanceCardList[i] = new MoveChanceCard(i - 10);

		for (int i = (int) (3 * (numberOfChanceCards / 4)); i < numberOfChanceCards; ++i)
			chanceCardList[i] = new PayChanceCard(i * 25);

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
			GUIBoundary.print("effect: " +  card.getEffect() + " " + player.getName());
			player.addBalance(card.getEffect());

		} else if (card instanceof TaxChanceCard) {
			player.removeBalance(card.getEffect());
			GUIBoundary.print("effect: -" + card.getEffect() + " " + player.getName());

		} else if (card instanceof MoveChanceCard) {
			GUIBoundary.removePlayerCar(player);
			gameBoard.movePlayer(player, card.getEffect());
			GUIBoundary.placePlayerCar(player);

			gameBoard.landOnField(player);
			GUIBoundary.updatePlayer(player);
			GUIBoundary.print("effect move: " + card.getEffect() + " " + player.getName());

		} else if (card instanceof PayChanceCard) {
			for (int i = 0; i < gameBoard.getPlayerList().getTotalPlayers(); ++i)
				if (!player.equals(gameBoard.getPlayerList().getPlayer(i)) && gameBoard.getPlayerList().getPlayer(i)==null) {
					gameBoard.getPlayerList().getPlayer(i).removeBalance(card.getEffect());
					player.addBalance(card.getEffect());
					GUIBoundary.updatePlayer(gameBoard.getPlayerList().getPlayer(i));
				}
			GUIBoundary.print("effect/ all players shall pay: " + card.getEffect() + " to " + player.getName());
			GUIBoundary.updatePlayer(player);
		} else if(card instanceof JailChanceCard)
			GUIBoundary.print("Jail chance card is not implemented yet !");
	}

}