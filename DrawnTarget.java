package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnTarget extends Drawable {
	private Target t;
	
	public DrawnTarget(Target ta) throws IOException {
		this.t = ta;
		
		setImg(ImageIO.read(new File("pics/Target.png"))); // kép beolvasása

		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(1));//mélység beállítása
		this.setX(t.getCoords()[0]);
		this.setY(t.getCoords()[1]);
	}

}