package shokoban;



public class Button extends TileElement {
	private Trap trap = new Trap();
	
	
	public void Accept(Worker w, Direction d) {
		//Dialógus kiíratása
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Button].Accept(o,d):");
		
		//Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
		if(this.getObject() != null) 
		{
			w.getTile().getNeighbour(d).getObject().push(w, d);
		}
		
		//Meghívja az object visit függvényét, hogy rá tudjon lépni 
		w.visit(this, d);		
	}
	
	public void Accept(Crate c, Direction d) {
		//Dialógus kiíratása
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Button].Accept(c,d):");
		
		//Meghívja crate push függvényét, hogy el tudja tolni a rajta levő elemet
		if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d);
		
		//Meghívja az object visit függvényét, hogy rá tudjon lépni 
		c.visit(this, d);	
	}
	
	public void Remove(Crate c) {
		//Dialógus kiíratása
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Button].Remove(c):");
		
		//Csapda állpotváltozását indító függyény
		Switch(trap);
		this.setObject(null);
	}
	
	@Override
    public void Remove(Worker w) {
		//Dialógus kiíratása
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Button].Remove(w):");

        //Üres mezőnek állítja be magát
        this.setObject(null);
    }
	
	public void Switch(Trap t) {
		//Dialógus kiíratása
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Button].Switch(t):");
		
		//Csapda állapotának változtatása, ha aktív -> inkatív, ha inaktív -> aktív
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

