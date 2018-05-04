package shokoban;

import javax.swing.ImageIcon;

public class DrawnButton extends Drawable {
	private Button b=new Button();
	
	public DrawnButton() {
		ImageIcon icon = new ImageIcon("pics/Button.png"); //kép helye
		setImg(icon.getImage());
		setDepth(1);
	}
	
	public void Draw() {
		
	}
	

	@Override
	public int compareTo(Drawable arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}