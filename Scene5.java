package shokoban;

public class Scene5 {
	Game game = new Game();
	Crate crate1 = new Crate();
	Crate crate2 = new Crate();
	Map m = new Map();
	Tile t1 = new Tile();
	Tile t2 = new Tile();
	Tile t3 = new Tile();
	
	public void Scene5set() {
		t1.setObject(crate1);
		t2.setObject(crate2);
		t3.setObject(null);
		
		game.AddCrate(crate1);
		game.AddCrate(crate2);
		
		m.AddTileElement(t1);
		m.AddTileElement(t2);
		m.AddTileElement(t3);
	}
	
	public void Scene5_0() {
		
		this.Scene5set();
		t1.setNeighbour(t2, Direction.RIGHT);
		t2.setNeighbour(t1, Direction.LEFT);
		t2.setNeighbour(t3, Direction.RIGHT);
		t3.setNeighbour(t2, Direction.LEFT);
		crate1.setTile(t1);
		crate2.setTile(t2);
		
		t2.Accept(crate1, Direction.RIGHT);
	}
		
	
}