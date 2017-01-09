package spil.entity;

import java.awt.Color;

/*
 * TextBoundary is a general class that holds all the text information of the system.
 * There are variable Strings that are used throughout the game, as well as specific methods
 * that uses the Players name and roll values to display for a more interactive feeling of the
 * game.
 */
public class TextInfo {

	public static final String[] chanceCardText = {

			// Få penge
			"Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken.",
			"Kommunen har eftergivet et kvartals skat. Hæv i banken kr. 3.000.",
			"Deres præmieobligation er kommet ud. De modtager kr. 1.000 af banken.",
			"De havde en række med elleve rigtige i tipning. Modtag kr. 1.000.",
			"De modtager Deres aktieudbytte. Modtag kr. 1.000 af banken.", "Modtag udbytte af Deres aktier kr. 1.000.",
			"Modtag udbytte af Deres aktier kr. 1.000.",
			"Grundet dyrtiden har De fået gageforhøjelse. Modtag kr. 1.000.",
			"Modtag udbytte af Deres aktier kr. 1.000.", "De modtager kr. 5.000.",
			"De har vundet i Klasselotteriet. Modtag kr. 500.",
			"Værdien af egen avl fra nyttehaven udgør kr. 200, som De modtager af banken",
			"Det er Deres fødselsdag. Modtag af hver medspiller kr. 200.",

			// Betal penge
			"De har måtte vedtage en parkeringsbøde. Betal kr. 200 i bøde.", "Betal Deres bilforsikring kr. 1.000.",
			"Betal kr. 3.000 for reparation af Deres vogn.", "Betal kr. 3.000 for reparation af Deres vogn.",
			"De har modtaget Deres tandlægeregning. Betal kr. 2.000.",
			"De har kørt frem for \"Fuld Stop\". Betal kr. 1.000 i bøde.",
			"De har kørt frem for \"Fuld Stop\". Betal kr. 1.000 i bøde.",
			"De har været en tur i udlandet og haft for mange cigaretter med hjem. Betal told kr. 200.",

			// Ryk til felt
			"Tag ind på Rådhuspladsen. Hvis De passerer \"Start\", indkassér da kr. 4.000.",
			"Ryk frem til Grønningen. Hvis De passerer \"Start\", indkassér da kr. 4.000.",
			"Ryk frem til Frederiksberg Allé. Hvis De passerer \"Start\", indkassér kr. 4.000.",
			"Ryk fem felter foran.", "Ryk tre felter foran.", "Ryk tre felter tilbage.",

			// Gå i fængsel
			"Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer \"Start\" indkasserer de ikke kr. 4.000.",
			"Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer \"Start\" indkasserer de ikke kr. 4.000.",
			"Gå i fængsel. Ryk direkte til fængslet. Selv om De passerer \"Start\" indkasserer de ikke kr. 4.000." };

	public static final int[] chanceCardValue = {

			// Få penge
			1000, 3000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 5000, 500, 200, 200,
			// Betal penge
			200, 1000, 3000, 3000, 2000, 1000, 1000, 200,

			// Ryk til felt
			39, 24, 11, 5, 2, -3,

			// Gå i fængsel
			30, 30, 30 };

	private TextInfo() {

	}

	public static final String TITLE = "Treasure Hunt 3";
	public static final String VERSION = "v0.00";

