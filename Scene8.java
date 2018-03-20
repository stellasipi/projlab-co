package shokoban;

public class Scene8 {
	Game game = new Game();
	Worker worker1 = new Worker();
	Worker worker2 = new Worker();
	Worker worker3=new Worker();
	Crate crate = new Crate();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();
	Tile t3 = new Tile();
	Tile t4 = new Tile();
	Wall w=new Wall();
	
	public void Scene8_0() {
		System.out.println("Dialógus előkészítése:");
		t1.setNeighbour(t2, Direction.RIGHT);
		t2.setNeighbour(t1, Direction.LEFT);
		t2.setNeighbour(t3, Direction.RIGHT);
		t3.setNeighbour(t3, Direction.LEFT);
		t3.setNeighbour(t4, Direction.LEFT);
		t4.setNeighbour(t3, Direction.LEFT);
		t4.setNeighbour(w, Direction.LEFT);
		w.setNeighbour(t4, Direction.LEFT);
		
		t1.setObject(worker1);
		t2.setObject(crate);
		t3.setObject(worker2);
		t4.setObject(worker3);
		
		worker1.setTile(t1);
		crate.setTile(t2);
		worker2.setTile(t3);
		worker3.setTile(t4);
		
		game.AddCrate(crate);
		game.AddWorker(worker1);
		game.AddWorker(worker2);
		game.AddWorker(worker3);
		
		m.AddTileElement(t1);
		m.AddTileElement(t2);
		m.AddTileElement(t3);
		m.AddTileElement(t4);
		m.AddTileElement(w);
		
		System.out.println("Dialógus:");
		game.Move(worker1, Direction.RIGHT);
	}
}