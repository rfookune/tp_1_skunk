import java.util.Scanner;
import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) 
	{
		StdOut.println("main method begins.");
		
		//Create a game
		Game game = new Game();

		//Create an interface
		SkunkInterface Ui = new SkunkInterface();
		//print the welcome message
		Ui.WelcomeMsg();
		//the final versions of these messages and inputs can be in the SkunkInterface this is just for now.
		Scanner scan = new Scanner(System.in);
		StdOut.println("Enter your name and press ENTER.");
		//Create the player for this assignment, requirements say address them by name.
		SkunkPlayer player = new SkunkPlayer(scan.nextLine());
		game.addNewPlayer(player);
		
		game.playerTurn(game.currentPlayer);
		//This asks if current player wants to play or pass
//		Ui.RollOrPassMsg(game.getPlayer(game.currentPlayer).name);
//			
//		String choice = scan.nextLine().toUpperCase();
//		
//		switch (choice)
//		{
//			case "R":
//				
//				break;
//			case "P":
//				break;
//			default:
//				StdOut.println("Invalid Choice");
//				break;
//		}
//		
		
		
		
		
		
		
		
//		Dice dice = new Dice();
//		dice.roll();
//		
//		StdOut.println(dice.toString());
		StdOut.println("main method ends.");
	}

}
