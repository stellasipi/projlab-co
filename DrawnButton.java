package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnButton extends Drawable {
	private Button b=new Button();
	
	public DrawnButton() throws IOException {
		setImg(ImageIO.read(new File("pics/Button.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(1);//mélység beállítása
	}

	@Override
	public int compareTo(Drawable arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}