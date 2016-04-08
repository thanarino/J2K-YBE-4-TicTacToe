 /*
 * Class Vertical
 * 	- contains the checker for vertical patterns
 * 
 */

package algo;

import javax.swing.JButton;

public class Vertical extends Thread{
	Player p;
	JButton[][] buttons;
	
	
	public Vertical(Player p, JButton[][] buttons){
		this.p = p;
		this.buttons = buttons;
	}
	
	public synchronized void run(){
		//{0,1,2}
		//{3,4,5}
		//{6,7,8}
		
		for(int i = 0; i < 3; i++){
			if(p.getSymbol() == 'X'){
				if(buttons[0][i].getText() == "X"){
					if(buttons[0][i].getText() == buttons[1][i].getText() && buttons[0][i].getText() == buttons[2][i].getText()){
						p.setWinner(true);
					}
				}
			}else{
				if(buttons[0][1].getText() == "O"){
					if(buttons[0][i].getText() == buttons[1][i].getText() && buttons[0][i].getText() == buttons[2][i].getText()){
						p.setWinner(true);
					}
				}
			}
		}
	}
	
	
}