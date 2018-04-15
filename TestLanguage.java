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
				
			case "PlaceCrate":
				/*
			 	 * 2 parameter:
			 	 * 		height	- int
			 	 * 		width	- int
			 	 */
			case "PlaceOil":
				/*
			 	 * 1 parameter:
			 	 * 		worker	- Worker
			 	 */
			case "PlaceHoney":
				/*
			 	 * 1 parameter:
			 	 * 		worker	- Worker
			 	 */
			case "ListCrates":
				/*
				 * 0 parameter:
				 */
				
				int crateCount = 0;
				for(Crate c : game.crates) {
					crateCount++;
					Results.add(crateCount+". Coordinates: "+/*valahogy a koordinátát visszanyerni*/ "X,Y" + 
					" Friction: " + "ezt is egy getterrel ki kell szerezni" + 
					" OnTarget: "+"ezt is valahogy ellenőrizni");
				}
				
			case "ListPlacedCrates":
				/*
				 * 0 parameter:
				 */
			case "ListFreeCrates":
				/*
				 * 0 parameter:
				 */
			case "SetStrenght":
				/*
				 * 2 parameter:
				 * 		targetWorker	- worker
				 * 		value			- int
				 */
			case "Move":
				/*
				 * 2 parameter:
				 * 		targetWorker	- Worker
				 * 		direction		- Direction
				 */
			case "ListWorkers":
				/*
				 * 0 parameter:
				 */
			case "ListTraps":
				/*
				 * 0 parameter:
				 */
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
	

