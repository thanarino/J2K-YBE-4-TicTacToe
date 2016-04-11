/**************************************
   Created by: Jonathan Arino, Krisanta Agdan, Krezly Plata
   Date Updated: April 11, 2016
**************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
	private BorderLayout borderlayout = new BorderLayout();
	private JPanel panel = new JPanel(borderlayout);
	private JLabel title = new JLabel("<html><body><br>WELCOME TO TICTACTOEv2!</body></html>", JLabel.CENTER);
	private JLabel player1Name = new JLabel("Enter Player1's name: ", JLabel.CENTER);
	private JLabel player2Name = new JLabel("Enter Player2's name: ", JLabel.CENTER);
	private JLabel roundsNum = new JLabel("Enter number of rounds: ", JLabel.CENTER);
	private JTextField player1 = new JTextField(15);
	private JTextField player2 = new JTextField(15);
	private JTextField rounds = new JTextField(5);
	private Font font = new Font("MONOSPACED", Font.BOLD, 20);
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	
	public Login() {
	/**********************************************
	   Constructor for the class Login
	**********************************************/
		title.setFont(font);
		title.setForeground(Color.BLUE);
		panel.add(title, BorderLayout.NORTH);
		panel.add(addForms(), BorderLayout.CENTER);
		panel.add(addButtonsBelow(), BorderLayout.SOUTH);
	}
	
	void addOKActionListener(ActionListener actionlistener){
		ok.addActionListener(actionlistener);
	}
	
	void addCancelActionListener(ActionListener actionlistener){
		cancel.addActionListener(actionlistener);
	}
	
	boolean checker(){
	/**********************************************
	   Check if textfields are filled,
	   and round number is an odd number.
	**********************************************/
		if(!(player1.getText().equals("")) && !(player2.getText().equals("")) && !(rounds.getText().equals("")) && Integer.parseInt(rounds.getText())%2 != 0){
			System.out.println(Integer.parseInt(rounds.getText()));
			return true;
		}
		return false;
	}
	
	int getRounds(){
		return Integer.parseInt(rounds.getText());
	}
	
	private JPanel addForms(){
	/**********************************************
	   Adds panel for players and the round
	**********************************************/
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.setPreferredSize(new Dimension(300,300));
		JPanel nested1 = new JPanel();
		JPanel nested2 = new JPanel();
		JPanel nested3 = new JPanel();
		nested1.add(player1Name);
		nested1.add(player1);
		nested2.add(player2Name);
		nested2.add(player2);
		nested3.add(roundsNum);
		nested3.add(rounds);
		centerPanel.add(nested1);
		centerPanel.add(nested2);
		centerPanel.add(nested3);
		return centerPanel;
	}
	
	private JPanel addButtonsBelow(){
	/**********************************************
	   Adds button
	**********************************************/
		JPanel botPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botPanel.setPreferredSize(new Dimension(500, 100));
		botPanel.add(ok);
		botPanel.add(cancel);
		return botPanel;
	}
	
	JPanel getPanel(){
		return panel;
	}
	
	String getPlayer1(){
		return player1.getText();
	}
	
	String getPlayer2(){
		return player2.getText();
	}

}
