package shokoban;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestLanguage {
	
	Game game = new Game();
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
			try {
				input = br.readLine();				
				switch(input) {
				case "1":
					try {
						Init();
						System.out.println("Manuális bemenet kiválasztva!");
						ManualInputHandler();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Hibásan paramétereztél, vissza a startra!");
						System.out.println("1 - Manuális bemenet \n"
								+ "2 - Előre elkészített tesztek \n"
								+ "3 - Kilépés");
					}
					break;
				case "2":
					String name;
					try {
						Init();
						System.out.println("Teszteset kiválasztása, írd be a teszt nevét");
						name = br.readLine();
						if(!name.equals("Mindet")) {
							TextIputHandler(name);
						}else {
							//minden Inpt mappában lévő tesztet megcsinál
							List<String> tests = new ArrayList<String>();
							File[] inputfiles = new File(System.getProperty("user.dir") + File.separatorChar + "Input").listFiles();
							for (File file : inputfiles) {
							    if (file.isFile()) {
							        tests.add(file.getName());
							    }
							}
							for(String str : tests) {
								TextIputHandler(str);
							}
						}
					} catch (IOException e) {
						System.out.println("Hibás nevet adtál meg, próbáld újra!");
						System.out.println("1 - Manuális bemenet \n"
								+ "2 - Előre elkészített tesztek \n"
								+ "3 - Kilépés");
					}
					break;
				case "3":
					System.out.println("Kilépés!");
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
	
	public void TextIputHandler(String path) throws IOException {
		File file = new File(System.getProperty("user.dir") + File.separatorChar + "Input" + File.separatorChar + path + ".txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> commands = new ArrayList<String>();
		String line;
		while((line = br.readLine()) != null) {
			commands.add(line);
		}
		for(String str: commands) {
			ExecuteCommand(str);
		}
		
		File out = new File(System.getProperty("user.dir") + File.separatorChar + "Tests" + File.separatorChar + path + ".txt");
		FileWriter fw = new FileWriter(out, false);
		for(String str : Results) {
			System.out.println(str);
		}
	}
	
	private void Init() {
		game= new Game();
		Results = new ArrayList<String>();
	}

	private void ExecuteCommand(String line) throws FileNotFoundException, IOException {
		String[] command = line.split(",");
		switch (command[0]){
			case "LoadMap":
				/*
				 * 1 parameter:
				 * 		name	- String
				 */
				String LoadMapName = command[1];
				
				LoadMap(LoadMapName);
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
				
			case "ListTraps":
				/*
				 * 0 parameter:
				 */
				ListTraps();
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
		try {
			game.map.LoadMap(mapName);
			Results.add("Map loaded");
			ArrayList<String> mapText = new ArrayList<String>();
			mapText = GetDrawnMap(game.map);
			for(String s : mapText) {
				Results.add(s);
			}
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Rossz fájlnevet adtál meg!");
		}
		
	}
	
	private ArrayList<String> GetDrawnMap(Map map) {
		ArrayList<String> result = new ArrayList<String>();
		int height = map.getHeight();
		int width = map.getWidth();
		
		for(int i=0; i<height; i++) {
			String line = "";
			for(int j=0; j<width; j++) {
				String mezo = map.getTile(i, j).getClass().getSimpleName();
				switch(mezo){
				case "Tile":
					line += "t ";
					break;
				case "Target":
					line += "ta ";
					break;
				case "Trap":
					line += "tr ";
					break;
				case "Hole":
					line += "h ";
					break;
				case "Button":
					line += "b ";
					break;
				case "Coloumn":
					line += "c ";
					break;
				}
			}
			result.add(line);
		}
		return result;
	}
	
	private void PlaceWorker(String name, int height, int width) {
		Worker w = new Worker();
		
		w.setGame(game);
		w.setTile(game.getMap().getTile(height-1, width-1));
		game.getMap().getTile(height-1, width-1).setObject(w);
		w.setName(name);
		
		// Sikeres illetve sikertelen elhelyezés esetén a kimenet
		if(game.getMap().getTile(height-1, width-1).getObject().getName() == name) {
			game.workers.add(w);
			Results.add("Worker placed  ID: " + name + " Coordinates: " + height + "," + width);
		}else {
			Results.add("Error- " + name + " not placed");
		}
	}
	
	private void PlaceCrate(String name, int height, int width) {
		Crate c = new Crate();
		
		c.setGame(game);
		c.setTile(game.getMap().getTile(height-1, width-1));
		game.getMap().getTile(height-1, width-1).setObject(c);
		c.setName(name);
		
		// Sikeres illetve sikertelen elhelyezés esetén a kimenet
		if(game.getMap().getTile(height-1, width-1).getObject().getName() == name) {
			game.crates.add(c);
			Results.add("Crate placed  ID: " + name + " Coordinates: " + height + "," + width);
		}else {
			Results.add("Error- " + name + " not placed");
		}
	}
	
	private void PlaceOil(String workerName) {
		for(Worker w : game.workers) {
			if(w.getName().equals(workerName)) {
				int oilCompare = ((Tile)w.getTile()).SumGreaseMu();
				w.PlaceOil();
				Integer[] coords = w.getTile().getCoords();
				if(((Tile)w.getTile()).SumGreaseMu() != oilCompare) {
					Results.add("Oil placed  Coordinates: " + coords[0] + "," + coords[1] + " Friction: " + ((Tile) w.getTile()).SumGreaseMu());
				}else {
					Results.add("Error- Oil not placed");
				}
				return;
			}
		}
		Results.add("Worker not found, oil not placed");
	}
	
	private void PlaceHoney(String workerName) {
		for(Worker w : game.workers) {
			if(w.getName().equals(workerName)) {
				int honeyCompare = ((Tile)w.getTile()).SumGreaseMu();
				w.PlaceHoney();
				Integer[] coords = w.getTile().getCoords();
				if(((Tile)w.getTile()).SumGreaseMu() != honeyCompare) {
					Results.add("Honey placed  Coordinates: " + coords[0] + "," + coords[1] + " Friction: " + ((Tile) w.getTile()).SumGreaseMu());
				}else {
					Results.add("Error- Honey not placed");
				}
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
			String bool;
			if(c.getTile().getClass().getCanonicalName().equals("Target")) {
				bool = "true";
			}else {
				bool = "false";
			}
			Results.add(crateCount+". Coordinates: "+ coords[0] + "," + coords[1] + 
			" Friction: " + c.getMu() + " OnTarget: " + bool);
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
				try {
				if(beforeCoord != w.getTile().getCoords()) {
					Results.add("Moved " + workerName + ", " + d);
				}else {
					Results.add("Failed- " + workerName + " could not step on gicen coordinates");
				}
				}catch(Exception e) {
					Results.add("Moved " + workerName + ", " + d);
				}
				return;
			}
		}
		Results.add("Worker not found!");
	}
	
	private void ListWorkers() {
		int workercount = 0;
		for(int i=0; i< game.workers.size();i++) {
			workercount++;
			Worker w= game.workers.get(i);
			Integer[] coords = w.getTile().getCoords();
			Results.add(workercount + ". " + w.getName() 
				+ " Coordinates: " + coords[0] + "," + coords[1] + " Score: " 
				+ w.getSumscore() + " Strenght: " + w.getStrenght());
		}
	}
	
	private void ListTraps() {
		int trapcount = 0;
		String status;
		for(TileElement[] line : game.map.Tiles) {
			for(TileElement tElement : line) {
				if(tElement.getClass().getCanonicalName().equals("Trap")) {
					trapcount++;
					Integer[] coords = tElement.getCoords();
					if(((Trap)tElement).getActive()) {
						status = "active";
					}else status = "inactive";
					Results.add(trapcount + ". Coordinates: " + coords[0] + "," + coords[1] + " Status: " + status);
				}
			}
		}
	}
}
	

