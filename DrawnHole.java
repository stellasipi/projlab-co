﻿package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnHole extends Drawable {
	private Hole h;
	
	public DrawnHole(Hole hole) throws IOException {
		h=hole;
		setImg(ImageIO.read(new File("pics/Hole.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(1);//mélység beállítása
	}
}