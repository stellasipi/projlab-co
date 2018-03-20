package shokoban;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	ArrayList<TileElement> tiles=new ArrayList<>();
	
	public void AddTileElement(TileElement t)
	{
		//Dialógus kiíratása
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].AddTileElement(t):");

        //hozzáad egy tileelement-et a tileshoz
        tiles.add(t);
	}
	public void PlaceWorker(Worker w) 
	{
		//Dialógus kiíratása
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].PlaceWorker(w):");

        //elhelyezi a workereket a pályán

	}
	public void PlaceCrate(Crate c) 
	{
		//Dialógus kiíratása
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].PlaceCrate(c):");

        //elhelyezi a ládákat a pályán
        
       
	}
	public void CreateMap() 
	{
		//Dialógus kiíratása
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Map].CreateMap():");

        //randomizáláshoz
        Random rand = new Random();
        
        //miből mennyinek kell lenni
        int co=19;
        int h=4;
        int ta=10;
        int tr=3;
        int b = 3;
        int ti=178;
        
        //pálya széle, hossza
        int width = 20;
        int height = 15;
        
        //első sor
        for(int i=0; i<width; i++) {
        	TileElement t = new Wall();
        	this.AddTileElement(t);
        }
        //2-14 sor
        for(int j=1;j<height-1;j++) {
        	//első fal
        	this.AddTileElement(new Wall());
        	//random tile-ok
        	int i=0;
        	while(i!=18) {
        		int r=rand.nextInt(8);
        		switch (r) {
        		case 1:
        			if(co<20) {
        				TileElement t = new Coloumn();
        	        	this.AddTileElement(t);
        	        	co--;
        	        	i++;
        	        	break;
        			}
        			else break;
        		case 2:
        			if(h<5) {
        				TileElement t = new Hole();
        	        	this.AddTileElement(t);
        	        	h--;
        	        	i++;
        	        	break;
        			}
        			else break;
        		case 3:
        			if(ta<11) {
        				TileElement t = new Target();
        	        	this.AddTileElement(t);
        	        	ta--;
        	        	i++;
        	        	break;
        			}
        			else break;
        		case 4:
        			if(tr<4) {
        				TileElement t = new Trap();
        	        	this.AddTileElement(t);
        	        	tr--;
        	        	i++;
        	        	break;
        			}
        			else break;
        		case 5:
        			if(ti<178) {
        				TileElement t = new Tile();
        	        	this.AddTileElement(t);
        	        	ti--;
        	        	i++;
        	        	break;
        			}
        			else break;
        		case 7:
        			if(b<4) {
        				TileElement t = new Button();
        	        	this.AddTileElement(t);
        	        	b--;
        	        	i++;
        	        	break;
        			}
        			else break;
        		}	
        	}
        	//utolsó fal
        	this.AddTileElement(new Wall());
        }
        
        //utolsó sor
        for(int i=0; i<width; i++) {
        	TileElement t = new Wall();
        	this.AddTileElement(t);
        }        
        //set direction
        this.setAllDirections(width, height);
	}

	public ArrayList<TileElement> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<TileElement> tiles) {
		this.tiles = tiles;
	}
	
	private void setAllDirections(int width, int height) {
		// fentről lefele és balról jobbra halad
		for(int i=0; i<height;i++) {
        	for(int j=0;j<width;j++) {
        		
        		//első sor
        		if(i==0) {
        			if(j==0) {
        				tiles.get(i*20+j).setNeighbour(null, Direction.UP);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j+1), Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*20+j), Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(null, Direction.LEFT);
        			}else if(j==width-1) {
        				tiles.get(i*20+j).setNeighbour(null, Direction.UP);
            			tiles.get(i*20+j).setNeighbour(null, Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*20+j), Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j-1), Direction.LEFT);
        			}else {
        				tiles.get(i*20+j).setNeighbour(null, Direction.UP);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j+1), Direction.RIGHT);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*20+j), Direction.DOWN);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j-1), Direction.LEFT);
        			}
        			
        		//utolsó sor
        		}else if(i==height-1) {
        			if(j==0) {
        				tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*20+j), Direction.UP);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j+1), Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(null, Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(null, Direction.LEFT);
        			}else if(j==14) {
        				tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*20+j), Direction.UP);
            			tiles.get(i*20+j).setNeighbour(null, Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(null, Direction.DOWN); //indexOutOfBoundsException
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j-1), Direction.LEFT);
        			}else {
        				tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*20+j), Direction.UP);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j+1), Direction.RIGHT); //indexOutOfBoundsException
        				tiles.get(i*20+j).setNeighbour(null, Direction.DOWN);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j-1), Direction.LEFT);
        			}
        			
        		//többi sor
        		}else if(j==0) {
        			tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*20+j), Direction.UP);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j+1), Direction.RIGHT);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*20+j), Direction.DOWN);
        			tiles.get(i*20+j).setNeighbour(null, Direction.LEFT);
        		}else if(j==width-1) {
        			tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*20+j), Direction.UP);
        			tiles.get(i*20+j).setNeighbour(null, Direction.RIGHT);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*20+j), Direction.DOWN);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j-1), Direction.LEFT);
        		}else {
        			tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*20+j), Direction.UP);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j+1), Direction.RIGHT);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*20+j), Direction.DOWN);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*20+j-1), Direction.LEFT);
        		}
        	}
        } //setDirection-ök vége
	}
}

