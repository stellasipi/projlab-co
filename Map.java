package shokoban;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	ArrayList<TileElement> tiles=new ArrayList<>();
	
	public void AddTileElement(TileElement t)
	{
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].AddTileElement(t):");

        //fgv t�rzs
        tiles.add(t);
	}
	public void PlaceWorker(Worker w) 
	{
		  //bemegy�nk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].PlaceWorker(w):");

        //fgv t�rzs

	}
	public void PlaceCrate(Crate c) 
	{
		  //bemegy�nk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].PlaceCrate(c):");

        //fgv t�rzs
        
       
	}
	public void CreateMap() 
	{
		  //bemegy�nk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].CreateMap():");

        //fgv t�rzs
        Random rand = new Random();
        int co=19;
        int h=4;
        int ta=10;
        int tr=3;
        int b = 3;
        int ti=178;
        
        for(int i=0; i<16; i++) {
        	TileElement t = new Wall();
        	this.AddTileElement(t);
        }
        for(int i=0; i<18; i++) {
        	int j =13;
        	while(j!=13){
        		int r=rand.nextInt(8);
        		switch (r) {
        		case 1:
        			if(co<20) {
        				TileElement t = new Coloumn();
        	        	this.AddTileElement(t);
        	        	co--;
        	        	j++;
        	        	break;
        			}
        			else break;
        		case 2:
        			if(h<5) {
        				TileElement t = new Hole();
        	        	this.AddTileElement(t);
        	        	h--;
        	        	j++;
        	        	break;
        			}
        			else break;
        		case 3:
        			if(ta<11) {
        				TileElement t = new Target();
        	        	this.AddTileElement(t);
        	        	ta--;
        	        	j++;
        	        	break;
        			}
        			else break;
        		case 4:
        			if(tr<4) {
        				TileElement t = new Trap();
        	        	this.AddTileElement(t);
        	        	tr--;
        	        	j++;
        	        	break;
        			}
        			else break;
        		case 5:
        			if(ti<178) {
        				TileElement t = new Tile();
        	        	this.AddTileElement(t);
        	        	ti--;
        	        	j++;
        	        	break;
        			}
        			else break;
        		case 7:
        			if(b<4) {
        				TileElement t = new Button();
        	        	this.AddTileElement(t);
        	        	b--;
        	        	j++;
        	        	break;
        			}
        			else break;
        		}	
        	}
        	for(int g=0; g<2; g++) {
        		TileElement t = new Wall();
            	this.AddTileElement(t);	
        	}
        }
        for(int i=0; i<14; i++) {
        	TileElement t = new Wall();
        	this.AddTileElement(t);
        }
        
	}
	

	
	public ArrayList<TileElement> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<TileElement> tiles) {
		this.tiles = tiles;
	}
}

