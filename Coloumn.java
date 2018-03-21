package shokoban;


public class Coloumn extends TileElement {
	
    public void Accept (Worker w, Direction d){
		//Dialógus kiíratása
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Coloumn].Accept(w, d):");

        //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)
			w.getTile().getNeighbour(d).getObject().push(w, d);
        
        //Meghívja az object visit függvényét, hogy rá tudjon lépni
        w.visit(this, d);

    }
    
    public void Accept (Crate c, Direction d){
		//Dialógus kiíratása
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Coloumn].Accept(object, dir):");

        //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d);
        
        //Meghívja az object visit függvényét, hogy rá tudjon lépni
        c.visit(this, d);

    }
	
    
	public void Remove(Worker w) {
    }
	
	public void Remove(Crate c) {
	}
}
