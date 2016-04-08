 /*
 * Class Vertical
 * 	- contains the checker for vertical patterns
 * 
 */

package algo;

public class Vertical extends Thread{
	Player p;
	int count =0;
	int count1=0;
	int count2=0;
	
	
	public Vertical(Player p){
		this.p = p;
	}
	
	int[] check = p.getPattern();
	public void run(){
		//{0,1,2}
		//{3,4,5}
		//{6,7,8}
		
		for(int i=0; i<p.getCounter(); i++){
			if(check[i] == 0 || check[i] == 3 || check[i] == 6){
				count++;
			}else if(check[i] == 1 || check[i] == 4 || check[i] == 7){
				count1++;
			}else if(check[i] == 2 || check[i] == 5 || check[i] == 8){
				count2++;
			}
		}
		
		if(count == 3 || count1 == 3 || count2 == 3){
			p.setScore(1);
		}
		
	}
	
	
}