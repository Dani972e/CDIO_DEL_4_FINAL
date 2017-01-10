package spil.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
import spil.entity.field.Ownable;

public class GameBoard {

	/*
	 * Global objects of the class JailedPlayers, ChanceCardList and PlayerList.
	 */
	private JailedPlayers jailedPlayers = new JailedPlayers();
	private ChanceCardList chanceCardList = new ChanceCardList(30, this);
	private PlayerList playerList;

	/*
	 * Array that holds all the graphical fields.
	 */
	private final desktop_fields.Field[] guiFields = {

			// index 0 
			new Start.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[0][0])
					.setSubText(TextInfo.fieldText[0][1]).setDescription(TextInfo.fieldText[0][2]).build(),

			// index 1 
			new Street.Builder().setBgColor(new Color(0x169DE5)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[1][0]).setSubText(TextInfo.fieldText[1][1])
					.setDescription(TextInfo.fieldText[1][2]).build(),

			// index 2 
			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			// index 3 
			new Street.Builder().setBgColor(new Color(0x169DE5)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[3][0]).setSubText(TextInfo.fieldText[3][1])
					.setDescription(TextInfo.fieldText[3][2]).build(),

			// index 4 
			new Street.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[4][0])
					.setSubText(TextInfo.fieldText[4][1]).setDescription(TextInfo.fieldText[4][2]).build(),

			// index 5 
			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[5][0])
					.setSubText(TextInfo.fieldText[5][1]).setDescription(TextInfo.fieldText[5][2]).build(),

			// index 6 
			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[6][0]).setSubText(TextInfo.fieldText[6][1])
					.setDescription(TextInfo.fieldText[6][2]).build(),

			// index 7 
			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			// index 8 
			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[8][0]).setSubText(TextInfo.fieldText[8][1])
					.setDescription(TextInfo.fieldText[8][2]).build(),

			// index 9 					
			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[9][0]).setSubText(TextInfo.fieldText[9][1])
					.setDescription(TextInfo.fieldText[9][2]).build(),

			// index 10 
			new Jail.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[10][0])
					.setSubText(TextInfo.fieldText[10][1]).setDescription(TextInfo.fieldText[10][2]).build(),

			// index 11 					
			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[11][0]).setSubText(TextInfo.fieldText[11][1])
					.setDescription(TextInfo.fieldText[11][2]).build(),

			// index 12
			new Brewery.Builder().setBgColor(Color.BLACK).setFgColor(Color.WHITE).setTitle(TextInfo.fieldText[12][0])
					.setSubText(TextInfo.fieldText[12][1]).setDescription(TextInfo.fieldText[12][2]).build(),

			// index 13 
			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[13][0]).setSubText(TextInfo.fieldText[13][1])
					.setDescription(TextInfo.fieldText[13][2]).build(),

			// index 14 
			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[14][0]).setSubText(TextInfo.fieldText[14][1])
					.setDescription(TextInfo.fieldText[14][2]).build(),

			// index 15 
			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[15][0])
					.setSubText(TextInfo.fieldText[15][1]).setDescription(TextInfo.fieldText[15][2]).build(),

			// index 16 
			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[16][0])
					.setSubText(TextInfo.fieldText[16][1]).setDescription(TextInfo.fieldText[16][2]).build(),

			// index 17 
			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			// index 18
			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[18][0])
					.setSubText(TextInfo.fieldText[18][1]).setDescription(TextInfo.fieldText[18][2]).build(),

			// index 19
			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[19][0])
					.setSubText(TextInfo.fieldText[19][1]).setDescription(TextInfo.fieldText[19][2]).build(),

			// index 20		
			new Refuge.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[20][0])
					.setSubText(TextInfo.fieldText[20][1]).setDescription(TextInfo.fieldText[20][2]).build(),

			// index 21		
			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[21][0])
					.setSubText(TextInfo.fieldText[21][1]).setDescription(TextInfo.fieldText[21][2]).build(),

			// index 22
			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			// index 23
			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[23][0])
					.setSubText(TextInfo.fieldText[23][1]).setDescription(TextInfo.fieldText[23][2]).build(),

			// index 24
			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[24][0])
					.setSubText(TextInfo.fieldText[24][1]).setDescription(TextInfo.fieldText[24][2]).build(),

			// index 25		
			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[25][0])
					.setSubText(TextInfo.fieldText[25][1]).setDescription(TextInfo.fieldText[25][2]).build(),

			// index 26
			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[26][0])
					.setSubText(TextInfo.fieldText[26][1]).setDescription(TextInfo.fieldText[26][2]).build(),

			// index 27	
			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[27][0])
					.setSubText(TextInfo.fieldText[27][1]).setDescription(TextInfo.fieldText[27][2]).build(),

			// index 28
			new Brewery.Builder().setBgColor(Color.BLACK).setFgColor(Color.WHITE).setTitle(TextInfo.fieldText[28][0])
					.setSubText(TextInfo.fieldText[28][1]).setDescription(TextInfo.fieldText[28][2]).build(),

			// index 29
			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[29][0])
					.setSubText(TextInfo.fieldText[29][1]).setDescription(TextInfo.fieldText[29][2]).build(),

			// index 30
			new Jail.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setSubText(TextInfo.fieldText[30][1])
					.setDescription(TextInfo.fieldText[30][2]).build(),

			// index 31
			new Street.Builder().setBgColor(Color.YELLOW).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[31][0])
					.setSubText(TextInfo.fieldText[31][1]).setDescription(TextInfo.fieldText[31][2]).build(),

			// index 32
			new Street.Builder().setBgColor(Color.YELLOW).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[32][0])
					.setSubText(TextInfo.fieldText[32][1]).setDescription(TextInfo.fieldText[32][2]).build(),

			// index 33
			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			// index 34
			new Street.Builder().setBgColor(Color.YELLOW).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[34][0])
					.setSubText(TextInfo.fieldText[34][1]).setDescription(TextInfo.fieldText[34][2]).build(),

			// index 35
			new Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[35][0])
					.setSubText(TextInfo.fieldText[35][1]).setDescription(TextInfo.fieldText[35][2]).build(),

			// index 36
			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			// index 37
			new Street.Builder().setBgColor(new Color(0xB144FF)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[37][0]).setSubText(TextInfo.fieldText[37][1])
					.setDescription(TextInfo.fieldText[37][2]).build(),

			// index 38
			new Street.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[38][0])
					.setSubText(TextInfo.fieldText[38][1]).setDescription(TextInfo.fieldText[38][2]).build(),

			// index 39
			new Street.Builder().setBgColor(new Color(0xB144FF)).setFgColor(Color.BLACK)
					.setTitle(TextInfo.fieldText[39][0]).setSubText(TextInfo.fieldText[39][1])
					.setDescription(TextInfo.fieldText[39][2]).build(), };

	/*
	 * Array that holds all the functional fields.
	 */
	private final spil.entity.field.Field[] fields = {

			// index 0
			new spil.entity.field.Empty(true),

			// index 1
			new spil.entity.field.Street(1200, 50, Color.BLUE, this),

			// index 2
			new spil.entity.field.ChanceField(chanceCardList),

			// index 3
			new spil.entity.field.Street(1200, 50, Color.BLUE, this),

			// index 4
			new spil.entity.field.Tax(4000, true),

			// index 5
			new spil.entity.field.Shipping(4000),

			// index 6
			new spil.entity.field.Street(2000, 100, Color.ORANGE, this),

			// index 7
			new spil.entity.field.ChanceField(chanceCardList),

			// index 8
			new spil.entity.field.Street(2000, 100, Color.ORANGE, this),

			// index 9
			new spil.entity.field.Street(2400, 150, Color.ORANGE, this),

			// index 10
			new spil.entity.field.Jail(jailedPlayers, false),

			// index 11
			new spil.entity.field.Street(2800, 200, Color.GREEN, this),

			// index 12
			new spil.entity.field.Brewery(3000),

			// index 13
			new spil.entity.field.Street(2800, 200, Color.GREEN, this),

			// index 14
			new spil.entity.field.Street(3200, 250, Color.GREEN, this),

			// index 15
			new spil.entity.field.Shipping(4000),

			// index 16
			new spil.entity.field.Street(3600, 300, Color.GRAY, this),

			// index 17
			new spil.entity.field.ChanceField(chanceCardList),

			// index 18
			new spil.entity.field.Street(3600, 300, Color.GRAY, this),

			// index 19
			new spil.entity.field.Street(4000, 350, Color.GRAY, this),

			// index 20
			new spil.entity.field.Empty(false),

			// index 21
			new spil.entity.field.Street(4400, 350, Color.RED, this),

			// index 22
			new spil.entity.field.ChanceField(chanceCardList),

			// index 23
			new spil.entity.field.Street(4400, 350, Color.RED, this),

			// index 24
			new spil.entity.field.Street(4800, 400, Color.RED, this),

			// index 25
			new spil.entity.field.Shipping(4000),

			// index 26
			new spil.entity.field.Street(5200, 450, Color.WHITE, this),

			// index 27
			new spil.entity.field.Street(5200, 450, Color.WHITE, this),

			// index 28
			new spil.entity.field.Brewery(3000),

			// index 29
			new spil.entity.field.Street(5600, 500, Color.WHITE, this),

			// index 30
			new spil.entity.field.Jail(jailedPlayers, true),

			// index 31
			new spil.entity.field.Street(6000, 550, Color.YELLOW, this),

			// index 32
			new spil.entity.field.Street(6000, 550, Color.YELLOW, this),

			// index 33
			new spil.entity.field.ChanceField(chanceCardList),

			// index 34
			new spil.entity.field.Street(6400, 600, Color.YELLOW, this),

			// index 35
			new spil.entity.field.Shipping(4000),

			// index 36
			new spil.entity.field.ChanceField(chanceCardList),

			// index 37
			new spil.entity.field.Street(7000, 700, Color.MAGENTA, this),

			// index 38
			new spil.entity.field.Tax(2000, false),

			// index 39
			new spil.entity.field.Street(8000, 1000, Color.MAGENTA, this), };

	/*
	 * Array that holds all the car figures.
	 */
	private final Car[] playerVehicles = {
			new Car.Builder().patternHorizontalGradiant().typeRacecar().primaryColor(FieldInfo.vehicleColors[0][0])
					.secondaryColor(FieldInfo.vehicleColors[0][1]).build(),
			new Car.Builder().patternZebra().typeCar().primaryColor(FieldInfo.vehicleColors[1][0])
					.secondaryColor(FieldInfo.vehicleColors[1][1]).build(),
			new Car.Builder().patternDotted().typeTractor().primaryColor(FieldInfo.vehicleColors[2][0])
					.secondaryColor(FieldInfo.vehicleColors[2][1]).build(),
			new Car.Builder().patternHorizontalGradiant().typeUfo().primaryColor(FieldInfo.vehicleColors[3][0])
					.secondaryColor(FieldInfo.vehicleColors[3][1]).build(),
			new Car.Builder().patternZebra().typeRacecar().primaryColor(FieldInfo.vehicleColors[4][0])
					.secondaryColor(FieldInfo.vehicleColors[4][1]).build(),
			new Car.Builder().patternDotted().typeUfo().primaryColor(FieldInfo.vehicleColors[5][0])
					.secondaryColor(FieldInfo.vehicleColors[5][1]).build(), };

	/*
	 * Wrapper method for the shuffleCards method in ChanceCardList class.
	 */
	public void shuffleCards() {
		chanceCardList.shuffleCards();
	}

	/*
	 * Method that shows and initializes all the graphical fields.
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
			GUIBoundary.setPlayerVehicle(player);
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
		GUIBoundary.setPlayerVehicle(player);
	}

	/*
	 * Method that returns a shuffled array of player vehicle figures.
	 */
	public Car[] getRandomUniqueVehicles() {
		Collections.shuffle(Arrays.asList(playerVehicles));
		return playerVehicles;
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

	/*
	 * Method that checks whether a player is jailed or not.
	 */
	public boolean isJailed(Player player) {
		return jailedPlayers.isJailed(player);
	}

	/*
	 * Method that jails a player for a specific amount of turns.
	 */
	public void jailPlayer(Player player) {
		jailedPlayers.jailPlayer(player);
	}

	/*
	 * Method that decrements a specific players jail turn counter.
	 */
	public void decPlayerCounter(Player jailedPlayer) {
		jailedPlayers.decPlayerCounter(jailedPlayer);
	}

	/*
	 * Method that prompts the user to sell a specified field,
	 * sells the field is the user agrees, if not, does not sell.
	 */
	public void promptForSale(Player player) {
		/* 
		 * Lists to hold all the purchased field names and
		 * the amount of house built on them, if it is a street object.
		 */
		List<String> fieldNames = new ArrayList<>();
		List<Integer> houseCountValues = new ArrayList<>();

		/* Get all the purchased field names and the number of house on them */
		for (int i = 0, n = fields.length; i < n; i++) {
			if (fields[i] instanceof Ownable && player.equals(((Ownable) fields[i]).getOwner())) {
				fieldNames.add(TextInfo.fieldText[i][0]);

				if (fields[i].getClass().equals(spil.entity.field.Street.class)) {
					houseCountValues.add(((spil.entity.field.Street) fields[i]).getHouseCount());
				} else {
					houseCountValues.add(null);
				}
			}
		}

		String soldFieldName = "";
		int soldFieldIndex = 0;

		/*
		 * If the player owns a field and the player has pressed 'yes' for a sale, then 
		 * let the player select the specified owned field that they want to sell.
		 */
		if (fieldNames.size() > 0 && GUIBoundary.promptSale(player)) {
			soldFieldName = GUIBoundary.showSaleMenu(player, fieldNames.toArray(new String[fieldNames.size()]),
					houseCountValues.toArray(new Integer[houseCountValues.size()]));

			/* Find index of the field to be sold */
			for (int i = 0, n = guiFields.length; i < n; i++) {
				if (TextInfo.fieldText[i][0].equals(soldFieldName)) {
					soldFieldIndex = i;
					break;
				}
			}

			/* Determine which class the field to be sold is and act accordingly */
			if (fields[soldFieldIndex] instanceof Ownable) {
				if (fields[soldFieldIndex].getClass().equals(spil.entity.field.Street.class)) {
					((spil.entity.field.Street) fields[soldFieldIndex]).sellField(player, soldFieldName,
							soldFieldIndex);
				} else if (fields[soldFieldIndex].getClass().equals(spil.entity.field.Shipping.class)) {
					((spil.entity.field.Shipping) fields[soldFieldIndex]).sellField(player, soldFieldName,
							soldFieldIndex);
				} else {
					((spil.entity.field.Ownable) fields[soldFieldIndex]).sellField(player, soldFieldName,
							soldFieldIndex);
				}
			}
		} else if (fieldNames.size() > 0) {
			GUIBoundary.print(TextInfo.sellFieldDeniedMessage(player));
		}

	}

	/*
	 * This method checks whether the player owns all of the fields of a 
	 * specified color.
	 */
	public boolean isAllFieldsPurchased(Player player, Color IDColor) {
		int fieldColorCount = 0;
		int playerColorCount = 0;

		/* How many fields exist with this colour? */
		for (Field field : fields) {
			if (field instanceof spil.entity.field.Street) {
				Color fieldColor = ((spil.entity.field.Street) field).getIDColor();
				if (fieldColor.equals(IDColor))
					fieldColorCount++;
			}
		}

		/* How many fields with this colour does the player own? */
		for (Field field : fields) {
			if (field instanceof spil.entity.field.Street) {
				Color fieldColor = ((spil.entity.field.Street) field).getIDColor();
				if (fieldColor.equals(IDColor) && player.equals(((spil.entity.field.Street) field).getOwner())) {
					playerColorCount++;
				}
			}
			/* Are the fields in existence count equal to the player owned field count? */
			if (fieldColorCount == playerColorCount)
				return true;
		}
		return false;
	}

	/*
	* Setter for the playerList object.
	*/
	public void setPlayerList(PlayerList playerList) {
		this.playerList = playerList;
	}

	/*
	 * Getter method for the playerList object.
	 */
	public PlayerList getPlayerList() {
		return playerList;
	}

	/*
	 * Getter method for the fields array.
	 */
	public Field[] getAllFields() {
		return fields;
	}

}