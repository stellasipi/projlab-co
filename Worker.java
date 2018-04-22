package shokoban;


public class Worker extends Object {
	private int sumscore;
	private int strenght;
	
	public void visit(Button b, Direction d) {
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(b.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			b.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(b);	//beállítj az új mezőt magának
		}
	}
	
	//Nem történik semmi, így üres
	public void visit(Coloumn c, Direction d) {
       
	}
	
	public void visit(Hole h, Direction d) { 
		//Eltávolítja magát arról a mezőről, mert meg fog halni, így tud oda lépni a következő
		this.getTile().Remove(this);
		getGame().Die(this);

	}
	
	public void visit(Target t, Direction d) {		
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}
	}
	
	public void visit(Tile t, Direction d) {		
		//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}
	}

	public void visit(Trap t, Direction d) {		
		//ha aktív lyukként működik
		if(t.getActive()) {
			this.getTile().Remove(this);
			getGame().Die(this);
		}
		//ha sima mezőként működik ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		else if(t.getObject() == null){
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}
	}
	
	
	
	//Nem történik semmi, így üres
	public void push(Worker w, Direction d, int acts) {
    
	}
	
	public void push(Crate c, Direction d, int acts) {
		TileElement seged = this.getTile();
		this.getTile().getNeighbour(d).Accept(this, d, acts); //a következő tile Accept-jét hívjuk
		if(seged==this.getTile()) {
			this.getTile().Remove(this);
			getGame().Die(this);
		}
	}
	
	void PlaceOil() {
		if(this.getTile().getClass().getSimpleName().equals("Tile")) { //ha az osztályneve Tile
			Grease g=new Grease();
			Tile tile=(Tile)this.getTile(); //azért kell a castolás, mert csak így tudjuk meghívni a setGrease fgv-t, de igazából nem történik valós castolás
			g.setMu(g.getMu()*(-1)); //létrehozza az olajat, ami mínusz előjelű
			tile.setGrease(g); //rápakoljuk az olajat
		}		
	}
	
	void PlaceHoney() {
		if(this.getTile().getClass().getSimpleName().equals("Tile")) { //ha az osztályneve Tile
			Grease g=new Grease();
			Tile tile=(Tile)this.getTile();
			tile.setGrease(g); //rápakoljuk a mézet
		}
	}
	
	public int getSumscore() {
		return sumscore;
	}
	
	public void setSumscore(int s) {
        sumscore = s;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}
}
