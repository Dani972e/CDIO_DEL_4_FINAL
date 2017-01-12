package test.field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.entity.Player;
import spil.entity.field.Empty;

public class TestEmpty {

	private Player p1;
	private spil.entity.field.Empty empty;

	@Before
	public void setUp() throws Exception {
		p1 = new Player("Player 1", 1000000, 0, 30000, 0);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
	}

	@Test
	public void testEmptyStartField() {
		empty = new Empty(true);

		empty.landOnField(p1);
	}

	@Test
	public void testEmptyParkingField() {
		empty = new Empty(false);

		empty.landOnField(p1);
	}

}