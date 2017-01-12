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
		player = new Player("Player 1", 1000000, 0, 30000, 0);
		owner = new Player("Owner", 1000000, 0, 30000, 0);
		b1 = new Brewery(1000);
		b2 = new Brewery(3000);
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
		b2 = null;
		player = null;
		owner = null;
	}

	/*
	 * Tests whether the landOnField method works correctly, when both
	 * Breweries are owned. This is a positive test because we are testing
	 * our requirements. 
	 */
	@Test
	public void testBrewery2OwnersRent() {
		int latestRoll = 5;
		int sameOwner = 2;

		/*
		 * Make sure that the owner object owns both Brewery fields. 
		 */

		// Position 12 for Bryghuset
		owner.setPosition(12);
		b1.landOnField(owner);

		// Position 28 for Kroen
		owner.setPosition(28);
		b2.landOnField(owner);

		int rent = (100 * latestRoll) * sameOwner;
		int expected = player.getBalance() - rent;

		/*
		 * Sets a sample latestRoll for Brewery to work.
		 * Sets position to 15 to simulate that the Player
		 * lands on Huts In The Mountain. It works as we have expected. 
		 */
		player.setLatestRoll(latestRoll);
		player.setPosition(15);
		b1.landOnField(player);

		int actual = player.getBalance();

		assertEquals("Brewery field is not removing the correct rent.", actual, expected);
	}

	/*
	 * Tests whether the landOnField method works correctly, when only one
	 * Brewery is owned. This is also a positive test because it should work
	 * without any errors. 
	 */
	@Test
	public void testBrewery1OwnersRent() {
		int latestRoll = 5;
		int sameOwner = 1;

		/*
		 * Make sure that the owner object owns one Brewery fields. 
		 */

		// Position 15 for Huts in the Mountain
		owner.setPosition(15);
		b1.landOnField(owner);

		int rent = (200 * latestRoll) * sameOwner;
		int expected = player.getBalance() - rent;

		/*
		 * Sets a sample latestRoll for LaborCamp to work.
		 * Sets position to 15 to simulate that the Player
		 * lands on Huts In The Mountain. We can see that this method
		 * works correctly and functional. 
		 */
		player.setLatestRoll(latestRoll);
		player.setPosition(15);
		b1.landOnField(player);

		int actual = player.getBalance();

		assertEquals("Brewery field is not removing the correct rent.", actual, expected);
	}

}