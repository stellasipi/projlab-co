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
				"	2.1 A mező, amire toljuk fal legyen.\n" + 
				"	2.2 A mező, amire toljuk oszlop legyen.\n" + 
				"	2.3 A mező, amire toljuk csapda legyen.\n" + 
				"	2.4 A mező, amire toljuk lyuk legyen.\n" + 
				"	2.5 A mező, amire toljuk cél legyen.\n" + 
				"	2.6 A mező, amire toljuk kapcsoló legyen.\n" + 
				"	2.7 A mező, amire toljuk sima mező legyen.\n" + 
				"3.0 Munkás eltol egy ládát egy adott mezőről (és egy sima üres mezőre érkezik)\n" + 
				"	3.1 A mező, amiről toljuk csapda legyen.\n" + 
				"	3.2 A mező, amiről toljuk cél legyen.\n" + 
				"	3.3 A mező, amiről toljuk kapcsoló legyen.\n" + 
				"	3.4 A mező, amiről toljuk sima mező legyen.\n" + 
				"4 Munkás lyukba lép\n" + 
				"5 Láda ládát tol\n" + 
				"6 Munkás munkást tol\n" + 
				"7 MLMF\n" + 
				"8 MLMMF\n" +
				"9 Kilépés a tesztelő programból"+
				"Használati útmutató: ...");
    	String input = null;
		while(true){
			System.out.println("? Válassz egy dialógust: ");
		
			//beolvasás	

	    	try {
	        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        	input = bufferedReader.readLine();
	        	if(input.equals("9"))
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
		        			Scene1 s1=new Scene1();
		        		}
	        			break;
	        		case(2):
	        			Scene2 s2=new Scene2();
	        			System.out.println("2.0 Munkás eltol egy ládát egy üres mezőre\n"+ "Válaszd ki az almenüt");
	        			//megnézem mi történik a check() meghívására- még formázni kell, de legalább már részben működik	
	        			//g.Check();
	        		input = bufferedReader.readLine();
	        		almenu=Integer.parseInt(input);
	        			switch(almenu)
	        			{
		        			case(1):
		        				System.out.println("2.1 A mező, amire toljuk fal legyen.");
		        				s2.Scene2_1();
		        				break;
		        			case(2):
		        				System.out.println("2.2 A mező, amire toljuk oszlop legyen.");
		        				s2.Scene2_2();
		        				break;
		        			case(3):
		        				System.out.println("2.3 A mező, amire toljuk csapda legyen.");
		        				s2.Scene2_3();
		        				break;
		        			case(4):
		        				System.out.println("2.4 A mező, amire toljuk lyuk legyen.");
			        			s2.Scene2_4();
		        				break;
		        			case(5):
		        				System.out.println("2.5 A mező, amire toljuk cél legyen.");
			        			s2.Scene2_5();
		        				break;
		        			case(6):
		        				System.out.println("2.6 A mező, amire toljuk kapcsoló legyen.");
			        			input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        			s2.Scene2_6();
		        				break;
		        			case(7):
		        				System.out.println("2.7 A mező, amire toljuk sima mező legyen.");
			        			s2.Scene2_7();
		        				break;
	        			}
	        			
	        			break;
	        		case(3):
	        			Scene3 s3=new Scene3();
	        			System.out.println("3.0 Munkás eltol egy ládát egy adott mezőről (és egy sima üres mezőre érkezik)\n");
		        		input = bufferedReader.readLine();
		        		almenu=Integer.parseInt(input);
		        			switch(almenu)
		        			{
			        			case(1):
			        				System.out.println("3.1 A mező, amiről toljuk csapda legyen.");
				        			s3.Scene3_1();
			        				break;
			        			case(2):
			        				System.out.println("3.2 A mező, amiről toljuk cél legyen.");
				        			s3.Scene3_2();
			        				break;
			        			case(3):
			        				System.out.println("3.3 A mező, amiről toljuk kapcsoló legyen.");
			        				s3.Scene3_3();
			        				break;
			        			case(4):
			        				System.out.println("3.4 A mező, amiről toljuk sima mező legyen.");
				        			s3.Scene3_4();
			        				break;
		        			}
			        				
	        			break;
	        		case(4):
	        			System.out.println("4 Munkás lyukba lép\n");
		        		{
		        			Scene4 s4=new Scene4();
		        			s4.Scene4_0();
		        		}
	        			break;
	        		case(5):
	        			System.out.println("5 Láda ládát tol\n");
		        		{
		        			Scene5 s5= new Scene5();
		        			s5.Scene5_0();
		        		}
	        			break;
	        		case(6):
	        			System.out.println("6 Munkás munkást tol\n");
		        		{
		        			Scene6 s6=new Scene6();
		        			s6.Scene6_0();
		        		}
	        			break;
	        		case(7):
	        			System.out.println("7 MLMF\n");
		        		{
		        			Scene7 s7=new Scene7();
		        			s7.Scene7_0();
		        		}
	        			break;
	        		case(8):
	        			System.out.println("8 MLMMF\n");
		        		{
		        			Scene8 s8=new Scene8();
		        			s8.Scene8_0();
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
	
		


