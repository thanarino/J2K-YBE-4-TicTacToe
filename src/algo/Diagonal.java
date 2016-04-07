 package algo;

public class Diagonal extends Thread{
	Player p;
	int count =0;
	int count1=0;
	
	
	public Diagonal(Player p){
		this.p = p;
	}
	
	int[] check = p.getPattern();
	public void run(){
		//{0,1,2}
		//{3,4,5}
		//{6,7,8}
		
		for(int i=0; i<p.getCounter(); i++){
			if(check[i] == 0 || check[i] == 4 || check[i] == 8){
				count++;
			}else if(check[i] == 2 || check[i] == 4 || check[i] == 6){
				count1++;
			}
		}
		
		if(count == 3 || count1 == 3){
			p.setScore(1);
		}
		
	}
	
	
}