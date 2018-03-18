package shokoban;

public class Hole extends TileElement {
	public void Accept(Object o, Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Hole].Accept(o,d):");
		
		if(!this.getObject().equals(null))//amíg van a következő mezőn láda vagy munkás, addig hívjuk a push-t
			o.push(o, d);
		
		o.visit(this, d);
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Hole].Accept(o,d):");
	}
}
