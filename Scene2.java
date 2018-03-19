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
	public void Scene2_2() {
		this.Scene2set();
		Coloumn co = new Coloumn();
		t2.setNeighbour(co, Direction.RIGHT);
		co.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(co);
		
		t2.Accept(worker, Direction.RIGHT);
	}
	public void Scene2_3() {
		this.Scene2set();
		Trap tr = new Trap();
		t2.setNeighbour(tr, Direction.RIGHT);
		tr.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(tr);
		
		t2.Accept(worker, Direction.RIGHT);
	}
	public void Scene2_4() {
		
		this.Scene2set();
		Hole ho = new Hole();
		t2.setNeighbour(ho, Direction.RIGHT);
		ho.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(ho);
		
		t2.Accept(worker, Direction.RIGHT);
		
	}
	public void Scene2_5() {
		
		this.Scene2set();
		Target ta = new Target();
		t2.setNeighbour(ta, Direction.RIGHT);
		ta.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(ta);
		
		t2.Accept(worker, Direction.RIGHT);
		
	}
	public void Scene2_6() {

		this.Scene2set();
		Button bu = new Button();
		t2.setNeighbour(bu, Direction.RIGHT);
		bu.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(bu);
		
		t2.Accept(worker, Direction.RIGHT);
		
	}
	public void Scene2_7() {

		
		this.Scene2set();
		Tile ti = new Tile();
		t2.setNeighbour(ti, Direction.RIGHT);
		ti.setNeighbour(t2, Direction.LEFT);
		m.AddTileElement(ti);
		
		t2.Accept(worker, Direction.RIGHT);
		
	}

}