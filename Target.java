package shokoban;

public class Target extends TileElement {

	public void Accept(Worker w, Direction d, int acts) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Target].Accept(o,d):");
		if(this.getObject() != null)
			w.getTile().getNeighbour(d).getObject().push(w, d, acts);
		w.visit(this, d);
		
	}
	
	public void Accept(Crate c, Direction d, int acts) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Accept(c,d):");
		
		if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d, acts); //Meghívja crate push függvényét, hogy el tudja tolni a rajta levő elemet
		c.visit(this, d);  //Meghívja a crate visit függvényét, hogy rá tudjon lépni 
		this.setObject(c); //Beállítja, hogy a mezőn áll a láda
	}
	
	public void Remove(Crate c) {
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Remove(c):");
		
		this.setObject(null); //Törli a beállított objektumot a mezőről
		c.getGame().CalculateScores(); //ez nem működik még, csak jelzés
	}
	
    public void Remove(Worker w) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Target].Remove(o):");

        //fgv törzs
        this.setObject(null);
    }
}
