import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tictactoe {
	private JFrame frame;

	public static void main(String[] args) {
		new Tictactoe();

	}
	
	public Tictactoe(){
		this.frame = new JFrame("Sample");
		this.frame.setPreferredSize(new Dimension(500, 300));
		this.frame.setMinimumSize(new Dimension(500,300));
		
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(addComponentsCenter(), BorderLayout.CENTER);
		container.add(addComponentsAbove(), BorderLayout.NORTH);
		container.add(addComponentsBelow(), BorderLayout.SOUTH);
		container.add(addComponentsEast(), BorderLayout.EAST);
		container.add(addComponentsWest(), BorderLayout.WEST);
		
		
		this.frame.pack();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		
	}
	
	public JPanel addComponentsAbove(){
		JPanel panel = new JPanel();
				
		panel.add(new JButton("yey"));
		
		return panel;
	}
	
	public JPanel addComponentsBelow(){
		JPanel panel = new JPanel();
				
		panel.add(new JButton("yey"));
		
		return panel;
	}
	
	public JPanel addComponentsCenter(){
		int i;
		Dimension dimension = new Dimension(30,30);
		JPanel panel = new JPanel();
		JButton[] button = new JButton[9];
		
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
				
		panel.add(new JButton("yey"));
		
		return panel;
	}
	
	public JPanel addComponentsWest(){
		JPanel panel = new JPanel();
				
		panel.add(new JButton("yey"));
		
		return panel;
	}
	
	

}
