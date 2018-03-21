package shokoban;
//
import java.util.HashMap;

public abstract class TileElement {

    private HashMap<Direction,TileElement> neighbours=new HashMap<Direction,TileElement>();
    private Object object;
    
    /* Az objektum mezőre lépését kezelő függvény
     * @param1 a mezőre lépő munkás
     * @param2 az irány, amerre a munkás mozog
     */
    public abstract void Accept (Worker w, Direction d);
    
    /* Az objektum mezőre lépését kezelő függvény
     * @param1 a mezőre lépő láda
     * @param2 az irány, amerre a láda mozog
     */
    public abstract void Accept (Crate c, Direction d);
    
    /* Az objektumot a mezőről eltávolító függvény
     * @param az eltávolítandó munkás
     */
    public abstract void Remove(Worker w);
    
    /* Az objektumot a mezőről eltávolító függvény
     * @param az eltávolítandó láda
     */
    public abstract void Remove(Crate c);
    
    /* Adott irányban lekérdezi a szomszédos mezőt
     * @param az irány, ahol lekérdezzük a mezőt
     * @return a kérdezett mező
     */
    public TileElement getNeighbour(Direction d) {
    	return neighbours.get(d);
    }
    
    /* Beállítja a szomszédos mezőt
     * @param1 a mező, amelyet be akaraunk állítani szomszédosnak
     * @param2 az irány, ahova beállítjuk a szomszédot
     */
    public void setNeighbour(TileElement t, Direction d) {
    	neighbours.put(d, t);
    }

    public Object getObject() {
    	return object;
    }
    
    /* Beállítja, hogy melyik objektum található a mezőn
     * @param a beállítani kívánt objektum
     */
    public void setObject(Object object) {
        this.object = object;
    }

}
