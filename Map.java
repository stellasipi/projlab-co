package shokoban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Map {
	ArrayList<TileElement> tiles=new ArrayList<>();
	private int width;
	private int height;
	TileElement[][] Tiles;
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	//magasság szélesség alapján visszaad TileElement-et
	public TileElement getTile(int height, int width) {
		return Tiles[height][width];
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
	
	private void AddTile(String type, int height, int width, String id) {
		switch(type) {
		case "Tile":
			Tile t = new Tile();
			t.setCoords(width, height); //koordináták beállítása
			t.setId(id); //név beállítása
			Tiles[height][width] = t;
			break;
		case "Trap":
			Trap trap = new Trap();
			trap.setCoords(width, height); //koordináták beállítása
			trap.setId(id); //név beállítása
			Tiles[height][width] = trap;
			break;
		case "Coloumn":
			Coloumn c = new Coloumn();
			c.setCoords(width, height); //koordináták beállítása
			c.setId(id); //név beállítása
			Tiles[height][width] = c;
			break;
		case "Target":
			Target ta = new Target();
			ta.setCoords(width, height); //koordináták beállítása
			ta.setId(id); //név beállítása
			Tiles[height][width] = ta;
			break;
		case "Button":
			Button b = new Button();
			b.setCoords(width, height); //koordináták beállítása
			b.setId(id); //név beállítása
			Tiles[height][width] = b;
			break;
		case "Hole":
			Hole h = new Hole();
			h.setCoords(width, height); //koordináták beállítása
			h.setId(id); //név beállítása
			Tiles[height][width] = h;
			break;
		}
	}
	
	private void SetNeighbours(TileElement t) {
		for(int i=0; i<height ; i++) {
			for(int j=0; j<width; j++) {
				if(t==Tiles[i][j]) {
					if(Tiles[i-1][j] != null) {
						t.setNeighbour(Tiles[i-1][j], Direction.UP );
					}
					if(Tiles[i+1][j] != null) {
						t.setNeighbour(Tiles[i+1][j], Direction.DOWN);
					}
					if(Tiles[i][j-1] != null) {
						t.setNeighbour(Tiles[i][j-1], Direction.LEFT);
					}
					if(Tiles[i+1][j] != null) {
						t.setNeighbour(Tiles[i-1][j], Direction.RIGHT);
					}
				}
			}
		}
	}
	
	public void LoadMap(String filename) throws FileNotFoundException, IOException {
		System.out.println("Loadmap-ben");
		File file = new File(System.getProperty("user.dir") + File.separatorChar + filename + ".txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		System.out.println("input");
		ArrayList<String> input = new ArrayList<String>();
		String line;
		while((line=br.readLine())!=null) {
			input.add(line);
		}
		
		//széle és hossza
		System.out.println("széle és hossza");
		String[] size = input.get(0).split(" ");
		height = Integer.parseInt(size[1]);
		width = Integer.parseInt(size[2]);
		
		Tiles = new TileElement[height][width];
		
		//TileElementek feltöltése	
		System.out.println("tileelementek föltöltése");
		for(int j=0;j<height;j++) {
			for(int i=0; i<width; i++) {
				String[] mapLine = input.get(i+1).split(" ");
				AddTile(mapLine[1], j+1, i+1, mapLine[2]);
			}
		}
		
		//szomszédok beállítása
		System.out.println("szomszédok");
		for(int i=0; i<height ; i++) {
			for(int j=0; j<width; j++) {
				SetNeighbours(Tiles[i][j]);
			}
		}
		
		//csapdák beállítása
		/*
		 * valahogy a gombok és csapdák összekötése, 
		 * szerintem egyszerűen gomb coord és csapda coord alapján mehetne,
		 * pl: 	1,1 1,2
		 * 		1,3 2,1
		 * szóval soronként koordináták
		 * és ennek egy segédfv ami mondjuk 4 int segítségével összeköti a kettőt (getTile(koordináta))
		 */
		System.out.println("csapdák");
		for(int i=0;i<input.size();i++) {
			String[] cmd=input.get(i).split(" ");
			if(cmd[0].equals("SetButton")) {
				for(int j=0; j<height ; j++) {
					for(int k=0; k<width; k++) {
						if(Tiles[j][k].getId()==cmd[1]) {
							for(int l=0; l<height ; l++) {
								for(int m=0; m<width; m++) {
									if(Tiles[l][m].getId()==cmd[2]) {
										if((Tiles[l][m].getClass().getSimpleName().equals("Button"))&&(Tiles[j][k].getClass().getSimpleName().equals("Trap"))){
											((Button)Tiles[l][m]).setTrap((Trap)Tiles[j][k]);
										}
									}
								}
							}
						}
					}
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

