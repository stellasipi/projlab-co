package shokoban;

import java.util.ArrayList;

public class Map {
	ArrayList<TileElement> tiles=new ArrayList<>();
	
	public void AddTileElement(TileElement t){}
	public void PlaceWorker(Worker w) {}
	public void PlaceCrate(Crate c) {}
	public void CreateMap() {}
	
	public ArrayList<TileElement> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<TileElement> tiles) {
		this.tiles = tiles;
	}
}
