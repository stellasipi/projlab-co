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
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Object].getTile():");

        return tile;

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Object].getTile():");
    }

    public void setTile(TileElement tile) {
        //bemegyünk a fgv-be
        System.out.println(">");
        System.out.println("  ");
        System.out.println("[:Object].setTile(tile):");

        this.tile = tile;

        //visszatérünk a fgv-ből
        System.out.println("<");
        System.out.println("  ");
        System.out.println("[:Object].setTile(tile):");
    }

    public Game getGame() {
    	//bemegyünk a fgv-be
    	System.out.println(">");
    	System.out.println("  ");
    	System.out.println("[:Object].getGame():");

    	return game;

    	//visszatérünk a fgv-ből
    	System.out.println("<");
    	System.out.println("  ");
    	System.out.println("[:Object].getGame():");
    }

    public void setGame(Game game) {
    	//bemegyünk a fgv-be
    	System.out.println(">");
    	System.out.println("  ");
    	System.out.println("[:Object].setGame(game):");

    	this.game = game;

    		//visszatérünk a fgv-ből
    	System.out.println("<");
    	System.out.println("  ");
    	System.out.println("[:Object].setGame(game):");
    }
}
