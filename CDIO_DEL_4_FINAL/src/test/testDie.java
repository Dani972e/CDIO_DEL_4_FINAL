package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import spil.entity.Die;

public class testDie {

	private Die die;

	@After
	public void tearDown() throws Exception {
		die = null;
	}

	/* 
	 * Tests whether the Die roll values are within the expected bounds. 
	 * This is a positive test, since the Die should be able to handle
	 * a maximum faceValue of 10.
	 */
	@Test
	public void testRoll10() {

		die = new Die(100); /* 100 inserted to check Die faceValue bounds */

		int iterations = 1000000;

		int[] rollArray = new int[10];
		int other = 0;

		for (int i = 0; i < iterations; i++) {
			int roll = die.roll();

			switch (roll) {
			case 1:
				rollArray[0]++;
				break;
			case 2:
				rollArray[1]++;
				break;
			case 3:
				rollArray[2]++;
				break;
			case 4:
				rollArray[3]++;
				break;
			case 5:
				rollArray[4]++;
				break;
			case 6:
				rollArray[5]++;
				break;
			case 7:
				rollArray[6]++;
				break;
			case 8:
				rollArray[7]++;
				break;
			case 9:
				rollArray[8]++;
				break;
			case 10:
				rollArray[9]++;
				break;
			default:
				other++;
				break;
			}

		}

		System.out.println("- - - - testRoll10 - - - -");

		for (int i = 0; i < rollArray.length; i++) {
			System.out.println((i + 1) + ": " + rollArray[i]);
		}

		System.out.println("other: " + other);

		int expected = 0;

		assertEquals("other > 0 is true: Fail, since other MUST be 0.", expected, other);

		assertEquals("expected: " + expected + "\nother " + other, expected, other);
	}

	/* 
	 * Tests whether the Die roll values are within the expected bounds. 
	 * This is a positive test, since the Die should be able to handle
	 * a maximum faceValue of 6.
	 */
	@Test
	public void testRoll6() {

		die = new Die(6);

		int iterations = 1000000;

		int[] rollArray = new int[6];
		int other = 0;

		for (int i = 0; i < iterations; i++) {
			int roll = die.roll();

			switch (roll) {
			case 1:
				rollArray[0]++;
				break;
			case 2:
				rollArray[1]++;
				break;
			case 3:
				rollArray[2]++;
				break;
			case 4:
				rollArray[3]++;
				break;
			case 5:
				rollArray[4]++;
				break;
			case 6:
				rollArray[5]++;
				break;
			default:
				other++;
				break;
			}

		}

		System.out.println("- - - - testRoll6 - - - -");

		for (int i = 0; i < rollArray.length; i++) {
			System.out.println((i + 1) + ": " + rollArray[i]);
		}

		System.out.println("other: " + other);

		int expected = 0;

		assertEquals("other > 0 is true: Fail, since other MUST be 0.", expected, other);

		assertEquals("expected: " + expected + "\nother: " + other, expected, other);
	}

	/* 
	 * Tests whether the lower bound for the faceValue is working as intended. 
	 * If the faceValue is over 10, it should revert to 10. If its lower than 6,
	 * it should revert to 6. This is a negative test, since we are putting a 
	 * Die faceValue that is not in the bounds. 
	 */
	@Test
	public void testMaxFaceValue1() {
		int faceValueAmount = 1;

		die = new Die(faceValueAmount);

		/* 
		 * 6, since the minimum allowed minimum faceValue is 6.
		 * Since the Integer.MAX_VALUE + 2 wraps around to a negative
		 * value, the expected value is considered to be 6.
		 */
		int expected = 6;

		int actual = die.getCurrMaxFaceValue();

		if (actual == faceValueAmount) {
			fail("faceValue == -1, true: The lower bound is not working.");
		}

		if (actual != 6) {
			fail("faceValue != 6, true: The faceValue variable is not equal to 6, which it should be.");
		}

		assertEquals("expected: " + expected + "\nactual: " + actual, expected, actual);
	}

