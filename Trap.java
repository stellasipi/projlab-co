package shokoban;

public class Trap extends Hole {
	private boolean active = false;
	
	@Override
	public void Accept (Object o,Direction d){
		//bemegyünk a fgv-be
		System.out.print(">");
		System.out.print("	");
		System.out.println("[:Trap].Accept(o,d):");
		
		if(this.getObject() != null)
			o.getTile().getNeighbour(d).getObject().push(o, d);
		
		o.visit(this, d);
	}
	
	@Override
    public void Remove(Object o) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Trap].Remove(o):");

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
