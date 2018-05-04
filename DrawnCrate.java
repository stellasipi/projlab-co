package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnCrate extends Drawable {
	private Crate c=new Crate();
	
	public DrawnCrate() throws IOException {
		setImg(ImageIO.read(new File("pics/Crate.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(3);//mélység beállítása
	}

	@Override
	public int compareTo(Drawable o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}