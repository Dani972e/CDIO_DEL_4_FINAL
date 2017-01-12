package test.field;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.JailedPlayers;
import spil.entity.Player;
import spil.entity.field.Jail;

public class testJail {

	private Player p1;
	private Player p2;
	private Jail jailField;
	private JailedPlayers jp;

	@Before
	public void setUp() throws Exception {

		p1 = new Player("Spiller1", 1000000, 0, 30000, 0);
		p2 = new Player("Spiller2", 1000000, 0, 30000, 0);
		jp = new JailedPlayers();
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		jp = null;
	}

	/*
	 * Testing jail field when a player lands on index 10. This is a positive
	 * test, because we assume that a player can land on this field and nothing
	 * happens.
	 */
	@Test
	public void testJailIndex10() {
		jailField = new Jail(jp, false);

		jailField.landOnField(p1);

		boolean actual = jp.isJailed(p1);

		assertFalse(actual);

	}

	/*
	 * Testing jail field when a player lands on index 30. This is also a
	 * positive test, because we assume that the player will get jailed.
	 */
	@Test
	public void testIfJailIndex30() {
		jailField = new Jail(jp, true);

		jailField.landOnField(p2);

		boolean actual = jp.isJailed(p2);

		assertTrue(actual);
	}

}