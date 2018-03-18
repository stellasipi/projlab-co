package shokoban;

public class Map {
	private TileElement[] tiles;
	
	public void AddTileElement(TileElement t){}
	public void PlaceWorker(Worker w) {}
	public void PlaceCrate(Crate c) {}
	public void CreateMap() {}
	
	public TileElement[] getTiles() {
		return tiles;
	}
	public void setTiles(TileElement[] tiles) {
		this.tiles = tiles;
	}
}
