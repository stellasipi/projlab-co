package shokoban;
//
public class Wall extends Coloumn {
	
	@Override
    public void Accept (Worker w, Direction d){
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Wall].Accept(worker, d):");
        
      //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)  
        {	
			w.getTile().getNeighbour(d).getObject().push(w, d);
        }

        w.visit(this, d);
        this.Remove(w);
    }
	
	@Override
    public void Remove(Worker w) {
    }
	
	@Override
    public void Accept (Crate c, Direction d){
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Wall].Accept(crate, d):");
        
      //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)  
        {	
			c.getTile().getNeighbour(d).getObject().push(c, d);
        }

        c.visit(this, d);
        this.Remove(c);
    }
	
	@Override
    public void Remove(Crate c) {
    }
}
