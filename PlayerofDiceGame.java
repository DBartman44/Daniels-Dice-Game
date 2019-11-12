package myPackage;

import java.util.Random;

public abstract class PlayerofDiceGame {
//instance variables
	int points;
	String difficulty;
	String name;
	int diceAdjuster;
	double pointsAdjuster;
	int totalRollValue=0;
	boolean wonTheGame;
	boolean tiedTheGame=false;
	boolean invalidResponse;
	int [] rollValue=new int[2];
	Random rnd=new Random();
	
	public void setPoints(int points)
	{
		this.points=points;
	}
	public int getPoints()
	{
		return points;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setDifficulty(String difficulty)
	{
		this.difficulty=difficulty;
	}
	public String getDifficulty()
	{
		return difficulty;
	}
	
	public int getRollvalue()
	{
		return totalRollValue;
	}
	public void displayRolls() throws InterruptedException
	{
		for(int i=0; i<2; i++)
		{
			System.out.print("["+rollValue[i]+"]\t");
			Thread.sleep(1000);
		}
		System.out.println("");
	}
}
