package myPackage;
import java.util.*;
public class HumanPlayerDice extends PlayerofDiceGame{
	String [] difficulties= {"Easy","Normal","Hard","Impossible"};
	String [] winningResponses= {"Great Job!", "Awesome!", "You're on Fire!"};
	String [] tiedResponses= {"That's all even!", "No winners or losers!", "Neck and Neck!"};
	String [] losingResponses= {"Tough Loss!", "Yikes! You Lost!", "No Luck!"};
	boolean validDifficulty=false;
	int wager;
	double pointsAdjuster;
	int payout;
	boolean isAlive=true;
	boolean isChampion, isLoser;
	boolean isPlaying=true;
	String tier;
	String postGameResponse;
	
	public void setValidity(String x)
	{
		for(int i=0;i<4;i++)
		{
			if(x.equalsIgnoreCase(difficulties[i]))
			{
				validDifficulty=true;
				break;
			}
			else
			{
				
			}
		}
	}
	public boolean getValidity()
	{
		return validDifficulty;
	}
	
	public void setPoints(String x)
	{
		if(x.equalsIgnoreCase("Easy"))
		{
			points=500;
		}
		else if(x.equalsIgnoreCase("Normal"))
		{
			points=250;	
		}
		else if(x.equalsIgnoreCase("Hard"))
		{
			points=200;	
		}
		else
		{
			points=100;
		}
	}
	public void setPointsAdjuster(String x)
	{
		if(x.equalsIgnoreCase("Easy"))
		{
			pointsAdjuster=1.0;
		}
		else if(x.equalsIgnoreCase("Normal"))
		{
			pointsAdjuster=1.0;
		}
		else if(x.equalsIgnoreCase("Hard"))
		{
			pointsAdjuster=0.9;
		}
		else
		{
			pointsAdjuster=0.75;
		}
	}

//set and get wager
public void setWager(int x)
{
wager=(int)x;
}
public int getWager()
{
	return wager;
}
public void setHumanRollValue()
{
	Random rnd=new Random();
	for(int i=0; i<(2); i++)
	{
		rollValue[i]=rnd.nextInt(6)+1;	
	}
}
public int getHumanRollValue()
{
	totalRollValue=0;
	for (int i=0; i<2; i++)
	{
		totalRollValue=totalRollValue+rollValue[i];
	}
	return totalRollValue;
}
public boolean humanWon(int x,int y)
{
	if(x>y)
	{
		wonTheGame=true;
	}

	else
	{
		wonTheGame=false;
	}
	return wonTheGame;
}
public boolean humanWon()
{
	return wonTheGame;
}
public boolean humanTied(int x, int y)
{
	if(x==y)
	{
		tiedTheGame=true;
	}
	else
	{
		tiedTheGame=false;
	}
	return tiedTheGame;
}
public boolean humanTied()
{
	return tiedTheGame;
}
public void decidePayout(int wager, boolean x, boolean y)
{
	//if there is a tie
	if(x==true) 
	{
		payout=(int) (-1*wager*(1-pointsAdjuster));
	}
	else if(y==true)
	{
		payout=(int)(wager*pointsAdjuster);
	}
	else
	{
		payout=(-1*wager);
	}
}
public int getPayout()
{
	return payout;
}
public void setPoints(int x, int y)
{
	points=x+y;
}
public boolean isAlive(int x)
{
	if(x>0 && x<2000)
	{
	isAlive=true;	
	}
	else
	{
	isAlive=false;
	}
	return isAlive;
}
public boolean isChampion(int x)
{
	if(x==2000)
	{
		isChampion=true;
	}
	else
	{
		isChampion=false;
	}
	return isChampion;
}
public boolean isLoser(int x)
{
	if(x==0)
	{
		isLoser=true;
	}
	else
	{
		isLoser=false;
	}
	return isLoser;
}
public boolean setIsPlaying(String x)
{
	if(x.equalsIgnoreCase("Rematch"))
	{
		isPlaying=true;
		invalidResponse=false;
	}
	else if(x.equalsIgnoreCase("No"))
	{
		isPlaying=false;
		invalidResponse=false;
	}
	else
	{
		invalidResponse=true;
	}
	return isPlaying;
}
public boolean getIsPlaying()
{
	return isPlaying;
}
public boolean getInvalidResponse()
{
	return invalidResponse;
}
public void setTier(int x)
{
	if(x==2000)
	{
		tier="GOLD";
	}
	else if(x>=1500)
	{
		tier="SILVER";
	}
	else if(x>=1000)
	{
		tier="BRONZE";
	}
	else
	{
		
	}
}
public String getTier()
{
	return tier;
}
public String postGameResponse(boolean x, boolean y)
{
	int number= rnd.nextInt(3);
	if(x)
	{
	postGameResponse=winningResponses[number];	
	}
	else if(y)
	{
	postGameResponse=tiedResponses[number];
	}
	else
	{
		postGameResponse=losingResponses[number];
	}
	return postGameResponse;
}
}