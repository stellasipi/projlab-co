package shokoban;

//absztrakt minden függvény a leszármazottakban kommentelve
public abstract class Object {
    private TileElement tile;
    private Game game;
    private String name;

    abstract public void visit(Coloumn c, Direction d);

    abstract public void visit(Target target, Direction d);

    abstract public void visit(Hole h, Direction d);

    abstract public void visit(Trap trap, Direction d);

    abstract public void visit(Button b, Direction d);

    abstract public void visit(Tile tile, Direction d);

    abstract public void push(Worker w, Direction d, int acts);
    
    abstract public void push(Crate c, Direction d, int acts);

    public TileElement getTile() {
        return tile;
    }
    
    public Tile getTileType() {
		if(this.getTile().getClass().getSimpleName().equals("Tile")) { //ha az osztályneve Tile
			return (Tile)this.getTile();
		}
		return null;
	}

    public void setTile(TileElement tile) {
    	this.tile = tile;

    }

    public Game getGame() {
    	return game;
    }

    public void setGame(Game game) {
    	this.game = game;
    }
    
    public void setName(String n) {
    	this.name = n;
    }
    
    public String getName() {
    	System.out.println("getname: ");
    	System.out.println(name);
    	return name;
    }
}