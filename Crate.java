package shokoban;

public class Crate extends Object {
	private int score;
	private Worker pushedBy;
	
	public void visit(Coloumn c ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(c,d):");
		
		//üres függvény, az oszlopra láda nem tud rálépni
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(c,d):");
	}
	
	public void visit(Target target ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(target,d):");
		
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(target.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			target.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(target);	//beállítj az új mezőt magának
			//setPushedBy(); //ez még nem jó
		}
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(target,d):");		
	}
	public void visit(Hole h ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(h,d):");
		
		//Eltávolítja magát arról a mezőről, mert meg fog halni, így tud oda lépni a következő
		this.getTile().Remove(this);
		getGame().Die(this);
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(h,d):");
	}
	
	public void visit(Trap trap ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(trap,d):");
		
		//ha aktív lyukként működik
		if(trap.getActive()) {
			this.getTile().Remove(this);
			getGame().Die(this);
		}
		//ha sima mezőként működik ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		else if(trap.getObject() == null){
			this.getTile().Remove(this); //eltávolítja magát a másikról
			trap.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(trap);	//beállítj az új mezőt magának
		}
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(trap,d):");
	}
	
	public void visit(Button b ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(b,d):");
		
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(b.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			b.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(b);	//beállítj az új mezőt magának
		}
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(b,d):");
	}
	
	public void visit(Tile tile ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(tile,d):");
		
		//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(tile.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			tile.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(tile);	//beállítj az új mezőt magának
		}
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(tile,d):");
	}
	
	public void visit(Wall w ,Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].visit(w,d):");
		
		//üres függvény, az falra láda nem tud rálépni
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].visit(w,d):");
	}
	
	public void push(Object o, Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].push(o,d):");
		
		
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].push(o,d):");
	}

	public int getScore() {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].getScore():");
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].getScore():");
		
		return score;
	}

	public void setScore(int score) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].setScore(score):");
		
		this.score = score;
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].setScore(score):");
	}

	public Worker getPushedBy() {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].getPushedBy():");
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].getPushedBy():");
		
		return pushedBy;
	}

	public void setPushedBy(Worker pushedBy) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].setPushedBy(pushedBy):");
		
		this.pushedBy = pushedBy;
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Crate].setPushedBy(pushedBy):");
	}

}
