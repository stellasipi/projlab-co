package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class DrawnWorker extends Drawable {
	private Worker w;
	
	public DrawnWorker(Worker w) throws IOException {
		this.w = w;
		
		String ID = w.getId();
		
		switch(ID) {
		case "w1":
			setImg(ImageIO.read(new File("pics/Worker_1.png"))); // kép beolvasása
			//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			break;
		case "w2":
			setImg(ImageIO.read(new File("pics/Worker_2.png"))); // kép beolvasása
			//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			break;
		case "w3":
			setImg(ImageIO.read(new File("pics/Worker_3.png"))); // kép beolvasása
			//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			break;
		case "w4":
			setImg(ImageIO.read(new File("pics/Worker_4.png"))); // kép beolvasása
			//setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			break;
		}
		
		this.setIcon(new ImageIcon(getImg()));
		
		setDepth(new Integer(3));//mélység beállítása
		
		this.setX(w.getTile().getCoords()[0]);
		this.setY(w.getTile().getCoords()[1]);
	}

	@Override
	public void refresh() {
		Integer[] temp = w.getTile().getCoords();
		this.setX(temp[0]);
		this.setY(temp[1]);
	}

	public String getWorkerId() {
		return w.getId();
	}	
	
}