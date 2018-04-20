package shokoban;


public class Coloumn extends TileElement {
	
    public void Accept (Worker w, Direction d, int acts){

        //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)
			w.getTile().getNeighbour(d).getObject().push(w, d, acts);
        
        //Meghívja az object visit függvényét, hogy rá tudjon lépni
        w.visit(this, d);

    }
    
    public void Accept (Crate c, Direction d, int acts){
		
        //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)
			c.getTile().getNeighbour(d).getObject().push(c, d, acts);
        
        //Meghívja az object visit függvényét, hogy rá tudjon lépni
        c.visit(this, d);

    }
	
    
	public void Remove(Worker w) {
    }
	
	public void Remove(Crate c) {
	}
}
