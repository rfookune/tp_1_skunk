import edu.princeton.cs.introcs.*;

public class SkunkApp {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		StdOut.println("Welcome to a game of skunk");
		
		Dice dice = new Dice();
		dice.roll();
		
		StdOut.println(dice.toString());
	}

}
