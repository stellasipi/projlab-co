package shokoban;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


public class GameView extends JFrame{
	private JPanel scorePanel = new JPanel();
	private JPanel mapPanel = new JPanel();
	private JLabel[] scorelabels;
	private JLabel keytest = new JLabel("");
	private int playerNumber;
	private Game game;
	ArrayList<Drawable> drawables=new ArrayList<>();
	
	GameView(int playerNumber) throws IOException{
		this.playerNumber = playerNumber;
		game = new Game(playerNumber);
		KeyListener listener = new MyKeyListener(this);
		this.addKeyListener(listener);
		this.setVisible(true);
		this.setTitle("Shokoban");
		this.setSize(new Dimension(1000,1000));
		this.setResizable(true);
		
		this.setLayout(new FlowLayout());
		//mapPanel.setMaximumSize(new Dimension(375,500));
		//mapPanel.setMinimumSize(new Dimension(375,500));
		mapPanel.setLayout(new GridLayout(15,20));
		//mapPanel.setLayout(null);
		this.add(mapPanel);

		this.add(keytest);
		
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
            	new MenuView();
            }
        });
		
		// pályaelemek feltöltése
		for(int i=0; i<15; i++) {
			for(int j=0; j<20; j++) {
				TileElement te = game.map.getTile(i, j);
				String str = te.getClass().getSimpleName();
				
				switch(str) {
				case "Button":
					drawables.add(new DrawnButton((Button)te));
					break;
				case "Coloumn":
					drawables.add(new DrawnColoumn((Coloumn)te));
					break;

				case "Hole":
					drawables.add(new DrawnHole((Hole)te));
					break;
					
				case "Target":
					drawables.add(new DrawnTarget((Target)te));
					break;
					
				case "Tile":
					drawables.add(new DrawnTile((Tile)te));
					break;
					
				case "Trap":
					drawables.add(new DrawnTrap((Trap)te));
					break;
				}
			}
		}
		
		// munkások és ládák hozzáadása
		for(Worker w : game.workers) {
			drawables.add(new DrawnWorker(w));
		}
		for(Crate c : game.crates) {
			drawables.add(new DrawnCrate(c));
		}
		
		Collections.sort(drawables);
		
		this.DrawAll();
		
		this.pack();//no border
	}
	void DrawAll() {
		JLayeredPane[][] tiles =  new JLayeredPane[15][20];
		FlowLayout fl=new FlowLayout();
		fl.setHgap(0); //no border
		fl.setVgap(0);//no border
		for(int i=0; i<15; i++) {
			for(int j=0; j<20; j++) {
				LinkedHashMap<Integer, Image> hashmap = new LinkedHashMap<Integer, Image>();
				for(int k=0; k<drawables.size(); k++) {
					if((j==drawables.get(k).getYy())&(i==drawables.get(k).getXx())) {
						hashmap.put( drawables.get(k).getDepth(), drawables.get(k).getImg());
					}
				}
				tiles[i][j]=new JLayeredPane();
				if(hashmap.containsKey(1)) {
				//JLabel lab1 = new JLabel(new ImageIcon(hashmap.get(1)));
				JLabel lab1 = new JLabel(new ImageIcon("pics/Tile.png"));
				tiles[i][j].add(lab1, new Integer(1));
				tiles[i][j].setBounds(0, 0, 25, 25);
				}
				if(hashmap.containsKey(2)) {
				JLabel lab2 = new JLabel(new ImageIcon(hashmap.get(2)));
					tiles[i][j].add(lab2, new Integer(2));
					tiles[i][j].setBounds(0, 0, 25, 25);
				}
				else {
					JLabel lab2 = new JLabel(new ImageIcon("pics/Oil.png"));
					lab2.setBackground(new Color(0,0,0,0));
					tiles[i][j].add(lab2, new Integer(2));
					tiles[i][j].setBounds(0, 0, 25, 25);
				}
					
				if(hashmap.containsKey(3)) {
					JLabel lab3 = new JLabel(new ImageIcon("pics/Worker_2.png"));
					//lab3 = new JLabel(new ImageIcon(hashmap.get(3)));
					tiles[i][j].add(lab3, new Integer(3));
					tiles[i][j].setBounds(0, 0, 25, 25);
				}
				tiles[i][j].setPreferredSize(new Dimension(25,25));
				tiles[i][j].setLayout(fl);
				mapPanel.add(tiles[i][j]);
			}
		}
		/*for(int i=0; i<drawables.size(); i++) {
			JLabel lab = new JLabel(new ImageIcon(drawables.get(i).getImg()));
			for(int k=0; k<15; k++) {
				for(int j=0; j<20; j++) {
					if((k==drawables.get(i).getYy())&(j==drawables.get(i).getXx())) {
						tiles[k][j].add(lab, drawables.get(i).getDepth());
						tiles[k][j].setBounds(0, 0, 25, 25);
					}
				}
			}
		}
		for(int i=0;i<drawables.size();i++) {
			drawables.get(i).Draw(this);
		}*/
	}
	void AddDrawables(Drawable d) {
		drawables.add(d);
		Collections.sort(drawables);
		for(int i=0;i<drawables.size();i++) {
			System.out.println(drawables.get(i).getDepth()+" "+drawables.get(i).getClass().getSimpleName());
		}
		
	}
	void RemoveDrawables(Drawable d) {
		drawables.remove(d);
	}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	/*public JLayeredPane getTiles(int x, int y) {
		return tiles[x][y];
	}
	public void setTiles(int x, int y, JLayeredPane p) {
		tiles[x][y] = p;
	}*/
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}