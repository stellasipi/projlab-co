package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DrawnHole extends Drawable {
	private Hole h;
	
	public DrawnHole(Hole hole) throws IOException {
		h=hole;
		CheckObjects();
		
		setImg(ImageIO.read(new File("pics/Hole.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}
	
	public void Draw(GameView gw) {
		CheckObjects();
		JPanel a = gw.getTiles(h.getCoords()[0], h.getCoords()[1]);
		a.add(getImg_label());
		gw.setTiles(h.getCoords()[0], h.getCoords()[1], a);
	}
	
	public void CheckObjects() {
		  try {
			setImg(ImageIO.read(new File("pics/Hole.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // kép beolvasása
		  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez 
	  }
	
}