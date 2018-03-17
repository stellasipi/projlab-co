package shokoban;

public class Crate extends Object {
	private int score;
	private Worker pushedBy;
	
	public void visit(Coloumn c ,Direction d) {
		
	}
	
	public void visit(Target target ,Direction d) {
		
	}
	public void visit(Hole h ,Direction d) {
		
	}
	
	public void visit(Trap trap ,Direction d) {
		
	}
	
	public void visit(Button b ,Direction d) {
		
	}
	
	public void visit(Tile tile ,Direction d) {
		
	}
	
	public void visit(Wall w ,Direction d) {
		
	}
	
	public void push(Object o, Direction d) {
		
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

}
