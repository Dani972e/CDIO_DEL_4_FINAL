package test;

import spil.entity.JailedPlayers;
import spil.entity.Player;

public class TestJailedPlayers {

	private JailedPlayers jp;

	public TestJailedPlayers() {

		jp = new JailedPlayers();

		Player p1 = new Player("Player 1", 1000000, 0, 30000, 0);
		Player p2 = new Player("Player 2", 1000000, 0, 30000, 0);

		jp.jailPlayer(p1);
		jp.jailPlayer(p2);

		System.out.println(jp.isJailed(p2));
		System.out.println(jp.isJailed(p1));
		System.out.println(jp.isJailed(p2));
		System.out.println(jp.isJailed(p1));
		System.out.println(jp.isJailed(p1));
		System.out.println(jp.isJailed(p1));
		System.out.println(jp.isJailed(p2));
		System.out.println(jp.isJailed(p2));
		
		

	}

	public static void main(String[] args) {
		new TestJailedPlayers();
	}

}