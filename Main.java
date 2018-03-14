package shokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		int szam; //beolvasott sorszáma
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
    	String input = null;
		while(input!="e"){
			System.out.println("? Válassz egy dialógust: ");
		
			//beolvasás	

	    	try {
	        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        	input = bufferedReader.readLine();
	        	szam = Integer.parseInt(input);
	        	System.out.println(szam);
	    	} catch (NumberFormatException ex) {
	    		System.out.println("Not a number !");
	    	} catch (IOException e) {
	        	e.printStackTrace();
	    	}
		}
	}

}
