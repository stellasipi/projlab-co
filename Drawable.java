package shokoban;

import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public abstract class Drawable extends JLabel implements Comparable<Drawable> {
	private Image img;
	//private JLabel img_label=new JLabel();
	private Integer depth;
	private int x = 0;
	private int y = 0;
	
	//abstract public void Draw(GameView gw);
	
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

	public int getXx() {
		return x;
	}

	public void setX(int xx) {
		this.x = xx;
	}

	public int getYy() {
		return y;
	}

	public void setY(int yy) {
		this.y = yy;
	}
}