	public static final String[][] fieldText = { { "Start", "Modtag 4.000", "Hvergang De passerer modtag kr. 4.000" },

			{ "Rødovrevej", "Kr. 1.200",
					"Bygge pris = Kr. 1.000,      Pris for at lande på grunden: uden hus = kr. 50, 1 hus = kr. 250, 2 huse = Kr. 750, 3 huse = Kr. 2.250, 4 huse = Kr. 4.000, Hotel = Kr. 6.000." },

			{ "", "Prøv lykken", "ChanceKort" },

			{ "Hvidovrevej", "Kr. 1.200",
					"Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 50, 1 hus = kr. 250, 2 huse = Kr. 750, 3 huse = Kr. 2.250, 4 huse = Kr. 4.000, Hotel = Kr. 6.000." },

			{ "Indkomstskat", "10% el. Kr 4.000.", "10% af dine samlede pengebeholdning eller kr. 4.000" },

			{ "SFL-Færgerne", "Kr. 4.000",
					"Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },

			{ "Roskildevej", "Kr. 2.000",
					"Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 100, 1 hus = kr. 600, 2 huse = Kr. 1.800, 3 huse = Kr. 5.400, 4 huse = Kr. 8.000, Hotel = Kr. 11.000." },

			{ "", "Prøv lykken", "ChanceKort" },

			{ "Valby Langgade", "Kr. 2.000",
					"Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 100, 1 hus = kr. 600, 2 huse = Kr. 1.800, 3 huse = Kr. 5.400, 4 huse = Kr. 8.000, Hotel = Kr. 11.000." },

			{ "Allégade", "Kr. 2.400",
					"Bygge pris = Kr. 1.000, Pris for at lande på grunden: uden hus = kr. 150, 1 hus = kr. 600, 2 huse = Kr. 1.800, 3 huse = Kr. 5.400, 4 huse = Kr. 8.000, Hotel = Kr. 11.000." },

			{ "I Fængsel", "På Besøg", "På besøg i fængslet" },

			{ "Frederiksberg Allé", "Kr. 2.800",
					"Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 200, 1 hus = kr. 1.000, 2 huse = Kr. 3.000, 3 huse = Kr. 9.000, 4 huse = Kr. 12.500, Hotel = Kr. 15.000." },

			{ "Bryghuset", "Kr. 3.000",
					"Hvis én virksomhed ejes, betales 100 gange så meget som øjnene viser. Hvis begge Breweries ejes, betales 200 gange så meget som øjnene viser." },

			{ "Bülowsvej", "Kr. 2800",
					"Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 200, 1 hus = kr. 1.000, 2 huse = Kr. 3.000, 3 huse = Kr. 9.000, 4 huse = Kr. 12.500, Hotel = Kr. 15.000." },

			{ "Gl. Kongevej", "Kr. 2.800",
					"Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 250, 1 hus = kr. 1.000, 2 huse = Kr. 3.000, 3 huse = Kr. 9.000, 4 huse = Kr. 12.500, Hotel = Kr. 15.000." },

			{ "DSB Rederierne, Kalundborg/Århus", "Kr. 4.000",
					"Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },

			{ "Bernstoffsvej", "Kr. 3.600",
					"Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 300, 1 hus = kr. 1.400, 2 huse = Kr. 4.000, 3 huse = Kr. 11.000, 4 huse = Kr. 16.000, Hotel = Kr. 19.000." },

			{ "", "Prøv lykken", "ChanceKort" },

			{ "Hellerupvej", "Kr. 3.600",
					"Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 300, 1 hus = kr. 1.400, 2 huse = Kr. 4.000, 3 huse = Kr. 11.000, 4 huse = Kr. 16.000, Hotel = Kr. 19.000." },

			{ "Strandvej", "Kr. 4.000",
					"Bygge pris = Kr. 2.000, Pris for at lande på grunden: uden hus = kr. 350, 1 hus = kr. 1.400, 2 huse = Kr. 4.000, 3 huse = Kr. 11.000, 4 huse = Kr. 16.000, Hotel = Kr. 19.000." },

			{ "Rasteplads", "Parkering", "Ta´ en pause" },

			{ "Trianglen", "Kr. 4.000",
					"Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 350, 1 hus = kr. 1.800, 2 huse = Kr. 5.000, 3 huse = Kr. 14.000, 4 huse = Kr. 17.500, Hotel = Kr. 21.000." },

			{ "", "Prøv lykken", "ChanceKort" },

			{ "Østerbrogade", "Kr. 4.000",
					"Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 350, 1 hus = kr. 1.800, 2 huse = Kr. 5.000, 3 huse = Kr. 14.000, 4 huse = Kr. 17.500, Hotel = Kr. 21.000." },

			{ "Grønningen", "Kr. 4.800",
					"Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 400, 1 hus = kr. 1.800, 2 huse = Kr. 5.000, 3 huse = Kr. 14.000, 4 huse = Kr. 17.500, Hotel = Kr. 21.000." },

			{ "DFDS Seaways", "Kr. 4.000",
					"Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },

			{ "Bredgade", "Kr. 5.200",
					"Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 450, 1 hus = kr. 2.200, 2 huse = Kr. 6.600, 3 huse = Kr. 16.000, 4 huse = Kr. 19.500, Hotel = Kr. 23.000." },

			{ "Kgs. Nytorv", "Kr. 5.200",
					"Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 450, 1 hus = kr. 2.200, 2 huse = Kr. 6.600, 3 huse = Kr. 16.000, 4 huse = Kr. 19.500, Hotel = Kr. 23.000." },

			{ "Bryghuset", "Kr. 3.000",
					"Hvis én virksomhed ejes, betales 100 gange så meget som øjnene viser. Hvis begge Breweries ejes, betales 200 gange så meget som øjnene viser." },

			{ "Østergade", "Kr. 5.600",
					"Bygge pris = Kr. 3.000, Pris for at lande på grunden: uden hus = kr. 500, 1 hus = kr. 2.200, 2 huse = Kr. 6.600, 3 huse = Kr. 16.000, 4 huse = Kr. 19.500, Hotel = Kr. 23.000." },

			{ "", "De Fængsles", "Du bliver fængslet!" },

			{ "Amagertorv", "Kr. 6.000",
					"Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 550, 1 hus = kr. 2.600, 2 huse = Kr. 7.800, 3 huse = Kr. 18.000, 4 huse = Kr. 22.000, Hotel = Kr. 25.000." },

			{ "Vimmelskaftet", "Kr. 6.000",
					"Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 550, 1 hus = kr. 2.600, 2 huse = Kr. 7.800, 3 huse = Kr. 18.000, 4 huse = Kr. 22.000, Hotel = Kr. 25.000." },

			{ "", "Prøv lykken", "ChanceKort" },

			{ "Nygade", "Kr. 6.400",
					"Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 600, 1 hus = kr. 2.600, 2 huse = Kr. 7.800, 3 huse = Kr. 18.000, 4 huse = Kr. 22.000, Hotel = Kr. 25.000." },

			{ "DSB Rederierne", "Kr. 4.000",
					"Pris for at lande på grunden: ét rederi ejes = kr. 500, to rederier ejes = Kr. 1.000, tre rederier ejes = 2.000, fire rederier ejes = Kr. 4.000" },

			{ "", "Prøv lykken", "ChanceKort" },

			{ "Frederiksberggade", "Kr. 7.000",
					"Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 700, 1 hus = kr. 3.500, 2 huse = Kr. 10.000, 3 huse = Kr. 22.000, 4 huse = Kr. 26.000, Hotel = Kr. 30.000." },

			{ "Ekstraordinær      -statsskat", "Betal Kr. 2.000", "" },

			{ "Rådhuspladsen", "Kr. 8.000",
					"Bygge pris = Kr. 4.000, Pris for at lande på grunden: uden hus = kr. 1000, 1 hus = kr. 3.500, 2 huse = Kr. 10.000, 3 huse = Kr. 22.000, 4 huse = Kr. 26.000, Hotel = Kr. 30.000." }, };

	public static final String welcomeMessage = "Velkommen til " + TITLE + ", " + VERSION
			+ "!\n\nDette er et matador-lignende spil, hvor du kommer til at rafle med to terninger"
			+ " og derefter lander du på et felt. Der findes felter der har forskellige effekter på spilleren samt nogle der kan købes. "
			+ "Hvis du går bankerot er du ude af spillet. Spillet bliver ved indtil der kun er en spiller tilbage, som så er vinderen"
			+ "af hele spillet. " + "\n\nVælg venligst antallet af spillere.";

	public static final String[] btnArray = { "2", "3", "4", "5", "6" };

	public static final String playerName = "Spiller";

	public static final String buttonYesMessage = "Ja";
	public static final String buttonNoMessage = "Nej";

	public static final String btnBalancePercentage = "10% af din pengebeholdning";

	public static String purchaseFieldMessage(Player player, int price) {
		return landMessage(player) + getFieldName(player) + " er til rådighed for køb. Vil " + player.getName()
				+ " købe dette felt for " + price + " kr?";
	}

	public static String purchaseConfirmedMessage(Player player, int price) {
		return player.getName() + " købte " + getFieldName(player) + " for " + price + " kr.";
	}

	public static String purchaseDeniedMessage(Player player) {
		return player.getName() + " købte ikke " + getFieldName(player) + ".";
	}

	public static final String playerAmountMessage(int playerAmount) {
		return playerAmount + " spillere er valgt!\n\nFor at starte spillet, venligst klik på \"OK\" knappen.";
	}

	public static String rollInfoMessage(Player player) {
		return player.getName() + ", klik på  \"OK\" knappen for at rafle.";
	}

	public static String rollEqualityMessage(Player player) {
		return "Tillykke, " + player.getName() + " har fået et ekstra kast!";
	}

	public static String rollMessage(Player player, int[] rollValues) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, n = rollValues.length; i < n; i++) {
			if (i == rollValues.length - 1) {
				sb.append("og " + Integer.toString(rollValues[i]));
				break;
			}
			sb.append(Integer.toString(rollValues[i]) + " ");
		}
		return player.getName() + " raflede " + sb.toString() + "!";
	}

	public static final String ownFieldMessage(Player player) {
		return player.getName() + " ejer allerede dette felt.";
	}

	public static String alreadyPurchasedMessage(Player player, Player owner, int rent) {
		return getFieldName(player) + " er allerede købt. Du skal betale en rente på " + rent + " til ejeren, "
				+ owner.getName() + ".";
	}

	public static String bonusMessage(Player player, int bonus) {
		return landMessage(player) + player.getName() + " fik en bonus på " + bonus + "!";
	}

	public static String taxMessage(Player player, int rent) {
		return player.getName() + " betaler en rente på " + rent + " for at lande på " + getFieldName(player);
	}

	public static String taxChoiceMessage(Player player) {
		return player.getName() + " vælg venligst.";
	}

	public static String fleetOwnedMessage(Player player, Player owner, int sameOwnerCount, int rent) {
		return landMessage(player) + "Dette felt er ejet af " + owner.getName() + ", som ejer " + sameOwnerCount
				+ " flåde felter. Derfor skal " + player.getName() + " betale en rente på " + rent + ".";
	}

	public static String fleetMessage(Player player, int sameOwnerCount, int rent) {
		return landMessage(player) + "Dette felt er ikke købt, som ejer " + sameOwnerCount + " flåde felter."
				+ "Derfor skal " + player.getName() + " betale en rente på " + rent + ".";
	}

	public static String removePlayerMessage(Player player) {
		return player.getName() + " er blevet deklaret bankerot og er blevet fjernet fra spillet!";
	}

	public static String winnerMessage(Player player) {
		return player.getName() + " har vundet spillet! Tillykke!";
	}

	public static String homeMessage(Player player) {
		return player.getName() + " lander på " + fieldText[0][0] + "!\n\n" + fieldText[0][1];
	}

	public static String insufficientBalance(Player player, int price) {
		return player.getName() + " har ikke nok penge til at købe feltet for " + price + " kr!";
	}

	public static String getFieldName(Player player) {
		return TextInfo.fieldText[player.getPosition()][0];
	}

	public static String landMessage(Player player) {
		return player.getName() + " lander på " + getFieldName(player) + "!\n\n";
	}

	public static String jailFieldMessage(Player player) {
		return player.getName() + " tager på et hurtigt besøg i fængslet.";
	}

	public static String jailedFieldMessage(Player player) {
		return player.getName() + " bliver fanget af politiet og sendes direkte i fængslet.";
	}

	public static String stillJailedMessage(Player player) {
		return player.getName() + " er stadig fængslet.";
	}

	public static String chanceCardMessage(Player player) {
		return player.getName() + " trækker et kort.";
	}

	public static String parkingMessage(Player player) {
		return player.getName() + " tager en pause.";
	}

	public static String startMessage(Player player) {
		return player.getName() + " har passeret \"Start\" og modtaget 4.000 kr.";
	}

	public static String startFieldMessage(Player player) {
		return player.getName() + " har landet på start feltet.";
	}

	public static String sameCounterThrowJailMessage(Player player) {
		return "Desværre,  " + player.getName() + " er fængslet for at slå tre ens slag.";
	}

	public static String purchaseHouseDeniedMessage(Player player) {
		return player.getName() + " har ikke købt alle felter med denne farve.";
	}

	public static String purchaseHouseMessage(Player player, int houseCount, int price) {
		String temp = "";
		switch (houseCount) {
		case 0:
			temp = "det første hus";
			break;
		case 1:
			temp = "det andet hus";
			break;
		case 2:
			temp = "det tredje hus";
			break;
		case 3:
			temp = "det fjerde hus";
			break;
		case 4:
			temp = "et hotel";
			break;
		}
		return "Vil " + player.getName() + " købe " + temp + " på " + getFieldName(player) + " for " + price + " Kr. ?";
	}

};