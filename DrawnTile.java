package shokoban;

import javax.swing.ImageIcon;

public abstract class DrawnTile extends Drawable {
	
	public DrawnTile() {
		ImageIcon icon = new ImageIcon("pics/Tile.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	
	public void CompareTo() {
		
	}
	
}