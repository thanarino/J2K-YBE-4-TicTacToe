package algo;

public class Player{
	private String name;
	private int[] pattern = new int[5];
	private char a;
	private int counter = 0;
	private int score;
	
	public Player(String name, char a){
		this.name = name;
		this.a = a;
	}
	
	public void insertNum(int n){
		pattern[counter++] = n;
	}
	
	public int[] getPattern(){
		return this.pattern;
	}
		
	public String getName(){
		return this.name;
	}
}