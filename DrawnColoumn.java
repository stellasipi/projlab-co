package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnColoumn extends Drawable {
	
	public DrawnColoumn() {
		ImageIcon icon = new ImageIcon("pics/Coloumn.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}