package shokoban;


public class Crate extends Object {
	private int score;
	private Worker pushedBy;
	
	public void visit(Coloumn c ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(c,d):");
		
		//üres függvény, az oszlopra láda nem tud rálépni
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(c,d):");
	}
	
	public void visit(Target target ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(target,d):");
		
		//fgv törzs
		target.Remove(this);
		//setPushedBy();
		this.setTile(target);
		
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(target,d):");		
	}
	public void visit(Hole h ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(h,d):");
		
		//fgv törzs
		h.Remove(this);
		this.setTile(h);
		getGame().Die(this);//a nem elérhető a láda
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(h,d):");
	}
	
	public void visit(Trap trap ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(trap,d):");
		
		//fgv törzs
		trap.Remove(this);
		this.setTile(trap);
		if(trap.getActive()) //ha aktív a csapda
			getGame().Die(this);//nem elérhető többé a láda
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(trap,d):");
	}
	
	public void visit(Button b ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(b,d):");
		
		//fgv törzs
		b.Remove(this);
		this.setTile(b);
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(b,d):");
	}
	
	public void visit(Tile tile ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(tile,d):");
		
		//fgv törzs
		tile.Remove(this);
		this.setTile(tile);
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(tile,d):");
	}
	
	public void visit(Wall w ,Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].visit(w,d):");
		
		//üres függvény, az falra láda nem tud rálépni
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].visit(w,d):");
	}
	
	public void push(Object o, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].push(o,d):");
		
		this.getTile().getNeighbour(d).Accept(this, d); //következő tile accept-jét hívjuk be
		
		/*//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].push(o,d):");*/
	}

	public int getScore() {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].getScore():");
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].getScore():");
		
		return score;
	}

	public void setScore(int score) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].setScore(score):");
		
		this.score = score;
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].setScore(score):");
	}

	public Worker getPushedBy() {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].getPushedBy():");
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].getPushedBy():");
		
		return pushedBy;
	}

	public void setPushedBy(Worker pushedBy) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Crate].setPushedBy(pushedBy):");
		
		this.pushedBy = pushedBy;
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Crate].setPushedBy(pushedBy):");
	}

}

