package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnHoney extends Drawable {
	private Tile t;
	
	public DrawnHoney(Tile t) throws IOException {
		this.t =t;
		Integer[] coords = t.getCoords();
		this.setX(coords[0]);
		this.setY(coords[1]);
		setImg(ImageIO.read(new File("pics/Honey.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(2);//mélység beállítása
	}
}