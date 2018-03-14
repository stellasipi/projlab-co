package shokoban;

public class Main {

	public static void main(String[] args) {
		int szam; //beolvasott sorsz�m
		System.out.println("Menu:\n"+ 
				"1. Pálya felépítése\n" + 
				"2. Munkás eltol egy ládát egy üres mezőre\n" + 
				"	2.1. A mező, amire toljuk fal legyen? (Y/N)\n" + 
				"	2.2. A mező, amire toljuk oszlop legyen? (Y/N)\n" + 
				"	2.3. A mező, amire toljuk csapda legyen? (Y/N)\n" + 
				"	2.4. A mező, amire toljuk lyuk legyen? (Y/N)\n" + 
				"	2.5. A mező, amire toljuk cél legyen? (Y/N)\n" + 
				"	2.6. A mező, amire toljuk kapcsoló legyen? (Y/N)\n" + 
				"	2.7. A mező, amire toljuk sima mező legyen? (Y/N)\n" + 
				"3. Munkás eltol egy ládát egy adott mezőről (és egy sima üres mezőre érkezik)\n" + 
				"	3.1. A mező, amiről toljuk csapda legyen? (Y/N)\n" + 
				"	3.2. A mező, amiről toljuk cél legyen? (Y/N)\n" + 
				"	3.3. A mező, amiről toljuk kapcsoló legyen? (Y/N)\n" + 
				"	3.4. A mező, amiről toljuk sima mező legyen? (Y/N)\n" + 
				"4. Munkás lyukba lép\n" + 
				"5. Láda ládát tol\n" + 
				"6. Munkás munkást tol\n" + 
				"7. MLMF\n" + 
				"8. MLMMF" +
				"Használati útmutató: ...");
		
		System.out.println("? Válassz egy dialógust: ");
	}

}