	/* 
	 * Tests whether the lower bound for the faceValue is working as intended. 
	 * If the faceValue is over 10, it should revert to 10. If its lower than 6,
	 * it should revert to 6. This is a negative test because we are giving a
	 * negative FaceValue. 
	 */
	@Test
	public void testMaxFaceValueNeg1() {
		int faceValueAmount = -1;

		die = new Die(faceValueAmount);

		/* 
		 * 6, since the minimum allowed minimum faceValue is 6.
		 * Since the Integer -1 is less than 6, then it will revert
		 * back to  6 which is the expected value.
		 */
		int expected = 6;

		int actual = die.getCurrMaxFaceValue();

		if (actual == faceValueAmount) {
			fail("faceValue == -1, true: The lower bound is not working.");
		}

		if (actual != 6) {
			fail("faceValue != 6, true: The faceValue variable is not equal to 6, which it should be.");
		}

		assertEquals("expected: " + expected + "\nactual: " + actual, expected, actual);
	}

	/* 
	 * Tests whether the lower bound for the faceValue is working as intended. 
	 * If the faceValue is over 10, it should revert to 10. If its lower than 6,
	 * it should revert to 6. This is a positive test, since it should be able
	 * to handle this.
	 */
	@Test
	public void testMaxFaceValueNeg50() {
		int faceValueAmount = -50;

		die = new Die(faceValueAmount);

		/* 
		 * 6, since the minimum allowed minimum faceValue is 6.
		 * Since -50 wraps around to a negative
		 * value, the expected value is considered to be 6.
		 */
		int expected = 6;

		int actual = die.getCurrMaxFaceValue();

		if (actual == faceValueAmount) {
			fail("faceValue == -50, true: The lower bound is not working.");
		}

		if (actual != 6) {
			fail("faceValue != 6, true: The faceValue variable is not equal to 6, which it should be.");
		}

		assertEquals("expected: " + expected + "\nactual: " + actual, expected, actual);
	}

	/* 
	 * Tests whether the upper bound for the faceValue is working as intended. 
	 * If the faceValue is over 10, it should revert to 10. If its lower than 6,
	 * it should revert to 6. This is a negative test since the faceValue should
	 * not be a value of 50. It will revert back to 10. 
	 */
	@Test
	public void testMaxFaceValue50() {
		int faceValueAmount = 50;

		die = new Die(faceValueAmount);

		/* 
		 * 10, since the maximum of the faceValue is 10.
		 * Since the Die class has the highest bounds of 10 for the 
		 * maximum faceValue, it will be changed to 10 instead of 50.
		 */
		int expected = 10;

		int actual = die.getCurrMaxFaceValue();

		if (actual == faceValueAmount) {
			fail("faceValue == 50, true: The higher bound is not working.");
		}

		if (actual != 10) {
			fail("faceValue != 10, true: The faceValue variable is not equal to 10, which it should be.");
		}

		assertEquals("expected: " + expected + "\nactual: " + actual, expected, actual);
	}

	/* 
	 * Tests whether the Die roll values are within the expected bounds, 
	 * even when an overflow occurs. This is a negative test, since the 
	 * Die should be able to handle an overflow without any exception throws.
	 * It should revert back to 6.
	 * 
	 * This introduces a slight problem in the program however, since the
	 * lower bounds of the faceValue would not be expected in this case.
	 */
	@Test
	public void testMaxFaceValueOverflow() {
		die = new Die(Integer.MAX_VALUE + 2);

		/* 
		 * 10, since the maximum faceValue is 10.
		 * Since the Integer.MAX_VALUE + 2 wraps around to a negative
		 * value, the expected value is considered to be 10.
		 */
		int expected = 10;

		int actual = die.getCurrMaxFaceValue();

		if (actual != expected) {
			fail("actual != expected, true: Actual is not equal to the expected value.");
		}

		assertEquals("expected: " + expected + "\nactual: " + actual, expected, actual);
	}

	/* 
	 * Tests whether the Die roll values are within the expected bounds, 
	 * even when an underflow occurs. This is a negative test, since the 
	 * Die should be able to handle an underflow without any exception throws.
	 * 
	 * This introduces a slight problem in the program however, since the
	 * higher bounds of the faceValue would not be expected in this case.
	 */
	@Test
	public void testMaxFaceValueUnderflow() {
		die = new Die(Integer.MIN_VALUE - 2);

		/* 
		 * 6, since the minimum faceValue is 6.
		 * Since the Integer.MIN_VALUE - 2 wraps around to a positive
		 * value, the expected value is considered to be 6.
		 */
		int expected = 6;

		int actual = die.getCurrMaxFaceValue();

		if (actual != expected) {
			fail("actual != expected, true: Actual is not equal to the expected value.");
		}

		assertEquals("expected: " + expected + "\nactual: " + actual, expected, actual);
	}

}