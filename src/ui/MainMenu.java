/*
 * Class MainMenu
 * 	- contains the screen displayed when starting the program.
 * 
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu{

	private Font font = new Font("MONOSPACED", Font.BOLD, 20);
	private JPanel panel = new JPanel();
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	private JTextField player1 = new JTextField(15);
	private JTextField player2 = new JTextField(15);
	private JTextField roundNumber = new JTextField(5);
	public JLabel error = new JLabel();
	
	private boolean player1HasData = false;
	private boolean player2HasData = false;
	private boolean oddNumber = false;
	
	public MainMenu() {
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
	
	public void addOKActionListener(ActionListener actionListener){
		ok.addActionListener(actionListener);
	}
	
	public void addCancelActionListener(ActionListener actionListener){
		cancel.addActionListener(actionListener);
	}
	
	private JPanel addComponentsAbove() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		return panel;
	}
	
	private JPanel addComponentsBelow() {
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(500, 50));
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
		
		panel.add(new JLabel("Player 1 name: "));
		panel.add(player1);
		panel.add(new JLabel("Player 2 name: "));
		panel.add(player2);
		panel.add(new JLabel("Best of: "));
		panel.add(roundNumber);
		panel.add(error);


		return panel;
	}
	
	public void checker(){
		if(player1.getText().equals("")){
			setPlayer1HasData(false);
		}else{
			setPlayer1HasData(true);
		}
		
		if(player2.getText().equals("")){
			setPlayer2HasData(false);
		}else{
			setPlayer2HasData(true);
		}

		if(roundNumber.getText().equals("") || Integer.parseInt(roundNumber.getText()) % 2 == 0){
			setOddNumber(false);
		}else{
			setOddNumber(true);
		}
		
		System.out.println(player1HasData);
		System.out.println(player2HasData);
		System.out.println(oddNumber);
		
	}

	//GETTERS && SETTERS
	
	public boolean isPlayer1HasData() {
		return player1HasData;
	}

	public void setPlayer1HasData(boolean player1HasData) {
		this.player1HasData = player1HasData;
	}

	public boolean isPlayer2HasData() {
		return player2HasData;
	}

	public void setPlayer2HasData(boolean player2HasData) {
		this.player2HasData = player2HasData;
	}

	public boolean isOddNumber() {
		return oddNumber;
	}

	public void setOddNumber(boolean oddNumber) {
		this.oddNumber = oddNumber;
	}
}
