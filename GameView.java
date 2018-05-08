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

import shokoban.Button;


public class GameView extends JFrame{
	private JPanel scorePanel = new JPanel();
	private JPanel mapPanel;
	private JLabel[] scorelabels;
	private JLabel keytest = new JLabel("");
	private int playerNumber;
	private Game game;
	ArrayList<Drawable> drawables=new ArrayList<>();
	
	GameView(int playerNumber) throws IOException{
		this.playerNumber = playerNumber;
		
		// window properties
		this.setResizable(false);
		this.setSize(516,514);
		this.setVisible(true);
		this.setTitle("Shokoban");
		
		
		scorePanel.setSize(500,100);
		scorePanel.setBackground(Color.green);
		scorePanel.setLocation(0, 0);
		
		// listeners
		this.addKeyListener(new MyKeyListener(this));
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
            	new MenuView();
            }
        });
		
		// pályaelemek feltöltése
		InitGame();
		
		// valahogy kirajzolunk
		mapPanel = new MapPanel(this);
		this.add(scorePanel);
		mapPanel.setLocation(0,100);
		this.add(mapPanel);
		
	}
	public void DrawAll2() {
		drawables = new ArrayList<Drawable>();
		try {
			FillDrawables();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.remove(mapPanel);
		mapPanel = new MapPanel(this);
		mapPanel.setLocation(0,100);
		this.add(mapPanel);
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
				//tiles[i][j].add(lab1, JLayeredPane.DEFAULT_LAYER);
				tiles[i][j].setBounds(0, 0, 25, 25);
				}
				if(hashmap.containsKey(2)) {
				JLabel lab2 = new JLabel(new ImageIcon(hashmap.get(2)));
					tiles[i][j].add(lab2, new Integer(2));
					//tiles[i][j].add(lab2, JLayeredPane.PALETTE_LAYER);
					tiles[i][j].setBounds(0, 0, 25, 25);
				}
				else {
					JLabel lab2 = new JLabel(new ImageIcon("pics/Oil.png"));
					lab2.setBackground(new Color(0,0,0,0));
					tiles[i][j].add(lab2, new Integer(2));
					//tiles[i][j].add(lab2, JLayeredPane.PALETTE_LAYER);
					tiles[i][j].setBounds(0, 0, 25, 25);
				}
					
				if(hashmap.containsKey(3)) {
					JLabel lab3 = new JLabel(new ImageIcon("pics/Worker_2.png"));
					//lab3 = new JLabel(new ImageIcon(hashmap.get(3)));
					//tiles[i][j].add(lab3, new Integer(3));
					tiles[i][j].add(lab3, JLayeredPane.MODAL_LAYER);
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
		
	}
	void RemoveDrawables(Drawable d) {
		drawables.remove(d);
	}

	private void InitGame() {
		this.game = new Game(this.playerNumber);
		try {
			FillDrawables();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("input fuckup");
		}
	}
	private void FillDrawables() throws IOException {
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
					if(((Tile)te).SumGreaseMu()>0){
						drawables.add(new DrawnHoney((Tile)te));
					}else if(((Tile)te).SumGreaseMu()<0) {
						drawables.add(new DrawnOil((Tile)te));
					}
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
		
		SortDrawables();
	}
	
	public void SortDrawables() {
		Collections.sort(drawables, new Comparator<Drawable>() {

			@Override
			public int compare(Drawable d1, Drawable d2) {
				if(d1.getDepth()<d2.getDepth()) {
					return 1;
				}else if(d1.getDepth()>d2.getDepth()) {
					return -1;
				}else {
					return 0;
				}
			}
			
		});
	}
	
	// get/set-ers
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}