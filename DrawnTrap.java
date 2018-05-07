package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnTrap extends Drawable {
	private Trap t;
	
	public DrawnTrap(Trap tr) throws IOException {
		this.t = tr;
		Integer[] coords = t.getCoords();
		this.setX(coords[0]);
		this.setY(coords[1]);
		
		if(t.getActive()) {
			setImg(ImageIO.read(new File("pics/Trap_opened.png"))); // kép beolvasása
			setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		}else {
			setImg(ImageIO.read(new File("pics/Trap_closed.png"))); // kép beolvasása
			setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez			
		}
		
		setDepth(1);//mélység beállítása
	}	
}