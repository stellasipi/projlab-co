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
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
		
		this.setXx(b.getCoords()[0]);
		this.setYy(b.getCoords()[1]);
	}
	
	/*public void Draw(GameView gw) {
		JLayeredPane a = gw.getTiles(b.getCoords()[0], b.getCoords()[1]);
		a.add(getImg_label(), new Integer(1));
		a.setBounds(0, 0, 25, 25);
		gw.setTiles(b.getCoords()[0], b.getCoords()[1], a);
		
		Component comps1[] = gw.getTiles(b.getCoords()[0], b.getCoords()[1]).getComponentsInLayer(1);
		Component comps2[] = gw.getTiles(b.getCoords()[0], b.getCoords()[1]).getComponentsInLayer(2);
		Component comps3[] = gw.getTiles(b.getCoords()[0], b.getCoords()[1]).getComponentsInLayer(3);
		JLayeredPane a = new JLayeredPane();
		for(int i=0; i<comps1.length; i++) {
			a.add(comps1[i], new Integer(1));
			a.setBounds(0, 0, 25, 25);
		}
		for(int i=0; i<comps2.length; i++) {
			a.add(comps2[i], new Integer(2));
			a.setBounds(0, 0, 25, 25);
		}
		for(int i=0; i<comps3.length; i++) {
			a.add(comps3[i], new Integer(3));
			a.setBounds(0, 0, 25, 25);
		}
		a.add(getImg_label(), new Integer(1));
		a.setBounds(0, 0, 25, 25);
		gw.setTiles(b.getCoords()[0], b.getCoords()[1], a);
	}*/
}