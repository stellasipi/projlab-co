package shokoban;

import java.util.ArrayList;

public class Game {
	Map map=new Map();
	ArrayList<Crate> crates= new ArrayList<>();
	ArrayList<Worker> workers= new ArrayList<>();
	private int PlayerNumber = 2;
	private GameView gv;
	
	public GameView getGameView() {
		return gv;
	}
	
	public Game(int n) {
		PlayerNumber = n;
		StartGame();
	}
	
	public Game() {}
	
	public void EndGame()
	{
        //Vége a játéknak
		System.exit(0);
	}
	
	public void StartGame()
	{
        //Elindul a játék, létrejön a map és a objectek
        map.CreateMap2();
        for(int i=0; i<10; i++) {
        	Crate c=new Crate();
        	String ID = "c" + (i+1);
        	c.setId(ID);
        	map.PlaceCrate(c);
            AddCrate(c);
        }
        for(int i=0; i<PlayerNumber; i++) {
        	Worker w = new Worker();
        	String ID = "w" + (i+1);
        	w.setId(ID);
            map.PlaceWorker(w);
            AddWorker(w);
        }
	}
	
	public void Move(Worker w, Direction d)
	{
        //Elindítja a mozgást (majd a külső input alapján)
        w.getTile().getNeighbour(d).Accept(w, d, w.getStrenght());
        
        //Ellenőrzi a játék folytatásának feltételeit
        Check();
        CalculateScores();
	}
	
	public void Check()
	{
        //Ellenőriz minden feltételt
        if(CheckCrateOnTarget()||CheckDeadWorker()||CheckMoveableCrate()||CheckPushable())
        	this.EndGame();
	}
	
	public void AddWorker(Worker w)
	{
        //hozzáadja a munkást a game workers adattagjához
        workers.add(w);
        //beállítja a munkásnak, hoyg melyik játékhoz tartozik (Game osztyálybeli függvények meghívása miatt kell
        w.setGame(this);
        
	}
	
	public void AddCrate(Crate c)
	{
        //hozzáadja a ládát a game workers adattagjához
        crates.add(c);
        //beállítja a ládának, hoyg melyik játékhoz tartozik (Game osztyálybeli függvények meghívása miatt kell
        c.setGame(this);
	}
	
	public boolean CheckCrateOnTarget()
	{
        //Ellenőrzi, hogy az összes láda a célon van-e
		for(int i=0; i<crates.size();i++)
		{
			Crate cr=crates.get(i);
			if(!(cr.getTile().getClass().getSimpleName().equals("Target")))
				return false;
		}
		return true;
			}
	
	public boolean CheckDeadWorker()
	{
		//Ha üres a workers vége a játéknak
        if (workers.size()==0)
        	return true;
        else
		return false;
	}
	
	public boolean CheckMoveableCrate()
	{
        //Ellenőrzi, hogy van-e még mozgatható láda
		int count=0;
		for(int i=0;i<crates.size();i++)
		{
			Crate cr=crates.get(i);
			String up= cr.getTile().getNeighbour(Direction.UP).getClass().getSimpleName();
			String down= cr.getTile().getNeighbour(Direction.DOWN).getClass().getSimpleName();
			String left= cr.getTile().getNeighbour(Direction.LEFT).getClass().getSimpleName();
			String right= cr.getTile().getNeighbour(Direction.RIGHT).getClass().getSimpleName();
			if((up.equals("Coloumn")||up.equals("Hole"))&&(right.equals("Coloumn")||right.equals("Hole")||left.equals("Coloumn")||left.equals("Hole")))
			{
				count++;
				
			}
			else if((down.equals("Coloumn")||down.equals("Hole"))&&(right.equals("Coloumn")||right.equals("Hole")||left.equals("Coloumn")||left.equals("Hole")))
			{
				count++;
			}
			
		}
		if (count==crates.size())
			return true;
		else
			return false;
	}
	
	public boolean CheckPushable()
	{
        //Ellenőrzi, hogy a mozgatható ládák elérhetőek-e a munkások számára
		return false;
	}
	
	public void CalculateScores(){
		for(int i=0; i<15 ; i++) {
		      for(int j=0; j<20; j++) {
					System.out.println("for");
					
					if(map.Tiles[i][j].getClass().getSimpleName().equals("Target")) {
						System.out.println("Target-es if");
						
						if(map.Tiles[i][j].getObject()==null) {//ha nincs rajta object
							System.out.println("semmi");
							
						}else {
							if(map.Tiles[i][j].getObject().getClass().getSimpleName().equals("Crate")) {
								System.out.println("Crate-es if");
								
								Crate c=(Crate)map.Tiles[i][j].getObject();
								c.getPushedBy().setSumscore(); //a setSumScore hasába egy int kell
							}
						}
					}
		      }
		}
		
		for(int i=0;i<workers.size();i++) {
			System.out.println("w"+i+": "+workers.get(i).getSumscore()+" pont");
		}
	}
	
	public void Die(Worker w)
	{        
        //meghal a munkás, kivesszük a game-ből
        workers.remove(w);
	}
	
	public void Die(Crate c)
	{
        //meghal a láda , kivesszük a game-ből
		crates.remove(c);
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map m) {
		map = m;
	}
	
	public Worker getWorker(String w_id) {
		for(Worker w : workers) {
			if(w.getId().equals(w_id)) {
				return w;
			}
		}
		return null;
	}
}


