package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnHoney extends Drawable {
	private Tile t;
	
	public DrawnHoney(Tile t) throws IOException {
		this.t =t;
		
		setImg(ImageIO.read(new File("pics/Honey.png"))); // kép beolvasása

		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(2));//mélység beállítása
		
		this.setX(t.getCoords()[0]);
		this.setY(t.getCoords()[1]);
		
	}

}