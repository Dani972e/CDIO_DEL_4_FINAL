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


	public void pickOneCard(){
		//TODO Use effect
		
		int newIndex;

		ChanceCard tempCard=new ChanceCard("");
		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		tempCard=chanceCardList[0];
		chanceCardList[0]=null;

		for (int i=0; i<temp.length;++i){
			newIndex=i+2; //use shift number to make the new position

			while(newIndex>temp.length){
				newIndex = newIndex - (temp.length); //if we go out the array, make a modulo
			}
			temp[newIndex-1]=chanceCardList[i]; //apply the new position to every number (not the last)
		}
		
		for (int i=0; i<temp.length;++i){
			if (temp[i]==null)
				temp[i]=tempCard;
		}
		chanceCardList=temp;
	}

}

