package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnHole extends Drawable {
	private Hole h;
	
	public DrawnHole(Hole hole) throws IOException {
		h=hole;

		setImg(ImageIO.read(new File("pics/Hole.png"))); // kép beolvasása

		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(1));//mélység beállítása
		
		this.setX(h.getCoords()[0]);
		this.setY(h.getCoords()[1]);
	}

}