package shokoban;

import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		TestLanguage t = new TestLanguage();
		
		System.out.println("Menu:\n");
		//Itt hívja meg Dávid a tesztelő részt
		try {

		t.Run();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
		


