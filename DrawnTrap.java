package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnTrap extends Drawable {
	private Trap t;
	
	public DrawnTrap(Trap tr) throws IOException {
		this.t = tr;
		
		if(t.getActive()) {
			setImg(ImageIO.read(new File("pics/Trap_opened.png"))); // kép beolvasása
		}else {
			setImg(ImageIO.read(new File("pics/Trap_closed.png"))); // kép beolvasása			
		}
		
		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(1));//mélység beállítása
		Integer[] temp = t.getCoords();
		this.setX(temp[0]);
		this.setY(temp[1]);
	}

	@Override
	public void refresh() {
		Integer[] temp = t.getCoords();
		this.setX(temp[0]);
		this.setY(temp[1]);
		if(t.getActive()) {
			try {
				setImg(ImageIO.read(new File("pics/Trap_opened.png")));
			} catch (IOException e) {
				e.printStackTrace();
			} // kép beolvasása
		}else {
			try {
				setImg(ImageIO.read(new File("pics/Trap_closed.png")));
			} catch (IOException e) {
				e.printStackTrace();
			} // kép beolvasása			
		}
	}

}