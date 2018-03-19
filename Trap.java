package shokoban;

public class Trap extends Hole {
	private boolean active = false;
	
	public void Accept (Object o,Direction d){
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Trap].Accept(o,d):");
		
		if(this.getObject() != null)
			o.getTile().getNeighbour(d).getObject().push(o, d);
		
		o.visit(this, d);
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
