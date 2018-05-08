package shokoban;

import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public abstract class Drawable implements Comparable<Drawable> {
	private Image img;
	private JLabel img_label=new JLabel();
	private Integer depth;
	
	abstract public void Draw(GameView gw);
	
	abstract public void CheckObjects();
	
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

	public JLabel getImg_label() {
		return img_label;
	}

	public void setImg_label(JLabel img_label) {
		this.img_label = img_label;
	}
}