﻿package shokoban;

public class Hole extends TileElement {
	
		@Override
		public void Accept(Object o, Direction d) {
			//bemegyünk a fgv-be
			System.out.print(">");
			System.out.print("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
			System.out.println("[:Hole].Accept(o,d):");
			
			if(this.getObject() != null)
				o.getTile().getNeighbour(d).getObject().push(o, d);
			
			o.visit(this, d);
			
		}
		
		@Override
	    public void Remove(Object o) {
	        //bemegyünk a fgv-be
	        System.out.print(">");
	        System.out.print("  ");
	        System.out.println("[:Hole].Remove(o):");

	        //fgv törzs
	        this.setObject(null);
	    }
}
