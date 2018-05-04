package shokoban;

import javax.swing.ImageIcon;

public class DrawnCrate extends Drawable {
	private Crate c=new Crate();
	
	public DrawnCrate() {
		ImageIcon icon = new ImageIcon("pics/Crate.png"); //kép helye
		setImg(icon.getImage());
		setDepth(3);
	}
	
	public void Draw() {
		
	}

	@Override
	public int compareTo(Drawable o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}