
public class Roll {
String rollOutcome; //my thought is to return a code for special condisions single/double skunk, deuce, etc.
Dice rollDice = new Dice();
/*
	 *	Knows value of each die rolled (Array<int>) 
		Handle create dice 
		Handle roll dice 
		Handle determine dice output (score value, single skunk, skunk and deuce, double skunk) 
				-Switch Statement
				-
		Return output of roll (score value, single skunk, skunk and deuce, double skunk) 
		
		
		Single Skunk = turnPoints set to zero, 1 chip to kitty, end turn
		Skunk Deuce = turnPoints set to zero, 2 chips to kitty, end turn
		Double Skunk = turnPoints set to zero, playerScore set to zero, 4 chips to kitty, end turn
	 */

	public void playerRoll()
	{
		rollDice.roll();
		
		if (rollDice.getBothDice()[0] == 1 && rollDice.getBothDice()[1] == 1)
			{
				rollOutcome = "DoubleSkunk" ;
			}
		else if (rollDice.getBothDice()[0] == 1)
			{
				if (rollDice.getBothDice()[1] == 2)
				{
					rollOutcome = "Skunk/Deuce";
				}
				else
					rollOutcome = "Skunk";
				
			}
		else if (rollDice.getBothDice()[1]==1)
			{
				if (rollDice.getBothDice()[0] == 2)
				{
					rollOutcome = "Skunk/Deuce";			
				}
				else
					rollOutcome = "Skunk";
			}
		else
			rollOutcome = "GoodRoll";
	}
}
