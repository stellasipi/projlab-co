package shokoban;

import javax.swing.ImageIcon;

public class DrawnWorker extends Drawable {
	private Worker w=new Worker();
	
	public DrawnWorker() {
		ImageIcon icon = new ImageIcon("pics/Worker.png"); //kép helye
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