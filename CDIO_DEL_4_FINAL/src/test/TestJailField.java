package test;

import spil.entity.Player;
import spil.entity.field.Jail;

public class TestJailField {

	public TestJailField() {

		Player p1 = new Player("Player 1", 1000000, 0, 30000, 0);
		p1.setPosition(30);

		spil.entity.field.Jail jailField = new Jail();

		jailField.landOnField(p1);

	}

	public static void main(String[] args) {
		new TestJailField();
	}

}
