package spil.entity;

public class DiceCup {

	/*
	 * Upper bound and lower bound for the amount of Dice.
	 */
	private final int MAX_DIE_COUNT = 1000;
	private final int MIN_DIE_COUNT = 2;

	/*
	 * Array holding all the Die objects.
	 */
	private Die[] diceList;

	/*
	 * Constructor that uses the dieCount variable as the amount
	 * of Dice that the above array should hold. maxFaceValue
	 * is the maximum faceValue of all the dice.
	 * Initializes the diceList.
	 */
	public DiceCup(int dieCount, int maxFaceValue) {

		if (dieCount > MAX_DIE_COUNT) {
			dieCount = MAX_DIE_COUNT;
		} else if (dieCount < MIN_DIE_COUNT) {
			dieCount = MIN_DIE_COUNT;
		}

		diceList = new Die[dieCount];

		for (int i = 0; i < dieCount; i++) {
			diceList[i] = new Die(maxFaceValue);
		}
	}

	/*
	 * Rolls all the Dice in the diceList array once each.
	 */
	public int[] rollDice(Player player) {
		int[] rollList = new int[diceList.length];
		for (int i = 0, n = rollList.length; i < n; i++) {
			rollList[i] = diceList[i].roll();
		}
		return rollList;
	}

	/*
	 * Gets the total roll of all the rolls in the rollList array parameter.
	 */
	public int getTotalRoll(int[] rollList) {
		int total = 0;
		for (int i = 0, n = rollList.length; i < n; i++) {
			total += rollList[i];
		}
		return total;
	}

	/*
	 * Returns the amount of Dice inside the diceList array.
	 */
	public int getDieAmount() {
		return diceList.length;
	}

}