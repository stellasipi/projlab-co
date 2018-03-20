package shokoban;

public class Scene3 {
	Game game = new Game();
	Worker worker = new Worker();
	Crate crate = new Crate();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();

	public void Scene3set() {
		t1.setObject(worker);
		t2.setObject(null);
		worker.setTile(t1);
		
		game.AddCrate(crate);
		game.AddWorker(worker);
		
		m.AddTileElement(t1);
		m.AddTileElement(t2);
	}
	
	public void Scene3_1() {
		
		this.Scene3set();
		Trap trap = new Trap();
		t1.setNeighbour(trap, Direction.RIGHT);
		t2.setNeighbour(trap, Direction.LEFT);
		trap.setNeighbour(t2, Direction.RIGHT);
		trap.setNeighbour(t1, Direction.LEFT);
		trap.setObject(crate);
		crate.setTile(trap);
		m.AddTileElement(trap);
		
		game.Move(worker, Direction.RIGHT);
	}
	public void Scene3_2() {
		this.Scene3set();
		Target target = new Target();
		t1.setNeighbour(target, Direction.RIGHT);
		t2.setNeighbour(target, Direction.LEFT);
		target.setNeighbour(t2, Direction.RIGHT);
		target.setNeighbour(t1, Direction.LEFT);
		target.setObject(crate);
		crate.setTile(target);
		m.AddTileElement(target);
		
		game.Move(worker, Direction.RIGHT);
	}
	public void Scene3_3() {
		this.Scene3set();
		Button button=new Button();
		t1.setNeighbour(button, Direction.RIGHT);
		t2.setNeighbour(button, Direction.LEFT);
		button.setNeighbour(t2, Direction.RIGHT);
		button.setNeighbour(t1, Direction.LEFT);
		button.setObject(crate);
		crate.setTile(button);
		m.AddTileElement(button);
		
		game.Move(worker, Direction.RIGHT);
	}
	public void Scene3_4() {
		this.Scene3set();
		Tile tile=new Tile();
		t1.setNeighbour(tile, Direction.RIGHT);
		t2.setNeighbour(tile, Direction.LEFT);
		tile.setNeighbour(t2, Direction.RIGHT);
		tile.setNeighbour(t1, Direction.LEFT);
		tile.setObject(crate);
		crate.setTile(tile);
		m.AddTileElement(tile);
		
		game.Move(worker, Direction.RIGHT);
	}
}