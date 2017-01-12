package test.field;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.field.Shipping;

public class TestShipping {
	private GameBoard gameBoard;
	private Player player1;
	private Player player2;
	private Shipping shipping1;
	private Shipping shipping2;
	private Shipping shipping3;
	private Shipping shipping4;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		shipping1 = new Shipping(4000);
		shipping2 = new Shipping(4000);
		shipping3 = new Shipping(4000);
		shipping4 = new Shipping(4000);

		player1 = new Player("player1", 1000000, 0, 30000, 0);
		player2 = new Player("player2", 1000000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		shipping1 = null;
		shipping2 = null;
		shipping3 = null;
		shipping4 = null;
		player1 = null;
		player2 = null;
	}

	/*
	 * Assuming that the user wants to buy the Fleet. Testing Prices. Positive
	 * test, since the Fleet field should handle this without any errors. The
	 * player can buy the field for 4000kr
	 */
	// @Test
	// public void testShipping1() {
	// player1.setPosition(5);
	// int expected = player1.getBalance() - 4000;
	// shipping1.landOnField(player1);
	// int actual = player1.getBalance();
	//
	// assertEquals("Price is not correct.", expected, actual);
	// }
	//
	// /*
	// * Assuming that the user wants to buy the Fleet. Testing Prices. Positive
	// * test, since the Fleet field should handle this without any errors. The
	// * player can buy the field for 4000kr
	// */
	// @Test
	// public void testShipping2() {
	// player1.setPosition(15);
	// int expected = player1.getBalance() - 4000;
	// shipping2.landOnField(player1);
	// int actual = player1.getBalance();
	//
	// assertEquals("Price is not correct.", expected, actual);
	// }
	//
	// /*
	// * Assuming that the user wants to buy the Fleet. Testing Prices. Positive
	// * test, since the Fleet field should handle this without any errors. The
	// * player can buy the field for 4000kr
	// */
	// @Test
	// public void testShipping3() {
	// player1.setPosition(25);
	// int expected = player1.getBalance() - 4000;
	// shipping3.landOnField(player1);
	// int actual = player1.getBalance();
	//
	// assertEquals("Price is not correct.", expected, actual);
	// }
	//
	// /*
	// * Assuming that the user wants to buy the Fleet. Testing Prices. Positive
	// * test, since the Fleet field should handle this without any errors. The
	// * player can buy the field for 4000kr
	// */
	// @Test
	// public void testShipping4() {
	// player1.setPosition(35);
	// int expected = player1.getBalance() - 4000;
	// shipping4.landOnField(player1);
	// int actual = player1.getBalance();
	//
	// assertEquals("Price is not correct.", expected, actual);
	// }

	@Test
	public void testRentShipping1() {
		int expected = player2.getBalance() - 500;

		player1.setPosition(5);
		shipping1.landOnField(player1);

		shipping1.landOnField(player2);
		int actual = player2.getBalance();

		assertEquals("Price is not correct.", expected, actual);

	}

	@Test
	public void testRentShipping2() {

		int expected = player1.getBalance() - 1000;

		player2.setPosition(15);
		shipping1.landOnField(player2);

		player2.setPosition(25);
		shipping2.landOnField(player2);

		shipping1.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}

	@Test
	public void testRentShipping3() {

		int expected = player2.getBalance() - 2000;

		player1.setPosition(15);
		shipping1.landOnField(player1);

		player1.setPosition(25);
		shipping2.landOnField(player1);

		player1.setPosition(35);
		shipping3.landOnField(player1);

		shipping3.landOnField(player2);
		int actual = player2.getBalance();

		assertEquals("Price is not correct.", expected, actual);
	}
	// @Test
	// public void testRentShipping4() {
	// int expected = player1.getBalance() - 4000;
	//
	// player2.setPosition(35);
	// shipping4.landOnField(player2);
	//
	// player2.setPosition(25);
	// shipping3.landOnField(player2);
	//
	// player2.setPosition(15);
	// shipping2.landOnField(player2);
	//
	// player2.setPosition(5);
	// shipping1.landOnField(player2);
	//
	//
	// shipping.landOnField(player1);
	// int actual = player1.getBalance();
	//
	// assertEquals("Price is not correct.", expected, actual);
	// }
}