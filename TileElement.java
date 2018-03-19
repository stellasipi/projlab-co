package shokoban;

import java.util.HashMap;

public abstract class TileElement {

    private HashMap<Direction,TileElement> neighbours=new HashMap<Direction,TileElement>();
    private Object object;

    public abstract void Accept (Object o, Direction d);

    public abstract void Remove(Object o);

    public TileElement getNeighbour(Direction d) {
    	return neighbours.get(d);
    }
    
    public void setNeighbour(TileElement t, Direction d) {
    	neighbours.put(d, t);
    }

    public Object getObject() {
    	return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
