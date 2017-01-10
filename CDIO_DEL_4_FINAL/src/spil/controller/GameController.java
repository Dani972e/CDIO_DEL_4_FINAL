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

		playerList = new PlayerList(playerAmount, 10000000, 0, 30000, 0, gameBoard.getRandomUniqueVehicles());
		playerList.setStartVehicles();

		gameBoard.setPlayerList(playerList);

		GUIBoundary.print(TextInfo.playerAmountMessage(playerAmount));

		gameBoard.shuffleCards();

		initGameLoop();
	}

	/*
	 * The actual game loop of the system. Will run each player through a turn
	 * until there is only one player left, who then is the winner.
	 */
	private void initGameLoop() {

		/* Initialize player index at 0 */
		int index = 0;

		/* 
		 * Make sure the index is calculated correctly and run 
		 * until only 1 player is left. 
		 */
		while (playerList.getPlayersLeft() > 1) {
			while (playerList.getPlayer(index) == null)
				index = calculateIndex(index);

			/* Switch currentPlayer object to the current player that is playing */
			Player currentPlayer = playerList.getPlayer(index);

			/* If the player is jailed, print a message, if not then play a round. */
			if (gameBoard.isJailed(currentPlayer)) {
				GUIBoundary.print(TextInfo.stillJailedMessage(currentPlayer));
			} else {
				playRound(currentPlayer);
			}

			/*
			 * Decrement jail counter for the player if jailed,
			 * reset identical throw index, recalculate index for new player.
			 */
			gameBoard.decPlayerCounter(currentPlayer);
			diceCup.resetSameThrowCounter();
			index = calculateIndex(index);
		}

		/* If one player is left, print a winner message for the last player alive, then quit. */
		GUIBoundary.print(TextInfo.winnerMessage(playerList.getLastPlayer()));
		System.exit(0);
	}

	/*
	* Method that "plays a round." The currentPlayer gets through a round,
	* which means that the player gets to roll the dice, purchase/sell fields or house/hotels,
	* etc.
	*/
	private void playRound(Player currentPlayer) {
		/* Prints roll starting message */
		GUIBoundary.print(TextInfo.rollInfoMessage(currentPlayer));

		/* Prompts the player for the possible sale of a field */
		gameBoard.promptForSale(currentPlayer);

		/*
		 * Get both the individual rolls and the total roll from
		 * the diceCup.
		 */
		int[] rollList = diceCup.rollDice(currentPlayer);
		int rollTotal = diceCup.getTotalRoll();

		/*
		 * Set the players latest roll value, throw the dice on the GUI, show roll message.
		 */
		currentPlayer.setLatestRoll(rollTotal);
		GUIBoundary.showDice(rollList);
		GUIBoundary.print(TextInfo.rollMessage(currentPlayer, rollList));

		/*
		 * Checks whether the player has rolled the same values in one throw, is not jailed and has thrown equal
		 * three times, if yes, then gets put to jail.
		 * 
		 * If not, player lands on a field and gets checked for another equal throw.
		 */
		if (diceCup.checkRollEquality(true) && !gameBoard.isJailed(currentPlayer) && diceCup.sameThrowJail(3)) {
			GUIBoundary.print(TextInfo.sameCounterThrowJailMessage(currentPlayer));
			gameBoard.jailPlayer(currentPlayer);
		} else {
			GUIBoundary.removePlayerCar(currentPlayer);
			gameBoard.movePlayer(currentPlayer, rollTotal);
			GUIBoundary.setPlayerVehicle(currentPlayer);

			gameBoard.landOnField(currentPlayer);
			GUIBoundary.updatePlayer(currentPlayer);

			if (diceCup.checkRollEquality(false) && !gameBoard.isJailed(currentPlayer)) {
				GUIBoundary.print(TextInfo.rollEqualityMessage(currentPlayer));
				playRound(currentPlayer);
			}
		}

		/*
		 * Checks whether the player is bankrupt, if yes, message gets shown and 
		 * player gets removed from the game with all its associated fields.
		 */
		if (currentPlayer.isBankrupt()) {
			GUIBoundary.print(TextInfo.removePlayerMessage(currentPlayer));
			GUIBoundary.removePlayerCar(currentPlayer);
			gameBoard.deleteFieldOwners(currentPlayer);
			playerList.removePlayer(currentPlayer);
		}

	}

	/*
	 * Calculate the Player index, so that it is always in the arrays limit of the current player amount.
	 */
	private int calculateIndex(int index) {
		if (index == (playerList.getTotalPlayers() - 1)) {
			return index = 0;
		}
		return index + 1;
	}

}