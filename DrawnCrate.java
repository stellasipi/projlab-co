package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DrawnCrate extends Drawable {
	private Crate c;
	
	public DrawnCrate(Crate cr) throws IOException {
		c=cr;
		Integer[] coords = c.getTile().getCoords();
		this.setX(coords[0]);
		this.setY(coords[1]);
		setImg(ImageIO.read(new File("pics/Crate.png"))); // kép beolvasása
		setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
		
		setDepth(3);//mélység beállítása
	}

	@Override
	public void Draw(GameView gv){
		Integer[] coords = c.getTile().getCoords();
		this.setX(coords[0]);
		this.setY(coords[1]);
		gv.setTiles(getX(), getY(), getImg_label());
	}
}