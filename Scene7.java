package shokoban;

public class Scene7 {

	Game game = new Game();
	Worker worker1 = new Worker();
	Worker worker2 = new Worker();
	Crate crate = new Crate();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();
	Tile t3 = new Tile();
	Wall w=new Wall();
	
	public void Scene7_0() {
		t1.setNeighbour(t2, Direction.RIGHT);
		t2.setNeighbour(t1, Direction.LEFT);
		t2.setNeighbour(t3, Direction.RIGHT);
		t3.setNeighbour(t3, Direction.LEFT);
		t3.setNeighbour(w, Direction.LEFT);
		w.setNeighbour(t3, Direction.LEFT);
		
		t1.setObject(worker1);
		t2.setObject(crate);
		t3.setObject(worker2);
		
		worker1.setTile(t1);
		crate.setTile(t2);
		worker2.setTile(t3);
		
		game.AddCrate(crate);
		game.AddWorker(worker1);
		game.AddWorker(worker2);
		
		m.AddTileElement(t1);
		m.AddTileElement(t2);
		m.AddTileElement(t3);
		m.AddTileElement(w);
		
		game.Move(worker, Direction.RIGHT);
	}
}