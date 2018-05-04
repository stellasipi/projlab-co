package shokoban;

import javax.swing.ImageIcon;

public class DrawnOil extends Drawable {
	private Tile t=new Tile();
	
	public DrawnOil() {
		ImageIcon icon = new ImageIcon("pics/Oil.png"); //kép helye
		setImg(icon.getImage());
		setDepth(2);
	}
	
	public void Draw() {
		
	}

	@Override
	public int compareTo(Drawable o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}