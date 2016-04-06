/*
 * Class TicTacToe
 * 	- contains the main method
 * 
 */

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.GameScreen;
import ui.MainMenu;

public class Tictactoe {
	private static final String MENU = "menu";
	private static final String GAME = "game";
	private CardLayout cardlayout = new CardLayout();
	private JPanel panel = new JPanel(cardlayout);
	private MainMenu mainmenu = new MainMenu();
	private GameScreen gamescreen = new GameScreen();
	
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
		panel.add(gamescreen.getMainComponent(), GAME);
		
		mainmenu.addOKActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				mainmenu.checker();
				System.out.println(mainmenu.isOddNumber());
				System.out.println(mainmenu.isPlayer1HasData());
				System.out.println(mainmenu.isPlayer2HasData());
				if(mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
					cardlayout.show(panel, GAME);
				}else if(mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&!mainmenu.isOddNumber()){
					mainmenu.error.setText("The number you've entered is not odd.");
					mainmenu.error.setForeground(Color.RED);
				}else if(mainmenu.isPlayer2HasData()&&!mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
					mainmenu.error.setText("Player 1 has no name.");
					mainmenu.error.setForeground(Color.RED);
				}else if(!mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
					mainmenu.error.setText("Player 2 has no name.");
					mainmenu.error.setForeground(Color.RED);
				}else if(mainmenu.isPlayer2HasData()&&!mainmenu.isPlayer1HasData()&&!mainmenu.isOddNumber()){
					mainmenu.error.setText("<html><body>The number you've entered is not odd.<br>Player 1 has no name.</body></html>");
					mainmenu.error.setForeground(Color.RED);
				}else if(!mainmenu.isPlayer2HasData()&&mainmenu.isPlayer1HasData()&&!mainmenu.isOddNumber()){
					mainmenu.error.setText("<html><body>The number you've entered is not odd.<br>Player 2 has no name.</html></body>");
					mainmenu.error.setForeground(Color.RED);
				}else if(!mainmenu.isPlayer2HasData()&&!mainmenu.isPlayer1HasData()&&mainmenu.isOddNumber()){
					mainmenu.error.setText("Players 1 & 2 have no names.");
					mainmenu.error.setForeground(Color.RED);
				}else{
					mainmenu.error.setText("Please enter the values indicated.");
					mainmenu.error.setForeground(Color.RED);
				}
			}
		});
	}
	
	private static void BuildUI(){
		JFrame frame = new JFrame("TicTacToe");
		frame.setPreferredSize(dimension);
		frame.setMinimumSize(dimension);
		
		frame.getContentPane().add(new Tictactoe().getMainComponent());
				
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
