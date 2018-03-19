﻿package shokoban;

public class Worker extends Object {
	private int sumscore;
	
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
		}
	}
	
	//Nem történik semmi, így üres
	public void visit(Coloumn c, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(c, d):");
	}
	
	public void visit(Hole h, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(h, d):");
		
		//Eltávolítja magát arról a mezőről, mert meg fog halni, így tud oda lépni a következő
		this.getTile().Remove(this);
		getGame().Die(this);
	}
	
	public void visit(Target t, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(t, d):");
		
        //Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}
	}
	
	public void visit(Tile t, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(t, d):");
		
		//Ellenőrzi, hogy sikerült-e elmozdulni a másik objectnek, ha null akkor mozoghatnak, amúgy marad minden ugyanaz
		if(t.getObject() == null) {
			this.getTile().Remove(this); //eltávolítja magát a másikról
			t.setObject(this);	//beállítja magát az új mezőnek
			this.setTile(t);	//beállítj az új mezőt magának
		}	
	}

	public void visit(Trap t, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].visit(t, d):");
		
		//ha aktív lyukként működik
		if(t.getActive()== true) {
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
	public void visit(Wall w, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.print("[:Worker].visit(w, d):");
	}
	
	//Nem történik semmi, így üres
	public void push(Object o, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].push(o, d):");
	}
	
	//Nem történik semmi, így üres
	public void push(Worker w, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].push(w, d):");
	}
	
	public void push(Crate c, Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Worker].push(w, d):");
        
       this.getTile().getNeighbour(d).Accept(this, d);
	}
	
	public int getSumscore() {
		return sumscore;
	}
	
	public void setSumscore(int s) {
        sumscore = s;
	}
}
