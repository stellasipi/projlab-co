package shokoban;


public class Crate extends Object {
	private int score;
	private Worker pushedBy;
	private int mu;
	
	public void visit(Coloumn c ,Direction d) {
		//üres függvény, az oszlopra láda nem tud rálépni
	}
	
	public void visit(Target target ,Direction d) {		
		//fgv törzs
		if(target.getObject() == null) 
		{
			this.getTile().Remove(this);
			this.setTile(target);
			target.setObject(this);
			this.getGame().CalculateScores();
			//setPushedBy();
		}	
	}
	
	public void visit(Hole h ,Direction d) {
		//fgv törzs
		this.getTile().Remove(this);
		getGame().Die(this);//a nem elérhető a láda
	}

	
	public void visit(Trap trap ,Direction d) {

		
		//fgv törzs
		if(trap.getActive()) { //ha aktív a csapda
		
			this.getTile().Remove(this);
			getGame().Die(this);//nem elérhető többé a láda
		}else{
			if(trap.getObject() == null) {
				this.getTile().Remove(this);
				this.setTile(trap);
				trap.setObject(this);

			}
		}		
	}
	
	public void visit(Button b ,Direction d) {
		
		//fgv törzs
		if(b.getObject() == null) {
			this.getTile().Remove(this);
			this.setTile(b);
			b.setObject(this);
			b.Switch(b.getTrap());
		}
	}
	
	public void visit(Tile tile ,Direction d) {
		
		//fgv törzs
		if(tile.getObject() == null) {
			this.getTile().Remove(this);
			this.setTile(tile);
			tile.setObject(this);
		}
	}
	
	public void push(Crate c, Direction d, int acts) {
		if(acts>mu) {
			acts=acts-mu;
			this.getTile().getNeighbour(d).Accept(this, d, acts); //következő tile accept-jét hívjuk be
		}	
	}
	
	public void push(Worker w, Direction d, int acts) {
		TileElement seged = this.getTile();
		this.getTile().getNeighbour(d).Accept(this, d, acts); //következő tile accept-jét hívjuk be
		if(seged!=this.getTile())
			this.setPushedBy(w);
	}
	
	public int getScore() {		
		return score;
	}

	public void setScore(int score) {		
		this.score = score;
	}

	public Worker getPushedBy() {		
		return pushedBy;
	}

	public void setPushedBy(Worker pushedBy) {		
		this.pushedBy = pushedBy;
	}
	public int getMu() {
		return mu;
	}
	public void setMu(int mu) {
		this.mu = mu;
	}
}

