
/* Authors: Jonathan Arino && Krisanta Agdan && Krezly Plata
 * Date Created: April 5, 2016
 * Date Submitted: April 8, 2016
 * Tictactoe Game: This lets the user play Tictactoe Game.
 */
 
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import algo.Horizontal;
import algo.Player;
import ui.GameScreen;
import ui.MainMenu;

public class Tictactoe {
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
	
	private static Dimension dimension = new Dimension(500, 300);

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable(){
			public void run(){
				BuildUI();
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
			/*********************************************************************************
				This function checks the inputs of the user in the main screen.
			*********************************************************************************/
				try{
					mainmenu.checker();
				}catch(NumberFormatException ex){
				}finally{
				
					
				
					if(mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
						playerX.setName(mainmenu.player2Name());
						playerO.setName(mainmenu.player1Name());
						GameScreen gamescreen = new GameScreen(playerX, playerO, mainmenu.getRoundNumber());
						panel.add(gamescreen.getMainComponent(), GAME);	
						Horizontal horizontal = new Horizontal(currentPlayer, gamescreen.getButton());
						cardlayout.show(panel, GAME);
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
		/*********************************************************************************
			This function allows the cancel button to exit the game.
		*********************************************************************************/
			 	@Override
			 	public void actionPerformed(ActionEvent e) {
			 	System.exit(1);
			 }
		});	
			  	
	}
	
	private void mainLoop(){
		while(this.roundCount < mainmenu.getRoundNumber()){
			turnCount++;
			if(turnCount%2 == 0){
				
			}
		}
	}
	
	private static void BuildUI(){
	
	/*********************************************************************************
		This function builds the user interface of the game.
	*********************************************************************************/
		JFrame frame = new JFrame("TicTacToe");
		frame.setPreferredSize(dimension);
		frame.setMinimumSize(dimension);
		
		frame.getContentPane().add(new Tictactoe().getMainComponent());
				
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
