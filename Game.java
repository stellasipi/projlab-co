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
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].EndGame():");
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
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].StartGame():");
	}
	
	public void Move(Direction d)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Move(d):");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].Move(d):");

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
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].Check():");

	}
	
	public void AddWorker(Worker w)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].AddWorker(w):");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].AddWorker(w):");
	}
	
	public void AddCrate(Crate c)
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].AddCrate(c):");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].AddCrate(c):");
	}
	
	public boolean CheckCrateOnTarget()
	{
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].CheckCrateOnTarget():");
        
        //bemegyünk a fgv-be
        System.out.print("<");
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
        
        //bemegyünk a fgv-be
        System.out.print("<");
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
        
        //bemegyünk a fgv-be
        System.out.print("<");
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
        
        //bemegyünk a fgv-be
        System.out.print("<");
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
        
        //bemegyünk a fgv-be
        System.out.print("<");
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
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].Die(w):");
	}
	
	public void Die(Crate c)
	{
	    //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Game].Die(c):");
        
        //fgv törzs
        crates.remove(c);
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Game].Die(c):");
	}
	
}


