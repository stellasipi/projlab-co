package shokoban;

public class Scene3 {
	Game game = new Game();
	Worker worker = new Worker();
	Crate crate = new Crate();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();

	public void Scene3set() {

	}
	
	public void Scene3_1() {
		
		this.Scene3set();
		Trap trap = new Trap();
		t1.setNeighbour(trap, Direction.RIGHT);
		t2.setNeighbour(trap, Direction.LEFT);
		trap.setNeighbour(t2, Direction.RIGHT);
		trap.setNeighbour(t1, Direction.LEFT);
		
		t1.setObject(worker);
		t2.setObject(null);
		trap.setObject(crate);
		
		worker.setTile(t1);
		crate.setTile(trap);
		
		game.AddCrate(crate);
		game.AddWorker(worker);
		
		m.AddTileElement(t1);
		m.AddTileElement(trap);
		m.AddTileElement(t2);

		trap.Accept(worker, Direction.RIGHT);
	}
	public void Scene3_2() {}
	public void Scene3_3() {}
	public void Scene3_4() {}
}