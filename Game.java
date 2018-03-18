package shokoban;

public class Game {
	private Map map;
	private Crate[] crates;
	private Worker[] workers;
	
	public void EndGame() {}
	public void StartGame() {}
	public void Move() {}
	public void Check() {}
	public void AddWorker(Worker w) {}
	public void AddCrate(Crate c) {}
	public boolean CheckCrateOnTarget() {return true;}
	public boolean CheckDeadWorker() {return true;}
	public boolean CheckMoveableCrate() {return true;}
	public boolean CheckPushable() {return true;}
	public void CalculateScores() {}
	public void Die(Worker w) {}
	public void Die(Crate c) {}
}
