package shokoban;
import java.util.ArrayList;

public class Game {
	//Dia
	Map map=new Map();
	ArrayList<Crate> crates= new ArrayList<>();
	ArrayList<Worker> workers= new ArrayList<>();
	
	public void EndGame()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].EndGame():");
        
        //fgv törzs
	}
	
	public void StartGame()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].StartGame():");

        //fgv törzs
        
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

        //fgv törzs
        w.getTile().getNeighbour(d).Accept(w, d);
        Check();
	}
	
	public void Check()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Check():");
        

        if(CheckCrateOnTarget()||CheckDeadWorker()||CheckMoveableCrate()||CheckPushable())
        	this.EndGame();


	}
	
	public void AddWorker(Worker w)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].AddWorker(w):");

        workers.add(w);
        w.setGame(this);
        

	}
	
	public void AddCrate(Crate c)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].AddCrate(c):");

        crates.add(c);
        c.setGame(this);
        
 
	}
	
	public boolean CheckCrateOnTarget()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckCrateOnTarget():");
        
		return false;
	}
	
	public boolean CheckDeadWorker()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckDeadWorker():");
        

		return false;
	}
	
	public boolean CheckMoveableCrate()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckMoveableCrate():");
        
		return false;
	}
	
	public boolean CheckPushable()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckPushable():");
        
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


