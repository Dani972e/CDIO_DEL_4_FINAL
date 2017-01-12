package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import spil.entity.DiceCup;

public class testDiceCup {

	private DiceCup diceCup;

	@After
	public void tearDown() throws Exception {
		diceCup = null;
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to 1.
	 * 
	 * This is considered as a negative test because 1 is out of the bounds.
	 */
	@Test
	public void testDieAmount1() {
		int dieFaceValue = 6;
		int amountOfDice = 1;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 2;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to 50.
	 * 
	 * This is considered as a positive test because 50 is within the bounds.
	 */
	@Test
	public void testDieAmount50() {
		int dieFaceValue = 6;
		int amountOfDice = 50;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 50;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to 2000.
	 * 
	 * This is considered a negative test, since the DiceCup object 
	 * should not be able to handle Die amount of 2000. We expect that the
	 * system should revert back to 1000. 
	 */
	@Test
	public void testDieAmount2000() {
		int dieFaceValue = 6;
		int amountOfDice = 2000;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 1000;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to 0.
	 * 
	 * This is considered a negative test, since 0 is out of bounds. The
	 * system should revert back to two dice objects. 
	 */
	@Test
	public void testDieAmount0() {
		int dieFaceValue = 6;
		int amountOfDice = 0;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 2;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to -1.
	 * 
	 * This is considered a negative test, since we are again out of bounds.
	 * The system should revert back to 2 dice.
	 */
	@Test
	public void testDieAmountNeg1() {
		int dieFaceValue = 6;
		int amountOfDice = -1;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 2;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will tests the scenario when the amount of dice is
	 * equal to -50.
	 * 
	 * This is considered a negative test, since the DiceCup object 
	 * should not be able to handle a Die amount of -50.
	 */
	@Test
	public void testDieAmountNeg50() {
		int dieFaceValue = 6;
		int amountOfDice = -50;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 2;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to Integer.MAX_VALUE + 2.
	 * 
	 * This is considered a negative test, since the DiceCup is not able
	 * to handle an overflow error. The integer overflow will turn negative because it
	 * will wrap to Integer.MIN_VALUE. The dieAmount value reverts to 2, which is the lower bound. 
	 * It would be better if it would revert to 1000, but because it wraps to negative numbers
	 * it will just revert back to 2. 
	 */
	@Test
	public void testDieAmountOverflow() {
		int dieFaceValue = 6;
		int amountOfDice = Integer.MAX_VALUE + 2;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 1000;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

	/*
	 * Tests whether the bounds of the amount of Die objects
	 * work as expected. If the amount is less than 2, the value
	 * will revert back to 2. If the amount is greater than 1000, the
	 * amount will revert back to 1000. The bounds can be changed through
	 * the class. This will test the scenario when the amount of dice is
	 * equal to Integer.MAX_VALUE + 2.
	 * 
	 * This is considered a negative test, since the DiceCup is not
	 * able to handle an underflow error. The integer underflow will turn positive,
	 * because it will wrap to Integer.MIN_VALUE. The dieAmount value reverts to 1000, 
	 * which is the highest bound. It would be better if it would revert to 2 but because
	 * it wraps to positive numbers, it will just revert back to 1000. 
	 */
	@Test
	public void testDieAmountUnderflow() {
		int dieFaceValue = 6;
		int amountOfDice = Integer.MIN_VALUE - 2;

		diceCup = new DiceCup(amountOfDice, dieFaceValue);

		int expected = 2;
		int actual = diceCup.getDieAmount();

		if (actual != expected) {
			fail("actual != expected, true: The bounds are not working as expected.");
		}

		assertEquals("expected: " + expected + "\nactual: ", expected, actual);
	}

}