package spil.entity.field;

import spil.entity.Player;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Territory extends Ownable {

	/*
	 * Rent for the Territory field.
	 */
	private int rent;

	/*
	 * Territory constructor with field price and field rent.
	 */
	public Territory(int price, int rent) {
		super(price);
		this.rent = rent;
	}

	/*
	 * Prompts the player to purchase the field or not.
	 */
	@Override
	public void landOnField(Player player) {
		super.purchaseField(player, price, rent);
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

}