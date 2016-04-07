package algo;

public class Horizontal extends Thread{
	Player p;
	int count =0;
	int count1=0;
	int count2=0;
	
	
	public Horizontal(Player p){
		this.p = p;
	}
	
	int[] check = p.getPattern();
	public void run(){
		//{1,4,2,0}
		//{0,1,2}
		//{3,4,5}
		//{6,7,8}
		
		for(int i=0; i<p.getCounter(); i++){
			if(check[i] == 0 || check[i] == 1 || check[i] == 2){
				count++;
			}else if(check[i] == 3 || check[i] == 4 || check[i] == 5){
				count1++;
			}else if(check[i] == 6 || check[i] == 7 || check[i] == 8){
				count2++;
			}
		}
		
		if(count == 3 || count1 == 3 || count2 == 3){
			p.setScore(1);
		}
		
	}
	
	
}