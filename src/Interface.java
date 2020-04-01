import java.util.Scanner;
import edu.princeton.cs.introcs.*;

public class Interface {

	private Scanner scan = new Scanner(System.in);
	
	
	// UI inputs
	public String askRollOrPass(String playerName)
	{
		rollOrPassMessage(playerName);
		return scan.nextLine().toUpperCase();
	}
	
	public String askPlayerName()
	{
		playerNameMessage();
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
		StdOut.println("You lost " + turn.getPenality() + " chip/s during this turn.");
		StdOut.println("Your final turn score is " + turn.getScore());
		StdOut.println("Your current game score is " + player.getPlayerScore());
	}
	
	
	// UI output messages
	public void welcomeMessage()
	{
		StdOut.println("Welcome to Skunk!");
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
	
	public void turnOverMessage()
	{
		StdOut.println("Your turn is over!");
	}
	
	
	public void playerNameMessage()
	{
		StdOut.println("Enter your name and press ENTER.");
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
	
	public void invalidPlayerDecisionMessage()
	{
		StdOut.println("Invalid input. Please try again.");
	}
	
	public void skunkRolledMessage()
	{
		StdOut.println("Too bad! You rolled a skunk :(");
	}
}
