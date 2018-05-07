package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnWorker extends Drawable {
	private Worker w=new Worker();
	
	public DrawnWorker() throws IOException {
		setImg(ImageIO.read(new File("pics/Worker.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(3);//mélység beállítása
	}	
}