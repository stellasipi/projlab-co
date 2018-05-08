package shokoban;
 
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
 
public class DrawnButton extends Drawable {
  private Button b;
  
  public DrawnButton(Button button) throws IOException {
	  b=button;
	  
	  CheckObjects();
	  
	  setDepth(new Integer(1));//mélység beállítása
  }
  
  public void Draw(GameView gw) {
	  CheckObjects();
	  JPanel a = gw.getTiles(b.getCoords()[0], b.getCoords()[1]);
	  a.add(getImg_label());
	  gw.setTiles(b.getCoords()[0], b.getCoords()[1], a);
	  }

  public void CheckObjects() {
	  if(b.getObject()==null) {
		  try {
			setImg(ImageIO.read(new File("pics/Button.png")));// kép beolvasása
		} catch (IOException e) {
			e.printStackTrace();
		}
		  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
	  }
	  else if(b.getObject().getClass().getSimpleName().equals("Crate")) {
		  try {
			setImg(ImageIO.read(new File("pics/Crate_on_Button.png")));// kép beolvasása
		} catch (IOException e) {
			e.printStackTrace();
		}
		  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
	  }
	  else if(b.getObject().getClass().getSimpleName().equals("Worker")) {
		  switch(b.getObject().getId()) {
		  case "w1":
			  try {
				setImg(ImageIO.read(new File("pics/Worker_1_on_Button.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}// kép beolvasása
			  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			  break;
		  case "w2":
			  try {
				setImg(ImageIO.read(new File("pics/Worker_2_on_Button.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}// kép beolvasása
			  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			  break;
		  case "w3":
			  try {
				setImg(ImageIO.read(new File("pics/Worker_3_on_Button.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}// kép beolvasása
			  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			  break;
		  case "w4":
			  try {
				setImg(ImageIO.read(new File("pics/Worker_4_on_Button.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}// kép beolvasása
			  setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
			  break;
		  }
	  }
  }
}