package shokoban;


public abstract class Object {
    private TileElement tile;
    private Game game;

    abstract public void visit(Coloumn c , Direction d);

    abstract public void visit(Target target ,Direction d);

    abstract public void visit(Hole h ,Direction d);

    abstract public void visit(Trap trap ,Direction d);

    abstract public void visit(Button b ,Direction d);

    abstract public void visit(Tile tile ,Direction d);

    abstract public void visit(Wall w ,Direction d);

    abstract public void push(Object o, Direction d);

    public TileElement getTile() {
        return tile;
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
}