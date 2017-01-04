package spil.entity;

import spil.entity.Player;

/*
 * TextBoundary is a general class that holds all the text information of the system.
 * There are variable Strings that are used throughout the game, as well as specific methods
 * that uses the Players name and roll values to display for a more interactive feeling of the
 * game.
 */
public class TextInfo {
	
	public static final String[] chanceCardText = { 
			
			//Få penge
			"Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken.",
			"Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3.000.",
			"Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken.",
			"Det er Deres fødselsdag. Modtag af hver medspiller kr. 200.",
			"De havde en række med elleve rigtige i tipning. Modtag kr. 1.000.",
			"De modtager Deres aktieudbytte. Modtag kr. 1.000 af banken.",
			"Modtag udbytte af Deres aktier kr. 1.000.",
			"Modtag udbytte af Deres aktier kr. 1.000.",
			"Grundet dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000.",
			"Modtag udbytte af Deres aktier kr. 1.000.",
			"De modtager \" Matador-legatet for værdig trængende\", stort kr. 40.000. Ved værdig trængende forstås, at Deres formue, d.v.s. Deres kontante penge + skøder + bygninger ikke overstiger kr. 15.000.",
			"De har vundet i Klasselotteriet. Modtag kr. 500.",
			"Værdien af egen avl fra nyttehaven udgør kr. 200, som De modtager af banken",
			
			//Betal penge
			"De har måtte vedtage en parkeringsbøde. Betal kr. 200 i bøde.",
			"Betal Deres bilforsikring kr. 1.000.",
			"Betal kr. 3.000 for reparation af Deres vogn.",
			"Betal kr. 3.000 for reparation af Deres vogn.",
			"De har modtaget Deres tandlægeregning. Betal kr. 2.000.",
			"De har kørt frem for \"Fuld Stop\". Betal kr. 1.000 i bøde.",
			"De har kørt frem for \"Fuld Stop\". Betal kr. 1.000 i bøde.",
			"De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200.",
			
			//Ryk til felt
			"Tag ind på Rådhuspladsen. Hvis De passerer \"Start\", indkassér da kr. 4.000.",
			"Ryk frem til Grønningen. Hvis De passerer \"Start\", indkassér da kr. 4.000.",
			"Ryk frem til Frederiksberg Allé. Hvis De passerer \"Start\", indkassér kr. 4.000.",
			"Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selvskabet ikke ejes af nogen kan De købe det af banken.",
			"Ryk tre felter tilbage.",
			"Tag med den nærmeste færge - Flyt brikken frem og hvis De passerer \"Start\" indkassér da kr. 4.000.",
			
			//Gå i fængsel
			"Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer \"Start\" indkasserer de ikke kr. 4.000.",
			"Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer \"Start\" indkasserer de ikke kr. 4.000.",
			"Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer \"Start\" indkasserer de ikke kr. 4.000." };


	private TextInfo() {

	}

	public static final String TITLE = "Treasure Hunt 2";
	public static final String VERSION = "v0.02";

