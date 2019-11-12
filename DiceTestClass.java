package myPackage;
import java.util.*;
public class DiceTestClass 
{
	public static void main(String []args) throws InterruptedException
	{
		Scanner input= new Scanner (System.in);
		ComputerOppDice c= new ComputerOppDice();
		HumanPlayerDice h= new HumanPlayerDice();
		System.out.println("Hello! Welcome to Daniel's Dice Game! Before we get started, what's your name?");
		Thread.sleep(500);
		h.setName(input.nextLine());
		while(h.getIsPlaying())
		{
		System.out.println("Thanks "+(h.getName())+"! Now lets decide the difficulty!");
		System.out.println("Easy, Normal, Hard, Impossible");
		Thread.sleep(500);
		h.setDifficulty(input.nextLine());
		h.setValidity(h.getDifficulty());
			while((h.getValidity())==false)
			{
				Thread.sleep(500);
				System.out.println("Oops, looks like there was an error. Lets try entering the difficulty again!");
				Thread.sleep(500);
				h.setDifficulty(input.nextLine());
				h.setValidity(h.getDifficulty());
			}
		c.setName("The Diceman");
		h.setPoints(h.getDifficulty());
		h.setPointsAdjuster(h.getDifficulty());
		c.setPoints(h.getDifficulty());
		c.setDiceAdjuster(h.getDifficulty());
		System.out.println("Since you chose "+((h.getDifficulty()).toUpperCase())+" you will start with "+(h.getPoints())+" points!");
		Thread.sleep(500);
		System.out.println((c.getName())+" will start with "+(c.getPoints()+" points"));
		Thread.sleep(500);
		System.out.println("To score BRONZE you need to win 1000 points.");
		Thread.sleep(500);
		System.out.println("To score SILVER you need to win 1500 points.");
		Thread.sleep(500);
		System.out.println("To score GOLD you need to win 2000 points.");
		Thread.sleep(500);
		//Start of the actual game
		while(h.isAlive(h.getPoints()))
		{
			System.out.println("Enter a wager!");
			h.setWager(input.nextInt());
			while(h.getWager()<1||(h.getWager()>(h.getPoints()))||(h.getWager()>(c.getPoints())))
			{
				System.out.println("Oops, looks like there was an error. Lets try entering the wager again!");
				System.out.println("Make sure its bigger than 1 but also less than or equal to yours and Diceman's total!");
				h.setWager(input.nextInt());
			}
		h.setHumanRollValue();
		c.setCompRollValue(c.getDiceAdjustment());
		System.out.println("The Computer rolled...");
		c.displayRolls();
		System.out.println("You rolled...");
		h.displayRolls();
		h.decidePayout(h.getWager(),h.humanTied(h.getHumanRollValue(),(c.getCompRollValue())),h.humanWon(h.getHumanRollValue(),(c.getCompRollValue())));
		h.setPoints(h.getPoints(), h.getPayout());
		c.setPoints(c.getPoints(), h.getPayout());
		System.out.println(h.postGameResponse(h.humanWon(), h.humanTied()));
		System.out.println("You now have "+h.getPoints()+" points!");
				if(h.getPoints()>=1000)
					{
						h.setTier(h.getPoints());
						System.out.println("You are now at the "+h.getTier()+" tier!");
					}
					else
						{
					
						}
		System.out.println("The Diceman now has "+c.getPoints()+" points!");
		}
						if(h.isChampion(h.getPoints()))
							{
								System.out.println(h.getName()+", You are the CHAMPION of Daniel's Dice Game! CONGRATS!");
							}
							else
								{
									System.out.println("Sorry, "+h.getName()+", you have lost Daniel's Dice Game.");
								}
		System.out.println("Would you like to play again? If so, please enter REMATCH. If not, please enter NO.");
		input.nextLine();
		h.setIsPlaying(input.nextLine());
								while(h.getInvalidResponse())
									{
										System.out.println("Oops, looks like there was an error. Lets try entering that again. Either 'Rematch' or 'No'");	
										h.setIsPlaying(input.nextLine());
									}
		
			}
		System.out.println("Thanks for playing! Good Bye!");
	}
}
