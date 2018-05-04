package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnCrate extends Drawable {
	
	public DrawnCrate() {
		ImageIcon icon = new ImageIcon("pics/Crate.png"); //kép helye
		setImg(icon.getImage());
		setDepth(3);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}