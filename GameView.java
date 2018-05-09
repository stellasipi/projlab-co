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
	private int playerNumber;
	private Game game;
	private JLabel lab1 = new JLabel("Worker1 score: ");
	private JLabel lab2 = new JLabel("Worker2 score: ");
	private	JLabel lab3 = new JLabel("Worker3 score: ");
	private JLabel lab4 = new JLabel("Worker4 score: ");
	ArrayList<Drawable> drawables=new ArrayList<>();
	
	GameView(int pn) throws IOException{
		
		//Alapbeállítások
		this.playerNumber = pn;
		InitGame(); // pályaelemek feltöltése
		
		// listeners
		this.addKeyListener(new MyKeyListener(this));
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
            	new MenuView();
            }
        });
		
		//mapPanel beállítása
		mapPanel = new MapPanel(this);
		
		//scorePanel beállítása
		scorePanel.setLocation(0,375);		
		scorePanel.setSize(500,100);
		scorePanel.setBackground(new Color(236, 224, 194));
		lab1.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 16));
		lab1.setForeground(new Color(88,62,24));
		lab2.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 16));
		lab2.setForeground(new Color(88,62,24));
		lab3.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 16));
		lab3.setForeground(new Color(88,62,24));
		lab4.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 16));
		lab4.setForeground(new Color(88,62,24));
		InitscorePanel();
		
		
		// window properties
		this.setResizable(false);
		this.setSize(516,514);
		this.setVisible(true);
		this.setTitle("Shokoban");
		this.add(scorePanel);
		this.add(mapPanel);
		
	}
	
	public void InitscorePanel() {
		switch(playerNumber) {
		case 2:
			scorePanel.setLayout(new GridLayout(1,2));
			scorePanel.add(lab1);
			scorePanel.add(lab2);
			if(game.getWorker("w1")!=null)
				lab1.setText("Worker1 score: " + game.getWorker("w1").getSumscore());
			else
				lab1.setText("Worker1: died");
			if(game.getWorker("w2")!=null)
				lab2.setText("Worker2 score: " + game.getWorker("w2").getSumscore());
			else
				lab2.setText("Worker2: died");
			break;
		case 3:
			scorePanel.setLayout(new GridLayout(2,2));
			scorePanel.add(lab1);
			scorePanel.add(lab2);
			scorePanel.add(lab3);
			if(game.getWorker("w1")!=null)
				lab1.setText("Worker1 score: " + game.getWorker("w1").getSumscore());
			else
				lab1.setText("Worker1: died");
			if(game.getWorker("w2")!=null)
				lab2.setText("Worker2 score: " + game.getWorker("w2").getSumscore());
			else
				lab2.setText("Worker2: died");
			if(game.getWorker("w3")!=null)
				lab3.setText("Worker3 score: " + game.getWorker("w3").getSumscore());
			else
				lab3.setText("Worker3: died");
			break;
		case 4:
			scorePanel.setLayout(new GridLayout(2,2));
			scorePanel.add(lab1);
			scorePanel.add(lab2);
			scorePanel.add(lab3);
			scorePanel.add(lab4);
			if(game.getWorker("w1")!=null)
				lab1.setText("Worker1 score: " + game.getWorker("w1").getSumscore());
			else
				lab1.setText("Worker1: died");
			if(game.getWorker("w2")!=null)
				lab2.setText("Worker2 score: " + game.getWorker("w2").getSumscore());
			else
				lab2.setText("Worker2: died");
			if(game.getWorker("w3")!=null)
				lab3.setText("Worker3 score: " + game.getWorker("w3").getSumscore());
			else
				lab3.setText("Worker3: died");
			if(game.getWorker("w4")!=null)
				lab4.setText("Worker4 score: " + game.getWorker("w4").getSumscore());
			else
				lab4.setText("Worker4: died");
			break;
			}
	}
	
	public void DrawAll() {
		drawables = new ArrayList<Drawable>();
		try {
			FillDrawables();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.remove(mapPanel);
		mapPanel = new MapPanel(this);
		this.add(mapPanel);
		InitscorePanel();
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
			System.out.println("Az inputbeolvasás nem működött helyesen.");
		}
	}
	private void FillDrawables() throws IOException { //drawables adattag feltöltése a játék logikából
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
	
	public void SortDrawables() {//mélység szerinti rendezés
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