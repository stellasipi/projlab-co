package shokoban;

public class Tile extends TileElement {
	public void Remove(Object o) {
      
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Remove(o):");

        //függvénytörzs
        setObject(null);
    }

	@Override
	public void Accept(Object o, Direction d) {
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Accept(o,d):");

      //függvénytörzs
        if(this.getObject() != null) 
        {
        	o.getTile().getNeighbour(d).getObject().push(o, d); //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        	System.out.print("<");
            System.out.print("  ");
        	System.out.println("[].Push(o,d):");
        }
		o.visit(this, d); //Meghívja az object visit függvényét, hogy ráléphessen a mezőre	
	}

}

