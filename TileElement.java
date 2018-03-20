package shokoban;

import java.util.HashMap;

public abstract class TileElement {

    private HashMap<Direction,TileElement> neighbours=new HashMap<Direction,TileElement>();
    private Object object;
    
    /* Az objektum mezőre lépését kezelő függvény
     * @param1 a mezőre lépő objektum
     * @param2 az irány, amerre az objektum mozog
     */
    public abstract void Accept (Object o, Direction d);
    
    /* Az objektumot a mezőről eltávolító függvény
     * @param az eltávolítandó objektum
     */
    public abstract void Remove(Object o);
    
    /* Adott irányban lekérdezi a szomszédos mezőt
     * @param az irány, ahol lekérdezzük a mezőt
     * @return a kérdezett mező
     */
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
