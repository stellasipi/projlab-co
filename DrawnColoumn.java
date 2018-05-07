package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnColoumn extends Drawable {
	private Coloumn c;
	
	public DrawnColoumn(Coloumn col) throws IOException {
		c=col;
		Integer[] coords = c.getCoords();
		this.setX(coords[0]);
		this.setY(coords[1]);
		setImg(ImageIO.read(new File("pics/Coloumn.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}
}