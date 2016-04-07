package algo;

public class Player{
	private String name;
	private int[] pattern = new int[5];
	private int counter = 0;
	private int score;
	
	public Player(String name){
		this.name = name;
	}
	
	public void insertNum(int n){
		pattern[counter++] = n;
	}
	
	public int[] getPattern(){
		return this.pattern;
	}
	
	public int getCounter(){
		return this.counter;
	}
	
	public void setScore(int score){
		this.score += score;
	}
	
}