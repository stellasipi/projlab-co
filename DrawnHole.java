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
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}
	
	public JLabel Draw(GameView gw) {
		/*JLayeredPane a = gw.getTiles(h.getCoords()[0], h.getCoords()[1]);
		a.add(getImg_label(),new Integer(1));
		gw.setTiles(h.getCoords()[0], h.getCoords()[1], a);	*/
		return img_label;
	}
	
}