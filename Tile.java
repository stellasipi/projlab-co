package shokoban;

public class Tile extends TileElement {
	public void Remove(Worker w) {
      
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Remove(w):");

        //függvénytörzs
        setObject(null);
    }
	
	public void Remove(Crate c) {
	      
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Remove(c):");

        //függvénytörzs
        setObject(null);
    }

	public void Accept(Worker w, Direction d) {
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Accept(w,d):");

      //függvénytörzs
        if(this.getObject() != null) 
        {
        	w.getTile().getNeighbour(d).getObject().push(w, d); //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet

        }
		w.visit(this, d); //Meghívja az object visit függvényét, hogy ráléphessen a mezőre	
	}
	
	public void Accept(Crate c, Direction d) {
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Accept(c,d):");

      //függvénytörzs
        if(this.getObject() != null) 
        {
        	c.getTile().getNeighbour(d).getObject().push(c, d); //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet

        }
		c.visit(this, d); //Meghívja az object visit függvényét, hogy ráléphessen a mezőre	
	}

}

