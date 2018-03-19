package shokoban;

public class Target extends TileElement {
	public void Accept(Object o, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Accept(o,d):");
		o.push(o, d);
		o.visit(this, d);
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Target].Accept(o,d):");
		
	}
	
	public void Accept(Crate c, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Accept(c,d):");
		
		c.push(c, d);
		c.visit(this, d);
		this.setObject(c); //ezt még meg kell írni a TileElements-be
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Target].Accept(c,d):");
	}
	
	public void Remove(Crate c) {
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Remove(c,d):");
		
		this.setObject(null);
		c.getGame().CalculateScores(); //ez nem működik még, csak jelzés
		
		//visszatérünk a fgv-ből
		System.out.print("<");
		System.out.print("	");
		System.out.println("[:Target].Remove(c,d):");
	}
}
