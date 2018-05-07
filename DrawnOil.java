package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnOil extends Drawable {
	private Tile t;
	
	public DrawnOil(Tile t) throws IOException {
		this.t = t;
		
		setImg(ImageIO.read(new File("pics/Oil.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(2));//mélység beállítása
	}

	@Override
	public void Draw(GameView gw) {
		JLayeredPane a = gw.getTiles(t.getCoords()[0], t.getCoords()[1]);
		a.add(getImg_label(),new Integer(2));
		gw.setTiles(t.getCoords()[0], t.getCoords()[1], a);	
		
	}
}