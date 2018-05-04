package shokoban;

import javax.swing.ImageIcon;

public class DrawnTarget extends Drawable {
	private Target t=new Target();
	
	public DrawnTarget() {
		ImageIcon icon = new ImageIcon("pics/Target.png"); //kép helye
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