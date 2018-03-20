package shokoban;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		int szam;
		int almenu;//beolvasott sorszáma és almenüje
		System.out.println("Menu:\n"+ 
				"1 Pálya felépítése\n" + 
				"2.0 Munkás adott mezőre tol egy ládát\n" + 
				"3.0 Munkás eltol egy ládát egy adott mezőről\n" + 
				"4 Munkás lyukba lép\n" + 
				"5 Láda ládát tol\n" + 
				"6 Munkás munkást tol\n" + 
				"7 MLMF\n" + 
				"8 MLMMF\n" +
				"10 Használati útmutató\n" +
				"9 Kilépés a tesztelő programból\n");
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
	        		switch(szam)
	        		{
	        		case(1):
	        			System.out.println("1.0 Pálya felépítése");
		        		{
		        			Scene1 s1=new Scene1();
		        			s1.Scene1_0();
		        		}
	        			break;
	        		case(2):
	        			Scene2 s2=new Scene2();
	        			System.out.println("2.0 Almenü:\n"+
	        					"	1 Munkás fal mezőre tol egy ládát.\n" + 
	        					"	2 Munkás oszlop mezőre tol egy ládát.\n" + 
	        					"	3 Munkás csapda mezőre tol egy ládát.\n" + 
	        					"	4 Munkás lyuk mezőre tol egy ládát.\n" + 
	        					"	5 Munkás cél mezőre tol egy ládát.\n" + 
	        					"	6 Munkás kapcsoló mezőre tol egy ládát.\n" + 
	        					"	7 Munkás sima mezőre tol egy ládát.\n" );
	        			//megnézem mi történik a check() meghívására- még formázni kell, de legalább már részben működik	
	        			//g.Check();
	        		input = bufferedReader.readLine();
	        		almenu=Integer.parseInt(input);
	        			switch(almenu)
	        			{
		        			case(1):
		        				System.out.println("2.1 Munkás fal mezőre tol egy ládát.");
		        				s2.Scene2_1();
		        				break;
		        			case(2):
		        				System.out.println("2.2 Munkás oszlop mezőre tol egy ládát.");
		        				s2.Scene2_2();
		        				break;
		        			case(3):
		        				System.out.println("2.3 Munkás csapda mezőre tol egy ládát.");
		        				System.out.println("A csapda aktív legyen? yes-Y/no-N");
		        				input = bufferedReader.readLine();
			        			if(input.equals("y")||input.equals("Y"))
			        				s2.Scene2_3_active();
			        			if(input.equals("n")||input.equals("N"))
			        				s2.Scene2_3_inactive();
		        				break;
		        			case(4):
		        				System.out.println("2.4 Munkás lyuk mezőre tol egy ládát.");
			        			s2.Scene2_4();
		        				break;
		        			case(5):
		        				System.out.println("2.5 Munkás cél mezőre tol egy ládát.");
			        			s2.Scene2_5();
		        				break;
		        			case(6):
		        				System.out.println("2.6 Munkás kapcsoló mezőre tol egy ládát.");
			        			s2.Scene2_6();
		        				break;
		        			case(7):
		        				System.out.println("2.7 Munkás sima mezőre tol egy ládát.");
			        			s2.Scene2_7();
		        				break;
	        			}
	        			
	        			break;
	        		case(3):
	        			Scene3 s3=new Scene3();
	        			System.out.println("3.0 Alemnü:\n"+
	        					" 	1 Munkás eltol egy ládát egy csapda mezőről\n" + 
	        					"	2 Munkás eltol egy ládát egy cél mezőről.\n" + 
	        					"	3 Munkás eltol egy ládát egy kapcsoló mezőről.\n" + 
	        					"	4 A mező, amiről toljuk sima mező legyen.\n");
		        		input = bufferedReader.readLine();
		        		almenu=Integer.parseInt(input);
		        			switch(almenu)
		        			{
			        			case(1):
			        				System.out.println("3.1 Munkás eltol egy ládát egy csapda mezőről");
				        			s3.Scene3_1();
			        				break;
			        			case(2):
			        				System.out.println("3.2 Munkás eltol egy ládát egy cél mezőről.");
				        			s3.Scene3_2();
			        				break;
			        			case(3):
			        				System.out.println("3.3 Munkás eltol egy ládát egy kapcsoló mezőről.");
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
	        		case(10):
	        			UserGuide();
	    
	        		}
	        	}

	        	
	    	} catch (NumberFormatException ex) {
	    		System.out.println("Not a number !");
	    	} catch (IOException e) {
	        	e.printStackTrace();
	    	}
			
		}
		
	}
	public static void UserGuide() {
		System.out.print("Használati utasítás:\n\n"
						+ "A kívánt dialógust a billentyűzet számaival tudod kiválasztani.\n"
						+ "Először a fő dialógust válaszd ki, majd az Enter lenyomása után kiválaszthatod a kívánt forgatókönyvet az almenüben.\n"
						+ "Ekkor lefut a kívánt forgatókönyv. A meghívott függvények a következő formátumban lesznek kiírva:\n"
						+ " [:Osztálynév].függvénynév(paraméterek):\n\n"
						);
	}
	
}
	
		


