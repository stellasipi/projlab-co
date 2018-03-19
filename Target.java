package shokoban;

public class Target extends TileElement {
	public void Accept(Object o, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Accept(o,d):");
		if(this.getObject() != null)
			o.getTile().getNeighbour(d).getObject().push(o, d);
		o.visit(this, d);
		
	}
	
	public void Accept(Crate c, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Accept(c,d):");
		
		if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d);
		c.visit(this, d);
		this.setObject(c); //ezt még meg kell írni a TileElements-be
	}
	
	public void Remove(Crate c) {
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Remove(c,d):");
		
		this.setObject(null);
		c.getGame().CalculateScores(); //ez nem működik még, csak jelzés
	}
}
