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

	private static final int incrementGUIIndex = 1;

	private GUIBoundary() {

	}

	public static boolean purchaseField(Player player, int price) {
		String result = GUI.getUserButtonPressed(TextInfo.purchaseFieldMessage(player, price),
				TextInfo.buttonYesMessage, TextInfo.buttonNoMessage);
		if (result.equals(TextInfo.buttonYesMessage) && (checkBalance(player, price))) {
			print((TextInfo.purchaseConfirmedMessage(player, price)));
			return true;
		}
		return false;
	}

	public static boolean purchaseHouse(Player player, int houseCount) {
		String result = GUI.getUserButtonPressed(TextInfo.purchaseHouseMessage(player, houseCount),
				TextInfo.buttonYesMessage, TextInfo.buttonNoMessage);
		if (result.equals(TextInfo.buttonYesMessage)) {
			return true;
		} else {
			return false;
		}
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
		GUI.setCar(player.getPosition() + incrementGUIIndex, player.getName());
	}

	public static void removePlayerCar(Player player) {
		GUI.removeCar(player.getPosition() + incrementGUIIndex, player.getName());
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
		String result = GUI.getUserSelection(TextInfo.welcomeMessage, TextInfo.btnArray[0], TextInfo.btnArray[1],
				TextInfo.btnArray[2], TextInfo.btnArray[3], TextInfo.btnArray[4]);
		return Integer.parseInt(result);
	}

	public static void showDice(int[] rollList) {
		GUI.setDice(rollList[0], rollList[1]);
	}

	public static void setHouses(int fieldNumber, int houseCount) {
		GUI.setHouses(fieldNumber + incrementGUIIndex, houseCount);
	}
	
	public static void setHotel(int fieldNumber, boolean hasHotel) {
		GUI.setHotel(fieldNumber, hasHotel);
	}

}