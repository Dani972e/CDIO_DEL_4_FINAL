package test;

import spil.entity.DiceCup;
import spil.entity.Player;

public class TestDiceCup {

	public static void main(String[] args) {

		DiceCup diceCup = new DiceCup(2, 6);
		int[] rollList = { 3000, 3000, 3000, 3000, 3000, 3000};

		System.out.println(diceCup.checkRollEquality(rollList));

	}

}
