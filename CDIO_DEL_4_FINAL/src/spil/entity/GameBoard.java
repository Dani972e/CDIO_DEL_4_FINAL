package spil.entity;

import java.util.Arrays;
import java.util.Collections;

import desktop_codebehind.Car;
import desktop_fields.Street;
import spil.boundery.GUIBoundary;
import spil.entity.field.Field;
import spil.entity.field.Fleet;
import spil.entity.field.LaborCamp;
import spil.entity.field.Refugee;
import spil.entity.field.Tax;
import spil.entity.field.Territory;

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
			new Refugee(0), new Refugee(0),

			new Territory(FieldInfo.territoryPrices[0], FieldInfo.territoryRents[0]),
			new Territory(FieldInfo.territoryPrices[1], FieldInfo.territoryRents[1]),
			new Territory(FieldInfo.territoryPrices[2], FieldInfo.territoryRents[2]),
			new Territory(FieldInfo.territoryPrices[3], FieldInfo.territoryRents[3]),
			new Territory(FieldInfo.territoryPrices[4], FieldInfo.territoryRents[4]),
			new Territory(FieldInfo.territoryPrices[5], FieldInfo.territoryRents[5]),
			new Territory(FieldInfo.territoryPrices[6], FieldInfo.territoryRents[6]),
			new Territory(FieldInfo.territoryPrices[7], FieldInfo.territoryRents[7]),
			new Territory(FieldInfo.territoryPrices[8], FieldInfo.territoryRents[8]),
			new Territory(FieldInfo.territoryPrices[9], FieldInfo.territoryRents[9]),
			new Territory(FieldInfo.territoryPrices[10], FieldInfo.territoryRents[10]),
			new Refugee(FieldInfo.refugeeReceive[0]), new Refugee(FieldInfo.refugeeReceive[1]),
			new LaborCamp(FieldInfo.laborCampPrices[0]), new LaborCamp(FieldInfo.laborCampPrices[1]),
			new Tax(FieldInfo.taxRents[0]), new Tax(FieldInfo.taxRents[1]), new Fleet(FieldInfo.fleetPrices[0]),
			new Fleet(FieldInfo.fleetPrices[1]), new Fleet(FieldInfo.fleetPrices[2]),
			new Fleet(FieldInfo.fleetPrices[3]) };

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
			guiFields[i] = new Street.Builder().setBgColor(FieldInfo.fieldColors[i][0])
					.setFgColor(FieldInfo.fieldColors[i][1]).setTitle(TextInfo.fieldText[i][0])
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