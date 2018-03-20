package shokoban;
import java.util.ArrayList;

public class Game {
	Map map=new Map();
	ArrayList<Crate> crates= new ArrayList<>();
	ArrayList<Worker> workers= new ArrayList<>();
	
	public void EndGame()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].EndGame():");
 
        //Vége a játéknak
	}
	
	public void StartGame()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].StartGame():");

        //Elindul a játék, létrejön a map és a objectek
        
        map.CreateMap();
        for(int i=0; i<10; i++) {
        	Crate c=new Crate();
        	map.PlaceCrate(c);
            AddCrate(c);
        }
        for(int i=0; i<2; i++) {
        	Worker w = new Worker();
            map.PlaceWorker(w);
            AddWorker(w);
        }
        
	}
	
	public void Move(Worker w, Direction d)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Move(d):");

        //Elindítja a mozgást (majd a külső input alapján)
        w.getTile().getNeighbour(d).Accept(w, d);
        
        //Ellenőrzi a játék folytatásának feltételeit
        Check();
	}
	
	public void Check()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Check():");
        
        //Ellenőriz minden feltételt
        if(CheckCrateOnTarget()||CheckDeadWorker()||CheckMoveableCrate()||CheckPushable())
        	this.EndGame();


	}
	
	public void AddWorker(Worker w)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].AddWorker(w):");

        //hozzáadja a munkást a game workers adattagjához
        workers.add(w);
        //beállítja a munkásnak, hoyg melyik játékhoz tartozik (Game osztyálybeli függvények meghívása miatt kell
        w.setGame(this);
        

	}
	
	public void AddCrate(Crate c)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].AddCrate(c):");
        
        //hozzáadja a ládát a game workers adattagjához
        crates.add(c);
        //beállítja a ládának, hoyg melyik játékhoz tartozik (Game osztyálybeli függvények meghívása miatt kell
        c.setGame(this);
        
 
	}
	
	public boolean CheckCrateOnTarget()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckCrateOnTarget():");
        
        //Ellenőrzi, hogy az összes láda a célon van-e
        
		return false;
	}
	
	public boolean CheckDeadWorker()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckDeadWorker():");
        
        //Ellenőrzi, hogy az összes játékos meghalt-e

		return false;
	}
	
	public boolean CheckMoveableCrate()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckMoveableCrate():");
        
        //Ellenőrzi, hogy van-e még mozgatható láda
		return false;
	}
	
	public boolean CheckPushable()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckPushable():");
        
        //Ellenőrzi, hogy a mozgatható ládák elérhetőek-e a munkások számára
		return false;
	}
	
	public void CalculateScores()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CalculateScores():");
        
  
	}
	
	public void Die(Worker w)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Die(w):");
        
        //fgv törzs
        workers.remove(w);
        
  
	}
	
	public void Die(Crate c)
	{
	    //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Die(c):");
        
        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].Die(c):");
	}
	
}


