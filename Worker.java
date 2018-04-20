package shokoban;


public class Worker extends Object {
	private int sumscore;
	private int strenght;
	
	public void visit(Button b, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(b, d):");
        
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(b.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			b.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(b);	//beállítj az új mezőt magának
			System.out.println("  	Lépes megtörtént");
		}
		else 
			System.out.println("  	Lépes nem történt meg");
	}
	
	//Nem történik semmi, így üres
	public void visit(Coloumn c, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(c, d):");
        System.out.println("  	Lépes nem történt meg");
	}
	
	public void visit(Hole h, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(h, d):");
		
		//Eltávolítja magát arról a mezőről, mert meg fog halni, így tud oda lépni a következő
		this.getTile().Remove(this);
		getGame().Die(this);
		System.out.println("  	Lépes megtörtént");
	}
	
	public void visit(Target t, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(target, d):");
		
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
			System.out.println("  	Lépes megtörtént");
		}
		else 
			System.out.println("  	Lépes nem történt meg");
	}
	
	public void visit(Tile t, Direction d) {
		
		//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának

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
	
	
	//Nem történik semmi, így üres
	
	
	//Nem történik semmi, így üres
	public void push(Worker w, Direction d, int acts) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].push(w, d):");
	}
	
	public void push(Crate c, Direction d, int acts) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].push(w, d):");
        TileElement seged = this.getTile();
       this.getTile().getNeighbour(d).Accept(this, d, acts); //a következő tile Accept-jét hívjuk
       if(seged==this.getTile()) {
    	   this.getTile().Remove(this);
    	   getGame().Die(this);  
       }   
	}
	
	void PlaceOil(Grease g) {
		
	}
	
	void PlaceHoney(Grease g) {
		
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
