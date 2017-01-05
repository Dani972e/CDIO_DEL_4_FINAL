package spil.entity;

public class JailedPlayers {

	private Player[] jailedPlayers = new Player[6];
	private int[] counters = { 0, 0, 0, 0, 0, 0 };

	public void jailPlayer(Player player) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] == null) {
				jailedPlayers[i] = player;
				counters[i] = 2;
				break;
			}
		}
	}

	public boolean isJailed(Player player) {
		for (int i = 0, n = jailedPlayers.length; i < n; i++) {
			if (jailedPlayers[i] != null) {
				if (jailedPlayers[i].equals(player)) {
					if (counters[i] > 0) {
						counters[i] -= 1;
						return true;
					}
					return false;
				}
			}
		}
		return false;
	}

}