package shokoban;

public class Wall extends Coloumn {
	@Override
    public void Accept (Object o, Direction d){
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Wall].Accept(object, d):");
        
      //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        if(this.getObject() != null)  
        {	
        	System.out.print("  ");
			o.getTile().getNeighbour(d).getObject().push(o, d);
        }

        System.out.print("  ");
        o.visit(this, d);
        this.Remove(o);
    }
	
	@Override
    public void Remove(Object o) {
    }
}
