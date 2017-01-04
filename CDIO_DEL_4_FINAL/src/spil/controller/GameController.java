package spil.controller;

import spil.boundary.GUIBoundary;
import spil.entity.DiceCup;
import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.TextInfo;

public class GameController {

	/*
	 * Objects from the entities package. diceCup holds all the dice in the
	 * game. playerList holds all the players in the game. gameBoard manages the
	 * fields in the game.
	 */
	private DiceCup diceCup;
	private PlayerList playerList;
	private GameBoard gameBoard;

	/*
	 * Constructor that initializes the above objects, and starts the game loop.
	 */
	public GameController() {
		diceCup = new DiceCup(2, 6);

		gameBoard = new GameBoard();

		gameBoard.initFields();

		int playerAmount = GUIBoundary.decidePlayerAmount();

		// Position used to be 0, changed it to 1 for debugging purposes.
		playerList = new PlayerList(playerAmount, 10000000, 0, 30000, 1, gameBoard.getRandomUniqueCars());
		playerList.setHomeCars();

		GUIBoundary.print(TextInfo.playerAmountMessage(playerAmount));

		initGameLoop();
	}

	/*
	 * The actual game loop of the system. Will run each player through a turn
	 * until there is only one player left, who then is the winner.
	 */
	private void initGameLoop() {
		int index = 0;

		while (playerList.getPlayersLeft() > 1) {
			while (playerList.getPlayer(index) == null)
				index = calculateIndex(index);

			Player currentPlayer = playerList.getPlayer(index);

			GUIBoundary.print(TextInfo.rollInfoMessage(currentPlayer));

			int[] rollList = diceCup.rollDice(currentPlayer);
			int rollTotal = diceCup.getTotalRoll(rollList);

			currentPlayer.setLatestRoll(rollTotal);
			GUIBoundary.showDice(rollList);
			GUIBoundary.print(TextInfo.rollMessage(currentPlayer, rollList));

			/*
			 * Der kommer en fejl her, grundet at Player positionen er 0 (functional field index) som start,
			 * DOG er GUI felternes start felt index 1! 
			 *
			 * Så her er et problem.
			 */
			GUIBoundary.removePlayerCar(currentPlayer);
			gameBoard.movePlayer(currentPlayer, rollTotal);
			GUIBoundary.placePlayerCar(currentPlayer);

			gameBoard.landOnField(currentPlayer);
			GUIBoundary.updatePlayer(currentPlayer);

			if (currentPlayer.isBankrupt()) {
				GUIBoundary.print(TextInfo.removePlayerMessage(currentPlayer));
				GUIBoundary.removePlayerCar(currentPlayer);
				gameBoard.deleteFieldOwners(currentPlayer);
				playerList.removePlayer(currentPlayer);
			}
			index = calculateIndex(index);
		}

		GUIBoundary.print(TextInfo.winnerMessage(playerList.getLastPlayer()));

		System.exit(0);
	}

	/*
	 * Calculate the Player index, so that it is always in the arrays limit.
	 */
	private int calculateIndex(int index) {
		if (index == (playerList.getTotalPlayers() - 1)) {
			return index = 0;
		}
		return index + 1;
	}

}