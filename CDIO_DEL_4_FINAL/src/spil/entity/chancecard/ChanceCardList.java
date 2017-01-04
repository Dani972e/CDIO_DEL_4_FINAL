package spil.entity.chancecard;

import spil.entity.Player;

public class ChanceCardList {
	private ChanceCard[] chanceCardList;

	public ChanceCardList(int numberOfChanceCard){
		chanceCardList=new ChanceCard[numberOfChanceCard];
		for(int i=0; i<numberOfChanceCard; ++i){
			chanceCardList[i]=new BonusChanceCard(i*100+1);
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


	public void pickOneCard(Player player){

		int newIndex;

		ChanceCard tempCard=new BonusChanceCard(0);
		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		tempCard=chanceCardList[chanceCardList.length-1];
		useEffect(player, chanceCardList[chanceCardList.length-1]); //Activate effect
		chanceCardList[chanceCardList.length-1]=null;

		for (int i=0; i<temp.length;++i){
			newIndex=i+2; //use shift number to make the new position

			while(newIndex>temp.length){
				newIndex = newIndex - (temp.length); //if we go out the array, make a modulo
			}
			temp[newIndex-1]=chanceCardList[i]; //apply the new position to every number (not the last)
		}

		temp[0]=tempCard;

		chanceCardList=temp;
	}

	private void useEffect(Player player, ChanceCard card){
		if (card instanceof BonusChanceCard){
			//System.out.println("effect: "+((BonusChanceCard) card).getEffect());
			player.addBalance(((BonusChanceCard) card).getEffect());
		}
		else;
	}

}

