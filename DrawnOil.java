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
		//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		this.setIcon(new ImageIcon(getImg()));

		setDepth(new Integer(2));//mélység beállítása
		
		this.setX(t.getCoords()[0]);
		this.setY(t.getCoords()[1]);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

}