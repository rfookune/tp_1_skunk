import java.util.ArrayList;

public class Turn {
	
	private int turnScore;
	private boolean skunked;
	private ArrayList<Roll> turnRolls;
	
	
	// constructors
	public Turn()
	{
		this.turnRolls = new ArrayList<Roll>();
		this.skunked = false;
	}
	
	
	// getters and setters
	public void setScore(int score)
	{
		this.turnScore = score;
	}
	
	public int getScore()
	{
		return turnScore;
	}
	
	public boolean isSkunked()
	{
		return skunked;
	}
	
	public ArrayList<Roll> getTurnRolls()
	{
		return this.turnRolls;
	}
	
	public Roll getLastRoll()
	{
		return turnRolls.get(turnRolls.size()-1);
	}
	
	public int getPenality()
	{
		return this.getLastRoll().getPenality();
	}
	
	public void addRoll(Roll roll)
	{
		turnRolls.add(roll);
	}
	
	public void addScore(Roll roll)
	{
		setScore(turnScore + roll.getScore());
	}
	
	
	// methods
	public void roll()
	{
		Roll roll = new Roll();
		
		addRoll(roll);
		addScore(roll);
		
		skunked = roll.isDoubleSkunk() || roll.isDeuceSkunk() || roll.isSingleSkunk();
	}
	
	// roll with a predefined set of die
	public void roll(Dice dice)
	{
		Roll roll = new Roll(dice);
		
		addRoll(roll);
		addScore(roll);
		
		this.skunked = roll.isDoubleSkunk() || roll.isDeuceSkunk() || roll.isSingleSkunk();
	}
	
	public String toString()
	{
		return "Your turn score is " + this.turnScore + ".";
	}
	
}