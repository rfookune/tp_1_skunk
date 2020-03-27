import java.util.ArrayList;
public class Turn {
int turnScore;
ArrayList<Integer> turnRolls = new ArrayList<Integer>(); //We're required to list all the rolls for the turn for this assignment, I don't think we need this for the finished program


	public Turn()
	{
	
	}
	public void turnRoll()
	{
		//rolls and returns the rolloutcome and the totals
	}
	public void AddTurnRoll(int rolled)
	{
		turnRolls.add(rolled);
	}
	
	public String TurnRollsToString()
	{
		return turnRolls.toString();
	}
	
}
