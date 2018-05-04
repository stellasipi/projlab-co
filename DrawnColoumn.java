package shokoban;

import javax.swing.ImageIcon;

public class DrawnColoumn extends Drawable {
	private Coloumn c=new Coloumn();
	
	public DrawnColoumn() {
		ImageIcon icon = new ImageIcon("pics/Coloumn.png"); //kép helye
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