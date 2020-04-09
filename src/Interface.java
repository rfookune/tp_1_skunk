import java.util.Scanner;
import edu.princeton.cs.introcs.*;

public class Interface {

	private Scanner scan = new Scanner(System.in);
	
	
	// UI inputs
	public Integer promptPlayerCount()
	{
		StdOut.println("How many players will join the game?");
		return Integer.parseInt(scan.nextLine());
	}
	
	public String promptPlayerName(int index)
	{
		playerNameMessage(index);
		return scan.nextLine();
	}
	
	public String promptRollOrPass(String playerName)
	{
		rollOrPassMessage(playerName);
		return scan.nextLine().toUpperCase();
	}
	
	public String promptShowTurnSummary()
	{
		StdOut.println("Do you wish to see a summary of this turn? (Y/N)");
		return scan.nextLine();
	}
	
	
	// UI reports
	public void turnRollReport(Player player, Turn turn) 
	{
		StdOut.println(player.getName() +", "+ turn.getLastRoll().toString() + " " + turn.toString());
	}
	
	public void turnReport(Player player, Turn turn) 
	{
		StdOut.println("Here is a summary of your rolls for this turn " + player.getName() + ":");
		turn.getTurnRolls().forEach((Roll roll) -> StdOut.println(roll.toString()));
		StdOut.println("Your final turn score is " + turn.getScore());
		StdOut.println("Your current game score is " + player.getPlayerScore());
	}
	
	
	// UI output messages
	public void welcomeMessage()
	{
		StdOut.println("Welcome to Skunk! \n");
	}
	
	public void turnStartedMessage(Player player)
	{
		StdOut.println("It's your turn now " + player.getName() + ". \n");
	}
	
	public void lastTurnStartedMessage(Player player)
	{
		StdOut.println("It's your last turn " + player.getName() + ". \n");
	}
	
	public void singleSkunkMessage()
	{
		StdOut.println("You rolled a single Skunk!");
		turnOverMessage();
	}
	
	public void skunkDeuceMessage()
	{
		StdOut.println("You rolled a Skunk-Deuce!");
		turnOverMessage();
	}
	
	public void doubleSkunkMessage()
	{
		StdOut.println("You Rolled a Double Skunk!");
		turnOverMessage();
	}
	
	public void targetScoreReachedMessage(Player player)
	{
		StdOut.println("Congrats " + player.getName() + "! You reached the target score. Your game score is " + player.getPlayerScore() + ". \n");
	}
	
	public void turnOverMessage()
	{
		StdOut.println("Your turn is over!");
	}
	
	public void newWinnerMessage(Player newPlayer, Player oldPlayer)
	{
		StdOut.println("Congrats "+ newPlayer.getName() + "! You surpassed " + oldPlayer.getName() + "'s score of " + oldPlayer.getPlayerScore() + "pts. You are the current winner with " + newPlayer.getPlayerScore() + "pts. \n");
	}
	
	public void displayWinnerMessage(Player winner)
	{
		StdOut.println("Congrats "+ winner.getName() + "! You won this game. Your chip count is now " + winner.getChipCount() + ". \n");
	}
	
	public void playerNameMessage(int index)
	{
		StdOut.println("Enter name for player " + index + " and press ENTER.");
	}
	
	public void rollOrPassMessage(String playerName)
	{
		StdOut.println(playerName + ", would you like to ROLL or PASS?");
		StdOut.println("Type R to roll or P to pass and press ENTER.");
	}
	
	public void endTurnMessage(String playerName)
	{
		StdOut.println(playerName + ", your turn has ended.");
	}
	
	public void invalidInputMessage()
	{
		StdOut.println("Invalid input. Please try again.");
	}
	
	public void skunkRolledMessage()
	{
		StdOut.println("Too bad! You rolled a skunk :(");
	}
}
