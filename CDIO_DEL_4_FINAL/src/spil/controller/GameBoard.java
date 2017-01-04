package spil.controller;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

import desktop_codebehind.Car;
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
	private final desktop_fields.Field[] guiFields;
	/*
	 * Array that holds all the functional fields.
	 */
	private final spil.entity.field.Field[] fields = {
			// Debug code do not delete.
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
			new spil.entity.field.Street(FieldInfo.territoryPrices[10], FieldInfo.territoryRents[10]),
			new Refuge(FieldInfo.refugeeReceive[0]), new Refuge(FieldInfo.refugeeReceive[1]),
			new Brewery(FieldInfo.laborCampPrices[0]), new Brewery(FieldInfo.laborCampPrices[1]),
			new Tax(FieldInfo.taxRents[0]), new Tax(FieldInfo.taxRents[1]), new Shipping(FieldInfo.fleetPrices[0]),
			new Shipping(FieldInfo.fleetPrices[1]), new Shipping(FieldInfo.fleetPrices[2]),
			new Shipping(FieldInfo.fleetPrices[3]) };

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

	/*
	 * c GameBoard constructor that initializes the graphical fields.
	 */
	public GameBoard() {
		guiFields = new desktop_fields.Field[FieldInfo.FIELD_COUNT];

		for (int i = 0; i < FieldInfo.FIELD_COUNT; i++) {
			guiFields[i] = new Street.Builder().setBgColor(Color.WHITE)
					.setFgColor(Color.BLACK).setTitle(TextInfo.fieldText[i][0])
					.setSubText(TextInfo.fieldText[i][1]).setDescription(TextInfo.fieldText[i][2]).build();
		}
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