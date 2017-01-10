package spil.entity.field;

import java.util.ArrayList;
import java.util.List;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Shipping extends Ownable {

	/*
	 * Different rents of this field.
	 */
	private int[] rents = { 500, 1000, 2000, 4000 };

	/*
	 * Rent variable for this field.
	 */
	private int rent;

	/*
	 * ArrayList object to keep track of Players who own instances of the Fleet
	 * field.
	 */
	private static List<Player> ownerList = new ArrayList<Player>();

	/*
	 * Constructor that sets price variable with super constructor.
	 */
	public Shipping(int price) {
		super(price);
	}

	/*
	 * Calculates the amount of Fleet fields the owner of this specific Field
	 * owns. That is used to decide the rent in the array above.
	 */
	@Override
	public void landOnField(Player player) {
		int sameOwnerCount = getSameOwnerCount();

		if ((sameOwnerCount - 1) < 1) {
			sameOwnerCount = 0;
		} else {
			sameOwnerCount -= 1;
		}

		rent = rents[sameOwnerCount];

		if (super.purchaseField(player, price, rent)) {
			ownerList.add(player);
		}
	}

	/*
	 * Returns the amount of LaborCamp fields with the same owner, of this
	 * specific field.
	 */
	private int getSameOwnerCount() {
		if (owner == null) {
			return 0;
		}

		int count = 0;

		if (ownerList.size() > 0) {
			for (Player ownerP : ownerList) {
				if (ownerP.equals(owner))
					count++;
			}
		}
		return count;
	}

	@Override
	public void sellField(Player player, String fieldName) {
		owner = null;
		// Exeption index:2, Size:1 - fejl med static.
		for (int i = 0; i < ownerList.size(); i++) {
			if (player.equals(ownerList.get(i))) {
				ownerList.remove(i);
			}
		}

		int balance = price / 2;
		player.addBalance(balance);

		// DEBUG
		System.out.println("DEBUG: Field sold.");

		GUIBoundary.print(TextInfo.ownableSoldMessage(player, fieldName, balance));
		GUIBoundary.updatePlayer(player);

	}

	/*
	 * Returns the rent variable.
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