package shokoban;

public class Map {
	private TileElement[] tiles;
	
	public void AddTileElement(TileElement t){
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Map].AddTileElement(t):");

        //fgv törzs

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Map].AddTileElement(t):");
	}
	public void PlaceWorker(Worker w) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Map].PlaceWorker(t):");

        //fgv törzs

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Map].PlaceWorker(t):");
	}
	public void PlaceCrate(Crate c) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Map].PlaceCrate(c):");

        //fgv törzs

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Map].PlaceCrate(c):");
	}
	public void CreateMap() {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Map].CreateMap():");

        //fgv törzs

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Map].CreateMap():");
	}
	
	public TileElement[] getTiles() {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Map].getTiles():");

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Map].getTiles():");
        
		return tiles;
	}
	public void setTiles(TileElement[] tiles) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Map].setTiles(tiles):");
        
		this.tiles = tiles;
		
        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Map].setTiles(tiles):");
	}
}
