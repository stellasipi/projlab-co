package shokoban;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestLanguage {
	
	Game game;
	ArrayList<String> Results = new ArrayList<String>();
	
	TestLanguage(){		
	}
	
	public void RecieveCommands() throws IOException {
		ArrayList<String> Commands = new ArrayList<String>();
		Results = new ArrayList<String>();
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		ArrayList<String> commands = new ArrayList<String>();
		String line;
		while ((line = br.readLine())!=null) {
			commands.add(line);
		}
		
		for(int i=0; i<commands.size(); i++) {
			ExecuteCommand(commands.get(i));
		}
	}
	
	private void Init() {
		game= new Game();
	}

	private void ExecuteCommand(String line) {
		String[] command = line.split(",");
		Init();
		switch (command[0]){
			case "LoadMap":
				/*
			 	 * 1 parameter:
			 	 * 		mapName	- string
			 	 */
				//game.getMap().loadMap(command[1]);
			case "PlaceWorker":
				/*
			 	 * 3 parameter:
			 	 * 		name	- String
			 	 * 		height	- int
			 	 * 		width	- int
			 	 */
				for(Worker w : game.workers) {
					if(w.getName() == command[1]) {
						//w.setTile(game.map.getTile(Integer.parseInt(command[2])), Integer.parseInt(command[3]));
						break;
					}
				}
				
				/*if(game.map.getTile(Integer.parseInt(command[2])), Integer.parseInt(command[3]).getObject().getName() == command[1]) {
					Results.add("Worker placed  ID: " + command[1] + " Coordinates: " + command[2] + "," + command[3]);
				}else {
					Results.add("Worker not placed  ID: " + command[1]);
				}*/
					
			case "PlaceCrate":
				/*
			 	 * 2 parameter:
			 	 * 		height	- int
			 	 * 		width	- int
			 	 */
				for(Crate c : game.crates) {
					if(c.getName() == command[1]) {
						//c.setTile(game.map.getTile(Integer.parseInt(command[2])), Integer.parseInt(command[3]));
						break;
					}
				}
				
				/*if(game.map.getTile(Integer.parseInt(command[2])), Integer.parseInt(command[3]).getObject().getName() == command[1]) {
					Results.add("Crate placed  ID: " + command[1] + " Coordinates: " + command[2] + "," + command[3]);
				}else {
					Results.add("Crate not placed  ID: " + command[1]);
				}*/
			case "PlaceOil":
				/*
			 	 * 1 parameter:
			 	 * 		worker	- Worker
			 	 */
				for(Worker w : game.workers) {
					if(w.getName() == command[1]) {
						//w.PlaceOil();
						Integer[] coords = w.getTile().getCoords();
						Results.add("Oil placed  Coordinates: " + coords[0] + "," + coords[1] + " Friction: " /*+ w.getTile().getFriction()*/);
						break;
					}
				}
			case "PlaceHoney":
				/*
			 	 * 1 parameter:
			 	 * 		worker	- Worker
			 	 */
				for(Worker w : game.workers) {
					if(w.getName() == command[1]) {
						//w.PlaceHoney();
						Integer[] coords = w.getTile().getCoords();
						Results.add("Honey placed  Coordinates: " + coords[0] + "," + coords[1] + " Friction: " /*+ w.getTile().getFriction()*/);
						break;
					}
				}
			case "ListCrates":
				/*
				 * 0 parameter:
				 */				
				int crateCount = 0;							//nagyon erős gyanú hogy nem fog menni xD a friction nem crate specifikus, lehet hogy olyan mezőn van ahol nincs mu nem?
				for(Crate c : game.crates) {
					crateCount++;
					Integer[] coords = c.getTile().getCoords();
					Results.add(crateCount+". Coordinates: "+ coords[0] + "," + coords[1] + 
					" Friction: " + /*c.getTile().SumGreaseMu() +*/ 
					" OnTarget: " + "ezt is valahogy ellenőrizni");
				}
				
			case "ListPlacedCrates":
				/*
				 * 0 parameter:
				 */
				// majd ha írok vagy ír valaki egy ellenőrző fv-t OnTarget ellenőrzésére
			case "ListFreeCrates":
				/*
				 * 0 parameter:
				 */
				// dettó
			case "SetStrenght":
				/*
				 * 2 parameter:
				 * 		targetWorker	- worker
				 * 		value			- int
				 */
				for(Worker w : game.workers) {
					if(w.getName() == command[1]) {
						//w.setStrenght(Integer.parseInt(command[1]));
						Results.add("Success  WorkerID:" + command[1] + " Strength: " + command[2]);
						break;
					}
				}
			case "Move":
				/*
				 * 2 parameter:
				 * 		targetWorker	- Worker
				 * 		direction		- Direction
				 */
				for(Worker w : game.workers) {
					if(w.getName() == command[1]) {
						Direction d = Direction.valueOf(command[2]);
						Integer[] beforeCoord = w.getTile().getCoords();
						game.Move(w, d);
						//leelenőrizni hogy mozgott-e, az alapján válasz
						if(beforeCoord != w.getTile().getCoords()) {
							Results.add("Moved " + command[1] + ", " + command[2]);
						}else {
							Results.add("Failed" + command[1] + "could not step on the given coordinates");
						}
						break;
					}
				}
			case "ListWorkers":
				/*
				 * 0 parameter:
				 */
			case "ListTraps":
				/*
				 * 0 parameter:
				 */
				// ez csak úgy ittvan, nem boztos hogy kell, ha kell akkor megvalósítjuk, ha nem akkor delete minden ami ez alatt van
			case "ListTiles":
				/*
				 * 0 parameter:
				 */
			case "ListHoles":
				/*
				 * 0 parameters:
				 */
			case "ListButtons":
				/*
				 * 0 parameter:
				 */
			case "ListTargets":
				/*
				 * 0 parameter:
				 */
			case "ListWalls":
				/*
				 * 0 parameter:
				 */
				int wallCount = 0;
				for(TileElement te : game.getMap().tiles) {
					if (te.getClass()==Wall.class) {
						wallCount++;
						Results.add(wallCount+". Coordinates: "+ /*valahogy a koordinátákat megszerezni*/ "");
					}
				}				
			case "ListColumns":
				/*
				 * 0 parameter:
				 */
			default:
				/*
				 * valami generikus hibauzenet, 
				 * hogy tudja a felhasznalo, 
				 * hogy elbaszta a stringet
				 */
		}
		/*
		 * kiprintelni meg fajlba beirni a kimenetet,
		 * de ha elbasztuk akkor lehetne ujrakezdeni
		 * mielott kiirja (marmint a bemenetet basztuk el)
		 */
	}		
}
	

