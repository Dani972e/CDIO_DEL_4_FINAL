package spil.boundary;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_resources.GUI;
import spil.entity.Player;
import spil.entity.TextInfo;

/*
 * GUIBoundary is a general class that holds all the methods associated with the communication between
 * the system and the graphical user interface (GUI). If anything is wrong with the GUI calls, then this 
 * class will probably be the sinner.
 */
public class GUIBoundary {

	private GUIBoundary() {

	}

	public static boolean purchaseField(Player player, int price) {
		String result = GUI.getUserButtonPressed(TextInfo.purchaseFieldMessage(player, price), TextInfo.buttonYesMessage, TextInfo.buttonNoMessage);
		if (result.equals(TextInfo.buttonYesMessage) && (checkBalance(player, price))) {
			print((TextInfo.purchaseConfirmedMessage(player, price)));
			return true;
		}
		return false;
	}

	private static boolean checkBalance(Player player, int price) {
		if (player.getBalance() >= price) {
			return true;
		} else {
			GUIBoundary.print(TextInfo.insufficientBalance(player, price));
			return false;
		}
	}

	public static void print(String message) {
		GUI.showMessage(message);
	}

	public static void initFields(Field[] fields) {
		GUI.create(fields);
	}

	public static void addPlayer(Player player, Car car) {
		GUI.addPlayer(player.getName(), player.getBalance(), car);
	}

	public static void updatePlayer(Player player) {
		GUI.setBalance(player.getName(), player.getBalance());
	}

	public static void placePlayerCar(Player player) {
		int magicNumber = 1;
		GUI.setCar(player.getPosition() + magicNumber, player.getName());
	}

	public static void removePlayerCar(Player player) { // THIS HERE IS IMPORTANT. (Index bug.)
		// DEBUG! 
		// Dette virker hvis man tager player.getPosition() + 1; Det giver mening. se bug report.
		
		int magicNumber = 1;
		// Det introducere dog en mulig fejl. 
		System.out.println(player.getName() + " index when removing car: " + player.getPosition() + magicNumber);
		// Vi transformerer Field index til GUI index.
		GUI.removeCar(player.getPosition() + magicNumber, player.getName());
	}

	public static boolean chooseTaxEffect(Player player, int taxAmount) {
		String btn1 = Integer.toString(taxAmount);
		String btn2 = TextInfo.btnBalancePercentage;

		String result = GUI.getUserButtonPressed(TextInfo.taxChoiceMessage(player), btn1, btn2);

		if (result.equals(btn1))
			return true;
		return false;
	}

	public static int decidePlayerAmount() {
		String result = GUI.getUserSelection(TextInfo.welcomeMessage, TextInfo.btnArray[0], TextInfo.btnArray[1], TextInfo.btnArray[2],
				TextInfo.btnArray[3], TextInfo.btnArray[4]);
		return Integer.parseInt(result);
	}

	public static void showDice(int[] rollList) {
		GUI.setDice(rollList[0], rollList[1]);
	}
}