package spil.entity.chancecard;

import spil.boundary.GUIBoundary;
import spil.controller.GameBoard;
import spil.entity.Player;

public class ChanceCardList {
	private ChanceCard[] chanceCardList;
	private GameBoard gameBoard;

	public ChanceCardList(int numberOfChanceCard, GameBoard gameBoard){
		this.gameBoard=gameBoard;
		
		chanceCardList=new ChanceCard[numberOfChanceCard];


			for(int i=0; i<(int)(numberOfChanceCard/4); ++i)
					chanceCardList[i]=new BonusChanceCard(i*100+1);
			
			for(int i=(int)(numberOfChanceCard/4); i<(int)(2*(numberOfChanceCard/4)); ++i)
				chanceCardList[i]=new TaxChanceCard(i*50);
			
			for(int i=(int)(2*(numberOfChanceCard/4)); i<(int)(3*(numberOfChanceCard/4)); ++i)
				chanceCardList[i]=new MoveChanceCard(i-10);
			
			for(int i=(int)(3*(numberOfChanceCard/4)); i<numberOfChanceCard; ++i)
				chanceCardList[i]=new PayChanceCard(i*25);

			//mixCards();
			
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

		ChanceCard[] temp = new ChanceCard[chanceCardList.length];

		useEffect(player, chanceCardList[chanceCardList.length-1]); //Activate effect

		for (int i=0; i<temp.length;++i){
			newIndex=i+2; //use shift number to make the new position

			while(newIndex>temp.length){
				newIndex = newIndex - (temp.length); //if we go out the array, make a modulo
			}
			temp[newIndex-1]=chanceCardList[i]; //apply the new position to every number (not the last)
		}

		chanceCardList=temp;
	}

	private void useEffect(Player player, ChanceCard card){
		if (card instanceof BonusChanceCard){
			System.out.println("effect: "+((BonusChanceCard) card).getEffect());
			player.addBalance(card.getEffect());
		}

		else if (card instanceof TaxChanceCard){
			player.removeBalance(card.getEffect());
			System.out.println("effect: -"+card.getEffect());
			
		}

		else if (card instanceof MoveChanceCard){
			GUIBoundary.removePlayerCar(player);
			gameBoard.movePlayer(player, card.getEffect());
			GUIBoundary.placePlayerCar(player);

			gameBoard.landOnField(player);
			GUIBoundary.updatePlayer(player);
			System.out.println("effect move: "+card.getEffect());
		
		}
		
		if (gameBoard.equals(null))
			System.out.println("DEBUG");

		else if (card instanceof PayChanceCard){
			for(int i=0; i<gameBoard.getPlayerList().getPlayersLeft(); ++i)
				if(!player.equals(gameBoard.getPlayerList().getPlayer(i))){
					gameBoard.getPlayerList().getPlayer(i).removeBalance(card.getEffect());
					player.addBalance(card.getEffect());
					GUIBoundary.updatePlayer(gameBoard.getPlayerList().getPlayer(i));
			
				}
			System.out.println("effect all players shall pay: "+card.getEffect() +" to one player");	
			GUIBoundary.updatePlayer(player);
		}
	}

}

