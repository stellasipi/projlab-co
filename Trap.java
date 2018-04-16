package shokoban;

public class Trap extends Hole {
	private boolean active = false;
	
		public void Accept (Crate c,Direction d, int acts){
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Trap].Accept(c,d):");
		
		if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d, acts);
		
		c.visit(this, d);
	}
	
	public void Accept (Worker w,Direction d, int acts){
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("  ");
		System.out.println("[:Trap].Accept(w,d):");
		
		if(this.getObject() != null)
			w.getTile().getNeighbour(d).getObject().push(w, d, acts);
		
		w.visit(this, d);
	}
	
	public void Remove(Crate c) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Trap].Remove(c):");

        //fgv törzs
        this.setObject(null); //eltünteti a rajta lévő objektumot
    }
	
	public void Remove(Worker w) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Trap].Remove(w):");

        //fgv törzs
        this.setObject(null); //eltünteti a rajta lévő objektumot
    }

	public boolean getActive() {
		return active; //ha a csapda aktív (tehát lyukként viselkedik), akkor igaz értékkel tér vissza
	}

	public void setActive(boolean active) {
		this.active = active; //a paraméterként kapott logikai értékre állítja a csapda aktivitását
	}
}
