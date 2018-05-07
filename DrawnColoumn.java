package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnColoumn extends Drawable {
	private Coloumn c;
	
	public DrawnColoumn(Coloumn col) throws IOException {
		c=col;
		setImg(ImageIO.read(new File("pics/Coloumn.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}
	
	public void Draw(GameView gw) {
		JLayeredPane a = gw.getTiles(c.getCoords()[0], c.getCoords()[1]);
		a.add(getImg_label(),getDepth());
		gw.setTiles(c.getCoords()[0], c.getCoords()[1], a);	
	}
}