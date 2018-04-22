package shokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Map {
	ArrayList<TileElement> tiles=new ArrayList<>();
	
	public void AddTileElement(TileElement t)
	{
        //hozzáad egy tileelement-et a tileshoz
        tiles.add(t);
	}
	public void PlaceWorker(Worker w) 
	{
        //elhelyezi a workereket a pályán
	}
	public void PlaceCrate(Crate c) 
	{
        //elhelyezi a ládákat a pályán 
	}
	public void LoadMap(String filename) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] cmd=line.split(" ");
				switch(cmd[0]) {
					case "create":
						switch(cmd[1]){
						case "Tile":
							Tile tile = new Tile(); //létrehozzuk
							tiles.add(tile); //hozzáadjuk a pályához
							break;
						case "Target":
							Target target=new Target();
							tiles.add(target);
							break;
						case "Trap":
							Trap trap = new Trap();
							tiles.add(trap);
							break;
						case "Button":
							Button b = new Button();
							
							break;
						case "Coloumn":
							
							break;
						case "Hole":
							
							break;
						default:
							
							break;
					}
						break;
					case "setNeighbour": 
						break;
					case "setButton": 
						break;
					default:
						System.out.println("Nem tudtunk beolvasni semmit.");
						break;
				}
		    }
		}
	}
	
	public void CreateMap() 
	{
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
        	TileElement t = new Coloumn();
        	this.AddTileElement(t);
        }
        //2-14 sor
        for(int j=1;j<height-1;j++) {
        	//első fal
        	this.AddTileElement(new Coloumn());
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
        	this.AddTileElement(new Coloumn());
        }
        
        //utolsó sor
        for(int i=0; i<width; i++) {
        	TileElement t = new Coloumn();
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
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j+1), Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*width+j), Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(null, Direction.LEFT);
        			}else if(j==width-1) {
        				tiles.get(i*20+j).setNeighbour(null, Direction.UP);
            			tiles.get(i*20+j).setNeighbour(null, Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*width+j), Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j-1), Direction.LEFT);
        			}else {
        				tiles.get(i*20+j).setNeighbour(null, Direction.UP);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j+1), Direction.RIGHT);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*width+j), Direction.DOWN);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j-1), Direction.LEFT);
        			}
        			
        		//utolsó sor
        		}else if(i==height-1) {
        			if(j==0) {
        				tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*width+j), Direction.UP);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j+1), Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(null, Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(null, Direction.LEFT);
        			}else if(j==width-1) {
        				tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*width+j), Direction.UP);
            			tiles.get(i*20+j).setNeighbour(null, Direction.RIGHT);
            			tiles.get(i*20+j).setNeighbour(null, Direction.DOWN);
            			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j-1), Direction.LEFT);
        			}else {
        				tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*width+j), Direction.UP);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j+1), Direction.RIGHT);
        				tiles.get(i*20+j).setNeighbour(null, Direction.DOWN);
        				tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j-1), Direction.LEFT);
        			}
        			
        		//többi sor
        		}else if(j==0) {
        			tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*width+j), Direction.UP);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j+1), Direction.RIGHT);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*width+j), Direction.DOWN);
        			tiles.get(i*20+j).setNeighbour(null, Direction.LEFT);
        		}else if(j==width-1) {
        			tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*width+j), Direction.UP);
        			tiles.get(i*20+j).setNeighbour(null, Direction.RIGHT);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*width+j), Direction.DOWN);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j-1), Direction.LEFT);
        		}else {
        			tiles.get(i*20+j).setNeighbour(tiles.get((i-1)*width+j), Direction.UP);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j+1), Direction.RIGHT);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i+1)*width+j), Direction.DOWN);
        			tiles.get(i*20+j).setNeighbour(tiles.get((i)*width+j-1), Direction.LEFT);
        		}
        	}
        } //setDirection-ök vége
	}
}

