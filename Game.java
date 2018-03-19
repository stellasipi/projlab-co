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
        Crate c=new Crate();
        Worker w = new Worker();
        map.CreateMap();
        map.PlaceCrate(c);
        AddCrate(c);
        map.PlaceWorker(w);
        AddWorker(w);
	}
	
	public void Move(Direction d)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Move(d):");

        //fgv törzs


	}
	
	public void Check()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Check():");

		CheckCrateOnTarget();
		CheckDeadWorker();
		CheckMoveableCrate();
		CheckPushable();


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


