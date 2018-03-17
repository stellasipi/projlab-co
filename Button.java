package shokoban;

public class Button extends TileElement {
	private Trap trap;
	
	public void Accept(Crate c, Direction d) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Button].Accept(c,d):");
		
		c.push(c, d);
		c.visit(this, d);
		this.Remove(c);
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Button].Accept(c,d):");		
	}
	
	public void Remove(Crate c) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Button].Remove(c):");
		
		//fgv törzs
		c.setTile(null); //ebbe azért nem vagyok biztos
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Button].Remove(c):");
	}
	
	public void Switch(Trap t) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Button].Switch(t):");
		
		if(t.getActive())
			setActive(true);
		else
			setActive(false);
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Button].Switch(c):");
	}

	public Trap getTrap() {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Button].getTrap():");
		
		return trap;
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Button].getTrap():");
	}

	public void setTrap(Trap trap) {
		//bemegyünk a fgv-be
		System.out.println(">");
		System.out.println("	");
		System.out.println("[:Button].setTrap(trap):");
		
		this.trap = trap;
		
		//visszatérünk a fgv-ből
		System.out.println("<");
		System.out.println("	");
		System.out.println("[:Button].setTrap(trap):");		
	}
	
}
