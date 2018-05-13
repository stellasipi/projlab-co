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
				
		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(1));//mélység beállítása
		
		this.setX(b.getCoords()[0]);
		this.setY(b.getCoords()[1]);
	}

}