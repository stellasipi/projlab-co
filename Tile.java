package shokoban;



public class Tile extends TileElement {
	public void Remove(Object o) {
      
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Tile].Remove(o):");

        //függvénytörzs
        setObject(null);

        //visszatérünk a függvényből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Tile].Remove(o):");
    }

	@Override
	public void Accept(Object o, Direction d) {
		
		System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Tile].Accept(o,d):");

      //függvénytörzs
        if(!this.getObject().equals(null))
			o.push(o, d);
		
		o.visit(this, d);

		//visszatérünk a függvényből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Tile].Accept(o,d):");
		
	}

}

