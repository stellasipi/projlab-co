package shokoban;

import java.awt.Image;

public abstract class Drawable implements Comparable<Drawable> {
	private Image img;
	private int depth;
	private int x;
	private int y;
	
	public abstract void Draw();
	
	public abstract void CompareTo();

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}