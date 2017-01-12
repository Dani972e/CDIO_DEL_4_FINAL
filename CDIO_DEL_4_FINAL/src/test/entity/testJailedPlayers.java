package test.entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.JailedPlayers;
import spil.entity.Player;

public class testJailedPlayers {

	private Player player1, player2;
	private JailedPlayers jailedPlayers;

	@Before
	public void setUp() throws Exception {
		player1 = new Player("Spiller 1", 100000, 0, 30000, 0);
		player2 = new Player("Spiller 1", 100000, 0, 30000, 0);
		jailedPlayers = new JailedPlayers();
	}

	@After
	public void tearDown() throws Exception {
		player1 = null;
		jailedPlayers = null;
	}

	/*
	 * Tests whether the object jailedPlayers can jail a player
	 * correctly. This sample is a positive test.
	 */
	@Test
	public void testJailPlayer1() {

		/* Jail the player */
		jailedPlayers.jailPlayer(player1);

		/* Get the actual boolean value */
		boolean actual = jailedPlayers.isJailed(player1);

		/* If actual is not true, give a error message. */
		assertEquals("isJailed method is giving wrong boolean output with 1 player.", true, actual);

		/* The expected value of the boolean actual */
		boolean expected = true;

		assertEquals("The jailPlayer or isJailed methods are not working.", expected, actual);
	}

	/*
	 * Tests whether the object jailedPlayers can jail a player
	 * correctly. This sample is a positive test.
	 * 
	 * This uses two players instead of 1.
	 */
	@Test
	public void testJailPlayer2() {

		/* Jail the player */
		jailedPlayers.jailPlayer(player1);
		jailedPlayers.jailPlayer(player2);

		boolean actual = false;

		/* Get the actual boolean value */
		if (jailedPlayers.isJailed(player1) && jailedPlayers.isJailed(player2)) {
			actual = true;
		}

		/* If actual is not true, give a error message. */
		assertEquals("isJailed method is giving wrong boolean output with 2 players.", true, actual);

		/* The expected value of the boolean actual */
		boolean expected = true;

		assertEquals("The jailPlayer or isJailed methods are not working.", expected, actual);
	}

	/*
	 * Tests whether the jailed players are still jailed
	 * after 10 times decrement of their counter. They should not
	 * be, so this is a negative test.
	 * 
	 * This uses two players instead of 1.
	 */
	@Test
	public void testJailedPlayersDecCounter2Neg() {

		/* Jail the player */
		jailedPlayers.jailPlayer(player1);
		jailedPlayers.jailPlayer(player2);

		boolean expected = false;

		/* Decrement their counter x times */
		for (int i = 0; i < 10; i++) {
			jailedPlayers.decPlayerCounter(player1);
			jailedPlayers.decPlayerCounter(player2);
		}

		boolean actual = jailedPlayers.isJailed(player1) && jailedPlayers.isJailed(player2);

		assertEquals("2 Players are still jailed when they should not be.", expected, actual);
	}

	/*
	 * Tests whether the jailed players are still jailed
	 * after 3 times decrement of their counter. They should not
	 * be, and this is expected, so therefore a positive test.
	 * 
	 * This uses two players instead of 1.
	 */
	@Test
	public void testJailedPlayersDecCounter2() {
		/* Jail the player */
		jailedPlayers.jailPlayer(player1);
		jailedPlayers.jailPlayer(player2);

		boolean expected = false;

		/* Decrement their counter x times */
		for (int i = 0; i < 3; i++) {
			jailedPlayers.decPlayerCounter(player1);
			jailedPlayers.decPlayerCounter(player2);
		}

		boolean actual = jailedPlayers.isJailed(player1) && jailedPlayers.isJailed(player2);

		assertEquals("2 Players are still jailed when they should not be.", expected, actual);
	}

}