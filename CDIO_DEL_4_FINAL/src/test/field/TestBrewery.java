package test.field;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.Player;
import spil.entity.field.Brewery;

public class TestBrewery {

	private Brewery b1;
	private Brewery b2;
	private Player player;
	private Player owner;

	@Before
	public void setUp() throws Exception {
		b1 = new Brewery(1000); /* Test if price of 1000 works */
		b2 = new Brewery(3000); /* Test if price of 3000 works */
		player = new Player("Player", 1000000, 0, 30000, 0);
		owner = new Player("Owner", 1000000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
		b2 = null;
		player = null;
		owner = null;
	}

	/*
	 * Tests whether the rent calculation works with 1 owner 
	 * of a Brewery field.
	 * This is a positive test, since this is expected to work.
	 */
	@Test
	public void test1OwnerRent() {
		/* Simulate player latestRoll */
		int latestRoll = 4;

		/* Owner lands on b1 and purchases it */
		b1.landOnField(owner);

		player.setLatestRoll(latestRoll);

		/* 100 times latest roll times the Brewery owner count of owner object. */
		int expected = player.getBalance() - (100 * latestRoll * 1);

		/* Player lands on b1 */
		b1.landOnField(player);

		int actual = player.getBalance();

		assertEquals("Brewery rent is not calculated correctly.", expected, actual);
	}

	/*
	 * Tests whether the rent calculation works with 2 owner 
	 * of Brewery fields.
	 * This is a positive test, since this is expected to work.
	 */
	@Test
	public void test2OwnerRent() {
		/* Simulate player latestRoll */
		int latestRoll = 4;

		/* Owner lands on b1 and purchases it */
		b1.landOnField(owner);

		/* Owner lands on b2 and purchases it */
		b2.landOnField(owner);

		player.setLatestRoll(latestRoll);

		/* 100 times latest roll times the Brewery owner count of owner object. */
		int expected = player.getBalance() - (100 * latestRoll * 2);

		/* Player lands on b1 */
		b1.landOnField(player);

		int actual = player.getBalance();

		assertEquals("Brewery rent is not calculated correctly.", expected, actual);
	}

}