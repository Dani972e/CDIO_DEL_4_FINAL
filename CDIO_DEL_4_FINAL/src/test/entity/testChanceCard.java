package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.JailedPlayers;
import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.chancecard.ChanceCard;
import spil.entity.chancecard.ChanceCardList;

public class testChanceCard {

	private static final int numberOfChanceCards=30;
	private static PlayerList playerList;
	private static GameBoard gameBoard;
	private static Player actualPlayer;
	private static ChanceCardList chanceCardList;
	private static JailedPlayers jp;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		playerList = new PlayerList(6, 10000000, 0, 1000, 0, gameBoard.getRandomUniqueVehicles());
		gameBoard.setPlayerList(playerList);
		chanceCardList=new ChanceCardList(numberOfChanceCards, gameBoard);
		actualPlayer = gameBoard.getPlayerList().getPlayer(0);
		jp = new JailedPlayers();
	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		chanceCardList=null;
		playerList=null;
		actualPlayer=null;
		jp=null;
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
	}

	@Test
	public final void testTaxEffect2() {

		int expected = 0;

		chanceCardList.pickOneSpecialCard(actualPlayer, 14);

		int actual = actualPlayer.getBalance();

		assertEquals(expected, actual);
	}


	/*
	 * Testing 2 MoveChanceCard Effect
	 * Index 24, 25 and 26
	 */
	@Test
	public final void testMoveEffect() {

		int expected = 5;

		chanceCardList.pickOneSpecialCard(actualPlayer, 24);

		int actual = actualPlayer.getPosition();

		assertEquals(expected, actual);
	}

	@Test
	public final void testMoveEffect2() {

		int expected = 4;

		System.out.println(actualPlayer.getPosition());

		ChanceCard pickedcard=chanceCardList.pickOneSpecialCard(actualPlayer, 25);

		System.out.println(pickedcard.getEffect());

		int actual = actualPlayer.getPosition();

		System.out.println(actualPlayer.getPosition());

		assertEquals(expected, actual);
	}

	//Array Exception
	@Test
	public final void testMoveEffect3() {

		int expected = 1;

		gameBoard.movePlayer(actualPlayer, 38);
		chanceCardList.pickOneSpecialCard(actualPlayer, 26);

		int actual = actualPlayer.getPosition();

		assertEquals(expected, actual);
	}
	
	/*
	 * Testing PayEffect
	 */
	@Test
	public final void testPayEffect() {

		int expected = 11;

		chanceCardList.pickOneSpecialCard(actualPlayer, 23);

		int actual = actualPlayer.getPosition(); // Don't work with jp.isJailed Method
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Testing PlaceEffect
	 */
	@Test
	public final void testPlaceEffect() {

		int expected = 11;

		chanceCardList.pickOneSpecialCard(actualPlayer, 23);

		int actual = actualPlayer.getPosition(); // Don't work with jp.isJailed Method
		
		assertEquals(expected, actual);
	}

	/*
	 * Testing if player go to jail
	 */
	@Test
	public final void testJailEffect() {

		int expected = 10;

		chanceCardList.pickOneSpecialCard(actualPlayer, 29);
		
		int actual = actualPlayer.getPosition(); // Don't work with jp.isJailed Method
		
		assertEquals(expected, actual);
	}

}
