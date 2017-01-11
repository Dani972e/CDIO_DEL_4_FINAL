package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.chancecard.ChanceCardList;

public class testChanceCard {

	private static final int numberOfChanceCards=30;
	private static PlayerList playerList;
	private static GameBoard gameBoard;
	private static Player actualPlayer;
	private static ChanceCardList chanceCardList;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		playerList = new PlayerList(6, 10000000, 0, 1000, 1, gameBoard.getRandomUniqueVehicles());
		gameBoard.setPlayerList(playerList);
		chanceCardList=new ChanceCardList(numberOfChanceCards, gameBoard);
		actualPlayer = gameBoard.getPlayerList().getPlayer(0);

	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		chanceCardList=null;
		playerList=null;
		actualPlayer=null;
	}


	/*
	 * Testing 2 BonusChanceCard Effect
	 * Index 0 and 1
	 */
	@Test
	public final void testBonusEffect() {

		int expected = 2000;

		chanceCardList.pickOneSpecialCard(actualPlayer, 0);

		int actual = actualPlayer.getBalance();

		assertEquals(expected, actual);

		System.out.println(actualPlayer.getBalance());
	}

	@Test
	public final void testBonusEffect2() {

		int expected = 4000;

		chanceCardList.pickOneSpecialCard(actualPlayer, 1);

		int actual = actualPlayer.getBalance();

		assertEquals(expected, actual);

		System.out.println(actualPlayer.getBalance());
	}


	/*
	 * Testing 2 TaxChanceCard Effect
	 * Index 13 and 14
	 */
	@Test
	public final void testTaxEffect() {

		int expected = 800;

		chanceCardList.pickOneSpecialCard(actualPlayer, 13);

		int actual = actualPlayer.getBalance();

		assertEquals(expected, actual);

		System.out.println(actualPlayer.getBalance());
	}

	@Test
	public final void testTaxEffect2() {

		int expected = 0;

		chanceCardList.pickOneSpecialCard(actualPlayer, 14);

		int actual = actualPlayer.getBalance();

		assertEquals(expected, actual);

		System.out.println(actualPlayer.getBalance());
	}

}
