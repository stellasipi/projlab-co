package shokoban;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GameView extends JFrame{
	private JPanel[][] tiles =  new JPanel[20][15];
	private JPanel scorePanel = new JPanel();
	private JPanel mapPanel = new JPanel();
	private JLabel proba = new JLabel("Proba");
	private JLabel[] scorelabels;
	int playerNumber;
	ArrayList<Drawable> drawables;
	GameView(){
		//KeyListener listener = new MyKeyListener();
		this.setVisible(true);
		this.setTitle("Shokoban");
		this.setSize(new Dimension(400,400));
		this.setResizable(true);
		this.setLayout(new FlowLayout());
		mapPanel.setBackground(Color.red);
		mapPanel.setSize(200,150);
		mapPanel.setLayout(new GridLayout(20,15));
		this.add(mapPanel);
		for(int i=0; i<20; i++) {
			for(int j=0; j<15; j++) {
				tiles[i][j]=new JPanel();
				mapPanel.add(tiles[i][j]);
				tiles[i][j].setBackground(Color.blue);
				tiles[i][j].setSize(1,1);
			}
		}
		this.add(proba);
	}
	void DrawAll() {
		
	}
	void AddDrawables() {}
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
}