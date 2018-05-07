package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnButton extends Drawable {
	private Button b;
	
	public DrawnButton(Button button) throws IOException {
		b=button;
		setImg(ImageIO.read(new File("pics/Button.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}
	
	public void Draw(GameView gw) {
		JLayeredPane a = gw.getTiles(b.getCoords()[0], b.getCoords()[1]);
		a.add(getImg_label(),getDepth());
		gw.setTiles(b.getCoords()[0], b.getCoords()[1], a);	
	}
}