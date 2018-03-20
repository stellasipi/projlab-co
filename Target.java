package shokoban;

public class Target extends TileElement {
	
	/*
	 * @see shokoban.TileElement#Accept(shokoban.Object, shokoban.Direction)
	 */
	@Override
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
			c.getTile().getNeighbour(d).getObject().push(c, d); //Meghívja crate push függvényét, hogy el tudja tolni a rajta levő elemet
		c.visit(this, d);  //Meghívja a crate visit függvényét, hogy rá tudjon lépni 
		this.setObject(c); //Beállítja, hogy a mezőn áll a láda
	}
	
	public void Remove(Crate c) {
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Target].Remove(c,d):");
		
		this.setObject(null); //Törli a beállított objektumot a mezőről
		c.getGame().CalculateScores(); //ez nem működik még, csak jelzés
	}
	
	/*
	 * @see shokoban.TileElement#Remove(shokoban.Object)
	 */
	@Override
    public void Remove(Object o) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Target].Remove(o):");

        //fgv törzs
        this.setObject(null);
    }
}
