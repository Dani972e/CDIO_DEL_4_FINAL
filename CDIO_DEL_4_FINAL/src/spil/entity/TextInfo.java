package spil.entity;

import spil.entity.Player;

/*
 * TextBoundary is a general class that holds all the text information of the system.
 * There are variable Strings that are used throughout the game, as well as specific methods
 * that uses the Players name and roll values to display for a more interactive feeling of the
 * game.
 */
public class TextInfo {

	private TextInfo() {

	}

	public static final String TITLE = "Treasure Hunt 2";
	public static final String VERSION = "v0.02";

	public static final String[][] fieldText = { { "1. Home", "( ͡° ͜ʖ ͡°)", "Home, sweet home." },
			{ "2. Tribe Encampment", "Territory", "Rent: 100 ~ Price: 1000" },
			{ "3. Crater", "Territory", "Rent: 300 ~ Price: 1500" },
			{ "4. Mountain", "Territory", "Rent: 500 ~ Price: 2000" },
			{ "5. Cold Desert", "Territory", "Rent: 700 ~ Price: 3000" },
			{ "6. Black Cave", "Territory", "Rent: 1000 ~ Price: 4000" },
			{ "7. The Werewall", "Territory", "Rent: 1300 ~ Price: 4300" },
			{ "8. Mountain Village", "Territory", "Rent: 1600 ~ Price: 4750" },
			{ "9. South Citadel", "Territory", "Rent: 2000 ~ Price: 5000" },
			{ "10. Palace Gates", "Territory", "Rent: 2600 ~ Price: 5500" },
			{ "11. Tower", "Territory", "Rent: 3200 ~ Price: 6000" },
			{ "12. Castle", "Territory", "Rent: 4000 ~ Price: 8000" },
			{ "13. Walled city", "Refugee", "Receive: 5000" }, { "14. Monastery", "Refugee", "Receive: 500" },
			{ "15. Huts in the Mountain", "Labor Camp", "Pay: 100 * dice * owner ~ Price: 2500" },
			{ "16. The Pit", "Labor Camp", "Pay: 100 * dice * owner ~ Price: 2500" },
			{ "17. Gold Mine", "Tax", "Pay: 2000" }, { "18. Caravan", "Tax", "Pay: 4000 or 10% of your coins" },
			{ "19. Second Sail", "Fleet", "Pay: 500-4000 ~ Price: 4000" },
			{ "20. Sea Grover", "Fleet", "Pay: 500-4000 ~ Price: 4000" },
			{ "21. The Buccaneers", "Fleet", "Pay: 500-4000 ~ Price: 4000" },
			{ "22. Privateer Armade", "Fleet", "Pay: 500-4000 ~ Price: 4000" }, };

	public static final String welcomeMessage = "Welcome to " + TITLE + ", " + VERSION
			+ "!\n\nThis game is a Monopoly-like game. You'll roll with two dice"
			+ " and land on a field where the field will have an effect on your bank account. If you reach bankruptcy, you're out. The game will"
			+ " continue until only one player is left, who will be the winner.\n\nTo proceed, please choose the number of players.";

	public static final String[] btnArray = { "2", "3", "4", "5", "6" };

	public static final String playerName = "Player";

	public static final String buttonYesMessage = "Yes";
	public static final String buttonNoMessage = "No";

	public static final String btnBalancePercentage = "10% of balance";

	public static final String errorMessage = "A fatal error has occurred.";

	public static final String purchaseFieldMessage(Player player, int price) {
		return landMessage(player) + getFieldName(player) + " is available for purchase. Does " + player.getName()
				+ " want to purchase this field for " + price + " coins?";
	}

	public static final String purchaseConfirmedMessage(Player player, int price) {
		return player.getName() + " successfully bought " + getFieldName(player) + " for the price of " + price
				+ " coins.";
	}

	public static final String purchaseDeniedMessage(Player player) {
		return player.getName() + " did not purchase " + getFieldName(player) + ".";
	}

	public static final String playerAmountMessage(int playerAmount) {
		return playerAmount + " players will play the game!\n\nTo proceed, please click the \"OK\" button.";
	}

	public static String rollInfoMessage(Player player) {
		return player.getName() + ", please click the \"OK\" button to roll.";
	}

	public static String rollMessage(Player player, int[] rollValues) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0, n = rollValues.length; i < n; i++) {
			if (i == rollValues.length - 1) {
				sb.append(Integer.toString(rollValues[i]));
				break;
			}
			sb.append(Integer.toString(rollValues[i]) + ", ");
		}
		sb.append("]");
		return player.getName() + " rolled " + sb.toString() + "!";
	}

	public static final String ownFieldMessage(Player player) {
		return "This field is already owned by " + player.getName() + ", nothing will happen.";
	}

	public static String alreadyPurchasedMessage(Player player, Player owner, int rent) {
		return getFieldName(player) + " is already purchased. You'll need to pay a rent of " + rent + " to the owner, "
				+ owner.getName() + ".";
	}

	public static String bonusMessage(Player player, int bonus) {
		return landMessage(player) + player.getName() + " earned a bonus of " + bonus + "!";
	}

	public static String taxMessage(Player player, int rent) {
		return player.getName() + " pays " + rent + " for landing on " + getFieldName(player);
	}

	public static String taxChoiceMessage(Player player) {
		return player.getName() + " select one of the opportunities.";
	}

	public static String fleetOwnedMessage(Player player, Player owner, int sameOwnerCount, int rent) {
		return landMessage(player) + "This field is owned by " + owner.getName() + ", who owns a total of "
				+ sameOwnerCount + " fleet Fields." + "Therefore " + player.getName() + "will pay a rent of " + rent
				+ ".";
	}

	public static String fleetMessage(Player player, int sameOwnerCount, int rent) {
		return landMessage(player) + "This field is owned by no one, who owns a total of " + sameOwnerCount
				+ " fleet Fields." + "Therefore " + player.getName() + "will pay a rent of " + rent + ".";
	}

	public static String removePlayerMessage(Player player) {
		return player.getName() + " has been declared bankrupt, and has been removed from the game!";
	}

	public static String winnerMessage(Player player) {
		return player.getName() + " has won the game! Congratulations!";
	}

	public static String homeMessage(Player player) {
		return player.getName() + " lands on " + fieldText[0][0] + "!\n\n" + fieldText[0][1];
	}

	public static String insufficientBalance(Player player, int price) {
		return player.getName() + " does not have enough balance to purchase a field for " + price + "!";
	}

	public static String getFieldName(Player player) {
		return TextInfo.fieldText[player.getPosition() - 1][0];
	}

	public static String landMessage(Player player) {
		return player.getName() + " lands on " + getFieldName(player) + "!\n\n";
	}

};