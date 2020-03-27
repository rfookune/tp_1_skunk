import java.util.Scanner;
import edu.princeton.cs.introcs.*;
public class SkunkInterface {

	
	//Interfaces:
	//I'm trying to only include the interface here, this is my first time making something like this, feel free to replace all of this.
	public String RollOrPass(String playerName)
	{
		Scanner scan = new Scanner(System.in);
		RollOrPassMsg(playerName);
		return scan.nextLine().toUpperCase();
	}
	public void ReportRoll(int[] diceValues)
	{
		
	}
	//MESSAGES:
	public void WelcomeMsg()
	{
		StdOut.println("Welcome to Skunk!");
		StdOut.println(	"would you like to play?");
	}
	
	public void SingleSkunkMsg()
	{
		StdOut.println("You rolled a single Skunk!");
		TurnOverMsg();
	}
	
	public void SkunkDeuceMsg()
	{
		StdOut.println("You rolled a Skunk-Deuce!");
		TurnOverMsg();
	}
	
	public void DoubleSkunkMsg()
	{
		StdOut.println("You Rolled a Double Skunk!");
		TurnOverMsg();
	}
	
	public void TurnOverMsg()
	{
		StdOut.println("Your turn is over!");
	}
	
	public void RollOrPassMsg(String name)
	{
		StdOut.println(name + ", would you like to ROLL or PASS?");
		StdOut.println("Type R to roll or P to pass and press ENTER");
	}
}
