package spil.entity;

import spil.boundary.GUIBoundary;

public class JailedPlayers {

	/*
	 * Array that contains all the currently jailed players. 
	 */
	private Player[] jailedPlayers = new Player[6];

	/*
	 * Array that contains all the currently jailed players 
	 * jail counters. 0 if not jailed, counts from 3 to 0 if just jailed.
	 * Player gets out of jail at 0. 
	 */
	private int[] counters = { 0, 0, 0, 0, 0, 0 };

	/*
	 * Jails a player, gets inserted into the jailedPlayers array.
	 */
	public void jailPlayer(Player player) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] == null) {
				jailedPlayers[i] = player;
				counters[i] = 3;
				GUIBoundary.removePlayerCar(player);
				player.setPosition(10);
				GUIBoundary.setPlayerVehicle(player);
				break;
			}
		}
	}

	/*
	 * Checks whether the player object is jailed or not.
	 */
	public boolean isJailed(Player player) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] != null) {
				if (jailedPlayers[i].equals(player)) {
					if (counters[i] > 0) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}

	/*
	 * Decrements the players jail counter if jailed.
	 */
	public void decPlayerCounter(Player jailedPlayer) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] != null) {
				if (jailedPlayers[i].equals(jailedPlayer) && counters[i] > 0) {
					counters[i] -= 1;
					removeJailedPlayer(i);
					break;
				}
			}
		}
	}

	/*
	 * Removes a player from the jailedPlayers array
	 * IFF their counter as reached or is 0.
	 */
	private void removeJailedPlayer(int index) {
		if (counters[index] == 0) {
			jailedPlayers[index] = null;
		}
	}

}