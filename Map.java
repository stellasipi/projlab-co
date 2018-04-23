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
	ArrayList<ArrayList<TileElement>> map=new ArrayList<>();
	
	public TileElement getTile(int height, int width) {
		return map.get(height).get(width);
	}
	
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
			int width, w, height, h, counter;
			String line;
			while ((line = br.readLine()) != null) {
				String[] cmd=line.split(" ");
				width=Integer.parseInt(cmd[2]); //szélesség=hanyadik elem
				w=1; //a koordinátákat ez alapján fogjuk beállítani
				height=Integer.parseInt(cmd[1]);//magasság=hanyadik sor
				h=1;//a koordinátákat ez alapján fogjuk beállítani
				counter=1;
				switch(cmd[0]) {
					case "mapsize":
						for(int i=0;i<height;i++) //létrehozzuk a pályát aka mátrixot
							map.add(new ArrayList<TileElement>(width));						
						break;
					case "create":
						switch(cmd[1]){
						case "Tile":
							Tile tile = new Tile(); //létrehozzuk
							
							//hozzáadjuk a pályához, koordináták csekkolgatása
							if(w==width){
								tile.setCoords(w, h);
								map.get(h-1).add(tile);
								h++;
								w=1;
							}else{
								tile.setCoords(w, h);
								map.get(h-1).add(tile);
								w++;
							}
							break;
						case "Target":
							Target target=new Target();
							//hozzáadjuk a pályához, koordináták csekkolgatása
							if(w==width){
								target.setCoords(w, h);
								map.get(h-1).add(target);
								h++;
								w=1;
							}else{
								target.setCoords(w, h);
								map.get(h-1).add(target);
								w++;
							}
							break;
						case "Trap":
							Trap trap = new Trap();
							//hozzáadjuk a pályához, koordináták csekkolgatása
							if(w==width){
								trap.setCoords(w, h);
								map.get(h-1).add(trap);
								h++;
								w=1;
							}else{
								trap.setCoords(w, h);
								map.get(h-1).add(trap);
								w++;
							}
							break;
						case "Button":
							Button b = new Button();
							//hozzáadjuk a pályához, koordináták csekkolgatása
							if(w==width){
								b.setCoords(w, h);
								map.get(h-1).add(b);
								h++;
								w=1;
							}else{
								b.setCoords(w, h);
								map.get(h-1).add(b);
								w++;
							}
							break;
						case "Coloumn":
							Coloumn c=new Coloumn();
							//hozzáadjuk a pályához, koordináták csekkolgatása
							if(w==width){
								c.setCoords(w, h);
								map.get(h-1).add(c);
								h++;
								w=1;
							}else{
								c.setCoords(w, h);
								map.get(h-1).add(c);
								w++;
							}
							break;
						case "Hole":
							Hole hole=new Hole();
							//hozzáadjuk a pályához, koordináták csekkolgatása
							if(w==width){
								hole.setCoords(w, h);
								map.get(h-1).add(hole);
								h++;
								w=1;
							}else{
								hole.setCoords(w, h);
								map.get(h-1).add(hole);
								w++;
							}
							break;
						default:
							System.out.println("Nem tudtunk beolvasni semmit.");
							break;
					}
						break;
					case "setNeighbour":
						if(map.get(height).get(width).equals(null)) {
							
							map.get(0).get(0).setNeighbour(map.get(0).get(1), Direction.RIGHT); // elsők és utolsók beállítása
							map.get(0).get(0).setNeighbour(map.get(1).get(0), Direction.DOWN);
							map.get(0).get(width-1).setNeighbour(map.get(0).get(width-2), Direction.LEFT);
							map.get(0).get(width-1).setNeighbour(map.get(1).get(width-1), Direction.DOWN);
							if(height>1) {
								map.get(1).get(0).setNeighbour(map.get(1).get(1), Direction.RIGHT);
								map.get(1).get(0).setNeighbour(map.get(0).get(0), Direction.UP);
								map.get(1).get(width-1).setNeighbour(map.get(1).get(width-2), Direction.LEFT);
								map.get(1).get(width-1).setNeighbour(map.get(0).get(width-1), Direction.UP);
							}
							
							//belső részek beállítása
							for(int i=0;i<height-1;i++) {
								for(int j=1;i<width-2;j++) {
									map.get(i).get(j).setNeighbour(map.get(i).get(j+1), Direction.RIGHT);
									map.get(i).get(j).setNeighbour(map.get(i).get(j-1), Direction.LEFT);
									if(i==0)
										map.get(i).get(j).setNeighbour(map.get(i+1).get(j), Direction.DOWN);
									if(i>0)
										map.get(i).get(j).setNeighbour(map.get(i-1).get(j), Direction.UP);
								}
							}
						}
						break;
					case "setButton":
						int bw=0,bh=0, trw=0,trh=0, count=1;
						Button b=new Button();
						Trap tr=new Trap();
						
						for(int i=0;i<height-1;i++) {
							for(int j=0;i<width-1;j++) {
								if(count==counter) {
									if(map.get(i).get(j).getClass().getSimpleName().equals("Button")) {
										bw=j; bh=i;
										b=(Button)map.get(bh).get(bw);
									}
									if(map.get(i).get(j).getClass().getSimpleName().equals("Trap")) {
										trw=j; trh=i;
										tr=(Trap)map.get(trh).get(trw);										
									}	
								}else{
									count++;
								}
							}
						}
						
						b.setTrap(tr);
						map.get(bh).set(bw,b);
						map.get(trh).set(trw,tr);
						counter++;
						
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
	
	public ArrayList<ArrayList<TileElement>> getMap() {
		return map;
	}
	public void setMap(ArrayList<ArrayList<TileElement>> map) {
		this.map = map;
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

