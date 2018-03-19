package shokoban;

public class Scene2 {
	Game game = new Game();
	Worker worker = new Worker();
	Crate crate = new Crate();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();

	public void Scene2set() {
		t1.setNeighbour(t2, Direction.RIGHT);
		t2.setNeighbour(t1, Direction.LEFT);
		t1.setObject(worker);
		t2.setObject(crate);
		worker.setTile(t1);
		crate.setTile(t2);
		game.AddCrate(crate);
		game.AddWorker(worker);
		m.AddTileElement(t1);
		m.AddTileElement(t2);
	}
	
	public void Scene2_1() {
		
		this.Scene2set();
		Wall w = new Wall();
		t2.setNeighbour(w, Direction.RIGHT);
		w.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(w);
		
		t2.Accept(worker, Direction.RIGHT);
		
	}
	public void Scene2_2() {}
	public void Scene2_3() {}
	public void Scene2_4() {}
	public void Scene2_5() {}
	public void Scene2_6() {}
	public void Scene2_7() {}
}