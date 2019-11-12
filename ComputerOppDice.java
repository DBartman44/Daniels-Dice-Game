package myPackage;

import java.util.*;

public class ComputerOppDice extends PlayerofDiceGame{
		//instance variables
		int totalRollValue;
		int diceAdjuster = 0;
		Random rnd=new Random();
	public void setPoints(String x)
	{
		if(x.equalsIgnoreCase("Easy"))
		{
			points=1500;
			
		}
		else if(x.equalsIgnoreCase("Normal"))
		{
			points=1750;
		}
		else if(x.equalsIgnoreCase("Hard"))
		{
			points=1800;
		}
		else
		{
			points=1900;
		}
	}
	public void setDiceAdjuster(String x)
	{
		if(x.equalsIgnoreCase("Easy"))
		{
			diceAdjuster=0;
		}
		else if(x.equalsIgnoreCase("Normal"))
		{
			diceAdjuster=0;
		}
		else if(x.equalsIgnoreCase("Hard"))
		{
			diceAdjuster=1;
		}
		else
		{
			diceAdjuster=3;
		}
	}
	public int getDiceAdjustment()
	{
		return diceAdjuster;
	}
	public void setCompRollValue(int diceAdj)
	{
		for(int i=0; i<2; i++)
		{
			rollValue[i]=rnd.nextInt(6-diceAdjuster)+(1+diceAdjuster);
		}
	}
	public int getCompRollValue()
	{
		totalRollValue=0;
		for (int i=0; i<2; i++)
		{
			totalRollValue=totalRollValue+rollValue[i];
		}
		return totalRollValue;
	}
	//messed up
	public void setPoints(int x, int y)
	{
	 points=x-y;
	}
}