package main;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Checker extends Thread{
	Thread[] threads = new Thread[3];
	
	public Checker(JButton[][] buttons, Player player, int turnNum) {
		//horizontal
		threads[0] = new Thread(){
			public synchronized void run(){
				for(int i=0; i<3; i++){
					if(buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][1].getText() == buttons[i][2].getText() && buttons[i][0].getText()!=""){
						JOptionPane.showMessageDialog(null, player.getName()+" wins!");
						player.setWin();
						player.setScore();
						resetBoard(buttons, turnNum);
					}
				}
				
			}
		};
		
		//vertical
		threads[1] = new Thread(){
			public synchronized void run(){
				for(int i=0; i<3; i++){
					if(buttons[0][i].getText() == buttons[1][i].getText() && buttons[1][i].getText() == buttons[2][i].getText() && buttons[0][i].getText()!=""){
						JOptionPane.showMessageDialog(null, player.getName()+" wins!");
						player.setWin();
						player.setScore();
						resetBoard(buttons, turnNum);
					}
				}
			}
		};
		
		//diagonal, pt1
		threads[2] = new Thread(){
			public synchronized void run(){
				if(buttons[0][0].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][2].getText() && buttons[0][0].getText()!=""){
					JOptionPane.showMessageDialog(null, player.getName()+" wins!");
					player.setWin();
					player.setScore();
					resetBoard(buttons, turnNum);
				}else if(buttons[0][2].getText() == buttons[1][1].getText() && buttons[1][1].getText() == buttons[2][0].getText() && buttons[0][2].getText()!=""){
					JOptionPane.showMessageDialog(null, player.getName()+" wins!");
					player.setWin();
					player.setScore();
					resetBoard(buttons, turnNum);
				}
			}
		};
	}
	
	Thread getThread(int i){
		return threads[i];
	}
	
	void resetBoard(JButton[][] buttons, int turnNum){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				buttons[i][j].setText("");
				buttons[i][j].setEnabled(true);
			}
		}
		turnNum = 0;
	}

}
