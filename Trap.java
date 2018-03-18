package shokoban;

public class Trap extends Hole {
	private boolean active;
	
	public void Accept (Object o,Direction d){
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Trap].Accept(o,d):");
		
		if(this.getObject() != null)//amíg van a következő mezőn láda vagy munkás, addig hívjuk a push-t
			o.push(o, d);
		
		o.visit(this, d);
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Trap].Accept(o,d):");
	}

	public boolean getActive() {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Trap].isActive():");
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Trap].isActive():");
		
		return active;
	}

	public void setActive(boolean active) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Trap].setActive(active):");
		
		this.active = active;
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Trap].setActive(active):");
	}

}
