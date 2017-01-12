package test.field;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;

public class TestTax {

	private static GameBoard gameBoard;
	Player actualPlayer;

	@Before
	public void setUp() throws Exception {
		actualPlayer = new Player("Player 1", 1000000, 0, 30000, 0);
		gameBoard = new GameBoard();
	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		actualPlayer = null;
	}

	/*
	 * Assume : Select 4000
	 */
	@Test
	public final void testLandOnFieldPos4() {
		int pos = 4;

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = 26000;
		int actual = actualPlayer.getBalance();

		assertEquals("False " + expected + actual, expected, actual);
	}
	

	/*
	 * Assume : Select 10%
	 */
	@Test
	public final void testLandOnFieldPos4_2() {
		int pos = 4;

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = 27000;
		int actual = actualPlayer.getBalance();

		assertEquals("False " + expected + actual, expected, actual);
	}
	
	/*
	 * Assume : Select 4000
	 */
	@Test
	public final void testLandOnFieldPos38() {
		int pos = 38;

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = 28000;
		int actual = actualPlayer.getBalance();

		assertEquals("False " + expected + actual, expected, actual);
	}
}