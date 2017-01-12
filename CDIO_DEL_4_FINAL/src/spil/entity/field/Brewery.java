package spil.entity.field;

import java.util.ArrayList;
import java.util.List;

import spil.boundary.GUIBoundary;
import spil.entity.FieldInfo;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * final class so nobody accidently inherits from this class.
 */
public final class Brewery extends Ownable {

	/*
	 * ArrayList object to keep track of Players who own instances of the
	 * Brewery field.
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
	 * If a Player lands on a Brewery field, the amount of Brewery fields
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
	 * This method is invoked when this field is being sold. 
	 * It essentially resets the owner as well as giving the player
	 * balance back.
	 */
	@Override
	public void sellField(Player player, String fieldName, int fieldIndex) {
		owner = null;
		for (int i = 0; i < ownerList.size(); i++) {
			if (player.equals(ownerList.get(i))) {
				ownerList.remove(i);
			}
		}

		int balance = price / 2;
		player.addBalance(balance);

		GUIBoundary.print(TextInfo.ownableSoldMessage(player, fieldName, balance));
		GUIBoundary.updatePlayer(player);
	}

	/*
	 * Returns the amount of Brewery fields with the same owner, of this
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