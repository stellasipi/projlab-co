package shokoban;

import java.util.HashMap;

public abstract class TileElement {

    private HashMap<Direction,TileElement> neighbours=new HashMap<Direction,TileElement>();
    private Object object;

    public abstract void Accept (Object o, Direction d);

    public void Remove(Object o) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:TileElement].Remove(o):");

        //fgv törzs
        setObject(null);

        //visszatérünk a fgv-ből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:TileElement].Remove(o):");
    }

    public TileElement getNeighbour(Direction d) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:TileElement].getNeighbour(d):");

        //visszatérünk a fgv-ből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:TileElement].getNeighbour(d):");
        
        return neighbours.get(d);
    }
    
    public void setNeighbour(TileElement t, Direction d) {
    	//bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:TileElement].setNeighbour(t,d):");
        
    	neighbours.put(d, t);
    	
    	/*visszatérünk a fgv-ből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:TileElement].getNeighbour(t,d):");*/
    }

    public Object getObject() {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:TileElement].getObject():");
        
        //visszatérünk a fgv-ből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:TileElement].getObject():");
        
        return object;
    }

    public void setObject(Object object) {
        //bemegyünk a fgv-be
        System.out.print(">");
        System.out.print("  ");
        System.out.println("[:TileElement].setObject(object):");

        this.object = object;

        //visszatérünk a fgv-ből
        System.out.print("<");
        System.out.print("  ");
        System.out.println("[:TileElement].setObject(object):");
    }

}
