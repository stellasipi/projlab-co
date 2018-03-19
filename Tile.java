package shokoban;

//ez egy próba
//ez egy próba válasz

public class Tile extends TileElement {
	public void Remove(Object o) {
      
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Remove(o):");

        //függvénytörzs
        setObject(null);

        //visszatérünk a függvényből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Tile].Remove(o):");
    }

	@Override
	public void Accept(Object o, Direction d) {
		
		System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Tile].Accept(o,d):");

      //függvénytörzs
        if(this.getObject() != null)
			o.push(o, d);
		
		o.visit(this, d);

		//visszatérünk a függvényből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:Tile].Accept(o,d):");
		
	}

}

