package shokoban;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MenuView extends JFrame {
	JButton newgame = new JButton("Új játék");
	JLabel playerNumberLabel = new JLabel("Player number");
	JTextField playerNumberTextfield = new JTextField(20);
	MenuView(){
		this.setVisible(true);
		this.setTitle("Shokoban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(400,400));
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.add(playerNumberLabel);
		this.add(playerNumberTextfield);
		this.add(newgame);
		newgame.addActionListener((ActionEvent e)->{
			GameStart(Integer.parseInt(playerNumberTextfield.getText()));});
	}
	void GameStart(int vm){
			GameView gamev = new GameView();
			gamev.setPlayerNumber(vm);
			
			//test
			Game g=new Game();
			
	}	
}