package test.fields;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.controller.GameBoard;
import spil.entity.Player;
import spil.entity.PlayerList;
import spil.entity.chancecard.ChanceCard;
import spil.entity.chancecard.ChanceCardList;
import spil.entity.field.ChanceField;
import spil.entity.field.Field;

public class testChanceField {

	private PlayerList playerList;
	private static GameBoard gameBoard;
	private static ChanceCardList chanceCardList;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		playerList = new PlayerList(6, 10000000, 0, 1000, 1, gameBoard.getRandomUniqueCars());
		gameBoard.setPlayerList(playerList);

	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		chanceCardList=null;
		playerList=null;
	}

	@Test
	public final void testLandOnField() {
		chanceCardList=new ChanceCardList(30, gameBoard);

		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		ChanceCard[] cards = chanceCardList.getAllCards();
		Field[] allFields = gameBoard.getAllFields();

		actualPlayer.setPosition(2); //ChanceField
		gameBoard.landOnField(actualPlayer);

		int expected = cards[29].getUniqueID();

		ChanceField actualField = (ChanceField) allFields[2];

		int actual = actualField.getPickedCard().getUniqueID();

		assertEquals("False " + expected + actual, expected, actual);
	}

	@Test
	public final void testLandOnField2() {
		chanceCardList=new ChanceCardList(30, gameBoard);

		Player actualPlayer = gameBoard.getPlayerList().getPlayer(0);

		ChanceCard[] cards = chanceCardList.getAllCards();
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