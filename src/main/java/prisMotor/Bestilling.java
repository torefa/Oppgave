package prisMotor;

import javax.validation.constraints.Min;

public class Bestilling {

	public String produktNavn;

	@Min(0)
	public int antEnh;

	@Min(0)
	public int antKart;

	@Min(0)
	public double pris;

	public void setProduktNavn(String navn) {
		this.produktNavn = navn;
	}

	public void setAntEnh(int antEnh) {
		this.antEnh = antEnh;
	}

	public void setAntKart(int antKart) {
		this.antKart = antKart;
	}

	public String getProduktNavn(){
		return produktNavn;
	}

	public int getAntEnh(){
		return antEnh;
	}

	public int getAntKart(){
		return antKart;
	}

	public double getPris(){
		return pris;
	}

	// Kalkulator for å regne ut pris på bestilling
	public double kalkulator(String produkt, int enheter, int kartonger){

		int kartongKap = 1;
		int kartongOverskudd;
		int antKart;

		double pris = 0;
		double enhetsPris;
		double totalpris;

		// Kartongstørrelsen varierer med produktinput
		switch (produkt) {
		case "Pingvinører":
			pris = getPris("Pingvinører");
			kartongKap = 20;
			break;
		case "Hestesko":
			pris = getPris("Hestesko");
			kartongKap = 5;
			break;
		}

		// 30% påslag for manuell plukk
		enhetsPris = pris / kartongKap * 1.3;

		// Regner ut hvor mange kartonger man får av input av antall enheter samt evt. kartonger 
		kartongOverskudd = enheter % kartongKap;
		antKart = kartonger + (enheter - (kartongOverskudd))/kartongKap;

		if (antKart >= 3){
			pris = pris * 0.9;
		}

		totalpris = antKart*pris + kartongOverskudd*enhetsPris; 

		return totalpris; 

	}

	// Funksjon for å sette pris på produktene. Bør kobles opp mot database.
	private double getPris(String produkt) {
		if (produkt == "Pingvinører"){
			return 175;
		}
		else {
			return 825;
		}

	}


}

