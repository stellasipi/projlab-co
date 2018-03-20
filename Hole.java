package shokoban;

public class Hole extends TileElement {
	
		public void Accept(Crate c, Direction d) {
			//Dialógus kiíratása
			System.out.print(">");
			System.out.print("  ");
			System.out.println("[:Hole].Accept(c,d):");
			
			//Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
			if(this.getObject() != null)
				c.getTile().getNeighbour(d).getObject().push(c, d);
			
			//Meghívja az object visit függvényét, hogy rá tudjon lépni 
			c.visit(this, d);
			
		}
		
		public void Accept(Worker w, Direction d) {
			//Dialógus kiíratása
			System.out.print(">");
			System.out.print("  ");
			System.out.println("[:Hole].Accept(w,d):");
			
			//Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
			if(this.getObject() != null)
				w.getTile().getNeighbour(d).getObject().push(w, d);
			
			//Meghívja az object visit függvényét, hogy rá tudjon lépni 
			w.visit(this, d);
			
		}
		
		public void Remove(Crate c) {
			//Dialógus kiíratása
	        System.out.print(">");
	        System.out.print("  ");
	        System.out.println("[:Hole].Remove(c):");

	        //Üres mezőnek állítja be magát
	        this.setObject(null);
	    }
		
	    public void Remove(Worker w) {
			//Dialógus kiíratása
	        System.out.print(">");
	        System.out.print("  ");
	        System.out.println("[:Hole].Remove(w):");

	        //Üres mezőnek állítja be magát
	        this.setObject(null);
	    }
}
