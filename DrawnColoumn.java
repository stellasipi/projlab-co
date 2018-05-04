package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnColoumn extends Drawable {
	private Coloumn c=new Coloumn();
	
	public DrawnColoumn() throws IOException {
		setImg(ImageIO.read(new File("pics/Coloumn.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(1);//mélység beállítása
	}

	@Override
	public int compareTo(Drawable o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}