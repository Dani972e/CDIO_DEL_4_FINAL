package test.field;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.Player;
import spil.entity.field.Shipping;

public class TestShipping {

	private Player player1;
	private Player player2;

	private Shipping shipping1;
	private Shipping shipping2;
	private Shipping shipping3;
	private Shipping shipping4;

	@Before
	public void setUp() throws Exception {
		shipping1 = new Shipping(4000);
		shipping2 = new Shipping(4000);
		shipping3 = new Shipping(4000);
		shipping4 = new Shipping(4000);

		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		shipping1 = null;
		shipping2 = null;
		shipping3 = null;
		shipping4 = null;

		player1 = null;
		player2 = null;
	}

	/*
	 * 
	 * Der sker et eller andet med de static ArrayLists?
	 * 
	 */

	/*
	 * Assuming that the user wants to buy the Shipping field. Testing Prices. Positive
	 * test, since the Shipping field should handle this without any errors. The
	 * player can buy the field for 4000.
	 */
	@Test
	public void testShippingPurchase() {
		int expected = player1.getBalance() - 4000;

		shipping1.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

	@Test
	public void testRentShipping1() {
		int expected = player2.getBalance() - 500;

		/* Purchase the field */
		shipping1.landOnField(player1);

		/* Land on the field */
		shipping1.landOnField(player2);

		int actual = player2.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

}