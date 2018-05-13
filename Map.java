package shokoban;


import java.util.ArrayList;
import java.util.Random;

public class Map {
	/*
	 * A pályát alkotó elemek 2D tömbje
	 */
	TileElement[][] Tiles = new TileElement[15][20];
	
	/*
	 * A default konstruktor, generál egy új pályát
	 */
	public Map() {
		CreateMap();
	}
	
	/*
	 * Pálya betöltése és felépítése az input String lista  alapján
	 */
	public void LoadMap(ArrayList<String> input) {
		//pálya feltöltése
		
		//első 15 sor (avagy a teljes pálya)
		for(int i=0; i<15; i++) {
			// " "(space)-ek alapján feldarabolja a pályát, ezzel megkapjuk az aktuális sort egy String[]-ben
			String[] Tiles = input.get(i).split(" ");
			
			//a feldolgozandó sor összes elemét berakjuk a Tiles tömb-be
			for(int j=0; j<20; j++) {
				// i magasságra, j szélességre berakunk egy épp beolvasott típusú mezőt
				AddTile(i,j,Tiles[j]);
			}
		}
		
		// a szomszédokat be kell állítani a már kész kinézetű map-on
		for(TileElement[] line : Tiles) {
			for(TileElement e : line) {
				SetNeighbours(e);
			}
		}
		
		// a gombokat a hozzájuk tartozó csapdákhoz kell kötni, összesen 3 db gomb van
		for(int i=0; i<3; i++) {
			//ebben a tömbben a két koordináta lesz
			String[] buttonTrap = input.get(i+15).split(" ");
			
			// String[]-be kiszedve a két koordináta
			String[] buttonCoords = buttonTrap[0].split(",");
			String[] trapCoords = buttonTrap[1].split(",");
			
			//integerré alakítása a két koordinátának, H=magasság, W=szélesség
			int buttonH = Integer.parseInt(buttonCoords[0]);
			int buttonW = Integer.parseInt(buttonCoords[1]);
			int trapH = Integer.parseInt(trapCoords[0]);
			int trapW = Integer.parseInt(trapCoords[1]);
			
			//a gomb csapdáját beállítjuk
			((Button)this.getTile(buttonH, buttonW)).setTrap((Trap)this.getTile(trapH, trapW));
		}
	}
	
	/*
	 * Egy elem szomszédainak beállítása
	 */
	private void SetNeighbours(TileElement t) {
	    for(int i=0; i<15 ; i++) {
	      for(int j=0; j<20; j++) {
	        if(t==Tiles[i][j]) {
	          if((i-1)!=-1 ) {
	            t.setNeighbour(Tiles[i-1][j], Direction.UP );
	          }
	          if((i+1)!=15 ) {
	            t.setNeighbour(Tiles[i+1][j], Direction.DOWN);
	          }
	          if((j-1)!=-1 ) {
	            t.setNeighbour(Tiles[i][j-1], Direction.LEFT);
	          }
	          if((j+1)!=20 ) {
	            t.setNeighbour(Tiles[i][j+1], Direction.RIGHT);
	          }
	        }
	      }
	    }
	  }
	
	/*
	 * a paraméterben kapott koordinátákra berak egy mezőt, 
	 * a berakott mezőt a type paraméter dönti el
	 */
	private void AddTile(int height, int width, String type) {
		/*
		 * type lehetséges értékei:
		 * 	t 	- Tile
		 *  c 	- Coloumn
		 *  ta	- Target
		 *  tr	- Trap
		 *  b	- Button
		 *  h	- Hole
		 */
		
		// típus és koordináták beállítása
		switch(type){
		case "t":
			Tiles[height][width] = new Tile();
			Tiles[height][width].setCoords(height, width);
			break;
		case "c":
			Tiles[height][width] = new Coloumn();
			Tiles[height][width].setCoords(height, width);
			break;
		case "ta":
			Tiles[height][width] = new Target();
			Tiles[height][width].setCoords(height, width);
			break;
		case "tr":
			Tiles[height][width] = new Trap();
			Tiles[height][width].setCoords(height, width);
			break;
		case "b":
			Tiles[height][width] = new Button();
			Tiles[height][width].setCoords(height, width);
			break;
		case "h":
			Tiles[height][width] = new Hole();
			Tiles[height][width].setCoords(height, width);
			break;
		}
	}
	
