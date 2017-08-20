package prisMotor;

import java.util.ArrayList;
import java.util.List;

// Prismotor som genererer og returnerer liste med priser for antall produkter fra 1-50.
public class PrisMotor {
	public List<String> prisMotor(String produkt){
		List<String> best = new ArrayList<String>();

		best.add("Antall  |   Pris");

		for (int i = 1; i <= 50; i++ ){
			Bestilling b = new Bestilling();

			best.add( i + "   |  " + b.kalkulator(produkt, i, 0) ); 

		}

		return best;
	}
}
