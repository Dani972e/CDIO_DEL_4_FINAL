package spil.entity;

public class ChanceCardList {
	private ChanceCard[] chanceCardList;

	public ChanceCardList(int numberOfChanceCard){
		chanceCardList=new ChanceCard[numberOfChanceCard];
		for(int i=0; i<numberOfChanceCard; ++i){
				chanceCardList[i]=new ChanceCard("Card "+(int)(i+1));
		}
	}
	
	public ChanceCard[] getAllCards(){
		return chanceCardList;
	}
	
	public void mixCards(){
		ChanceCard[] temp = new ChanceCard[chanceCardList.length];
		int randomIndex=0;
		
		for(int i=0; i<chanceCardList.length; ++i){
			while(temp[randomIndex]!=null)
				randomIndex=(int)(Math.random()*temp.length);
			
			temp[randomIndex]=chanceCardList[i];
	}
	chanceCardList=temp;
	}
}
