/**************************************
   Created by: Jonathan Arino, Krisanta Agdan, Krezly Plata
   Date Updated: April 11, 2016
**************************************/

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	private CardLayout cardlayout = new CardLayout();
	private JPanel panel = new JPanel(cardlayout);
	private Login login = new Login();
	
	private boolean check;
	
	
	private JPanel getPanel(){
		return panel;
	}
	
	public Main() {
	/**********************************************
	   Constructor for the class Main
	**********************************************/
		panel.add(login.getPanel(), "login");
		
		
		login.addOKActionListener(new ActionListener(){
		/************************************************
	   	   Action when OK button is clicked
		************************************************/

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					check = login.checker();
				}catch(NumberFormatException ex){
					
				}finally{
					if(check){
						Game game = new Game(login.getRounds(), login.getPlayer1(), login.getPlayer2());
						panel.add(game.getPanel(), "game");
						cardlayout.show(panel, "game");
					}else{
						JOptionPane.showMessageDialog(null, "You've entered wrong values. Please re-evaluate.");
					}
				}
			}
			
		});
		
		login.addCancelActionListener(new ActionListener(){
		/****************************************************
	   	   Exit program when exit button is clicked
		*****************************************************/

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		
	}

	public static void main(String[] args) {
	/****************************************************
	   Main method: 
		creating frame for the GUI
	*****************************************************/
		JFrame window = new JFrame("TicTacToe V2");
		window.getContentPane().add(new Main().getPanel());;
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(new Dimension(500, 300));
		window.setMinimumSize(new Dimension(500, 300));
		window.pack();
		window.setVisible(true);
	}

}
