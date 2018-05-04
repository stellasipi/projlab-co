package shokoban;

import javax.swing.ImageIcon;

public class DrawnHole extends Drawable {
	private Hole h=new Hole();
	
	public DrawnHole() {
		ImageIcon icon = new ImageIcon("pics/Hole.png"); //kép helye
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