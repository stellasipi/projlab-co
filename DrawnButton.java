package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnButton extends Drawable {
	
	public DrawnButton() {
		ImageIcon icon = new ImageIcon("pics/Button.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}