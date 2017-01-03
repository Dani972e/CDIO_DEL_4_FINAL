package spil.entity.field;

import java.util.ArrayList;
import java.util.List;

import spil.entity.FieldInfo;
import spil.entity.Player;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Brewery extends Ownable {

	/*
	 * ArrayList object to keep track of Players who own instances of the
	 * LaborCamp field.
	 */
	private static List<Player> ownerList = new ArrayList<Player>();

	/*
	 * Rent amount of the field.
	 */
	private int rent;

	/*
	 * Constructor that sets price variable with super constructor.
	 */
	public Brewery(int price) {
		super(price);
	}

	/*
	 * If a Player lands on a LaborCamp field, the amount of LaborCamp fields
	 * with the same owner is calculated which then is used to calculate the
	 * rent of the field. Asks the Player whether they want to purchase the
	 * field or not.
	 */
	@Override
	public void landOnField(Player player) {
		int sameOwnerCount = getSameOwnerCount();
		rent = ((FieldInfo.DICE_MULTIPLIER * player.getLatestRoll()) * sameOwnerCount);

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