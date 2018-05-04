package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnHole extends Drawable {
	
	public DrawnHole() {
		ImageIcon icon = new ImageIcon("pics/Hole.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}