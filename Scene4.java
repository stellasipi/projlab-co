package shokoban;

public class Scene4 {
	Game game = new Game();
	Worker worker = new Worker();
	Map m = new Map();
	Tile t1 = new Tile();
	
	public void Scene4set() {
		t1.setObject(worker);
		worker.setTile(t1);
		game.AddWorker(worker);
		m.AddTileElement(t1);
	}
	
	public void Scene4_0() {
		this.Scene4set();
		Hole h = new Hole();
		t1.setNeighbour(h, Direction.RIGHT);
		h.setNeighbour(t1, Direction.LEFT);
		m.AddTileElement(h);
		
		System.out.println("Dialógus:");
		game.Move(worker, Direction.RIGHT);
	}

}