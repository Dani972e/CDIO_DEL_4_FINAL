package spil.entity;

public class JailedPlayers {

	private Player[] jailedPlayers = new Player[6];
	private int[] counters = { 0, 0, 0, 0, 0, 0 };

	public void jailPlayer(Player player) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] == null) {
				jailedPlayers[i] = player;
				counters[i] = 3;
				break;
			}
		}
	}

	public boolean isJailed(Player player) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] != null) {
				if (jailedPlayers[i].equals(player) && counters[i] > 0) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public void decPlayerCounter(Player jailedPlayer) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] != null) {
				// DEBUG
				System.out.println("DEBUG: " + jailedPlayers[i].getName() + ": " + counters[i]);
				if (jailedPlayers[i].equals(jailedPlayer) && counters[i] > 0) {
					counters[i] -= 1;
					removeJailedPlayer(i);
					break;
				}
			}
		}
	}

	private void removeJailedPlayer(int index) {
		if (counters[index] == 0) {
			jailedPlayers[index] = null;
		}
	}

}