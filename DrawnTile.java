﻿package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnTile extends Drawable {
	private Tile t;
	
	public DrawnTile(Tile t) throws IOException {
		this.t = t;

		setImg(ImageIO.read(new File("pics/Tile.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(new Integer(1));//mélység beállítása
	}
	public void Draw(GameView gw) {
		JLayeredPane a = gw.getTiles(t.getCoords()[0], t.getCoords()[1]);
		a.add(getImg_label(),getDepth());
		gw.setTiles(t.getCoords()[0], t.getCoords()[1], a);	
	}
}