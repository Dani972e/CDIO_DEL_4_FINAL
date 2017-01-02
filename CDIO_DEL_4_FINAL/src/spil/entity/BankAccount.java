package spil.entity;

public class BankAccount {

	/*
	 * Lower bound and higher bounds for the balance variable.
	 * Balance variable is the current balance of the BankAccount.
	 */
	private final int MAX_BALANCE;
	private final int MIN_BALANCE;
	private int balance;

	/*
	 * Constructor that sets all of the above values to the
	 * current instance of the BankAccount.
	 */
	public BankAccount(int maxBalance, int minBalance, int balance) {
		this.MAX_BALANCE = maxBalance;
		this.MIN_BALANCE = minBalance;
		this.balance = checkBalanceBounds(balance);
	}

	/*
	 * Method that adds a specific amount to the balance variable,
	 * IFF the lower bounds and higher bounds are met.
	 */
	public void addBalance(int amount) {
		int newBalance = balance + amount;
		balance = checkBalanceBounds(newBalance);
	}

	/*
	 * Method that removes a specific amount from the balance variable,
	 * IFF the lower bounds and higher bounds are met.
	 */
	public void removeBalance(int amount) {
		int newBalance = balance - amount;
		balance = checkBalanceBounds(newBalance);
	}

	/*
	 * Method that checks whether the currentBalance variable
	 * is within the balance bounds.
	 */
	private int checkBalanceBounds(int currentBalance) {
		if (currentBalance < MIN_BALANCE) {
			currentBalance = MIN_BALANCE;
		} else if (currentBalance > MAX_BALANCE) {
			currentBalance = MAX_BALANCE;
		}
		return currentBalance;
	}

	/*
	 * Returns a boolean value about the state of the 
	 * account. If the balance is equal to the minimum, 
	 * then the the BankAccount is declared bankrupt.
	 */
	public boolean isBankrupt() {
		if (balance == MIN_BALANCE) {
			return true;
		}
		return false;
	}

	/*
	 * Returns the current value of the balance variable.
	 */
	public int getBalance() {
		return balance;
	}

}