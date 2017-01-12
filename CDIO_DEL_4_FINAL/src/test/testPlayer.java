package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.Player;

public class testPlayer {

	private final int MAX_BALANCE = 100000;
	private final int MIN_BALANCE = 0;
	private Player player;

	@Before
	public void setUp() throws Exception {
		player = new Player("Player T", 100000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		player = null;
	}

	/*
	 * Tests whether the initial position from the Player constructor
	 * is working correctly. This is a positive test, since we expect
	 * this to work without any errors.
	 */
	@Test
	public void testPlayerPosition0() {
		int actual = player.getPosition();

		/* 0 since the initial position of the Player is 0. */
		int expected = 0;

		assertEquals("The Players position is not correct.", expected, actual);
	}

	/*
	 * Tests whether the setPosition() method works with positive variable 10.
	 * This is considered a positive test, since this is expected to work without
	 * any errors and the system should be able to set the position to 10.
	 */
	@Test
	public void testPlayerPosition10() {
		int position = 10;

		player.setPosition(position);

		int actual = player.getPosition();

		int expected = position;

		assertEquals("The Players position is not correct.", expected, actual);
	}

	/*
	 * Tests whether the setPosition() method works with positive variable 1.
	 * This is considered a positive test, since this is expected to work without
	 * any errors.
	 */
	@Test
	public void testPlayerPosition1() {
		int position = 1;

		player.setPosition(position);

		int actual = player.getPosition();

		int expected = position;

		assertEquals("The Players position is not correct.", expected, actual);
	}

	/*
	 * Tests whether the setPosition() method works with negative variable -10.
	 * Since there are not any negative positions in the system where the Player object
	 * is used, the position should not have a negative position.
	 * 
	 * This is considered a negative test, since the Players position should 
	 * not be able to turn negative. We assumes that it will revert back to
	 * Homefield, but we can see that it has not been implemented.
	 */
	@Test
	public void testPlayerPositionNeg10() {
		int position = -10;

		player.setPosition(position);

		int actual = player.getPosition();

		int expected = 0;

		assertEquals("The Players position is not correct.", expected, actual);
	}

	/*
	 * Tests whether the Players initial BankAccount balance 
	 * is assigned correctly. This is a positive test, since
	 * this is expected to work without any problems. It works correctly. 
	 * 
	 * ATT: The getBalance() method is thoroughly tested in the
	 * testBankAccount JUnit test case. Therefore it is not tested
	 * more here.
	 */
	@Test
	public void testgetBalance30000() {
		int actual = player.getBalance();

		int expected = 30000;

		assertEquals("The Players balance is not correct.", expected, actual);
	}

	/*
	 * Tests whether the Players addBalance methods works.
	 * This is a positive test, since this is expected to 
	 * work without any problems. It works and the player gets an 
	 * amount of 100 to the current balance.
	 * 
	 * ATT: The addBalance() method is thoroughly tested in the
	 * testBankAccount JUnit test case. Therefore it is not tested
	 * more here.
	 */
	@Test
	public void testAddBalance100() {
		player.addBalance(100);

		int actual = player.getBalance();

		int expected = 30100;

		assertEquals("The Players balance is not correct.", expected, actual);
	}

	/*
	 * Tests whether the Players removeBalance methods works.
	 * This is a positive test, since this is expected to 
	 * work without any problems.
	 * 
	 * ATT: The removeBalance() method is thoroughly tested in the
	 * testBankAccount JUnit test case. Therefore it is not tested
	 * more here.
	 */
	@Test
	public void testRemoveBalance1000() {
		player.removeBalance(1000);

		int actual = player.getBalance();

		int expected = 29000;

		assertEquals("The Players balance is not correct.", expected, actual);
	}

	/*
	 * Tests whether the Players isBankrupt methods works.
	 * This is a positive test, since this is expected to 
	 * work without any problems.
	 * 
	 * ATT: The isBankrupt() method is thoroughly tested in the
	 * testBankAccount JUnit test case. Therefore it is not tested
	 * more here.
	 */
	@Test
	public void testIsBankrupt() {
		boolean actual = player.isBankrupt();
		boolean expected = false;

		assertEquals("The Player is bankrupt when it should not be.", expected, actual);
	}

	/*
	 * Tests whether the setLatestRoll() and getLatestRoll() methods
	 * are working as intended with a positive value of 10.
	 * Positive test, since the methods should both function with 10.
	 */
	@Test
	public void testsetLatestRoll10() {
		int latestRoll = 10;
		player.setLatestRoll(latestRoll);

		int expected = latestRoll;
		int actual = player.getLatestRoll();

		assertEquals("The Player is not assigned the correct LastestRoll value.", expected, actual);
	}

	/*
	 * Tests whether the setLatestRoll() and getLatestRoll() methods
	 * are working as intended with a negative value of -1.
	 * Negative test, since the methods should both function with -1.
	 * We expect it to be the latestRoll. 
	 */
	@Test
	public void testsetLatestRollNeg1() {
		int latestRoll = -1;
		player.setLatestRoll(latestRoll);

		int expected = latestRoll;
		int actual = player.getLatestRoll();

		assertEquals("The Player is not assigned the correct LastestRoll value.", expected, actual);
	}

	/*
	 * Tests whether the setLatestRoll() and getLatestRoll() methods
	 * are working as intended with a neutral value of 0.
	 * Positive test, since the methods should both function with 0.
	 */
	@Test
	public void testsetLatestRoll0() {
		int latestRoll = 0;
		player.setLatestRoll(latestRoll);

		int expected = latestRoll;
		int actual = player.getLatestRoll();

		assertEquals("The Player is not assigned the correct LastestRoll value.", expected, actual);
	}

	/*
	 * Tests whether the setLatestRoll() and getLatestRoll() methods
	 * are working as intended with a positive value of 1000.
	 * Positive test, since the methods should both function with 1000.
	 * We are testing if this method is working overall. 
	 */
	@Test
	public void testsetLatestRoll1000() {
		int latestRoll = 1000;
		player.setLatestRoll(latestRoll);

		int expected = latestRoll;
		int actual = player.getLatestRoll();

		assertEquals("The Player is not assigned the correct LastestRoll value.", expected, actual);
	}

	/*
	 * This is a negative test because we add underflow.
	 */
	@Test
	public void testBalanceUnderflow() {
		int expected = MIN_BALANCE;

		player.removeBalance(player.getBalance());
		player.addBalance(Integer.MIN_VALUE);
		player.removeBalance(1);

		int actual = player.getBalance();
		assertEquals(expected, actual);
	}

	/*
	 * Tests whether balance related methods are
	 * working correctly. Positive test it the amount
	 * is within the bounds.
	 */
	@Test
	public void testBalance() {
		int expected = 1500;
		player.addBalance(500);
		int actual = player.getBalance();
		assertEquals(expected, actual);

		expected = 500;
		player.removeBalance(1000);
		actual = player.getBalance();
		assertEquals(expected, actual);
	}

	/*
	 * adding overflow which is a negative test.
	 */
	@Test
	public void testBalanceOverflow() {
		int expected = MAX_BALANCE;

		player.removeBalance(player.getBalance());
		player.addBalance(Integer.MAX_VALUE);
		player.addBalance(1);

		int actual = player.getBalance();
		assertEquals(expected, actual);
	}

}