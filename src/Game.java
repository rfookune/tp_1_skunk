import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class Game {
ArrayList<SkunkPlayer> Players = new ArrayList<SkunkPlayer>();
Turn gameTurn = new Turn();
int currentPlayer = 0;//this will be 0 - length of Players to keep track of which player's turn is next.
SkunkInterface Ui = new SkunkInterface();
boolean endTurn = true;
/*To Do:
*	Add player to Players(at game startup)
*	
*
*		Single Skunk = turnPoints set to zero, 1 chip to kitty, end turn
		Skunk Deuce = turnPoints set to zero, 2 chips to kitty, end turn
		Double Skunk = turnPoints set to zero, playerScore set to zero, 4 chips to kitty, end turn
*/


public void playerTurn(int currentPlayer)
{
	//Roll or Pass
	//if Roll => do a roll and check for skunk, skunk/deuce, or double skunk
	//		if skunk => turn score is ignored, 1 chip to kitty, turn over
	//		if skunk/deuce => turn score is ignored, 2 chips to kitty, turn over
	//		if double skunk => turn score is ignored, player score is set to 0, 3 chips to kitty, turn over
	//      else add roll to turnScore start over.
	//if Pass => add turn score to total score, turn over
	do 
	{
		switch (Ui.RollOrPass(getPlayer(currentPlayer).name)) //this is using the players name and returning the player's choice.
		{
			case "R":
				StdOut.println("you picked roll"); // just put this here to make sure the loop was working
				
				break;
			case "P":
				StdOut.println("you picked pass");  // just put this here to make sure the loop was working
				endTurn = false;
				break;
			default: 
				StdOut.println("invalid input");  // the loop makes this work, I think, we an keep this
		 }
	
	}while (endTurn); //poorly named, I guess but it's working!
	
}


public void addNewPlayer(SkunkPlayer player)
{
	Players.add(player);
}

public void setCurrentPlayer()
{
//this is initialized as 0, we can leave this for now since we only need one player for HW3	
}

public SkunkPlayer getPlayer(int index)
{
	return Players.get(index);
}



}
