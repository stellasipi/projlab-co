package shokoban;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GameView extends JFrame{
	private JPanel[][] tiles;
	private JPanel scorePanel;
	private JPanel mapPanel;
	private JLabel[] scorelabels;
	int playerNumber;
	ArrayList<Drawable> drawables;
	GameView(){
		this.setVisible(true);
		this.setTitle("Shokoban");
		this.setSize(new Dimension(400,400));
		this.setResizable(false);
		this.setLayout(new FlowLayout());
	}
	void DrawAll() {}
	void AddDrawables() {}
	void RemoveDrawables() {}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
}