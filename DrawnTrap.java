package shokoban;

import javax.swing.ImageIcon;

public class DrawnTrap extends Drawable {
	private Trap t=new Trap();
	
	public DrawnTrap() {
		ImageIcon icon = new ImageIcon("pics/Trap.png"); //kép helye
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