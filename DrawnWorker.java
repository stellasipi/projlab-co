package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnWorker extends Drawable {
	
	public DrawnWorker() {
		ImageIcon icon = new ImageIcon("pics/Worker.png"); //kép helye
		setImg(icon.getImage());
		setDepth(3);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}