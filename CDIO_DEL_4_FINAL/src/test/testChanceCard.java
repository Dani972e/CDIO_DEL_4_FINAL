package test;

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

public class testChanceCard {

	private PlayerList playerList;
	private static GameBoard gameBoard;
	private static ChanceCardList chanceCardList;

	@Before
	public void setUp() throws Exception {
		gameBoard = new GameBoard();
		playerList = new PlayerList(6, 10000000, 0, 1000, 1, gameBoard.getRandomUniqueVehicles());
		gameBoard.setPlayerList(playerList);

	}

	@After
	public void tearDown() throws Exception {
		gameBoard=null;
		chanceCardList=null;
		playerList=null;
	}

	@Test
	public final void testBonusEffect() {
		chanceCardList=new ChanceCardList(30, gameBoard);
		
		Player player = playerList.getPlayer(0);
		int expected = 2000;
		
		chanceCardList.pickOneSpecialCard(player, 0);
		
		int actual = player.getBalance();
		
		assertEquals(expected, actual);
		
		System.out.println(player.getBalance());
	}

}
