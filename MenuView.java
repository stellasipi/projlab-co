package shokoban;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.*;

public class MenuView extends JFrame {
	JPanel base = new JPanel();
	JButton newgame = new JButton("New Game");
	JLabel titleLabel = new JLabel("Shokoban");
	JLabel playerNumberLabel = new JLabel("Player number");
	JComboBox<String> comboPlayerNum = new JComboBox<String>();
	MenuView(){
		
		//Title beállítása
		titleLabel.setFont(new Font("Vineta BT", Font.PLAIN, 40));
		titleLabel.setForeground(new Color(150,4,4));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setVerticalAlignment(SwingConstants.CENTER);

		//PlayerNumber beállítása
		playerNumberLabel.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 16));
		playerNumberLabel.setForeground(new Color(88,62,24));
		comboPlayerNum.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 12));
		comboPlayerNum.setForeground(new Color(88,62,24));
		comboPlayerNum.setBackground(new Color(236, 224, 194));
		comboPlayerNum.addItem("2");
		comboPlayerNum.addItem("3");
		comboPlayerNum.addItem("4");
		
		//NewGame button beállítása
		newgame.setFont(new Font("Adobe Fan Heiti Std B", Font.BOLD, 20));
		newgame.setForeground(new Color(150,4,4));
		newgame.setBackground(new Color(236, 224, 194));
		newgame.addActionListener((ActionEvent e)->{
			try {
				GameStart(Integer.parseInt((String) comboPlayerNum.getSelectedItem()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
		
		//Frame beállítása
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400, 400);
		this.setResizable(false);
		base.setBackground(new Color(216, 190, 126));
		this.add(base);
		base.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		base.add(titleLabel, c);
		c.gridy = 1;
		c.insets = new Insets(60,0,0,0);
		base.add(playerNumberLabel, c);
		c.gridy = 2;
		c.insets = new Insets(10,0,0,0);
		base.add(comboPlayerNum, c);
		c.gridy = 3;
		c.insets = new Insets(50,0,0,0);
		base.add(newgame, c);
	}
	void GameStart(int vm) throws IOException{
			GameView gamev = new GameView(vm);
			this.setVisible(false);
	}	
}