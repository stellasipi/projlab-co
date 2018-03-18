package shokoban;


public class Worker extends Object {
	private int sumscore;
	
	public void visit(Button b, Direction d) {
	//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(b.getObject()== null) {
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
		//h.getGame().Die(this);
		getGame().Die(this);
	}
	
	public void visit(Target t, Direction d) {
	//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject()== null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}
	}
	
	public void visit(Tile t, Direction d) {
	//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject()== null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}
	}

	public void visit(Trap t, Direction d) {
		//ha aktív lyukként működik
		if(t.getActive()== true) {
			this.getTile().Remove(this);
			//t.getGame().Die(this);
			getGame().Die(this);
		}
		//ha sima mezőként működik ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		else if(t.getObject()== null){
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}	
	}
	
	//Nem történik semmi, így üres
	public void visit(Wall w, Direction d) {
	}
	
	public void push(Crate c, Direction d) {
		
	}
	
	//Nem történik semmi, így üres
	public void push(Worker w, Direction d) {
	}
	
	public int getSumscore() {
		return sumscore;
	}
	public void setSumscore(int s) {
		sumscore = s;
	}

	@Override
	public void push(Object o, Direction d) {
		// TODO Auto-generated method stub
		
	}

	
}
