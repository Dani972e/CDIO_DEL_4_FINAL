package spil.entity;

import desktop_codebehind.Car;
import spil.boundary.GUIBoundary;

public class PlayerList {

	/*
	 * Upper bound and lower bound variables for the amount of Players this
	 * class can maintain.
	 */
	private final int MAX_PLAYER_COUNT = 6;
	private final int MIN_PLAYER_COUNT = 2;

	/*
	 * Array containing all the players in the current game instance.
	 */
	private Player[] playerList;

	/*
	 * Class constructor, taking the amount of Players in the game, as well as
	 * common variables for the Player object.
	 */
	public PlayerList(int playerCount, int maxCoinAmount, int minCoinAmount, int coins, int position, Car[] cars) {

		if (playerCount > MAX_PLAYER_COUNT) {
			playerCount = MAX_PLAYER_COUNT;
		} else if (playerCount < MIN_PLAYER_COUNT) {
			playerCount = MIN_PLAYER_COUNT;
		}

		playerList = new Player[playerCount];

		for (int i = 0; i < playerCount; i++) {
			playerList[i] = new Player(TextInfo.playerName + " " + (i + 1), maxCoinAmount, minCoinAmount, coins,
					position);
			GUIBoundary.addPlayer(playerList[i], cars[i]);
		}
	}

	/*
	 * Sets all Player objects Cars to the initial position.
	 */
	public void setHomeCars() {
		for (Player player : playerList) {
			player.setPosition(1);
			GUIBoundary.placePlayerCar(player);
			player.setPosition(0);
		}
	}

	/*
	 * Removes a Player from the game by pointing the object at null.
	 */
	public void removePlayer(Player playerToDelete) {
		int index = 0;

		for (Player player : playerList) {
			if (playerToDelete.equals(player)) {
				playerList[index] = null;

			}
			++index;
		}
	}

	/*
	 * Returns the Player object at the specified index.
	 */
	public Player getPlayer(int index) {
		return playerList[index];
	}

	/*
	 * Returns the total amount of Players.
	 */
	public int getTotalPlayers() {
		return playerList.length;
	}

	/*
	 * Returns the amount of Player objects left.
	 */
	public int getPlayersLeft() {
		int left = 0;
		for (Player player : playerList) {
			if (player instanceof Player) {
				++left;
			}
		}
		return left;
	}

	/*
	 * Returns the last Player object inside the array.
	 */
	public Player getLastPlayer() {
		Player last = null;
		for (Player player : playerList) {
			if (player instanceof Player)
				last = player;
		}
		return last;
	}

}