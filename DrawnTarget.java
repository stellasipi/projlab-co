package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnTarget extends Drawable {
	
	public DrawnTarget() {
		ImageIcon icon = new ImageIcon("pics/Target.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}