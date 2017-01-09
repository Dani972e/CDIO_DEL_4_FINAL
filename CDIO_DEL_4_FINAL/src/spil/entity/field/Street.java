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

	/*
	 * Territory constructor with field price and field rent.
	 */
	public Street(int price, int rent, Color IDColor, GameBoard gameBoard) {
		super(price);
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

		if (player.equals(owner) && !isPurchased) {

			if (gameBoard.isAllFieldsPurchased(player, IDColor)) {
				if (GUIBoundary.purchaseHouse(player, houseCount)) {
					houseCount++;
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