package shokoban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestLanguage {
	
	Game game;
	ArrayList<String> Results = new ArrayList<String>();
	
	TestLanguage(){	}
	
	public void Run() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		Boolean asd = true;
		
		System.out.println("Üdv a test-testkörnyezetben \n"
				+ "1 - Manuális bemenet \n"
				+ "2 - Előre elkészített tesztek \n"
				+ "3 - Kilépés");
		String input;
		while (asd) {
			// reseteljük a kimeneti tömböt és a játékot, 
			// hogy minden tesztet ugyanabból az állapotból tudjunk indítani
			Init();
			try {
				input = br.readLine();				
				switch(input) {
				case "1":
					try {
						Init();
						ManualInputHandler();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "2":
					String name;
					try {
						Init();
						name = br.readLine();
						TextIputHandler(name);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "3":
					asd = false;
					break;
				default:
					System.out.println("Rossz bemenet! \n"
							+ "1 - Manuális bemenet \n"
							+ "2 - Előre elkészített tesztek \n"
							+ "3 - Kilépés");
					break;
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}						
		}
	}
	
	public void ManualInputHandler() throws IOException {		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while (!(line = br.readLine()).equals("")) {
			ExecuteCommand(line);
		}
	}
	
	public void TextIputHandler(String name) {
		//in progress
		ArrayList<String> commands = new ArrayList<String>();
	}
	
	private void Init() {
		game= new Game();
		Results = new ArrayList<String>();
	}

	private void ExecuteCommand(String line) throws FileNotFoundException, IOException {
		String[] command = line.split(",");
		switch (command[0]){
			case "LoadMap":
				game.getMap().LoadMap(command[1]);
				break;
			case "PlaceWorker":
				/*
			 	 * 3 parameter:
			 	 * 		name	- String
			 	 * 		height	- int
			 	 * 		width	- int
			 	 */
				String PlaceWorkerName = command[1];
				int PlaceWorkerHeight = Integer.parseInt(command[2]);
				int PlaceWorkerWidth = Integer.parseInt(command[3]);
				
				PlaceWorker(PlaceWorkerName, PlaceWorkerHeight, PlaceWorkerWidth);
				break;
					
			case "PlaceCrate":
				/*
			 	 * 3 parameter:
			 	 * 		name	- String
			 	 * 		height	- int
			 	 * 		width	- int
			 	 */
				String PlaceCrateName = command[1];
				int PlaceCrateHeight = Integer.parseInt(command[2]);
				int PlaceCrateWidth = Integer.parseInt(command[3]);
				
				PlaceCrate(PlaceCrateName, PlaceCrateHeight, PlaceCrateWidth);
				break;
				
			case "PlaceOil":
				/*
			 	 * 1 parameter:
			 	 * 		worker	- Worker
			 	 */
				String PlaceOilWorker = command[1];
				
				PlaceOil(PlaceOilWorker);
				break;
				
			case "PlaceHoney":
				/*
			 	 * 1 parameter:
			 	 * 		worker	- Worker
			 	 */
				String PlaceHoneyWorker = command[1];
				
				PlaceHoney(PlaceHoneyWorker);
				break;
				
			case "ListCrates":
				/*
				 * 0 parameter:
				 */				
				ListCrates();
				break;
				
			case "ListPlacedCrates":
				/*
				 * 0 parameter:
				 */
				ListPlacedCrates();
				Results.add("TESZT KÖCSÖG");
				break;
				
			case "ListFreeCrates":
				/*
				 * 0 parameter:
				 */
				ListFreeCrates();
				break;
				
			case "SetStrenght":
				/*
				 * 2 parameter:
				 * 		targetWorker	- worker
				 * 		value			- int
				 */
				String SetStrenghtWorker = command[1];
				int SetStrenghtValue = Integer.parseInt(command[2]);
				
				SetStrenght(SetStrenghtWorker, SetStrenghtValue);
				break;
				
			case "Move":
				/*
				 * 2 parameter:
				 * 		targetWorker	- Worker
				 * 		direction		- Direction
				 */
				String MoveWorker = command[1];
				Direction MoveDirection = Direction.valueOf(command[2]);
				
				Move(MoveWorker, MoveDirection);
				break;
				
			case "ListWorkers":
				/*
				 * 0 parameter:
				 */
				ListWorkers();
				break;
				
			case "Exit":
				for(String lines : Results) {
					System.out.println(lines);
				}
				return;
			default:
				System.out.println("Rossz parancsot adtál meg...");
				break;
		}
	}
	private void LoadMap(String mapName) {
		
	}
	
	private void PlaceWorker(String name, int height, int width) {
		for(Worker w : game.workers) {
			if(w.getName().equals(name)) {
				//w.setTile(game.map.getTile(height, width);
				break;
			}
		}
		// Sikeres illetve sikertelen elhelyezés esetén a kimenet
		/*
		if(game.map.getTile(height, width).getObject().getName() == name) {
			Results.add("Worker placed  ID: " + name + " Coordinates: " + height + "," + width);
		}else {
			Results.add("Worker not placed  ID: " + name);
		}*/
	}
	
	private void PlaceCrate(String name, int height, int width) {
		for(Crate c : game.crates) {
			if(c.getName().equals(name)) {
				//c.setTile(game.map.getTile(height, width);
				break;
			}
		}
		// Sikeres illetve sikertelen elhelyezés esetén a kimenet
		/*if(game.map.getTile(height, width).getObject().getName() == name) {
			Results.add("Crate placed  ID: " + name + " Coordinates: " + height + "," + width);
		}else {
			Results.add("Crate not placed  ID: " + name);
		}*/
	}
	
	private void PlaceOil(String workerName) {
		for(Worker w : game.workers) {
			if(w.getName().equals(workerName)) {
				w.PlaceOil();
				Integer[] coords = w.getTile().getCoords();
				Results.add("Oil placed  Coordinates: " + coords[0] + "," + coords[1] + " Friction: " +  ((Tile) w.getTile()).SumGreaseMu());
				return;
			}
		}
		Results.add("Worker not found, oil not placed");
	}
	
	private void PlaceHoney(String workerName) {
		for(Worker w : game.workers) {
			if(w.getName().equals(workerName)) {
				w.PlaceHoney();
				Integer[] coords = w.getTile().getCoords();
				Results.add("Oil placed  Coordinates: " + coords[0] + "," + coords[1] + " Friction: " + ((Tile) w.getTile()).SumGreaseMu());
				return;
			}
		}
		Results.add("Worker not found, oil not placed");
	}
	
	private void ListCrates() {
		int crateCount = 0;
		for(Crate c : game.crates) {
			crateCount++;
			Integer[] coords = c.getTile().getCoords();
			Results.add(crateCount+". Coordinates: "+ coords[0] + "," + coords[1] + 
			" Friction: " + c.getMu() + 
			" OnTarget: " + ".|..");
		}
	}
	
	private void ListPlacedCrates() {
		for(Crate c : game.crates) {
			if(c.getTile().getClass().getCanonicalName().equals("Target")) {
				Integer[] coords = c.getTile().getCoords();
				Results.add("Placed Crate ID: " + c.getName() 
						+ " Coordinates: " + coords[0] + "," + coords[1]
						+ " Friction: " + c.getMu()
						+ " Last pushed by: " + c.getPushedBy().getName());
			}
		}
	}
	
	private void ListFreeCrates() {
		for(Crate c : game.crates) {
			if(!c.getTile().getClass().getCanonicalName().equals("Target")) {
				Integer[] coords = c.getTile().getCoords();
				Results.add("Free Crate ID: " + c.getName() 
						+ " Coordinates: " + coords[0] + "," + coords[1] 
						+ " Friction: " + c.getMu());
			}
		}
	}
	
	private void SetStrenght(String workerName, int value) {
		for(Worker w : game.workers) {
			if(w.getName().equals(workerName)) {
				w.setStrenght(value);
				Results.add("Success  WorkerID:" + workerName + " Strength: " + value);
				return;
			}
		}
		Results.add("Worker not found!");
	}
	
	private void Move(String workerName, Direction d) {
		for(Worker w : game.workers) {
			if(w.getName().equals(workerName)) {
				Integer[] beforeCoord = w.getTile().getCoords();
				game.Move(w, d);
				//leelenőrizni hogy mozgott-e, az alapján válasz
				if(beforeCoord != w.getTile().getCoords()) {
					Results.add("Moved " + workerName + ", " + d);
				}else {
					Results.add("Failed" + workerName + "could not step on the given coordinates");
				}
				return;
			}
		}
		Results.add("Worker not found!");
	}
	
	private void ListWorkers() {
		int workercount = 0;
		for(Worker w : game.workers) {
			workercount++;
			Integer[] coords = w.getTile().getCoords();
			Results.add(workercount + ". " + w.getName() 
				+ " Coordinates: " + coords[0] + "," + coords[1] + " Score: " 
				+ w.getSumscore() + " Strenght: " + w.getStrenght());
		}
	}
}
	

