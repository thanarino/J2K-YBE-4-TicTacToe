package algo;

public class Player{
	private String name;
	private int[] pattern = new int[5];
	private int counter = 0;
	private int score;
	private char symbol;
	
	public Player(char symbol){
		//this.name = name;
		this.symbol = symbol;
	}
	
	public void setPattern(int playerMoveCount, int num){
		this.pattern[playerMoveCount] = num;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void insertNum(int n){
		pattern[counter++] = n;
	}
	
	public String getName(){
		return this.name;
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
	
	public int getScore(){
		return this.score;
	}
	
}