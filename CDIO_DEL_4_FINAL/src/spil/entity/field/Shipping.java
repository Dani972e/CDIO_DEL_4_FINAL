package spil.entity.field;

import java.util.ArrayList;
import java.util.List;

import spil.entity.FieldInfo;
import spil.entity.Player;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Shipping extends Ownable {

	/*
	 * Different rents of this field.
	 */
	private int[] rents = { FieldInfo.fleetRents[0], FieldInfo.fleetRents[1], FieldInfo.fleetRents[2],
			FieldInfo.fleetRents[3] };

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