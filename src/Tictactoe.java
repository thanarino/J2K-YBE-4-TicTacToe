/*
 * Class TicTacToe
 * 	- contains the main method
 * 
 */

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import ui.MainMenu;

public class Tictactoe {
	private JFrame frame;
	private static Dimension dimension = new Dimension(500, 300);

	public static void main(String[] args) {
		new Tictactoe();

	}
	
	public Tictactoe(){
		this.frame = new JFrame("TicTacToe");
		this.frame.setPreferredSize(dimension);
		this.frame.setMinimumSize(dimension);
		
		Container container = frame.getContentPane();
		
		new MainMenu(container);
		
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
	}
	
	
	
	

}
