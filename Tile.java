package shokoban;

import java.util.ArrayList;
import java.lang.*;

public class Tile extends TileElement {
	private ArrayList<Grease> grease = new ArrayList<Grease>();
	
	public void Remove(Worker w) {
        //függvénytörzs
        setObject(null);
    }
	
	public void Remove(Crate c) { 
        //függvénytörzs
        setObject(null);
    }

	public void Accept(Worker w, Direction d, int acts) {
      //függvénytörzs
        if(this.getObject() != null) 
        {
        	w.getTile().getNeighbour(d).getObject().push(w, d, acts); 
        	//Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet
        }
		w.visit(this, d); //Meghívja az object visit függvényét, hogy ráléphessen a mezőre	
	}
	
	public void Accept(Crate c, Direction d, int acts) {
      //függvénytörzs
        if(this.getObject() != null) 
        {
        	c.getTile().getNeighbour(d).getObject().push(c, d, acts); //Meghívja object push függvényét, hogy el tudja tolni a rajta levő elemet

        }
		c.visit(this, d); //Meghívja az object visit függvényét, hogy ráléphessen a mezőre	
	}
	
	public int SumGreaseMu() {
		int sum=0;
		for(int i =0; i<grease.size(); i++) {
			sum+=grease.get(i).getMu();
		}
		return Math.min(5, Math.max(-5, sum));
	}
	
	public void setGrease(Grease g) {
		grease.add(g);
	}

}

