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
	private int housePrice;
	private int initialRent;

	/*
	 * Territory constructor with field price and field rent.
	 */
	public Street(int price, int rent, Color IDColor, GameBoard gameBoard) {
		super(price);
		this.rent = rent;
		this.IDColor = IDColor;
		this.gameBoard = gameBoard;
		initialRent = rent;
		calculateHousePrice();
	}

	/*
	 * Prompts the player to purchase the field or not.
	 */
	@Override
	public void landOnField(Player player) {
		if (houseCount > 0) {
			calculateRent(houseCount - 1);
		} else {
			this.rent = initialRent;
		}

		boolean isPurchased = super.purchaseField(player, price, rent);

		if (player.equals(owner) && !isPurchased) {

			if (gameBoard.isAllFieldsPurchased(player, IDColor)) {
				if (GUIBoundary.purchaseHouse(player, houseCount, housePrice)) {
					houseCount++;
					player.removeBalance(housePrice);
					if (houseCount <= 4) {
						GUIBoundary.setHouses(player.getPosition(), houseCount);
					} else if (houseCount == 5) {
						GUIBoundary.setHotel(player.getPosition(), true);
					} else {
						GUIBoundary.print("Du kan ikke købe flere huse eller hoteller.");
					}
				}
			} else {
				GUIBoundary.print(TextInfo.purchaseHouseDeniedMessage(player));
			}
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
			housePrice = FieldInfo.blueHousePrice;
		} else if (IDColor.equals(Color.ORANGE)) {
			housePrice = FieldInfo.orangeHousePrice;
		} else if (IDColor.equals(Color.GREEN)) {
			housePrice = FieldInfo.greenHousePrice;
		} else if (IDColor.equals(Color.GRAY)) {
			housePrice = FieldInfo.grayHousePrice;
		} else if (IDColor.equals(Color.RED)) {
			housePrice = FieldInfo.redHousePrice;
		} else if (IDColor.equals(Color.WHITE)) {
			housePrice = FieldInfo.whiteHousePrice;
		} else if (IDColor.equals(Color.YELLOW)) {
			housePrice = FieldInfo.yellowHousePrice;
		} else if (IDColor.equals(Color.MAGENTA)) {
			housePrice = FieldInfo.magentaHousePrice;
		}
	}

	@Override
	public void sellField(Player player, String fieldName, int fieldIndex) {
		calculateHousePrice();
		deleteOwner();

		int balance = 0;
		int halfHousePrice = housePrice / 2;

		for (int i = 0; i < houseCount; i++) {
			balance += halfHousePrice;
		}

		balance += price / 2;

		player.addBalance(balance);

		GUIBoundary.print(TextInfo.streetSoldMessage(player, fieldName, houseCount, balance));

		if (houseCount == 4) {
			GUIBoundary.setHotel(fieldIndex, false);
		} else {
			GUIBoundary.setHouses(fieldIndex, 0);
		}

		houseCount = 0;
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

	public int getHouseCount() {
		return houseCount;
	}

}