package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnTrap extends Drawable {
	
	public DrawnTrap() {
		ImageIcon icon = new ImageIcon("pics/Trap.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}