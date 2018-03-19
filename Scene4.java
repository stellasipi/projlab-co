package shokoban;

public class Scene4 {
	Game game = new Game();
	Worker worker = new Worker();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();
	
	public void Scene4set() {
		t1.setNeighbour(t2, Direction.RIGHT);
		t2.setNeighbour(t1, Direction.LEFT);
		t1.setObject(worker);
		worker.setTile(t1);
		game.AddWorker(worker);
		m.AddTileElement(t1);
		m.AddTileElement(t2);
	}
	
	public void Scene4_0() {
		this.Scene4set();
		Hole h = new Hole();
		t2.setNeighbour(h, Direction.RIGHT);
		h.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(h);
		
		game.Move(worker, Direction.RIGHT);
		game.Check();
	}

}