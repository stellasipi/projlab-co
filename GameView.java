package shokoban;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class GameView extends JFrame{
	String jatekosok;
	JLabel jatek = new JLabel();
	GameView(){
		this.setVisible(true);
		this.setTitle("Shokoban");
		this.setSize(new Dimension(400,400));
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.add(jatek);
	}
	void setjatekosok(String a ) {
		jatekosok=a;
	}
}