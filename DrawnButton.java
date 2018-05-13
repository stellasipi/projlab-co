package shokoban;

import java.awt.Component;
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
		
		//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
				
		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(1));//mélység beállítása
		
		this.setX(b.getCoords()[0]);
		this.setY(b.getCoords()[1]);
	}

	@Override
	public void refresh() {
		/*
		Integer[] temp = b.getCoords();
		this.setX(temp[0]);
		this.setY(temp[1]);
		 */	
	}
}