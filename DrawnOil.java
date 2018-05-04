package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnOil extends Drawable {
	
	public DrawnOil() {
		ImageIcon icon = new ImageIcon("pics/Oil.png"); //kép helye
		setImg(icon.getImage());
		setDepth(2);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}