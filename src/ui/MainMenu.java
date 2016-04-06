/*
 * Class MainMenu
 * 	- contains the screen displayed when starting the program.
 * 
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu {

	Font font = new Font("MONOSPACED", Font.BOLD, 20);
	
	public MainMenu(Container container) {
		
		container.setLayout(new BorderLayout());
		container.add(addComponentsCenter(), BorderLayout.CENTER);
		container.add(addComponentsAbove(), BorderLayout.NORTH);
		container.add(addComponentsBelow(), BorderLayout.SOUTH);
		container.add(addComponentsEast(), BorderLayout.EAST);
		container.add(addComponentsWest(), BorderLayout.WEST);
	}
	
	private JPanel addComponentsAbove() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		return panel;
	}
	
	private JPanel addComponentsBelow() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		JButton ok = new JButton("OK");
		JButton cancel = new JButton("Cancel");
		panel.add(ok);
		panel.add(cancel);
		return panel;
	}
	
	private JPanel addComponentsEast() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 300));
		return panel;
	}
	
	private JPanel addComponentsWest() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 300));
		return panel;
	}

	public JPanel addComponentsCenter(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		
		JLabel title = new JLabel("WELCOME TO TICTACTOE!");
		title.setFont(font);
		panel.add(title);
		
		JTextField player1 = new JTextField("Enter here", 15);
		JTextField player2 = new JTextField("Enter here", 15);
		
		panel.add(new JLabel("Player 1 name: "));
		panel.add(player1);
		panel.add(new JLabel("Player 2 name: "));
		panel.add(player2);
		return panel;
	}

}
