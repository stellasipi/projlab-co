package shokoban;

import java.awt.Image;
import java.util.Comparator;
import javax.swing.JLabel;


public abstract class Drawable implements Comparable<Drawable> {
	private Image img;
	private JLabel img_label;
	private Integer depth;
	private int x;
	private int y;
	
	public void Draw(GameView gw) {
		gw.setTiles(getX(), getY(), getImg_label());
	}
	
	@Override
	public int compareTo(Drawable d1) {
		if (d1.getDepth()<this.getDepth())
			return d1.getDepth();
		else
			return this.getDepth();
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
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