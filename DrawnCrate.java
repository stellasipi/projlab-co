/*package shokoban;
 
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
 
public class DrawnCrate extends Drawable {
  private Crate c;
  
  public DrawnCrate(Crate cr) throws IOException {
    c=cr;
    setImg(ImageIO.read(new File("pics/Crate.png"))); // kép beolvasása
    setImg_label(new JLabel(new ImageIcon(getImg()))); // így már egy komponens és majd hozzá tudjuk adni a mapPanel-hez
    
    setDepth(new Integer(3));//mélység beállítása
  }
 
  public void Draw(GameView gw) {
    JPanel a = gw.getTiles(c.getTile().getCoords()[0], c.getTile().getCoords()[1]);
    a.add(getImg_label());
    gw.setTiles(c.getTile().getCoords()[0], c.getTile().getCoords()[1], a);
  }
}*/