package main;

public class Player {
	private int score;
	private String name;
	private boolean isWinner;

	public Player() {
	}
	
	String getName(){
		return this.name;
	}
	
	int getScore(){
		return this.score;
	}
	
	void setScore(){
		this.score++;
	}
	
	void resetScore(){
		this.score = 0;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	boolean checkWin(){
		return this.isWinner;
	}
	
	void setWin(){
		this.isWinner = true;
	}
	
	void resetWin(){
		this.isWinner = false;
	}

}
