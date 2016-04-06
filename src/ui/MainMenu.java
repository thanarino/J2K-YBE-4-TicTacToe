/*
 * Class MainMenu
 * 	- contains the screen displayed when starting the program.
 * 
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ui.GameScreen;

public class MainMenu{

	Font font = new Font("MONOSPACED", Font.BOLD, 20);
	JPanel panel = new JPanel();
	JButton ok = new JButton("OK");
	JTextField player1 = new JTextField(15);
	JTextField player2 = new JTextField(15);
	
	boolean player1HasData = false;
	boolean player2HasData = false;
	
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
	
	private JPanel addComponentsAbove() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 50));
		return panel;
	}
	
	private JPanel addComponentsBelow() {
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(500, 50));
		JButton cancel = new JButton("Cancel");
		
		if(player1HasData && player2HasData){
			ok.setEnabled(true);
		}else{
			ok.setEnabled(false);
		}
		
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new GameScreen();
			}
		});
		
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
		
		player1.getDocument().addDocumentListener(new DocumentListener(){
			public void changedUpdate(DocumentEvent e){
				changed();
			}
			public void removeUpdate(DocumentEvent e){
				changed();
			}
			public void insertUpdate(DocumentEvent e){
				changed();
			}
			public void changed(){
				if(player1.getText().equals("")){
					player1HasData = false;
				}else{
					player1HasData = true;
				}
			}
		});
		
		player2.getDocument().addDocumentListener(new DocumentListener(){
			public void changedUpdate(DocumentEvent e){
				changed();
			}
			public void removeUpdate(DocumentEvent e){
				changed();
			}
			public void insertUpdate(DocumentEvent e){
				changed();
			}
			public void changed(){
				if(player2.getText().equals("")){
					player2HasData = false;
				}else{
					player2HasData = true;
				}
			}
		});
		
		return panel;
	}
}
