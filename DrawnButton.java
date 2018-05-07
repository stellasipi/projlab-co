package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnButton extends Drawable {
	private Button b;
	
	public DrawnButton(Button button) throws IOException {
		b=button;
		Integer[] coords = b.getCoords();
		this.setX(coords[0]);
		this.setY(coords[1]);
		setImg(ImageIO.read(new File("pics/Button.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}	
}