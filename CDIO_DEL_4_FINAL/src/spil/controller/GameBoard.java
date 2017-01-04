package spil.controller;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

import desktop_codebehind.Car;
import desktop_fields.Chance;
import desktop_fields.Empty;
import desktop_fields.Jail;
import desktop_fields.Start;
import desktop_fields.Street;
import spil.boundary.GUIBoundary;
import spil.entity.FieldInfo;
import spil.entity.Player;
import spil.entity.TextInfo;
import spil.entity.field.Brewery;
import spil.entity.field.Field;
import spil.entity.field.Refuge;
import spil.entity.field.Shipping;
import spil.entity.field.Tax;

public class GameBoard {

	/*
	 * Array that holds all the graphical fields.
	 */
	private final desktop_fields.Field[] guiFields = { new Start.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK)
			.setTitle(TextInfo.fieldText[0][0]).setSubText(TextInfo.fieldText[0][1]).setDescription(TextInfo.fieldText[0][2]).build(),

			new Street.Builder().setBgColor(new Color(0x169DE5)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[1][0])
					.setSubText(TextInfo.fieldText[1][1]).setDescription(TextInfo.fieldText[1][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(new Color(0x169DE5)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[3][0])
					.setSubText(TextInfo.fieldText[3][1]).setDescription(TextInfo.fieldText[3][2]).build(),

			// Lavet om fra TAX til STREET grundet bug.)
			// new desktop_fields.Tax.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[4][0]).setSubText(TextInfo.fieldText[4][1]).setDescription(TextInfo.fieldText[4][2]).build(),
			new Street.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[4][0])
					.setSubText(TextInfo.fieldText[4][1]).setDescription(TextInfo.fieldText[4][2]).build(),

			new desktop_fields.Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[5][0])
					.setSubText(TextInfo.fieldText[5][1]).setDescription(TextInfo.fieldText[5][2]).build(),

			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[6][0])
					.setSubText(TextInfo.fieldText[6][1]).setDescription(TextInfo.fieldText[6][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[8][0])
					.setSubText(TextInfo.fieldText[8][1]).setDescription(TextInfo.fieldText[8][2]).build(),

			new Street.Builder().setBgColor(new Color(0xFCb16F)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[9][0])
					.setSubText(TextInfo.fieldText[9][1]).setDescription(TextInfo.fieldText[9][2]).build(),

			new Jail.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[10][0])
					.setSubText(TextInfo.fieldText[10][1]).setDescription(TextInfo.fieldText[10][2]).build(),

			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[11][0])
					.setSubText(TextInfo.fieldText[11][1]).setDescription(TextInfo.fieldText[11][2]).build(),

			new desktop_fields.Brewery.Builder().setBgColor(Color.BLACK).setFgColor(Color.WHITE).setTitle(TextInfo.fieldText[12][0])
					.setSubText(TextInfo.fieldText[12][1]).setDescription(TextInfo.fieldText[12][2]).build(),

			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[13][0])
					.setSubText(TextInfo.fieldText[13][1]).setDescription(TextInfo.fieldText[13][2]).build(),

			new Street.Builder().setBgColor(new Color(0xA9F446)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[14][0])
					.setSubText(TextInfo.fieldText[14][1]).setDescription(TextInfo.fieldText[14][2]).build(),

			new desktop_fields.Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[15][0])
					.setSubText(TextInfo.fieldText[15][1]).setDescription(TextInfo.fieldText[15][2]).build(),

			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[16][0])
					.setSubText(TextInfo.fieldText[16][1]).setDescription(TextInfo.fieldText[16][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[18][0])
					.setSubText(TextInfo.fieldText[18][1]).setDescription(TextInfo.fieldText[18][2]).build(),

			new Street.Builder().setBgColor(Color.GRAY).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[19][0])
					.setSubText(TextInfo.fieldText[19][1]).setDescription(TextInfo.fieldText[19][2]).build(),

			new desktop_fields.Refuge.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[20][0])
					.setSubText(TextInfo.fieldText[20][1]).setDescription(TextInfo.fieldText[20][2]).build(),

			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[21][0])
					.setSubText(TextInfo.fieldText[21][1]).setDescription(TextInfo.fieldText[21][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[23][0])
					.setSubText(TextInfo.fieldText[23][1]).setDescription(TextInfo.fieldText[23][2]).build(),

			new Street.Builder().setBgColor(Color.RED).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[24][0])
					.setSubText(TextInfo.fieldText[24][1]).setDescription(TextInfo.fieldText[24][2]).build(),

			new desktop_fields.Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[25][0])
					.setSubText(TextInfo.fieldText[25][1]).setDescription(TextInfo.fieldText[25][2]).build(),

			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[26][0])
					.setSubText(TextInfo.fieldText[26][1]).setDescription(TextInfo.fieldText[26][2]).build(),

			new Street.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[27][0])
					.setSubText(TextInfo.fieldText[27][1]).setDescription(TextInfo.fieldText[27][2]).build(),

			new desktop_fields.Brewery.Builder().setBgColor(Color.BLACK).setFgColor(Color.WHITE).setTitle(TextInfo.fieldText[28][0])
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

			new desktop_fields.Shipping.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[35][0])
					.setSubText(TextInfo.fieldText[35][1]).setDescription(TextInfo.fieldText[35][2]).build(),

			new Chance.Builder().setBgColor(Color.WHITE).setFgColor(Color.BLACK).build(),

			new Street.Builder().setBgColor(new Color(0xB144FF)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[37][0])
					.setSubText(TextInfo.fieldText[37][1]).setDescription(TextInfo.fieldText[37][2]).build(),

			// Lavet om fra TAX til STREET grundet bug.)
			// new desktop_fields.Tax.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[38][0]).setSubText(TextInfo.fieldText[38][1]).setDescription(TextInfo.fieldText[38][2]).build(),
			new Street.Builder().setBgColor(Color.PINK).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[38][0])
					.setSubText(TextInfo.fieldText[38][1]).setDescription(TextInfo.fieldText[38][2]).build(),

			new Street.Builder().setBgColor(new Color(0xB144FF)).setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[39][0])
					.setSubText(TextInfo.fieldText[39][1]).setDescription(TextInfo.fieldText[39][2]).build(), };
	/*
	 * Array that holds all the functional fields.
	 */
	private final spil.entity.field.Field[] fields = {
			/*// Debug code do not delete.
			new Refuge(0), new Refuge(0),

			new spil.entity.field.Street(FieldInfo.territoryPrices[0], FieldInfo.territoryRents[0]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[1], FieldInfo.territoryRents[1]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[2], FieldInfo.territoryRents[2]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[3], FieldInfo.territoryRents[3]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[4], FieldInfo.territoryRents[4]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[5], FieldInfo.territoryRents[5]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[6], FieldInfo.territoryRents[6]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[7], FieldInfo.territoryRents[7]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[8], FieldInfo.territoryRents[8]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[9], FieldInfo.territoryRents[9]),
			new spil.entity.field.Street(FieldInfo.territoryPrices[10], FieldInfo.territoryRents[10]), new Refuge(FieldInfo.refugeeReceive[0]),
			new Refuge(FieldInfo.refugeeReceive[1]), new Brewery(FieldInfo.laborCampPrices[0]), new Brewery(FieldInfo.laborCampPrices[1]),
			new Tax(FieldInfo.taxRents[0]), new Tax(FieldInfo.taxRents[1]), new Shipping(FieldInfo.fleetPrices[0]),
			new Shipping(FieldInfo.fleetPrices[1]), new Shipping(FieldInfo.fleetPrices[2]), new Shipping(FieldInfo.fleetPrices[3]) 
			*/
			
				new spil.entity.field.Start(4000),
				new spil.entity.field.Street(1200, 50),
				new spil.entity.field.ChanceField(),
				new spil.entity.field.Street(1200, 50),

				new spil.entity.field.Tax(4000),
				new spil.entity.field.Shipping(4000),
				new spil.entity.field.Street(2000, 100),
				new spil.entity.field.ChanceField(),
				new spil.entity.field.Street(2000, 100),
				new spil.entity.field.Street(2400, 100),
				
				new spil.entity.field.Jail(),
				new spil.entity.field.Street(2800, 200),
				new spil.entity.field.Brewery(3000),
				new spil.entity.field.Street(2800, 200),
				new spil.entity.field.Street(3200, 200),
				
				new spil.entity.field.Shipping(4000),
				new spil.entity.field.Street(3600, 300),
				new spil.entity.field.ChanceField(),
				new spil.entity.field.Street(3600, 300),
				new spil.entity.field.Street(4000, 300),
				
			};

	/*
	 * Array that holds all the car figures.
	 */
	private final Car[] playerCars = {
			new Car.Builder().patternHorizontalGradiant().typeRacecar().primaryColor(FieldInfo.carColors[0][0])
					.secondaryColor(FieldInfo.carColors[0][1]).build(),
			new Car.Builder().patternZebra().typeCar().primaryColor(FieldInfo.carColors[1][0]).secondaryColor(FieldInfo.carColors[1][1]).build(),
			new Car.Builder().patternDotted().typeTractor().primaryColor(FieldInfo.carColors[2][0]).secondaryColor(FieldInfo.carColors[2][1]).build(),
			new Car.Builder().patternHorizontalGradiant().typeTractor().primaryColor(FieldInfo.carColors[3][0])
					.secondaryColor(FieldInfo.carColors[3][1]).build(),
			new Car.Builder().patternZebra().typeRacecar().primaryColor(FieldInfo.carColors[4][0]).secondaryColor(FieldInfo.carColors[4][1]).build(),
			new Car.Builder().patternDotted().typeCar().primaryColor(FieldInfo.carColors[5][0]).secondaryColor(FieldInfo.carColors[5][1]).build(), };
	
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

		while (newPosition > numberOfFields) {
			newPosition -= numberOfFields;
		}
		player.setPosition(newPosition);
	}

	/*
	 * landOnField method that puts a player on a field.
	 */
	public void landOnField(Player player) {
		int pos = player.getPosition();
		if (pos > 1) {
			fields[pos].landOnField(player);
		} else {
			GUIBoundary.print(TextInfo.homeMessage(player));
		}
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

}