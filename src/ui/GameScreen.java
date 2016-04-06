/*
 * Class GameScreen
 * 	- contains the screen displayed when starting the game.
 * 
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameScreen {

	private JFrame frame;
	
	public GameScreen() {
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(addComponentsCenter(), BorderLayout.CENTER);
		container.add(addComponentsAbove(), BorderLayout.NORTH);
		container.add(addComponentsBelow(), BorderLayout.SOUTH);
		container.add(addComponentsEast(), BorderLayout.EAST);
		container.add(addComponentsWest(), BorderLayout.WEST);
	}
	
	public JPanel addComponentsAbove(){
		JPanel panel = new JPanel();
				
		panel.setPreferredSize(new Dimension(500, 50));
		
		return panel;
	}
	
	public JPanel addComponentsBelow(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		
		return panel;
	}
	
	public JPanel addComponentsCenter(){
		int i;
		Dimension dimension = new Dimension(30,30);
		JPanel panel = new JPanel();
		JButton[] button = new JButton[9];
		
		panel.setPreferredSize(new Dimension(150, 150));
		panel.setLayout(new GridLayout(3,3));
		
		for(i=0; i < 9; i++){
			button[i] = new JButton();
			button[i].setPreferredSize(dimension);
			panel.add(button[i]);
		}
		
		return panel;
	}
	
	public JPanel addComponentsEast(){
		JPanel panel = new JPanel();
				
		panel.setPreferredSize(new Dimension(100, 300));		
		return panel;
	}
	
	public JPanel addComponentsWest(){
		JPanel panel = new JPanel();
				
		panel.setPreferredSize(new Dimension(100, 300));		
		return panel;
	}

}
