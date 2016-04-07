/*
 * Class GameScreen
 * 	- contains the screen displayed when starting the game.
 * 
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class GameScreen {
	
	JPanel panel = new JPanel();
	JButton back = new JButton("Back");
	
	public GameScreen() {
		panel.setLayout(new BorderLayout());
		panel.add(addComponentsCenter(), BorderLayout.CENTER);
		panel.add(addComponentsAbove(), BorderLayout.NORTH);
		panel.add(addComponentsBelow(), BorderLayout.SOUTH);
		panel.add(addComponentsEast(), BorderLayout.EAST);
		panel.add(addComponentsWest(), BorderLayout.WEST);
	}
	
	public JComponent getMainComponent(){
		return panel;
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
			button[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					((JButton)e.getSource()).setText("X");
				}			
			});
			button[i].setName(Integer.toString(i));
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
