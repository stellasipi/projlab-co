package shokoban;

public class Coloumn extends TileElement {
    public void Accept (Object o, Direction d){
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Coloumn].Accept(o, d):");

        if (!this.getObject().equals(null))
        o.push(o, d);

        o.visit(this, d);

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Coloumn].Accept(o, d):");
    }
}
