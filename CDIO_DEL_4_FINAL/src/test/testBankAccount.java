package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import spil.entity.BankAccount;

public class testBankAccount {

	private BankAccount b1;

	@After
	public void tearDown() throws Exception {
		b1 = null;
	}

	/*
	 * Testing whether the upper bound for BankAccount is working. 
	 * This is a negative test because the input is much bigger than 
	 * 1000000. We can see that the system is reverting the balance to 1000000
	 * as we have expected. So it is not possible to get over the specified maximum.
	 */
	@Test
	public void testUpperBound1000000() {
		b1 = new BankAccount(1000000, 0, 5000000);
		int expected = 1000000;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing whether the lower bound for BankAccount is working.
	 * This is a negative test since the player's account can't have
	 * a balance lower than 0. The system should in this case revert 
	 * the score back to 0. The system is reverting the score back to 0.
	 */
	@Test
	public void testLowerBound0() {
		b1 = new BankAccount(100000, 0, -500000);
		int expected = 0;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing whether the lower bound for BankAccount is working with a negative value. 
	 * This is a negative test, since a much lower value than -500 is used as input
	 * for the current balance of the player, in this case -500000. The system is
	 * reverting back to -500. 
	 */
	@Test
	public void testLowerBoundNeg500() {
		b1 = new BankAccount(100000, -500, -500000);
		int expected = -500;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing whether the BankAccount can handle an underflow error.
	 * This is a negative test, since Integer.MIN_VALUE - 1, is a value
	 * that is a lot lower than 0.
	 */
	@Test
	public void testUnderflow() {
		b1 = new BankAccount(100000, 0, Integer.MIN_VALUE - 1);
		int expected = 0;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing whether the BankAccount can handle an overflow error.
	 * This is a negative test because the amount of coins is much higher
	 * than the maximum current balance. 
	 */
	@Test
	public void testOverflow() {
		b1 = new BankAccount(1000000, 0, Integer.MAX_VALUE + 1);
		int expected = 100000;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);

	}

	/*
	 * Testing whether the BankAccount can handle the maximum amount of balance.
	 * This is a positive test since the system should be able to have a balance 
	 * of 1000000. We can se that the system can handle the expected value. 
	 */
	@Test
	public void testMillion() {
		b1 = new BankAccount(1000000, 0, 1000000);
		int expected = 1000000;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing whether the BankAccount can handle an amount between the minimum and
	 * maximum.This is a positive test since the system should be able to have a balance 
	 * of 1. We can see that the system can handle the expected value. 
	 */
	@Test
	public void testBounds1() {
		b1 = new BankAccount(1000000, 0, 1);
		int expected = 1;
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can add 100 coins to it's balance. 
	 * This is a positive test because it should be able to add 100 coins 
	 * to the balance.
	 */
	@Test
	public void testAddBalance100() {
		b1 = new BankAccount(1000000, 0, 30000);
		int add = 100;
		int expected = b1.getBalance() + add;
		b1.addBalance(add);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can add 0 coins to it's balance.
	 * This is a positive test since the BankAccount should be able
	 * to add 0 coins to its balance. 
	 */
	@Test
	public void testAddBalance0() {
		b1 = new BankAccount(1000000, 0, 30000);
		int add = 0;
		int expected = b1.getBalance() + add;
		b1.addBalance(add);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can add -500 coins to it's balance.
	 * This is a negative test since the BankAccount should not be able
	 * to add a value of -500 coins. We can see that the system can add a
	 * negative balance which it should not be able to to. 
	 */
	@Test
	public void testAddBalanceNeg500() {
		b1 = new BankAccount(100000, 0, 30000);
		int add = -500;
		int expected = b1.getBalance();
		b1.addBalance(add);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can add Integer.MAX_VALUE coins to it's balance.
	 * This is a negative test since the BankAccount should not add an amount
	 * that is over the maxBalance so we assume that it will revert back to one million. 
	 */
	@Test
	public void testAddBalanceMaxInt() {
		b1 = new BankAccount(1000000, 0, 0);
		int add = Integer.MAX_VALUE;
		int expected = 1000000;
		b1.addBalance(add);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can add Integer.MIN_VALUE coins to it's balance.
	 * This is a negative test since the BankAccount should not add a negative amount which is 
	 * Integer.MIN_VALUE. We assume that it will revert back to 0
	 */
	@Test
	public void testAddBalanceMinInt() {
		b1 = new BankAccount(1000000, 0, 0);
		int add = Integer.MIN_VALUE;
		int expected = 0;
		b1.addBalance(add);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can add 1 coin to it's balance.
	 * This is a positive test because the BankAccount should add an 
	 * amount of 1 coin to the player. 
	 */
	@Test
	public void testAddBalance1() {
		b1 = new BankAccount(1000000, 0, 30000);
		int add = 1;
		int expected = b1.getBalance() + add;
		b1.addBalance(add);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can remove 1 coins from the balance.
	 * This is a positive test because the BankAccount should remove 1
	 * coin from the balance.
	 */
	@Test
	public void testRemoveBalance1() {
		b1 = new BankAccount(1000000, 0, 30000);
		int remove = 1;
		int expected = b1.getBalance() - remove;
		b1.removeBalance(remove);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can remove 30000 coins from the balance.
	 * This is a positive test because the system should be able to 
	 * remove 30000 coins.  
	 */
	@Test
	public void testRemoveBalance30000() {
		b1 = new BankAccount(1000000, 0, 30000);
		int remove = 30000;
		int expected = b1.getBalance() - remove;
		b1.removeBalance(remove);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can remove 0 coins from the balance.
	 * This is a positive test, since the it should be allowed to 
	 * remove 0 from the BankAccount's balance.
	 */
	@Test
	public void testRemoveBalance0() {
		b1 = new BankAccount(1000000, 0, 30000);
		int remove = 0;
		int expected = b1.getBalance() - remove;
		b1.removeBalance(remove);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can remove Integer.MIN_VALUE from the balance.
	 * This is a negative test because the BankAccount should not be able to remove a value 
	 * of Integer.MIN_VALUE, but we assume that it will revert back to 0, since its a
	 * very negative number.
	 */
	@Test
	public void testRemoveBalanceMinInt() {
		b1 = new BankAccount(1000000, 0, 0);
		int remove = Integer.MIN_VALUE;
		int expected = 0;
		b1.removeBalance(remove);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the BankAccount can remove Integer.MAX_VALUE from the balance.
	 * This is a negative test because the BankAccount should not be able to remove a value 
	 * of Integer.MAX_VALUE, but we assume that it will revert back to 0, since its a very large
	 * integer.
	 */
	@Test
	public void testRemoveBalanceMaxInt() {
		b1 = new BankAccount(1000000, 0, 0);
		int remove = Integer.MAX_VALUE;
		int expected = 0;
		b1.removeBalance(remove);
		int actual = b1.getBalance();

		assertEquals("BankAccount balance is not correct", expected, actual);
	}

	/*
	 * Testing if the player gets bankrupt.
	 * This is a positive test because the player will get their balance
	 * to zero and therefore will be declared bankrupt. 
	 */
	@Test
	public void testIsBankrupt0() {
		b1 = new BankAccount(1000000, 0, 5000);
		b1.removeBalance(6000);
		boolean actual = b1.isBankrupt();
		boolean expected = true;

		assertEquals("BankAccount is not bankrupt when it should be", expected, actual);
	}

	/*
	 * Testing if the player is not bankrupt when the balance is 1. 
	 * This is a positive test because the system should be able
	 * to know that if a player's balance is 1, than the player is 
	 * not bankrupt. 
	 */
	@Test
	public void testIsBankrupt1() {
		b1 = new BankAccount(1000000, 0, 5000);
		b1.removeBalance(4999);
		boolean actual = b1.isBankrupt();
		boolean expected = false;

		assertEquals("BankAccount is not bankrupt when it should be", expected, actual);
	}

}