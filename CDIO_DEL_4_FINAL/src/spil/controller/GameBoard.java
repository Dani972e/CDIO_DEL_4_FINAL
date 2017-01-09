package spil.controller;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

import desktop_codebehind.Car;
import desktop_fields.Brewery;
import desktop_fields.Chance;
import desktop_fields.Jail;
import desktop_fields.Refuge;
import desktop_fields.Shipping;
import desktop_fields.Start;
import desktop_fields.Street;
import spil.boundary.GUIBoundary;
import spil.entity.FieldInfo;
import spil.entity.JailedPlayers;
import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.TextInfo;
import spil.entity.chancecard.ChanceCardList;
import spil.entity.field.Field;

public class GameBoard {

	private JailedPlayers jailedPlayers = new JailedPlayers();

	/*
	 * Array that holds all the graphical fields.
	 */
	private final desktop_fields.Field[] guiFields = {
			new Start.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[0][0])
					.setSubText(TextInfo.fieldText[0][1]).setDescription(TextInfo.fieldText[0][2]).build(),

			new Street.Builder().setBgColor(new Color(0x169DE5)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[1][0]).setSubText(TextInfo.fieldText[1][1])
					.setDescription(TextInfo.fieldText[1][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(new Color(0x169DE5)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[3][0]).setSubText(TextInfo.fieldText[3][1])
					.setDescription(TextInfo.fieldText[3][2]).build(),

			// Lavet om fra TAX til STREET grundet bug.)
			// new
			// desktop_fields.Tax.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[4][0]).setSubText(TextInfo.fieldText[4][1]).setDescription(TextInfo.fieldText[4][2]).build(),
			new Street.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[4][0])
					.setSubText(TextInfo.fieldText[4][1]).setDescription(TextInfo.fieldText[4][2]).build(),

			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[5][0])
					.setSubText(TextInfo.fieldText[5][1]).setDescription(TextInfo.fieldText[5][2]).build(),

			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[6][0]).setSubText(TextInfo.fieldText[6][1])
					.setDescription(TextInfo.fieldText[6][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[8][0]).setSubText(TextInfo.fieldText[8][1])
					.setDescription(TextInfo.fieldText[8][2]).build(),

			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[9][0]).setSubText(TextInfo.fieldText[9][1])
					.setDescription(TextInfo.fieldText[9][2]).build(),

			new Jail.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[10][0])
					.setSubText(TextInfo.fieldText[10][1]).setDescription(TextInfo.fieldText[10][2]).build(),

			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[11][0]).setSubText(TextInfo.fieldText[11][1])
					.setDescription(TextInfo.fieldText[11][2]).build(),

			new Brewery.Builder().setBgColor(Color.BLACK).setFgColor(Color.WHITE).setTitle(TextInfo.fieldText[12][0])
					.setSubText(TextInfo.fieldText[12][1]).setDescription(TextInfo.fieldText[12][2]).build(),

			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[13][0]).setSubText(TextInfo.fieldText[13][1])
					.setDescription(TextInfo.fieldText[13][2]).build(),

			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[14][0]).setSubText(TextInfo.fieldText[14][1])
					.setDescription(TextInfo.fieldText[14][2]).build(),

			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[15][0])
					.setSubText(TextInfo.fieldText[15][1]).setDescription(TextInfo.fieldText[15][2]).build(),

			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[16][0])
					.setSubText(TextInfo.fieldText[16][1]).setDescription(TextInfo.fieldText[16][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[18][0])
					.setSubText(TextInfo.fieldText[18][1]).setDescription(TextInfo.fieldText[18][2]).build(),

			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[19][0])
					.setSubText(TextInfo.fieldText[19][1]).setDescription(TextInfo.fieldText[19][2]).build(),

			new Refuge.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[20][0])
					.setSubText(TextInfo.fieldText[20][1]).setDescription(TextInfo.fieldText[20][2]).build(),

			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[21][0])
					.setSubText(TextInfo.fieldText[21][1]).setDescription(TextInfo.fieldText[21][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[23][0])
					.setSubText(TextInfo.fieldText[23][1]).setDescription(TextInfo.fieldText[23][2]).build(),

			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[24][0])
					.setSubText(TextInfo.fieldText[24][1]).setDescription(TextInfo.fieldText[24][2]).build(),

			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[25][0])
					.setSubText(TextInfo.fieldText[25][1]).setDescription(TextInfo.fieldText[25][2]).build(),

			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[26][0])
					.setSubText(TextInfo.fieldText[26][1]).setDescription(TextInfo.fieldText[26][2]).build(),

			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[27][0])
					.setSubText(TextInfo.fieldText[27][1]).setDescription(TextInfo.fieldText[27][2]).build(),

			new Brewery.Builder().setBgColor(Color.BLACK).setFgColor(Color.WHITE).setTitle(TextInfo.fieldText[28][0])
					.setSubText(TextInfo.fieldText[28][1]).setDescription(TextInfo.fieldText[28][2]).build(),

			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[29][0])
					.setSubText(TextInfo.fieldText[29][1]).setDescription(TextInfo.fieldText[29][2]).build(),

			new Jail.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setSubText(TextInfo.fieldText[30][1])
					.setDescription(TextInfo.fieldText[30][2]).build(),

			new Street.Builder().setBgColor(Color.YELLOW).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[31][0])
					.setSubText(TextInfo.fieldText[31][1]).setDescription(TextInfo.fieldText[31][2]).build(),

			new Street.Builder().setBgColor(Color.YELLOW).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[32][0])
					.setSubText(TextInfo.fieldText[32][1]).setDescription(TextInfo.fieldText[32][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(Color.YELLOW).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[34][0])
					.setSubText(TextInfo.fieldText[34][1]).setDescription(TextInfo.fieldText[34][2]).build(),

			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[35][0])
					.setSubText(TextInfo.fieldText[35][1]).setDescription(TextInfo.fieldText[35][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(new Color(0xB144FF)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[37][0]).setSubText(TextInfo.fieldText[37][1])
					.setDescription(TextInfo.fieldText[37][2]).build(),

			// Lavet om fra TAX til STREET grundet bug.)
			// new
			// desktop_fields.Tax.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[38][0]).setSubText(TextInfo.fieldText[38][1]).setDescription(TextInfo.fieldText[38][2]).build(),
			new Street.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[38][0])
					.setSubText(TextInfo.fieldText[38][1]).setDescription(TextInfo.fieldText[38][2]).build(),

			new Street.Builder().setBgColor(new Color(0xB144FF)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[39][0]).setSubText(TextInfo.fieldText[39][1])
					.setDescription(TextInfo.fieldText[39][2]).build(), };
	/*
	 * Array that holds all the functional fields.
	 */
	private ChanceCardList chanceCardList = new ChanceCardList(30, this);

	private final spil.entity.field.Field[] fields = { new spil.entity.field.Empty(true),
			new spil.entity.field.Street(1200, 50, Color.BLUE, this), new spil.entity.field.ChanceField(chanceCardList),
			new spil.entity.field.Street(1200, 50, Color.BLUE, this), new spil.entity.field.Tax(4000, true),
			new spil.entity.field.Shipping(4000), new spil.entity.field.Street(2000, 100, Color.ORANGE, this),
			new spil.entity.field.ChanceField(chanceCardList),
			new spil.entity.field.Street(2000, 100, Color.ORANGE, this),
			new spil.entity.field.Street(2400, 100, Color.ORANGE, this),
			new spil.entity.field.Jail(jailedPlayers, false),
			new spil.entity.field.Street(2800, 200, Color.GREEN, this), new spil.entity.field.Brewery(3000),
			new spil.entity.field.Street(2800, 200, Color.GREEN, this),
			new spil.entity.field.Street(3200, 250, Color.GREEN, this), new spil.entity.field.Shipping(4000),
			new spil.entity.field.Street(3600, 300, Color.GRAY, this),
			new spil.entity.field.ChanceField(chanceCardList),
			new spil.entity.field.Street(3600, 300, Color.GRAY, this),
			new spil.entity.field.Street(4000, 350, Color.GRAY, this), new spil.entity.field.Empty(false),
			new spil.entity.field.Street(4400, 350, Color.RED, this), new spil.entity.field.ChanceField(chanceCardList),
			new spil.entity.field.Street(4400, 350, Color.RED, this),
			new spil.entity.field.Street(4800, 400, Color.RED, this), new spil.entity.field.Shipping(4000),
			new spil.entity.field.Street(5200, 450, Color.WHITE, this),
			new spil.entity.field.Street(5200, 450, Color.WHITE, this), new spil.entity.field.Brewery(3000),
			new spil.entity.field.Street(5600, 500, Color.WHITE, this), new spil.entity.field.Jail(jailedPlayers, true),
			new spil.entity.field.Street(6000, 550, Color.YELLOW, this),
			new spil.entity.field.Street(6000, 550, Color.YELLOW, this),
			new spil.entity.field.ChanceField(chanceCardList),
			new spil.entity.field.Street(6400, 600, Color.YELLOW, this), new spil.entity.field.Shipping(4000),
			new spil.entity.field.ChanceField(chanceCardList),
			new spil.entity.field.Street(7000, 700, Color.MAGENTA, this), new spil.entity.field.Tax(2000, false),
			new spil.entity.field.Street(8000, 1000, Color.MAGENTA, this), };

	/*
	 * Array that holds all the car figures.
	 */
	private final Car[] playerCars = {
			new Car.Builder().patternHorizontalGradiant().typeRacecar().primaryColor(FieldInfo.carColors[0][0])
					.secondaryColor(FieldInfo.carColors[0][1]).build(),
			new Car.Builder().patternZebra().typeCar().primaryColor(FieldInfo.carColors[1][0])
					.secondaryColor(FieldInfo.carColors[1][1]).build(),
			new Car.Builder().patternDotted().typeTractor().primaryColor(FieldInfo.carColors[2][0])
					.secondaryColor(FieldInfo.carColors[2][1]).build(),
			new Car.Builder().patternHorizontalGradiant().typeTractor().primaryColor(FieldInfo.carColors[3][0])
					.secondaryColor(FieldInfo.carColors[3][1]).build(),
			new Car.Builder().patternZebra().typeRacecar().primaryColor(FieldInfo.carColors[4][0])
					.secondaryColor(FieldInfo.carColors[4][1]).build(),
			new Car.Builder().patternDotted().typeCar().primaryColor(FieldInfo.carColors[5][0])
					.secondaryColor(FieldInfo.carColors[5][1]).build(), };

	private PlayerList playerList;

	public void setPlayerList(PlayerList playerList) {
		this.playerList = playerList;
	}

	public PlayerList getPlayerList() {
		return playerList;
	}

	/*
	 * Method that shows all the graphical fields.
	 */
	public void initFields() {
		GUIBoundary.initFields(guiFields);
	}

	/*
	 * Method that moves a player across the graphical fields.
	 */
	public void movePlayer(Player player, int amount) {
		int newPosition = player.getPosition() + amount;
		int numberOfFields = FieldInfo.FIELD_COUNT;

		while (newPosition >= numberOfFields) {
			GUIBoundary.removePlayerCar(player);
			newPosition -= numberOfFields;
			player.setPosition(newPosition);
			GUIBoundary.placePlayerCar(player);
			GUIBoundary.print(TextInfo.startMessage(player));
			player.addBalance(4000);
			GUIBoundary.updatePlayer(player);
		}
		player.setPosition(newPosition);
	}

	/*
	 * landOnField method that puts a player on a field.
	 */
	public void landOnField(Player player) {
		int pos = player.getPosition();
		fields[pos].landOnField(player);
	}

	/*
	 * Method that places a player on the GUI.
	 */
	public void placePlayer(Player player) {
		GUIBoundary.placePlayerCar(player);
	}

	/*
	 * Method that returns a shuffled array of player car figures.
	 */
	public Car[] getRandomUniqueCars() {
		Collections.shuffle(Arrays.asList(playerCars));
		return playerCars;
	}

	/*
	 * Deletes every field that the Player owns.
	 */
	public void deleteFieldOwners(Player player) {
		for (Field field : fields) {
			if (field.getOwner() != null)
				if (field.getOwner().equals(player))
					field.deleteOwner();
		}
	}

	public boolean isJailed(Player player) {
		return jailedPlayers.isJailed(player);
	}

	public void jailPlayer(Player player) {
		jailedPlayers.jailPlayer(player);
	}

	public void decPlayerCounter(Player jailedPlayer) {
		jailedPlayers.decPlayerCounter(jailedPlayer);
	}

	public boolean isAllFieldsPurchased(Player player, Color IDColor) {

		int fieldColorCount = 0;
		int playerColorCount = 0;

		for (Field field : fields) {
			if (field instanceof spil.entity.field.Street) {
				Color fieldColor = ((spil.entity.field.Street) field).getIDColor();
				if (fieldColor.equals(IDColor))
					fieldColorCount++;
			}
		}

		for (Field field : fields) {
			if (field instanceof spil.entity.field.Street) {
				Color fieldColor = ((spil.entity.field.Street) field).getIDColor();
				if (fieldColor.equals(IDColor) && player.equals(((spil.entity.field.Street) field).getOwner())) {
					playerColorCount++;
				}
			}
			System.out.println("fieldColorCount: " + fieldColorCount + " ;;; playerColorCount: " + playerColorCount);
			if (fieldColorCount == playerColorCount)
				return true;
		}
		return false;
	}

}
