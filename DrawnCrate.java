package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnCrate extends Drawable {
	private Crate c;
	
	public DrawnCrate(Crate cr) throws IOException {
		c=cr;
		setImg(ImageIO.read(new File("pics/Crate.png"))); // kép beolvasása

		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(3));//mélység beállítása
		
		this.setX(c.getTile().getCoords()[0]);
		this.setY(c.getTile().getCoords()[1]);
	}

}