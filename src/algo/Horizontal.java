package algo;

import javax.swing.JButton;

public class Horizontal extends Thread{
	Player p;
	JButton[][] buttons;
	
	
	public Horizontal(Player p, JButton[][] buttons){
		this.p = p;
		this.buttons = buttons;
	}
	
	public synchronized void run(){
		//{1,4,2,0}
		//{0,1,2}
		//{3,4,5}
		//{6,7,8}
		
		for(int i = 0; i < 3; i++){
			if(p.getSymbol() == 'X'){
				if(buttons[i][0].getText() == "X"){
					if(buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][0].getText() == buttons[i][2].getText()){
						p.setWinner(true);
					}
				}
			}else{
				if(buttons[i][0].getText() == "O"){
					if(buttons[i][0].getText() == buttons[i][1].getText() && buttons[i][0].getText() == buttons[i][2].getText()){
						p.setWinner(true);
					}
				}
			}
			
		}
	}
	
	
}