package shokoban;

public class Scene6 {
	public void Scene6_0() {
		System.out.println("Dialógus előkészítése:");
		Game game = new Game();
		Worker worker1 = new Worker();
		Worker worker2 = new Worker();
		Map m = new Map();
		Tile t1 = new Tile();
		Tile t2 = new Tile();
		Tile t3 = new Tile();
		t1.setNeighbour(t2, Direction.RIGHT);
		t2.setNeighbour(t1, Direction.LEFT);
		t2.setNeighbour(t3, Direction.RIGHT);
		t3.setNeighbour(t2, Direction.LEFT);
		t1.setObject(worker1);
		t2.setObject(worker2);
		worker1.setTile(t1);
		worker2.setTile(t2);
		game.AddWorker(worker1);
		game.AddWorker(worker2);
		m.AddTileElement(t1);
		m.AddTileElement(t2);
		m.AddTileElement(t3);
		
		System.out.println("Dialógus:");
		game.Move(worker1, Direction.RIGHT);

	}
}