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
		
		this.setXx(c.getCoords()[0]);
		this.setYy(c.getCoords()[1]);
	}
	
	/*public void Draw(GameView gw) {
		JLayeredPane a = gw.getTiles(c.getCoords()[0], c.getCoords()[1]);
		a.add(getImg_label(), new Integer(1));
		a.setBounds(0, 0, 25, 25);
		gw.setTiles(c.getCoords()[0], c.getCoords()[1], a);
	}*/
}