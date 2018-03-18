package shokoban;

public class Target extends TileElement {
	public void Accept(Crate c, Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].Accept(c,d):");
		c.push(c, d);
		c.visit(this, d);
		//this.object.setObject(c); //ezt még meg kell írni a TileElements-be	
	}
	
	public void Remove(Crate c) {
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Crate].Accept(c,d):");
		//this.object.setObject(NULL);
		//c.game.CalculateScores(); //ez nem működik még, csak jelzés
	}
}