	/*
	 * Véletlenszerűen felépít egy pályát
	 */
	public void CreateMap() {
		int height = 15;
		int width = 20;
		
		// oszlop és tile feltöltés
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(i==0 || i==14) {
					Tiles[i][j] = new Coloumn();
					Tiles[i][j].setCoords(i, j);
				}else if(j==0 || j==19) {
					Tiles[i][j] = new Coloumn();
					Tiles[i][j].setCoords(i, j);
				}else {
					Tiles[i][j] = new Tile();
					Tiles[i][j].setCoords(i, j);
				}
			}
		}
		
		// extra elemek pozíciójának meghatározása
		ArrayList<int[]> pos = new ArrayList<int[]>();
		for(int i= 0; i<40; i++) {
			int[] cord = getRando(pos);
			pos.add(cord);
		}
		
		// extra elemek elhelyezése
		for(int i=0; i<40; i++) {
			int[] coords = pos.get(i);
			int h = coords[0];
			int w = coords[1];
			
			if(i<19) {
				Tiles[h][w] = new Coloumn();
				Tiles[h][w].setCoords(h, w);
			}else if(i<23) {
				Tiles[h][w] = new Hole();
				Tiles[h][w].setCoords(h, w);
			}else if(i<34) {
				Tiles[h][w] = new Target();
				Tiles[h][w].setCoords(h, w);
			}else if(i<37) {
				Tiles[h][w] = new Trap();
				Tiles[h][w].setCoords(h, w);
			}else if(i<40) {
				Tiles[h][w] = new Button();
				Tiles[h][w].setCoords(h, w);
			}
		}
		
		// trap és button összehangolás
		for(int i=0; i<3; i++) {
			int[] trap = pos.get(i+34);
			int[] button = pos.get(i+37);
			int ht = trap[0];
			int hb = button[0];
			int wt = trap[1];
			int wb = button[1];
			
			((Button)this.getTile(hb, wb)).setTrap((Trap)this.getTile(ht, wt));
		}
		
		// szomszédok beállítása
		for(TileElement[] line : Tiles) {
			for(TileElement e : line) {
				SetNeighbours(e);
			}
		}
	}
	
	/*
	 * Koordináta alapján visszaad egy mezőt
	 */
	public TileElement getTile(int height, int width) {
		return Tiles[height][width];
	}

	/*
	 * Munkás véletlenszerű Tile-ra helyezése
	 */
	public void PlaceWorker(Worker w) 
	{
        //elhelyezi a workereket a pályán
		int[] coords = getRandomCoords();
		TileElement te = getTile(coords[0], coords[1]);
		w.setTile(te);
		te.setObject(w);
	}
	
	/*
	 * Láda véletlenszerű Tile-ra helyezése
	 */
	public void PlaceCrate(Crate c) 
	{
        //elhelyezi a ládákat a pályán 
		int[] coords = getRandomCoords();
		TileElement te = getTile(coords[0], coords[1]);
		c.setTile(te);
		te.setObject(c);
	}
	
	/*
	 * Véletlenszerű koordináta generálása
	 */
	private int[] getRandomCoords() {
		Random rando = new Random();
		int[] cord = {rando.nextInt(11)+2, rando.nextInt(16)+2};
		TileElement te = getTile(cord[0],cord[1]);
		if(te.getClass().getName().equals(Tile.class.getName())) {
			if(te.getObject()==null) {
				return cord;
			}
		}
		return getRandomCoords();
	}

	/*
	 * Plyan véletlenszerű koordinát generálása,
	 * ami nem szerepel a paraméter listán
	 */
	private int[] getRando(ArrayList<int[]> list) {
		Random rando = new Random();
		int[] cord = {rando.nextInt(13)+1, rando.nextInt(18)+1};
		for(int[] asd : list) {
			if(cord==asd) {
				cord = getRando(list);
			}
		}
		return cord;
	}

}

