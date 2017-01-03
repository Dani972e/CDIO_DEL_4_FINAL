package spil.entity.field;

import spil.boundary.GUIBoundary;
import spil.entity.Player;
import spil.entity.TextInfo;

/* 
 * abstract class since an Ownable field is a concept,
 * and other Fields will inherit from this class.
 */
public abstract class Ownable extends Field {

	/*
	 * The price variable represents the price of the field. The owner variable
	 * represents the owner of the field.
	 */
	protected int price;
	protected Player owner = null;

	/*
	 * Constructor for the Ownable class which sets the value of the price
	 * variable.
	 */
	public Ownable(int price) {
		this.price = price;
	}

	/*
	 * abstract method, since all classes that inherits from this class needs a
	 * getter method for the rent variable.
	 */
	public abstract int getRent();

	/*
	 * General method for all Ownable subclasses, that needs to be able to be
	 * purchased by a player.
	 */
	public boolean purchaseField(Player player, int price, int rent) {
		if (owner == null) {
			if (GUIBoundary.purchaseField(player, price)) {
				owner = player;
				owner.removeBalance(price);
				return true;
			} else {
				GUIBoundary.print(TextInfo.purchaseDeniedMessage(player));
				return false;
			}
		} else {
			if (player.getName().equals(owner.getName())) {
				GUIBoundary.print(TextInfo.ownFieldMessage(player));
			} else {
				GUIBoundary.print(TextInfo.alreadyPurchasedMessage(player, owner, rent));
				player.removeBalance(rent);
				owner.addBalance(rent);
				GUIBoundary.updatePlayer(owner);
			}
			return false;
		}

	}

	/*
	 * Returns the owner of the particular field.
	 */
	@Override
	public Player getOwner() {
		return owner;
	}

}