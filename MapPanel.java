package shokoban;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel extends JPanel {
	public static int height = 15 * 25;
	public static int width = 20 * 25;
	public static int tileSize = 25;
	public GameView parent;
	
	public MapPanel(GameView gv) {
		this.parent = gv;
		this.setSize(width, height);
		this.setLayout(null);
		
		//színezés
		Draw();
		
		
	}
	
	private void DrawAll() {
		while(true) {
			Draw();
		}
	}
	
	private void Draw() {
		for(Drawable d : parent.drawables) {
			JLabel temp = d.getImg_label();
			temp.setSize(25, 25);
			temp.setLocation(d.getYy()*25, d.getXx()*25);
			temp.setVisible(true);
			this.add(temp);
		}
	}
}
