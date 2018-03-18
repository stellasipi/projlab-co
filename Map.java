package shokoban;

import java.util.ArrayList;

public class Map {
	ArrayList<TileElement> tiles=new ArrayList<>();
	
	public void AddTileElement(TileElement t)
	{
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].AddTileElement(t):");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Map].AddTileElement(t):");
	}
	public void PlaceWorker(Worker w) 
	{
		  //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].PlaceWorker(w):");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Map].PlaceWorker(c):");
	}
	public void PlaceCrate(Crate c) 
	{
		  //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].PlaceCrate(c):");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Map].PlaceCrate(c):");
	}
	public void CreateMap() 
	{
		  //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].CreateMap():");

        //fgv törzs
        
        //bemegyünk a fgv-be
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Map].CreateMap():");
	}
	
	public ArrayList<TileElement> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<TileElement> tiles) {
		this.tiles = tiles;
	}
}

