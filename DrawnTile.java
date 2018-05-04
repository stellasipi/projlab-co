package shokoban;

import javax.swing.ImageIcon;

public class DrawnTile extends Drawable {
	private Tile t=new Tile();
	
	public DrawnTile() {
		ImageIcon icon = new ImageIcon("pics/Tile.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}

	@Override
	public int compareTo(Drawable o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}