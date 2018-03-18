package shokoban;

public abstract class TileElement {

    private TileElement neighbours;
    private Object object;

    public void Accept (Object o, Direction d){
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:TileElement].Accept(object, dir):");

        if this.getObject() != null)
            o.push(o, d);

        o.visit(this, d);
        this.Remove(o);

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:TileElement].Accept(object, dir):");
    }

    public void Remove(Object o) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:TileElement].Remove(o):");

        //fgv törzs
        o.setObject(null);

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:TileElement].Remove(o):");
    }

    public TileElementaí getNeighbour(Direction d) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:TileElement].getNeighbour(d):");

        return neighbour;

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:TileElement].getNeighbour(d):");
    }

    public Object getObject() {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:TileElement].getObject():");

        return object;

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:TileElement].getObject():");
    }

    public void setObject(Object object) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:TileElement].setObject(object):");

        this.object = object;

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:TileElement].setObject(object):");
    }

}
