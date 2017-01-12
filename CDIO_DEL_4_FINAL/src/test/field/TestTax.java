package test.field;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.Player;
import spil.entity.field.Tax;

public class TestTax {

	Tax T100;
	Tax TNeg1235;
	Player player;

	@Before
	public void setUp() throws Exception {
		T100 = new Tax(100, false);
		TNeg1235 = new Tax(1235, false);
		player = new Player("Player 1", 1000000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		T100 = null;
		TNeg1235 = null;
		player = null;
	}

	/*
	 * Testing whether a Tax field with a tax amount of 100
	 * is working functionally. This is a positive test, since
	 * the Tax class should be able to handle this.
	 * 
	 * ATT: 100 is pressed in this case, not 10% of balance.
	 */
	@Test
	public void testT100NonSpecial() {
		player.setPosition(17);
		int expected = player.getBalance() - 100;
		T100.landOnField(player);
		int actual = player.getBalance();
		assertEquals("Tax amount is not correct.", expected, actual);
	}

	/*
	 * Testing whether a Tax field with a tax amount of 100
	 * is working functionally. This is a positive test, since
	 * the Tax class should be able to handle this.
	 * 
	 * ATT: 10% of balance is pressed in this test, not 100.
	 */
	@Test
	public void testT100Special() {
		//player.setPosition(FieldBoundary.TAX_SPECIAL_POS);
		int expected = player.getBalance() - ((int) (player.getBalance() * 0.1));
		T100.landOnField(player);
		int actual = player.getBalance();
		assertEquals("Tax amount is not correct.", expected, actual);
	}

	/*
	 * Testing whether a Tax field with a tax amount of 100
	 * is working functionally. This is a positive test, since
	 * the Tax class should be able to handle this.
	 * 
	 * ATT: 1235 is pressed in this case, not 10% of balance.
	 */
	@Test
	public void testTNeg1235NonSpecial() {
		//player.setPosition(FieldBoundary.TAX_SPECIAL_POS);
		int expected = player.getBalance() - 1235;
		TNeg1235.landOnField(player);
		int actual = player.getBalance();
		assertEquals("Tax amount is not correct.", expected, actual);
	}

	/*
	 * Testing whether a Tax field with a tax amount of 1235
	 * is working functionally. This is a positive test, since
	 * the Tax class should be able to handle this.
	 * 
	 * ATT: 10% of balance is pressed in this test, not 1235.
	 */
	@Test
	public void testTNeg1235Special() {
		//player.setPosition(FieldBoundary.TAX_SPECIAL_POS);
		int expected = player.getBalance() - ((int) (player.getBalance() * 0.1));
		TNeg1235.landOnField(player);
		int actual = player.getBalance();
		assertEquals("Tax amount is not correct.", expected, actual);
	}

}