package test.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.chancecard.ChanceCardList;
import spil.entity.field.ChanceField;
import spil.entity.field.Field;

public class testChanceField {

	private static final int numberOfChanceCards=30;
	private static PlayerList playerList;
	private static GameBoard gameBoard;
	private static ChanceCardList chanceCardList;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		playerList = new PlayerList(6, 10000000, 0, 1000, 1, gameBoard.getRandomUniqueVehicles());
		gameBoard.setPlayerList(playerList);
		chanceCardList=new ChanceCardList(numberOfChanceCards, gameBoard);

	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		chanceCardList=null;
		playerList=null;
	}

	@Test
	public final void testLandOnFieldPos2() {
		int pos = 2;
		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = chanceCardList.getCard(numberOfChanceCards-1).getUniqueID();

		ChanceField actualField = (ChanceField) allFields[pos];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}
	
	
	@Test
	public final void testLandOnFieldPos7() {
		int pos = 7;
		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = chanceCardList.getCard(numberOfChanceCards-1).getUniqueID();

		ChanceField actualField = (ChanceField) allFields[pos];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}
	
	@Test
	public final void testLandOnFieldPos17() {
		int pos = 17;
		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = chanceCardList.getCard(numberOfChanceCards-1).getUniqueID();

		ChanceField actualField = (ChanceField) allFields[pos];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}
	
	@Test
	public final void testLandOnFieldPos22() {
		int pos = 22;
		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = chanceCardList.getCard(numberOfChanceCards-1).getUniqueID();

		ChanceField actualField = (ChanceField) allFields[pos];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}
	
	@Test
	public final void testLandOnFieldPos33() {
		int pos = 33;
		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = chanceCardList.getCard(numberOfChanceCards-1).getUniqueID();

		ChanceField actualField = (ChanceField) allFields[pos];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}
	
	@Test
	public final void testLandOnFieldPos36() {
		int pos = 36;
		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(pos); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = chanceCardList.getCard(numberOfChanceCards-1).getUniqueID();

		ChanceField actualField = (ChanceField) allFields[pos];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}

	@Test
	public final void testLandOnFieldAllCards() {
		chanceCardList=new ChanceCardList(30, gameBoard);

		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(2); //ChanceField
		int actual = 0;

		for (int i=0; i<30; ++i){
			try{
				actualPlayer.setPosition(2); //ChanceField
				System.out.println(i);
				gameBoard.landOnField(actualPlayer);
				ChanceField actualField = (ChanceField) allFields[2];
				actual=actualField.getPickedCard().getUniqueID();
			}catch (Exception e){
				fail("Exception with the card id: " + actual + " " +e);
			}


		}

	}

}