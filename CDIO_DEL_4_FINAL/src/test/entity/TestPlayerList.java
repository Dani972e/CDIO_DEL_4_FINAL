package test.entity;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.PlayerList;

public class TestPlayerList {

	private final int MAX_BALANCE = 100000;
	private final int MIN_BALANCE = 0;

	private PlayerList playerList;
	private GameBoard gameBoard;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		playerList = new PlayerList(6, MAX_BALANCE, MIN_BALANCE, 30000, 0, gameBoard.getRandomUniqueVehicles());
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testPlayerListAll() {
		/*
		 * Test if the playerList instantiates the correct
		 * amount of Player objects. This is a positive test because
		 * 6 is within the amount and we assume that it should give
		 * us 6 players. 
		 */
		int expected = 6;
		int actual = playerList.getTotalPlayers();
		assertEquals("PlayerList did not create the expected amount of players.", expected, actual);

		/*
		 * Test if the removePlayer() method removes the correct
		 * amount of Players. We consider this as a positive test 
		 * because it should be able to remove players. 
		 */
		for (int i = 5; i > 0; --i) {
			playerList.removePlayer(playerList.getPlayer(i));
			expected = i;
			actual = playerList.getPlayersLeft();
			assertEquals(expected, actual);
		}

		/*
		 * Test whether the last Player actually exists.
		 * This is a positive test because we assume that
		 * the last player exists. 
		 */
		Player expected2 = playerList.getPlayer(0);
		Player actual2 = playerList.getLastPlayer();
		assertEquals(expected2, actual2);
	}

}