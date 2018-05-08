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
	private JPanel[][] tiles =  new JPanel[15][20];
	private JPanel scorePanel = new JPanel();
	private JPanel mapPanel=new JPanel();
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
		
		this.setLayout(new FlowLayout());;
		mapPanel.setLayout(new GridLayout(15,20));
		this.add(mapPanel);
		
	    FlowLayout fl=new FlowLayout();
	    fl.setHgap(0); //no border
	    fl.setVgap(0);//no border
	    for(int i=0; i<15; i++) {
	      for(int j=0; j<20; j++) {
	        tiles[i][j]=new JPanel();
	        tiles[i][j].setPreferredSize(new Dimension(25,25));
	        tiles[i][j].setLayout(fl);
	        tiles[i][j].setOpaque(false);
	        mapPanel.add(tiles[i][j]);
	      }
	    }

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
		/*for(Worker w : game.workers) {
			drawables.add(new DrawnWorker(w));
		}
		for(Crate c : game.crates) {
			drawables.add(new DrawnCrate(c));
		}*/
		
		//Collections.sort(drawables);
		
		this.DrawAll();
		
		this.pack();//no border
	}
	void DrawAll() {
		for(int i=0;i<drawables.size();i++) {
			drawables.get(i).Draw(this);
		}
	}
	void AddDrawables(Drawable d) {
		drawables.add(d);
		//Collections.sort(drawables);
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
	public JPanel getTiles(int x, int y) {
		return tiles[x][y];
	}
	public void setTiles(int x, int y, JPanel p) {
		tiles[x][y].equals(p);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}