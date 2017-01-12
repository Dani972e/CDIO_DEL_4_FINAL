package test.field;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.Player;
import spil.entity.field.Shipping;

public class testShipping {

	private Shipping shipping1;
	private Shipping shipping2;
	private Shipping shipping3;
	private Shipping shipping4;

	private Player player;
	private Player player2;

	@Before
	public void setUp() throws Exception {
		shipping1 = new Shipping(4000);
		shipping2 = new Shipping(-6000);
		shipping3 = new Shipping(0);
		shipping4 = new Shipping(1);

		player = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		shipping1 = null;
		shipping2 = null;
		shipping3 = null;
		shipping4 = null;
		player = null;
		player2 = null;
	}

	/*
	 * Assuming that the user wants to buy the Fleet.
	 * Testing Prices.
	 * 
	 * Positive test, since the Fleet field should handle this
	 * without any errors.
	 */
	@Test
	public void testShipping1() {
		player.setPosition(1);
		int expected = player.getBalance() - 4000;
		shipping1.landOnField(player);
		int actual = player.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

	/*
	 * Assuming that the user wants to buy the Fleet.
	 * Testing Prices.
	 * 
	 * Positive test, since the Fleet field should handle this
	 * without any errors.
	 */
	@Test
	public void testShipping2() {
		player.setPosition(2);
		int expected = player.getBalance() + 6000;
		shipping2.landOnField(player);
		int actual = player.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

	/*
	 * Assuming that the user wants to buy the Fleet.
	 * Testing Prices.
	 * 
	 * Positive test, since the Fleet field should handle this
	 * without any errors.
	 */
	@Test
	public void testShipping3() {
		player.setPosition(1);
		int expected = player.getBalance();
		shipping3.landOnField(player);
		int actual = player.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

	/*
	 * Assuming that the user wants to buy the Fleet.
	 * Testing Prices.
	 * 
	 * Positive test, since the Fleet field should handle this
	 * without any errors.
	 */
	@Test
	public void testShipping4() {
		player.setPosition(1);

		int expected = player.getBalance() - 1;
		shipping4.landOnField(player);
		int actual = player.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

	/*
	 * Assuming that the player1 want to buy 3 Fleets.
	 * player2 lands on fleet1 and pays the correct rent.
	 */
	@Test
	public void testBuy3Shipping() {
		player.setPosition(1);
		player2.setPosition(2);

		int expected = player2.getBalance() - 2000;

		shipping1.landOnField(player);
		shipping2.landOnField(player);
		shipping3.landOnField(player);

		shipping1.landOnField(player2);

		int actual = player2.getBalance();

		assertEquals("Rent is not correct.", expected, actual);
	}

}