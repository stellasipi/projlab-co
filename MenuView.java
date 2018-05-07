package shokoban;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

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
			try {
				GameStart(Integer.parseInt(playerNumberTextfield.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
	}
	void GameStart(int vm) throws IOException{
			GameView gamev = new GameView(vm);
			this.setVisible(false);
	}	
}