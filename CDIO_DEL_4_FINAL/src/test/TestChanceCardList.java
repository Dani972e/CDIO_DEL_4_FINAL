package test;
import spil.entity.Player;
import spil.entity.TextInfo;
import spil.entity.chancecards.ChanceCard;
import spil.entity.chancecards.ChanceCardList;

public class TestChanceCardList {
	private static ChanceCardList chanceCardList;
	private static Player player1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		player1 = new Player(TextInfo.playerName + " 1", 1000000, 0, 0, 0);
		
		chanceCardList=new ChanceCardList(30);
		
		for(ChanceCard card : chanceCardList.getAllCards())
			System.out.println(card);
		System.out.println("--------------------------");
		
		System.out.println("Player 1 has: " + player1.getBalance());
		
		chanceCardList.mixCards();
		
		for(ChanceCard card : chanceCardList.getAllCards())
			System.out.println(card);
		System.out.println("--------------------------");
		
		System.out.println("Player 1 has: " + player1.getBalance());
		
		chanceCardList.pickOneCard(player1);
		
		for(ChanceCard card : chanceCardList.getAllCards())
			System.out.println(card);
		System.out.println("--------------------------");
		
		System.out.println("Player 1 has: " + player1.getBalance());
		
		chanceCardList.pickOneCard(player1);
		
		for(ChanceCard card : chanceCardList.getAllCards())
			System.out.println(card);
		System.out.println("--------------------------");
		
		System.out.println("Player 1 has: " + player1.getBalance());
	}}
