package shokoban;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
		


