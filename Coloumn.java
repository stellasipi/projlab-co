package shokoban;

public class Coloumn extends TileElement {
	@Override
    public void Accept (Object o, Direction d){
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Coloumn].Accept(object, dir):");

        if(this.getObject() != null)
			o.getTile().getNeighbour(d).getObject().push(o, d);

        o.visit(this, d);
        this.Remove(o);

    }
    
	@Override
    public void Remove(Object o) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:Coloumn].Remove(o):");

        //fgv törzs
        this.setObject(null);
    }
}
