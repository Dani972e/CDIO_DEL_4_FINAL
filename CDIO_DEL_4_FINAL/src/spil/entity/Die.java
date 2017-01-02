package spil.entity;

public class Die {

	/*
	 * Upper bound and lower bound for the faceValue variable. 
	 */
	private final int MAX_FACE_VALUE = 10;
	private final int MIN_FACE_VALUE = 6;

	/*
	 * currMaxFaceValue is the current maximum faceValue. 
	 * faceValue is the current side value of a dice.
	 */
	private int currMaxFaceValue;
	private int faceValue = 1;

	/*
	 * Constructor of Die that sets the current maximum faceValue.
	 */
	public Die(int currMaxFaceValue) {

		if (currMaxFaceValue > MAX_FACE_VALUE) {
			currMaxFaceValue = MAX_FACE_VALUE;
		} else if (currMaxFaceValue < MIN_FACE_VALUE) {
			currMaxFaceValue = MIN_FACE_VALUE;
		}

		this.currMaxFaceValue = currMaxFaceValue;
	}

	/*
	 * Roll method that simulates a roll from a die. Returns the roll value. 
	 */
	public int roll() {
		faceValue = (int) (Math.random() * currMaxFaceValue) + 1;
		return getFaceValue();
	}

	/*
	 * Getter method that returns faceValue.
	 */
	public int getFaceValue() {
		return faceValue;
	}

	/*
	 * Getter method that returns currMaxFaceValue.
	 */
	public int getCurrMaxFaceValue() {
		return currMaxFaceValue;
	}

}