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
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import algo.Player;

public class GameScreen extends MainMenu implements ActionListener{
	
	JPanel panel = new JPanel();
	JButton back = new JButton("Back");
	private JLabel player1 = new JLabel("",JLabel.CENTER);
	JLabel player2 = new JLabel("",JLabel.CENTER);
	JLabel gameStatus = new JLabel("", JLabel.CENTER);
	JLabel turnStatus = new JLabel("", JLabel.CENTER);
	JButton[] button = new JButton[9];
	int playerOMoveCount = 0;
	int playerXMoveCount = 0;
	int turnCount = 0;
	Player currentPlayer;
	String letter;
	
	public GameScreen(Player playerX, Player playerO, int roundNumber) {
		panel.setLayout(new BorderLayout());
		panel.add(addComponentsCenter(button), BorderLayout.CENTER);
		panel.add(addComponentsAbove(), BorderLayout.NORTH);
		panel.add(addComponentsBelow(playerX, playerO, roundNumber), BorderLayout.SOUTH);
		panel.add(addComponentsEast(), BorderLayout.EAST);
		panel.add(addComponentsWest(), BorderLayout.WEST);
	}
	
	public void mainLoop(Player playerX, Player playerO, int roundNumber){
		for(int j=1; j<10; j++){
			System.out.println(j);
			if(j % 2 == 0){
				currentPlayer = playerO;
				for(int i = 0; i<9; i++){
					button[i].setFont(new Font("Monospace", Font.BOLD, 50));
					button[i].setForeground(Color.RED);
					button[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							((JButton)e.getSource()).setText("o");
							//System.out.println(Integer.parseInt(((JButton)e.getSource()).getName()));
							currentPlayer.setPattern(playerOMoveCount, Integer.parseInt(((JButton)e.getSource()).getName()));	
							playerOMoveCount++;
						}
					});
				}
			}else{
				currentPlayer = playerX;
				for(int i = 0; i<9; i++){
					button[i].setFont(new Font("Monospace", Font.BOLD, 50));
					button[i].setForeground(Color.BLUE);
					button[i].addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							((JButton)e.getSource()).setText("x");
							currentPlayer.setPattern(playerXMoveCount, Integer.parseInt(((JButton)e.getSource()).getName()));	
							playerXMoveCount++;
						}
					});
				}
			}
		}
	}
	
	public JComponent getMainComponent(){
		return panel;
	}
	
	public JPanel addComponentsAbove(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		turnStatus.setText("Turn "+"XX"+": "+"XX"+" ("+"Player "+"XX"+")");
		panel.add(turnStatus);
		return panel;
	}
	
	public JPanel addComponentsBelow(Player playerX, Player playerO, int roundNumber){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		panel.setLayout(new GridLayout(1,3));
		player1.setText(playerX.getName()+": "+"XX");
		player2.setText(playerO.getName()+": "+"XX");
		gameStatus.setText("Round "+"XX"+" out of "+roundNumber);
		panel.add(player1);
		panel.add(gameStatus);
		panel.add(player2);
		
		return panel;
	}
	
	public JPanel addComponentsCenter(JButton[] button){
		int i;
		Dimension dimension = new Dimension(30,30);
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(150, 150));
		panel.setLayout(new GridLayout(3,3));
		
		for(i=0; i < 9; i++){
			button[i] = new JButton();
			button[i].setName(Integer.toString(i));
			button[i].setPreferredSize(dimension);
			panel.add(button[i]);
			button[i].addActionListener(this);
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

	public JLabel getPlayer1() {
		return player1;
	}

	public void setPlayer1(JLabel player1) {
		this.player1 = player1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		turnCount++;
		if(turnCount % 2 == 0){
			letter = "O";
		}else{
			letter = "X";
		}
		((JButton)e.getSource()).setText(letter);
		((JButton)e.getSource()).setFont(new Font("Monospace", Font.BOLD, 50));
		((JButton)e.getSource()).setText(letter);
		((JButton)e.getSource()).setEnabled(false);
	}
	

}
