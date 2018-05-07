package shokoban;

import java.awt.Image;
import javax.swing.JLabel;


public abstract class Drawable {
	private Image img;
	private JLabel img_label;
	private int depth;
	private int x;
	private int y;
	
	public void Draw(GameView gw) {
		gw.setTiles(getX(), getY(), getImg_label());
	}

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

	public JLabel getImg_label() {
		return img_label;
	}

	public void setImg_label(JLabel img_label) {
		this.img_label = img_label;
	}
}