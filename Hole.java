package shokoban;

public class Hole extends TileElement {
	
		@Override
		public void Accept(Object o, Direction d) {
			//Dialógus kiíratása
			System.out.print(">");
			System.out.print("  ");
			System.out.println("[:Hole].Accept(o,d):");
			
			//Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
			if(this.getObject() != null)
				o.getTile().getNeighbour(d).getObject().push(o, d);
			
			//Meghívja az object visit függvényét, hogy rá tudjon lépni 
			o.visit(this, d);
			
		}
		
		@Override
	    public void Remove(Object o) {
			//Dialógus kiíratása
	        System.out.print(">");
	        System.out.print("  ");
	        System.out.println("[:Hole].Remove(o):");

	        //Üres mezőnek állítja be magát
	        this.setObject(null);
	    }
}
