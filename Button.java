package shokoban;


public class Button extends TileElement {
	private Trap trap;
	
	@Override
	public void Accept(Object o, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Button].Accept(o,d):");
		
		if(this.getObject() != null)
			o.getTile().getNeighbour(d).getObject().push(o, d);
		
		o.visit(this, d);		
	}
	
	public void Accept(Crate c, Direction d) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");//itt úgy kéne, hogy annyi tab, ahányaid fgv hívás az adott dialógusba és a visszatérésnél is, csak nem tudom, hogy lenne az...
		System.out.println("[:Button].Accept(c,d):");
		
		if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d);
		
		c.visit(this, d);	
	}
	
	public void Remove(Crate c) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Button].Remove(c):");
		
		//fgv törzs
		Switch(trap);
		c.setTile(null); //ebbe azért nem vagyok biztos

	}
	
	@Override
    public void Remove(Object o) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Button].Remove(o):");

        //fgv törzs
        this.setObject(null);
    }
	
	public void Switch(Trap t) {
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Button].Switch(t):");
		
		if(t.getActive())
			t.setActive(true); //aktívra állítjuk a csapdát
		else
			t.setActive(false); //inaktívra állítjuk a csapdát
		
	}

	public Trap getTrap() {

		
		return trap;
	}

	public void setTrap(Trap trap) {

	}
	
}
