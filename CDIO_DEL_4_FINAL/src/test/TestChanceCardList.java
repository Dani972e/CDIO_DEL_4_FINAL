package test;
import spil.entity.ChanceCardList;
import spil.entity.ChanceCard;

public class TestChanceCardList {
	private static ChanceCardList chanceCardList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chanceCardList=new ChanceCardList(30);
		
		chanceCardList.mixCards();
		
		for(ChanceCard card : chanceCardList.getAllCards()){
			System.out.println(card);
		System.out.println("--------------------------");
		
	}

	}}
