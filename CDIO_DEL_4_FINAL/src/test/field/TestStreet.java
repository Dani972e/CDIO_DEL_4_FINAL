package test.field;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.field.Street;

public class TestStreet {

	private Player player1;
	private Player player2;

	private GameBoard gameBoard;

	private Street streetP1000R100;
	private Street streetP4000R1000;
	private Street streetP6000R3200;
	private Street streetP5500R2600;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();

		streetP1000R100 = new Street(1000, 100, Color.BLUE, gameBoard);
		streetP4000R1000 = new Street(4000, 1000, Color.BLUE, gameBoard);
		streetP6000R3200 = new Street(6000, 3200, Color.BLUE, gameBoard);
		streetP5500R2600 = new Street(5500, 2600, Color.BLUE, gameBoard);
	}

	@After
	public void tearDown() throws Exception {
		player1 = null;
		player2 = null;
	}

	/*
	 * Tests whether the landOnField() methods works on a specific Street field,
	 * with the price of 1000 and rent of 100. It is needed that Player 1 purchases
	 * the first field, so when Player 2 lands on the field, the player will pay a 
	 * rent to Player 1.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldP1000R100() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 1000;
		final int rent = 100;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 1000. */
		streetP1000R100.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		expected = player2.getBalance() - rent;

		/* Player 2 lands and pays rent of 100. */
		streetP1000R100.landOnField(player2);

		actual = player2.getBalance();

		assertEquals("Player 2 BankAccount balance is not correct. landOnField() alreadyPurchased scenario must be manipulating it wrong.", expected,
				actual);
	}

	/*
	 * Tests whether the landOnField() methods works on a specific Street field,
	 * with the price of 4000 and rent of 1000. It is needed that Player 1 purchases
	 * the first field, so  when Player 2 lands on the field, he will pay the 
	 * rent to Player 1.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldP4000R1000() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 4000;
		final int rent = 1000;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 4000. */
		streetP4000R1000.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		expected = player2.getBalance() - rent;

		/* Player 2 lands and pays rent of 1000. */
		streetP4000R1000.landOnField(player2);

		actual = player2.getBalance();

		assertEquals("Player 2 BankAccount balance is not correct. landOnField() alreadyPurchased scenario must be manipulating it wrong.", expected,
				actual);
	}

	/*
	 * Tests whether the landOnField() methods works on a specific Territory field,
	 * with the price of 6000 and rent of 3200. It is needed that Player 1 purchases
	 * the first field, so when Player 2 lands on the field, he will pay the 
	 * rent to Player 1.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldP6000R3200() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 6000;
		final int rent = 3200;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 6000. */
		streetP6000R3200.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		expected = player2.getBalance() - rent;

		/* Player 2 lands and pays rent of 3200. */
		streetP6000R3200.landOnField(player2);

		actual = player2.getBalance();

		assertEquals("Player 2 BankAccount balance is not correct. landOnField() alreadyPurchased scenario must be manipulating it wrong.", expected,
				actual);
	}

	/*
	 * Tests whether the landOnField() methods works on a specific Territory field,
	 * with the price of 5500 and rent of 2600. It is needed that Player 1 purchases
	 * the first field, so that when Player 2 lands on the field, he will pay the 
	 * rent to Player 1.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldP5500R2600() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 5500;
		final int rent = 2600;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 6000. */
		streetP5500R2600.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		expected = player2.getBalance() - rent;

		/* Player 2 lands and pays rent of 3200. */
		streetP5500R2600.landOnField(player2);

		actual = player2.getBalance();

		assertEquals("Player 2 BankAccount balance is not correct. landOnField() alreadyPurchased scenario must be manipulating it wrong.", expected,
				actual);
	}

	/*
	 * Tests whether the player can purchase a field when the player does not
	 * have enough balance to buy the field.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldInsufficientBalance() {
		player1 = new Player("Player 1", 1000000, 0, 0, 0);

		/* Nothing is removed, since the player does not purchase the field. */
		int expected = player1.getBalance();

		/* Player 1 lands and purchases the field for 4000. */
		streetP4000R1000.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);
	}

	/*
	 * Tests if the same Player can land on the same field twice in a row 
	 * with any errors.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldTwiceSamePlayer() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 4000;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 4000. */
		streetP4000R1000.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		/* Player 1 lands on the Field again */
		streetP4000R1000.landOnField(player1);
	}

	/*
	 * Tests if the same Player can land on the same field twice in a row 
	 * with any errors.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldThriceSamePlayer() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 4000;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 4000. */
		streetP4000R1000.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		/* Player 1 lands on the Field again */
		streetP4000R1000.landOnField(player1);

		/* Player 1 lands on the Field AGAIN! */
		streetP4000R1000.landOnField(player1);
	}

	/*
	 * Tests if the same Player can land on the same field three times in a row 
	 * with any errors.
	 * 
	 * This is a positive test, since the landOnField() method should be able
	 * to handle this scenario without any errors.
	 */
	@Test
	public void testLandOnFieldTwiceDifferentPlayer() {
		player1 = new Player("Player 1", 1000000, 0, 30000, 0);
		player2 = new Player("Player 2", 1000000, 0, 30000, 0);

		final int price = 4000;

		int expected = player1.getBalance() - price;

		/* Player 1 lands and purchases the field for 4000. */
		streetP4000R1000.landOnField(player1);

		int actual = player1.getBalance();

		assertEquals("Player 1 BankAccount balance is not correct. landOnField() purchase scenario must be manipulating it wrong.", expected, actual);

		/* Player 2 lands on the Field */
		streetP4000R1000.landOnField(player2);

		/* Player 2 lands on the Field again */
		streetP4000R1000.landOnField(player2);
	}

}