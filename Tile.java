package shokoban;

public class Tile extends TileElement {
	public void Remove(Object o) {
      
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Remove(o):");

        //függvénytörzs
        setObject(null);
    }

	public void Accept(Object o, Direction d) {
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Accept(o,d):");

      //függvénytörzs
        if(this.getObject() != null)
			o.getTile().getNeighbour(d).getObject().push(o, d);
		
		o.visit(this, d);		
	}

}

