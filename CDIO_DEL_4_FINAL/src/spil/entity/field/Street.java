package spil.entity.field;

import java.awt.Color;

import spil.boundary.GUIBoundary;
import spil.controller.GameBoard;
import spil.entity.FieldInfo;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Street extends Ownable {

	/*
	 * Rent for the Territory field.
	 */
	private int rent;
	private int houseCount = 0;
	private Color IDColor;
	private GameBoard gameBoard;
	private int initialFieldPrice;

	/*
	 * Territory constructor with field price and field rent.
	 */
	public Street(int price, int rent, Color IDColor, GameBoard gameBoard) {
		super(price);
		this.initialFieldPrice = price;
		this.rent = rent;
		this.IDColor = IDColor;
		this.gameBoard = gameBoard;
	}

	/*
	 * Prompts the player to purchase the field or not.
	 */
	@Override
	public void landOnField(Player player) {
		boolean isPurchased = super.purchaseField(player, price, rent);
		calculateHousePrice();

		if (player.equals(owner) && !isPurchased) {

			if (gameBoard.isAllFieldsPurchased(player, IDColor)) {
				if (GUIBoundary.purchaseHouse(player, houseCount, price)) {
					houseCount++;
					player.removeBalance(price);
					if (houseCount <= 4) {
						GUIBoundary.setHouses(player.getPosition(), houseCount);
					} else {
						GUIBoundary.setHotel(player.getPosition(), true);
					}
				}
			} else {
				GUIBoundary.print(TextInfo.purchaseHouseDeniedMessage(player));
			}
			if (houseCount > 0)
				calculateRent(houseCount - 1);
		}
	}

	private void calculateRent(int rentIndex) {
		if (IDColor.equals(Color.BLUE)) {
			rent = FieldInfo.blueRents[rentIndex];
		} else if (IDColor.equals(Color.ORANGE)) {
			rent = FieldInfo.orangeRents[rentIndex];
		} else if (IDColor.equals(Color.GREEN)) {
			rent = FieldInfo.greenRents[rentIndex];
		} else if (IDColor.equals(Color.GRAY)) {
			rent = FieldInfo.grayRents[rentIndex];
		} else if (IDColor.equals(Color.RED)) {
			rent = FieldInfo.redRents[rentIndex];
		} else if (IDColor.equals(Color.WHITE)) {
			rent = FieldInfo.whiteRents[rentIndex];
		} else if (IDColor.equals(Color.YELLOW)) {
			rent = FieldInfo.yellowRents[rentIndex];
		} else if (IDColor.equals(Color.MAGENTA)) {
			rent = FieldInfo.magentaRents[rentIndex];
		}
	}

	private void calculateHousePrice() {
		if (IDColor.equals(Color.BLUE)) {
			price = FieldInfo.blueHousePrice;
		} else if (IDColor.equals(Color.ORANGE)) {
			price = FieldInfo.orangeHousePrice;
		} else if (IDColor.equals(Color.GREEN)) {
			price = FieldInfo.greenHousePrice;
		} else if (IDColor.equals(Color.GRAY)) {
			price = FieldInfo.grayHousePrice;
		} else if (IDColor.equals(Color.RED)) {
			price = FieldInfo.redHousePrice;
		} else if (IDColor.equals(Color.WHITE)) {
			price = FieldInfo.whiteHousePrice;
		} else if (IDColor.equals(Color.YELLOW)) {
			price = FieldInfo.yellowHousePrice;
		} else if (IDColor.equals(Color.MAGENTA)) {
			price = FieldInfo.magentaHousePrice;
		}
	}

	@Override
	public void sellField(Player player, String fieldName) {
		deleteOwner();
		calculateHousePrice();

		int balance = 0;
		int halfHousePrice = price / 2;

		for (int i = 0; i < houseCount; i++) {
			balance += halfHousePrice;
		}

		balance += initialFieldPrice / 2;

		// DEBUG
		System.out.println("DEBUG: houseCount: " + houseCount + " | halfHousePrice: " + halfHousePrice);
		System.out.println("DEBUG: Final balance to get back: " + balance);
		player.addBalance(balance);

		GUIBoundary.print(TextInfo.streetSoldMessage(player, fieldName, houseCount, balance));
		GUIBoundary.updatePlayer(player);
	}

	/*
	 * Getter method for rent variable.
	 */
	@Override
	public int getRent() {
		return rent;
	}

	/*
	 * Sets the owner object equal to null.
	 */
	@Override
	public void deleteOwner() {
		owner = null;
	}

	public Color getIDColor() {
		return IDColor;
	}

}