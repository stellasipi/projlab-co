package shokoban;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		//létrehozok egy játékot
		//Game g=new Game();
		
		int szam;
		int almenu;//beolvasott sorszáma és almenüje
		System.out.println("Menu:\n"+ 
				"1.0 Pálya felépítése\n" + 
				"2.0 Munkás eltol egy ládát egy üres mezőre\n" + 
				"	2.1 A mező, amire toljuk fal legyen? (Y/N)\n" + 
				"	2.2 A mező, amire toljuk oszlop legyen? (Y/N)\n" + 
				"	2.3 A mező, amire toljuk csapda legyen? (Y/N)\n" + 
				"	2.4 A mező, amire toljuk lyuk legyen? (Y/N)\n" + 
				"	2.5 A mező, amire toljuk cél legyen? (Y/N)\n" + 
				"	2.6 A mező, amire toljuk kapcsoló legyen? (Y/N)\n" + 
				"	2.7 A mező, amire toljuk sima mező legyen? (Y/N)\n" + 
				"3.0 Munkás eltol egy ládát egy adott mezőről (és egy sima üres mezőre érkezik)\n" + 
				"	3.1 A mező, amiről toljuk csapda legyen? (Y/N)\n" + 
				"	3.2 A mező, amiről toljuk cél legyen? (Y/N)\n" + 
				"	3.3 A mező, amiről toljuk kapcsoló legyen? (Y/N)\n" + 
				"	3.4 A mező, amiről toljuk sima mező legyen? (Y/N)\n" + 
				"4 Munkás lyukba lép\n" + 
				"5 Láda ládát tol\n" + 
				"6 Munkás munkást tol\n" + 
				"7 MLMF\n" + 
				"8 MLMMF\n" +
				"Használati útmutató: ...");
    	String input = null;
		while(true){
			System.out.println("? Válassz egy dialógust: ");
		
			//beolvasás	

	    	try {
	        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        	input = bufferedReader.readLine();
	        	if(input.equals("e"))
	        	{
	        		break;
	        	}
	        	else
	        	{
	        		szam=Integer.parseInt(input);
	        		System.out.println("-"+szam+".");
	        		switch(szam)
	        		{
	        		case(1):
	        			System.out.println("1.0 Pálya felépítése");
		        		{
		        			//forgatókönyv
		        		}
	        			break;
	        		case(2):
	        			System.out.println("2.0 Munkás eltol egy ládát egy üres mezőre\n");
	        			//megnézem mi történik a check() meghívására- még formázni kell, de legalább már részben működik	
	        			//g.Check();
	        		input = bufferedReader.readLine();
	        		almenu=Integer.parseInt(input);
	        			switch(almenu)
	        			{
		        			case(1):
		        				System.out.println("2.1 A mező, amire toljuk fal legyen? (Y/N)");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
		        			case(2):
		        				System.out.println("2.2 A mező, amire toljuk oszlop legyen? (Y/N)");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
		        			case(3):
		        				System.out.println("2.3 A mező, amire toljuk csapda legyen? (Y/N)");
		        				input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
		        			case(4):
		        				System.out.println("2.4 A mező, amire toljuk lyuk legyen? (Y/N)");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
		        			case(5):
		        				System.out.println("2.5 A mező, amire toljuk cél legyen? (Y/N)");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
		        			case(6):
		        				System.out.println("2.6 A mező, amire toljuk kapcsoló legyen? (Y/N)");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
		        			case(7):
		        				System.out.println("2.7 A mező, amire toljuk sima mező legyen? (Y/N)");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			{
			        				//forgatóköny 
			        			}
		        				break;
	        			}
	        			
	        			break;
	        		case(3):
	        			System.out.println("3.0 Munkás eltol egy ládát egy adott mezőről (és egy sima üres mezőre érkezik)\n");
		        		input = bufferedReader.readLine();
		        		almenu=Integer.parseInt(input);
		        			switch(almenu)
		        			{
			        			case(1):
			        				System.out.println("3.1 A mező, amiről toljuk csapda legyen? (Y/N)");
				        			input = bufferedReader.readLine();
				        			if(input.equals("y")||input.equals("Y"))
				        			{
				        				//forgatóköny 
				        			}
			        				break;
			        			case(2):
			        				System.out.println("3.2 A mező, amiről toljuk cél legyen? (Y/N)");
				        			input = bufferedReader.readLine();
				        			if(input.equals("y")||input.equals("Y"))
				        			{
				        				//forgatóköny 
				        			}
			        				break;
			        			case(3):
			        				System.out.println("3.3 A mező, amiről toljuk kapcsoló legyen? (Y/N)");
			        				input = bufferedReader.readLine();
				        			if(input.equals("y")||input.equals("Y"))
				        			{
				        				//forgatóköny 
				        			}
			        				break;
			        			case(4):
			        				{System.out.println("3.4 A mező, amiről toljuk sima mező legyen? (Y/N)");
				        			input = bufferedReader.readLine();
				        			if(input.equals("y")||input.equals("Y"))
				        			{
				        				//forgatóköny 
				        			}
			        				break;
			        				}
		        			}
			        				
	        			break;
	        		case(4):
	        			System.out.println("4 Munkás lyukba lép\n");
		        		{
		        			//forgatókönyv
		        		}
	        			break;
	        		case(5):
	        			System.out.println("5 Láda ládát tol\n");
		        		{
		        			//forgatókönyv
		        		}
	        			break;
	        		case(6):
	        			System.out.println("6 Munkás munkást tol\n");
		        		{
		        			//forgatókönyv
		        		}
	        			break;
	        		case(7):
	        			System.out.println("7 MLMF\n");
		        		{
		        			//forgatókönyv
		        		}
	        			break;
	        		case(8):
	        			System.out.println("8 MLMMF\n");
		        		{
		        			//forgatókönyv
		        		}
	        			break;
	    
	        		}
	        	}

	        	
	    	} catch (NumberFormatException ex) {
	    		System.out.println("Not a number !");
	    	} catch (IOException e) {
	        	e.printStackTrace();
	    	}
			
			
		}
		
	}
}
	
		


