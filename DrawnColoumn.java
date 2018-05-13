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
		//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez		
		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(1));//mélység beállítása
		
		this.setX(c.getCoords()[0]);
		this.setY(c.getCoords()[1]);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}