/*
 * Class TicTacToe
 * 	- contains the main method
 * 
 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algo.Diagonal;
import algo.Horizontal;
import algo.Player;
import algo.Vertical;
import ui.GameScreen;
import ui.MainMenu;

public class Tictactoe implements ActionListener{
	private static final String MENU = "menu";
	private static final String GAME = "game";
	private CardLayout cardlayout = new CardLayout();
	private JPanel panel = new JPanel(cardlayout);
	private MainMenu mainmenu = new MainMenu();
	private Player playerX = new Player('X');
	private Player playerO = new Player('O'); 
	private int roundCount = 0;
	private int turnCount = 0;
	Player currentPlayer;
	JButton[][] buttons = new JButton[3][3];
	static JFrame frame = new JFrame("TicTacToe");
	
	private static Dimension dimension = new Dimension(500, 300);

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				BuildUI(frame);
			}
		});
	}
	
	private JComponent getMainComponent(){
		return panel;
	}
	
	public Tictactoe(){
		panel.add(mainmenu.getMainComponent(), MENU);
		
		mainmenu.addOKActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					mainmenu.checker();
				}catch(NumberFormatException ex){
				}finally{
					if(mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
						playerX.setName(mainmenu.player2Name());
						playerO.setName(mainmenu.player1Name());
						mainLoop(playerX, playerO);
						//gamescreen.mainLoop(playerX, playerO, mainmenu.getRoundNumber());
						
					}else if(mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&!mainmenu.isOddNumber()){
						mainmenu.error.setText("<html><body>The number you've entered is either not odd<br>or not a number at all.</body></html>");
						mainmenu.error.setForeground(Color.RED);
					}else if(mainmenu.isPlayer2HasData()&&!mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
						mainmenu.error.setText("Player 1 has no name.");
						mainmenu.error.setForeground(Color.RED);
					}else if(!mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
						mainmenu.error.setText("Player 2 has no name.");
						mainmenu.error.setForeground(Color.RED);
					}else if(mainmenu.isPlayer2HasData()&&!mainmenu.isPlayer1HasData()&&!mainmenu.isOddNumber()){
						mainmenu.error.setText("<html><body>The number you've entered is either not odd<br>or not a number at all.<br>Player 1 has no name.</body></html>");
						mainmenu.error.setForeground(Color.RED);
					}else if(!mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&!mainmenu.isOddNumber()){
						mainmenu.error.setText("<html><body>The number you've entered is either not odd<br>or not a number at all.<br>Player 2 has no name.</html></body>");
						mainmenu.error.setForeground(Color.RED);
					}else if(!mainmenu.isPlayer2HasData()&&!mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
						mainmenu.error.setText("Players 1 & 2 have no names.");
						mainmenu.error.setForeground(Color.RED);
					}else{
						mainmenu.error.setText("Please enter the values indicated.");
						mainmenu.error.setForeground(Color.RED);
					}
				}
			}
		});
		
		mainmenu.addCancelActionListener(new ActionListener(){
			 	@Override
			 	public void actionPerformed(ActionEvent e) {
			 	System.exit(1);
			 }
		});	
			  	
	}
	
	private void mainLoop(Player playerX, Player playerO){
		GameScreen gamescreen = new GameScreen(playerX, playerO, mainmenu.getRoundNumber());
		panel.add(gamescreen.getMainComponent(), GAME);	
		cardlayout.show(panel, GAME);
		
		while(this.roundCount < mainmenu.getRoundNumber()){
			while((playerX.getWinner() || playerO.getWinner()) || turnCount < 10){
				turnCount++;
				if(turnCount%2 == 0){
					this.currentPlayer = playerO;
				}else{
					this.currentPlayer = playerX;
				}
				System.out.println("jkl");
				Horizontal horizontal = new Horizontal(currentPlayer, gamescreen.getButton());
				horizontal.start();
				
				Vertical vertical = new Vertical(currentPlayer, gamescreen.getButton());
				vertical.start();
				
				if(playerX.getWinner() || playerO.getWinner()){
					JOptionPane.showMessageDialog(null, "yey");
				}else{
					//JOptionPane.showMessageDialog(null, "draw.");
				}
				
				
			}
			roundCount++;
		}
	}
	
	private static void BuildUI(JFrame frame){
		
		frame.setPreferredSize(dimension);
		frame.setMinimumSize(dimension);
		
		frame.getContentPane().add(new Tictactoe().getMainComponent());
				
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		turnCount++;
		if(turnCount % 2 == 0){
			((JButton)e.getSource()).setText("O");
		}else{
			((JButton)e.getSource()).setText("X");
		}
		((JButton)e.getSource()).setFont(new Font("Monospace", Font.BOLD, 50));
		((JButton)e.getSource()).setEnabled(false);
	}
}
