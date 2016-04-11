/**************************************
   Created by: Jonathan Arino, Krisanta Agdan, Krezly Plata
   Date Updated: April 11, 2016
**************************************/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends Thread implements ActionListener{
	private BorderLayout borderlayout = new BorderLayout();
	private JPanel panel = new JPanel(borderlayout);
	private JButton[][] buttons = new JButton[3][3];
	
	private int turnNum = 1;
	private int roundNum = 0;
	private int currentRound = 0;
	private int checkIfAlreadyWon = 0;
	
	private Player player1 = new Player();
	private Player player2 = new Player();
	private Player currentPlayer;
	
	private String player1Name;
	private String player2Name;
	
	private JLabel turns = new JLabel("Turn "+turnNum+": "+"XX"+" ("+"XX"+")", JLabel.CENTER);
	private JLabel player1Score = new JLabel("XX"+" (P1): "+"XX", JLabel.CENTER);
	private JLabel player2Score = new JLabel("XX"+" (P2): "+"XX", JLabel.CENTER);
	private JLabel game = new JLabel("Game "+"XX"+" out of "+"XX", JLabel.CENTER);
	
	Thread[] threads = new Thread[3];
	
	JPanel getPanel(){
		return panel;
	}
	
	public Game(int rounds, String playerUno, String playerDos) {
	/**********************************************
	   Constructor for the class Game
	**********************************************/
		player1.setName(playerUno);
		player2.setName(playerDos);
		player1Name = player1.getName();
		player2Name = player2.getName();
		roundNum = rounds;
		
		panel.setLayout(borderlayout);
		panel.add(addCenter(), BorderLayout.CENTER);
		panel.add(addTop(), BorderLayout.NORTH);
		panel.add(addBot(rounds, playerUno, playerDos), BorderLayout.SOUTH);
	}
	
	public JPanel addBot(int rounds, String playerUno, String playerDos){
	/**********************************************
	   Method for creating components at bottom
	**********************************************/
		JPanel botPanel = new JPanel(new GridLayout(1,3));
		player1Score.setText(playerUno+" (P1): "+"XX");
		botPanel.add(player1Score);
		game.setText("Game "+roundNum+" out of "+rounds);
		botPanel.add(game);
		player2Score.setText(playerDos+" (P2): "+"XX");
		botPanel.add(player2Score);
		return botPanel;
	}
	
	public JPanel addTop(){
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(turns);
		return topPanel;
	}
	
	public JPanel addCenter(){
	/**********************************************
	   Method for creating components at center
	**********************************************/
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,3));
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(this);
				centerPanel.add(buttons[i][j]);
			}
		}
		return centerPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	/**********************************************
	   Action when a button is clicked during 
	   the game proper.
	**********************************************/
		
		if(currentRound < roundNum+1){
			
			((JButton)e.getSource()).setEnabled(false);
			
			if(currentRound%2 != 0){
				if(turnNum%2 == 0){
					currentPlayer = player1;
					((JButton)e.getSource()).setText("O");
					turns.setText("Turn "+turnNum+": "+player1Name+" ("+"Player 1"+")");
				}else{
					currentPlayer = player2;
					((JButton)e.getSource()).setText("X");
					turns.setText("Turn "+turnNum+": "+player2Name+" ("+"Player 2"+")");
				}
			}else{
				if(turnNum%2 == 0){
					currentPlayer = player2;
					((JButton)e.getSource()).setText("X");
					turns.setText("Turn "+turnNum+": "+player2Name+" ("+"Player 2"+")");
				}else{
					currentPlayer = player1;
					((JButton)e.getSource()).setText("O");
					turns.setText("Turn "+turnNum+": "+player1Name+" ("+"Player 1"+")");
				}
			}
			
			
			turnNum++;
			/**********************************************
	  		  Use of thread for checking of patterns
			**********************************************/
			buildThreadsHorizontal(currentPlayer).start();
			buildThreadsVertical(currentPlayer).start();
			buildThreadsDiagonal(currentPlayer).start();
			
			if(turnNum == 10 && !(player1.checkWin()) && !(player2.checkWin()) && checkIfAlreadyWon!=1){
				JOptionPane.showMessageDialog(null, "Draw! Everyone gets a point!");
				player1.setScore();
				player2.setScore();
				player1.resetWin();
				player2.resetWin();
				resetBoard(buttons);
				turnNum = 1;
				currentRound++;
				checkIfAlreadyWon = 0;
			}
			
			if(player1.checkWin()){
				player1.resetWin();
				player2.resetWin();
			}else if(player2.checkWin()){
				player1.resetWin();
				player2.resetWin();
			}
			
			game.setText("Game "+currentRound+" out of "+roundNum);
		}else{
			if(player1.getScore() < player2.getScore()){
				JOptionPane.showMessageDialog(null, "The game has ended! "+player2.getName()+" won with "+player2.getScore()+" points!");
			}else if(player1.getScore() > player2.getScore()){
				JOptionPane.showMessageDialog(null, "The game has ended! "+player1.getName()+" won with "+player1.getScore()+" points!");
			}else if(player1.getScore() == player2.getScore()){
				JOptionPane.showMessageDialog(null, "The game has ended! It's a tie!");
			}
			
		}
		
		
	}
	
	Thread buildThreadsHorizontal(Player player){
	/**********************************************
	   Thread for Horizontal pattern
	**********************************************/
		threads[0] = new Thread(){
			public synchronized void run(){
				for(int i=0; i<3; i++){
					if(buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][1].getText() == buttons[i][2].getText() && buttons[i][0].getText()!=""){
						JOptionPane.showMessageDialog(null, player.getName()+" wins!");
						player.setWin();
						player.setScore();
						if(player1.checkWin()){
							player1Score.setText(player1Name+" (P1): "+player1.getScore());
							checkIfAlreadyWon = 1;
						}else if(player2.checkWin()){
							player2Score.setText(player2Name+" (P2): "+player2.getScore());
							checkIfAlreadyWon = 1;
						}else if(!(player1.checkWin()) && !(player2.checkWin())){
							checkIfAlreadyWon = 0;
						}
						currentRound++;
						resetBoard(buttons);
						turnNum = 1;
					}
				}
				
			}
		};
		return threads[0];
	}
	
	Thread buildThreadsVertical(Player player){
	/**********************************************
	   Thread for Vertical pattern
	**********************************************/
		threads[1] = new Thread(){
			public synchronized void run(){
				for(int i=0; i<3; i++){
					if(buttons[0][i].getText() == buttons[1][i].getText() && buttons[1][i].getText() == buttons[2][i].getText() && buttons[0][i].getText()!=""){
						JOptionPane.showMessageDialog(null, player.getName()+" wins!");
						player.setWin();
						player.setScore();
						if(player1.checkWin()){
							player1Score.setText(player1Name+" (P1): "+player1.getScore());
							checkIfAlreadyWon = 1;
						}else if(player2.checkWin()){
							player2Score.setText(player2Name+" (P2): "+player2.getScore());
							checkIfAlreadyWon = 1;
						}else if(!(player1.checkWin()) && !(player2.checkWin())){
							checkIfAlreadyWon = 0;
						}
						currentRound++;
						resetBoard(buttons);
						turnNum = 1;
					}
				}
			}
		};
		return threads[1];
	}
	
	Thread buildThreadsDiagonal(Player player){
	/**********************************************
	   Thread for Diagonal pattern
	**********************************************/
		threads[2] = new Thread(){
			public synchronized void run(){
				if(buttons[0][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][2].getText() && buttons[0][0].getText()!=""){
					JOptionPane.showMessageDialog(null, player.getName()+" wins!");
					player.setWin();
					player.setScore();
					if(player1.checkWin()){
						player1Score.setText(player1Name+" (P1): "+player1.getScore());
						checkIfAlreadyWon = 1;
					}else if(player2.checkWin()){
						player2Score.setText(player2Name+" (P2): "+player2.getScore());
						checkIfAlreadyWon = 1;
					}else if(!(player1.checkWin()) && !(player2.checkWin())){
						checkIfAlreadyWon = 0;
					}
					currentRound++;
					resetBoard(buttons);
					turnNum = 1;
				}else if(buttons[0][2].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][0].getText() && buttons[0][2].getText()!=""){
					JOptionPane.showMessageDialog(null, player.getName()+" wins!");
					player.setWin();
					player.setScore();
					if(player1.checkWin()){
						player1Score.setText(player1Name+" (P1): "+player1.getScore());
						checkIfAlreadyWon = 1;
					}else if(player2.checkWin()){
						player2Score.setText(player2Name+" (P2): "+player2.getScore());
						checkIfAlreadyWon = 1;
					}else if(!(player1.checkWin()) && !(player2.checkWin())){
						checkIfAlreadyWon = 0;
					}
					currentRound++;
					resetBoard(buttons);
					turnNum = 1;
				}
			}
		};
		return threads[2];
	}
	
	void resetBoard(JButton[][] buttons){
	/**********************************************
	   Reset board for new round
	**********************************************/
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				buttons[i][j].setText("");
				buttons[i][j].setEnabled(true);
			}
		}
	}

}
