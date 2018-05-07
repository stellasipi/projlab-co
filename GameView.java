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
	private JPanel[][] tiles =  new JPanel[20][15];
	private JPanel scorePanel = new JPanel();
	private JPanel mapPanel = new JPanel();
	private JLabel proba = new JLabel("Proba");
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
		mapPanel.setBackground(Color.red);
		mapPanel.setMaximumSize(new Dimension(500,375));
		mapPanel.setMinimumSize(new Dimension(500,375));
		GridLayout gl = new GridLayout(20,15);
		/*gl.setHgap(1);
		gl.setVgap(1);*/
		Border border;
		border = BorderFactory.createLineBorder(Color.cyan);
		mapPanel.setLayout(gl);
		this.add(mapPanel);
		for(int i=0; i<20; i++) {
			for(int j=0; j<15; j++) {
				tiles[i][j]=new JPanel();
				mapPanel.add(tiles[i][j]);
				tiles[i][j].setBackground(Color.blue);
				tiles[i][j].setMaximumSize(new Dimension(25,25));
				tiles[i][j].setMinimumSize(new Dimension(25,25));
				//tiles[i][j].setBorder(border);
				
			}
		}
		this.add(proba);
		this.add(keytest);
		
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
            	new MenuView();
            }
        });
		
		//Ide létrehozhatjáktok a minipályát
		/*AddDrawables(new DrawnColoumn());
		DrawAll();*/
		Image img=ImageIO.read(new File("pics/Button.png"));
		JLabel label=new JLabel(new ImageIcon(img));
		label.setBackground(Color.red);
		tiles[0][0].add(label);
		
		Image img1=ImageIO.read(new File("pics/Coloumn.png"));
		JLabel label1=new JLabel(new ImageIcon(img1));
		tiles[0][1].add(label1);
		
		Image img2=ImageIO.read(new File("pics/Crate.png"));
		JLabel label2=new JLabel(new ImageIcon(img2));
		tiles[0][2].add(label2);
		
		Image img3=ImageIO.read(new File("pics/Hole.png"));
		JLabel label3=new JLabel(new ImageIcon(img3));
		tiles[0][3].add(label3);
		
		Image img4=ImageIO.read(new File("pics/Honey.png"));
		JLabel label4=new JLabel(new ImageIcon(img4));
		tiles[0][4].add(label4);
		
		Image img5=ImageIO.read(new File("pics/Oil.png"));
		JLabel label5=new JLabel(new ImageIcon(img5));
		label5.setSize(25,25);
		tiles[0][5].add(label5);
		
		Image img6=ImageIO.read(new File("pics/Target.png"));
		JLabel label6=new JLabel(new ImageIcon(img6));
		tiles[0][6].add(label6);
		
		Image img7=ImageIO.read(new File("pics/Tile.png"));
		JLabel label7=new JLabel(new ImageIcon(img7));
		tiles[0][7].add(label7);
		
		Image img8=ImageIO.read(new File("pics/Trap_closed.png"));
		JLabel label8=new JLabel(new ImageIcon(img8));
		label8.setSize(25,25);
		tiles[0][8].add(label8);
		
		Image img9=ImageIO.read(new File("pics/Worker_1.png"));
		JLabel label9=new JLabel(new ImageIcon(img9));
		tiles[0][9].add(label9);
		this.pack();//no border
	}
	void DrawAll() {
		for(int i=0;i<drawables.size();i++) {
			drawables.get(i).Draw(this);
		}
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
	public JPanel getTiles(int x, int y) {
		return tiles[x][y];
	}
	public void setTiles(int x, int y, JLabel comp) {
		tiles[x][y].add(comp);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}