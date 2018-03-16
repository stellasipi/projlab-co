package shokoban;



public class Game {
	//Dia
	Map map;
	Crate[] crates;
	Worker[] workers;
	
	public void EndGame()
	{
		System.out.println("[:Game].EndGame");
	}
	
	public void StartGame()
	{
		System.out.println("[:Game].StartGame");
	}
	
	public void Move(Direction d)
	{
		System.out.println("[:Game].Move(d)");
	}
	
	public void Check()
	{
		System.out.println("[:Game].Check()");
		CheckCrateOnTarget();
		CheckDeadWorker();
		CheckMoveableCrate();
		CheckPushable();
	}
	
	public void AddWorker(Worker w)
	{
		System.out.println("[:Game].AddWorker(w)");
	}
	
	public void AddWorker(Crate c)
	{
		System.out.println("[:Game].AddCrate(c)");
	}
	
	public boolean CheckCrateOnTarget()
	{
		System.out.println("[:Game].CheckCrateOnTarget()");
		return false;
	}
	
	public boolean CheckDeadWorker()
	{
		System.out.println("[:Game].CheckDeadWorker()");
		return false;
	}
	
	public boolean CheckMoveableCrate()
	{
		System.out.println("[:Game].CheckMoveableCrate()");
		return false;
	}
	
	public boolean CheckPushable()
	{
		System.out.println("[:Game].CheckPushable()");
		return false;
	}
	
	public void CalculateScores()
	{
		System.out.println("[:Game].CalculateScores()");
	}
	
	public void Die(Worker w)
	{
		System.out.println("[:Game].Die(w)");
	}
	
	public void Die(Crate c)
	{
		System.out.println("[:Game].Die(c)");
	}
	
}

