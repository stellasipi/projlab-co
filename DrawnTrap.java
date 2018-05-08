package shokoban;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DrawnTrap extends Drawable {
	private Trap t;
	
	public DrawnTrap(Trap tr) throws IOException {
		this.t = tr;
		CheckObjects();
		
		setDepth(new Integer(1));//mélység beállítása
	}
	
	public void Draw(GameView gw) {
		CheckObjects();
		JPanel a = gw.getTiles(t.getCoords()[0], t.getCoords()[1]);
		a.add(getImg_label());
		gw.setTiles(t.getCoords()[0], t.getCoords()[1], a);
	}

	public void CheckObjects() {
		if(t.getActive()) {
			  try {
					setImg(ImageIO.read(new File("pics/Trap_opened.png")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // kép beolvasása
				  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez 
		}else{	
			  if(t.getObject()==null) {
				  try {
					setImg(ImageIO.read(new File("pics/Trap_closed.png")));// kép beolvasása
				} catch (IOException e) {
					e.printStackTrace();
				}
				  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			  }
			  else if(t.getObject().getClass().getSimpleName().equals("Crate")) {
				  try {
					setImg(ImageIO.read(new File("pics/Crate_on_Trap.png")));// kép beolvasása
				} catch (IOException e) {
					e.printStackTrace();
				}
				  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			  }
			  else if(t.getObject().getClass().getSimpleName().equals("Worker")) {
				  switch(t.getObject().getId()) {
				  case "w1":
					  try {
						setImg(ImageIO.read(new File("pics/Worker_1_on_Trap.png")));
					} catch (IOException e) {
						e.printStackTrace();
					}// kép beolvasása
					  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
					  break;
				  case "w2":
					  try {
						setImg(ImageIO.read(new File("pics/Worker_2_on_Trap.png")));
					} catch (IOException e) {
						e.printStackTrace();
					}// kép beolvasása
					  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
					  break;
				  case "w3":
					  try {
						setImg(ImageIO.read(new File("pics/Worker_3_on_Trap.png")));
					} catch (IOException e) {
						e.printStackTrace();
					}// kép beolvasása
					  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
					  break;
				  case "w4":
					  try {
						setImg(ImageIO.read(new File("pics/Worker_4_on_Trap.png")));
					} catch (IOException e) {
						e.printStackTrace();
					}// kép beolvasása
					  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
					  break;
				  }
			  }
		}
		
	}
		
}