	public static final String[][] fieldText = { 
			{"Start", "Modtag 4.000", "Hvergang De passerer modtag kr. 4.000" },
			{ "Rødovrevej", "Kr. 1.200", "Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 50, 1 hus = kr. 250, 2 huse = Kr. 750, 3 huse = Kr. 2.250, 4 huse = Kr. 4.000, Hotel = Kr. 6.000." },
			{ "", "Prøv lykken", "ChanceKort" },
			{ "Hvidovrevej", "Kr. 1.200", "Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 50, 1 hus = kr. 250, 2 huse = Kr. 750, 3 huse = Kr. 2.250, 4 huse = Kr. 4.000, Hotel = Kr. 6.000." },
			{ "Indkomstskat 10% eller 4000 kr.", "", "10% af dine samlede værdier (kontanter, bygninger og den trykte pris for dine grunde og virksomheder) eller kr. 4.000" },
			{ "SFL-Færgerne", "Kr. 4.000", "Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },
			{ "Roskildevej", "Kr. 2.000", "Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 100, 1 hus = kr. 600, 2 huse = Kr. 1.800, 3 huse = Kr. 5.400, 4 huse = Kr. 8.000, Hotel = Kr. 11.000." },
			{ "", "Prøv lykken", "ChanceKort" },
			{ "Valby Langgade", "Kr. 2.000", "Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 100, 1 hus = kr. 600, 2 huse = Kr. 1.800, 3 huse = Kr. 5.400, 4 huse = Kr. 8.000, Hotel = Kr. 11.000." },
			{ "Allégade", "Kr. 2.400", "Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 100, 1 hus = kr. 600, 2 huse = Kr. 1.800, 3 huse = Kr. 5.400, 4 huse = Kr. 8.000, Hotel = Kr. 11.000." },
			{ "I Fængsel", "På Besøg", "" },
			{ "Frederiks-berg Allé", "Kr. 2.800", "Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 200, 1 hus = kr. 1.000, 2 huse = Kr. 3.000, 3 huse = Kr. 9.000, 4 huse = Kr. 12.500, Hotel = Kr. 15.000." },
			{ "Tuborg", "Kr. 3.000", "Hvis én virksomhed ejes, betales 100 gange så meget som øjnene viser. Hvis begge Breweries ejes, betales 200 gange så meget som øjnene viser." },
			{ "Bülowsvej", "Kr. 2800", "Kr. 2.800", "Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 200, 1 hus = kr. 1.000, 2 huse = Kr. 3.000, 3 huse = Kr. 9.000, 4 huse = Kr. 12.500, Hotel = Kr. 15.000." },
			{ "Gl. Kongevej", "Kr. 2.800", "Kr. 2.800", "Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 200, 1 hus = kr. 1.000, 2 huse = Kr. 3.000, 3 huse = Kr. 9.000, 4 huse = Kr. 12.500, Hotel = Kr. 15.000." },
			{ "DSB Rederierne, Kalundborg/Århus", "Kr. 4.000", "Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },
			{ "Bernstoffs-vej", "Kr. 3.600", "Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 300, 1 hus = kr. 1.400, 2 huse = Kr. 4.000, 3 huse = Kr. 11.000, 4 huse = Kr. 16.000, Hotel = Kr. 19.000." }, 
			{ "", "Prøv lykken", "ChanceKort" },
			{ "Hellerupvej", "Kr. 3.600", "Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 300, 1 hus = kr. 1.400, 2 huse = Kr. 4.000, 3 huse = Kr. 11.000, 4 huse = Kr. 16.000, Hotel = Kr. 19.000." },
			{ "Strandvej", "Kr. 4.000", "Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 300, 1 hus = kr. 1.400, 2 huse = Kr. 4.000, 3 huse = Kr. 11.000, 4 huse = Kr. 16.000, Hotel = Kr. 19.000." },
			{ "Den Danske Bank", "Parkering", "" },
			{ "Trianglen", "Kr. 4.000", "Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 350, 1 hus = kr. 1.800, 2 huse = Kr. 5.000, 3 huse = Kr. 14.000, 4 huse = Kr. 17.500, Hotel = Kr. 21.000." }, 
			{ "", "Prøv lykken", "ChanceKort" },	
			{ "Østerbrogade", "Kr. 4.000", "Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 350, 1 hus = kr. 1.800, 2 huse = Kr. 5.000, 3 huse = Kr. 14.000, 4 huse = Kr. 17.500, Hotel = Kr. 21.000." },
			{ "Grønningen", "Kr. 4.800", "Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 350, 1 hus = kr. 1.800, 2 huse = Kr. 5.000, 3 huse = Kr. 14.000, 4 huse = Kr. 17.500, Hotel = Kr. 21.000." },
			{ "DFDS Seaways", "Kr. 4.000", "Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },
			{ "Bredgade", "Kr. 5.200", "Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 450, 1 hus = kr. 2.200, 2 huse = Kr. 6.600, 3 huse = Kr. 16.000, 4 huse = Kr. 19.500, Hotel = Kr. 23.000." },
			{ "Kgs. Nytorv", "Kr. 5.200", "Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 450, 1 hus = kr. 2.200, 2 huse = Kr. 6.600, 3 huse = Kr. 16.000, 4 huse = Kr. 19.500, Hotel = Kr. 23.000." },
			{ "Coca-Cola", "Kr. 3.000", "Hvis én virksomhed ejes, betales 100 gange så meget som øjnene viser. Hvis begge Breweries ejes, betales 200 gange så meget som øjnene viser." },
			{ "Østergade", "Kr. 5.600", "Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 450, 1 hus = kr. 2.200, 2 huse = Kr. 6.600, 3 huse = Kr. 16.000, 4 huse = Kr. 19.500, Hotel = Kr. 23.000." },
			{ "", "De Fængsles", "Ryk til I Fængsel" },
			{ "Amagertorv", "Kr. 6.000", "Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 550, 1 hus = kr. 2.600, 2 huse = Kr. 7.800, 3 huse = Kr. 18.000, 4 huse = Kr. 22.000, Hotel = Kr. 25.000." },
			{ "Vimmel-skaftet", "Kr. 6.000", "Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 550, 1 hus = kr. 2.600, 2 huse = Kr. 7.800, 3 huse = Kr. 18.000, 4 huse = Kr. 22.000, Hotel = Kr. 25.000." },
			{ "", "Prøv lykken", "ChanceKort" },
			{ "Nygade", "Kr. 6.400", "Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 550, 1 hus = kr. 2.600, 2 huse = Kr. 7.800, 3 huse = Kr. 18.000, 4 huse = Kr. 22.000, Hotel = Kr. 25.000." },
			{ "DSB Rederierne Halsskov/Knudshoved", "Kr. 4.000", "Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },
			{ "", "Prøv lykken", "ChanceKort" },
			{ "Frederiks-berggade", "Kr. 7.000", "Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 700, 1 hus = kr. 3.500, 2 huse = Kr. 10.000, 3 huse = Kr. 22.000, 4 huse = Kr. 26.000, Hotel = Kr. 30.000." },
			{ "Ekstraordinær statsskat", "Betal Kr. 2.000", "" },
			{ "Rådhus-pladsen", "Kr. 8.000", "Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 700, 1 hus = kr. 3.500, 2 huse = Kr. 10.000, 3 huse = Kr. 22.000, 4 huse = Kr. 26.000, Hotel = Kr. 30.000." },
				
	};

	public static final String welcomeMessage = "Welcome to " + TITLE + ", " + VERSION
			+ "!\n\nThis game is a Monopoly-like game. You'll roll with two dice"
			+ " and land on a field where the field will have an effect on your bank account. If you reach bankruptcy, you're out. The game will"
			+ " continue until only one player is left, who will be the winner.\n\nTo proceed, please choose the number of players.";

	public static final String[] btnArray = { "2", "3", "4", "5", "6" };

	public static final String playerName = "Player";

	public static final String buttonYesMessage = "Yes";
	public static final String buttonNoMessage = "No";

	public static final String btnBalancePercentage = "10% of balance";

	public static final String errorMessage = "A fatal error has occurred.";

	public static final String purchaseFieldMessage(Player player, int price) {
		return landMessage(player) + getFieldName(player) + " is available for purchase. Does " + player.getName()
				+ " want to purchase this field for " + price + " coins?";
	}

	public static final String purchaseConfirmedMessage(Player player, int price) {
		return player.getName() + " successfully bought " + getFieldName(player) + " for the price of " + price
				+ " coins.";
	}

	public static final String purchaseDeniedMessage(Player player) {
		return player.getName() + " did not purchase " + getFieldName(player) + ".";
	}

	public static final String playerAmountMessage(int playerAmount) {
		return playerAmount + " players will play the game!\n\nTo proceed, please click the \"OK\" button.";
	}

	public static String rollInfoMessage(Player player) {
		return player.getName() + ", please click the \"OK\" button to roll.";
	}

	public static String rollMessage(Player player, int[] rollValues) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0, n = rollValues.length; i < n; i++) {
			if (i == rollValues.length - 1) {
				sb.append(Integer.toString(rollValues[i]));
				break;
			}
			sb.append(Integer.toString(rollValues[i]) + ", ");
		}
		sb.append("]");
		return player.getName() + " rolled " + sb.toString() + "!";
	}

	public static final String ownFieldMessage(Player player) {
		return "This field is already owned by " + player.getName() + ", nothing will happen.";
	}

	public static String alreadyPurchasedMessage(Player player, Player owner, int rent) {
		return getFieldName(player) + " is already purchased. You'll need to pay a rent of " + rent + " to the owner, "
				+ owner.getName() + ".";
	}

	public static String bonusMessage(Player player, int bonus) {
		return landMessage(player) + player.getName() + " earned a bonus of " + bonus + "!";
	}

	public static String taxMessage(Player player, int rent) {
		return player.getName() + " pays " + rent + " for landing on " + getFieldName(player);
	}

	public static String taxChoiceMessage(Player player) {
		return player.getName() + " select one of the opportunities.";
	}

	public static String fleetOwnedMessage(Player player, Player owner, int sameOwnerCount, int rent) {
		return landMessage(player) + "This field is owned by " + owner.getName() + ", who owns a total of "
				+ sameOwnerCount + " fleet Fields." + "Therefore " + player.getName() + "will pay a rent of " + rent
				+ ".";
	}

	public static String fleetMessage(Player player, int sameOwnerCount, int rent) {
		return landMessage(player) + "This field is owned by no one, who owns a total of " + sameOwnerCount
				+ " fleet Fields." + "Therefore " + player.getName() + "will pay a rent of " + rent + ".";
	}

	public static String removePlayerMessage(Player player) {
		return player.getName() + " has been declared bankrupt, and has been removed from the game!";
	}

	public static String winnerMessage(Player player) {
		return player.getName() + " has won the game! Congratulations!";
	}

	public static String homeMessage(Player player) {
		return player.getName() + " lands on " + fieldText[0][0] + "!\n\n" + fieldText[0][1];
	}

	public static String insufficientBalance(Player player, int price) {
		return player.getName() + " does not have enough balance to purchase a field for " + price + "!";
	}

	public static String getFieldName(Player player) {
		return TextInfo.fieldText[player.getPosition() - 1][0];
	}

	public static String landMessage(Player player) {
		return player.getName() + " lands on " + getFieldName(player) + "!\n\n";
	}

};