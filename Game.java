package shokoban;

import java.util.ArrayList;

public class Game {
	Map map=new Map();
	ArrayList<Crate> crates= new ArrayList<>();
	ArrayList<Worker> workers= new ArrayList<>();
	
	public void EndGame()
	{
        //Vége a játéknak
	}
	
	public void StartGame()
	{
        //Elindul a játék, létrejön a map és a objectek
        map.CreateMap();
        for(int i=0; i<10; i++) {
        	Crate c=new Crate();
        	map.PlaceCrate(c);
            AddCrate(c);
        }
        for(int i=0; i<2; i++) {
        	Worker w = new Worker();
            map.PlaceWorker(w);
            AddWorker(w);
        }
	}
	
	public void Move(Worker w, Direction d)
	{
        //Elindítja a mozgást (majd a külső input alapján)
		System.out.println("Belépett a Game:move-ba "+ w.getName());
        w.getTile().getNeighbour(d).Accept(w, d, w.getStrenght());
        System.out.println("Belépett a Game:move-ból " +w.getName());
        
        //Ellenőrzi a játék folytatásának feltételeit
        Check();
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
		return false;
	}
	
	public boolean CheckDeadWorker()
	{
        //Ellenőrzi, hogy az összes játékos meghalt-e
		return false;
	}
	
	public boolean CheckMoveableCrate()
	{
        //Ellenőrzi, hogy van-e még mozgatható láda
		return false;
	}
	
	public boolean CheckPushable()
	{
        //Ellenőrzi, hogy a mozgatható ládák elérhetőek-e a munkások számára
		return false;
	}
	
	public void CalculateScores()
	{
        //Összeszámolja a pontokat, az alapján, hogy hány láda van célon és ki tolta oda.
	}
	
	public void Die(Worker w)
	{        
        //meghal a munkás, kivesszük a game-ből
        workers.remove(w);  
        System.out.println("Munkás meghal");
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
}


