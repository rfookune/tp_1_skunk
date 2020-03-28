
public class Roll {
	
	private Dice dice;
	private int score;
	
	
	// constructors
	Roll() 
	{
		dice = new Dice();
		dice.roll();
		this.score = dice.getLastRoll();
	}
	
	
	// getters and setters
	public Dice getDice()
	{
		return dice;
	}
	
	public int getScore() 
	{
		return score;
	}
	
	public int getPenality()
	{
		if (isDoubleSkunk()) {
			return 4;
		} else if (isDeuceSkunk()) {
			return 2;
		} else if (isSingleSkunk()) {
			return 1;
		}
		
		return 0;	
	}
	
	
	// methods
	public Boolean isDoubleSkunk() 
	{
		return dice.getDie1Roll() == 1 && dice.getDie2Roll() == 1;
	}
	
	public Boolean isDeuceSkunk() 
	{
		return (dice.getDie1Roll() == 1 && dice.getDie2Roll() == 2) || (dice.getDie1Roll() == 2 && dice.getDie2Roll() == 1);
	}
	
	public Boolean isSingleSkunk() 
	{
		return dice.getDie1Roll() == 1 || dice.getDie2Roll() == 1;
	}
	
	public String toString() 
	{
		String outcome = Integer.toString(this.score);
		
		if (isDoubleSkunk()) {
			outcome = "Double Skunk";
		} else if (isDeuceSkunk()) {
			outcome = "Deuce Skunk";
		} else if (isSingleSkunk()) {
			outcome = "Single Skunk";
		}
		
		return "You rolled a " + outcome + " => " + dice.getDie1Roll() + " and " + dice.getDie2Roll() + ".";
	}
}
