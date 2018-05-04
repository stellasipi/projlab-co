package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnHoney extends Drawable {
	
	public DrawnHoney() {
		ImageIcon icon = new ImageIcon("pics/Honey.png"); //kép helye
		setImg(icon.getImage());
		setDepth(2);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}