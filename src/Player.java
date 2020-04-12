
public class Player {

	private String name;
	private int playerScore;
	private int chipCount;
	
	private Turn currentTurn;
	
	
	// constructors
	Player(String name)
	{
		this.name = name;
		
		// starting chip count 
		this.chipCount = 50;
	}
	
	Player(String name, int score, int chips)
	{
		this.name = name;
		this.playerScore = score;
		this.chipCount = chips;
	}
	
	
	// getters and setters
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getPlayerScore() 
	{
		return playerScore;
	}

	public void setPlayerScore(int playerScore) 
	{
		this.playerScore = playerScore;
	}

	public int getChipCount() {
		return chipCount;
	}

	public void setChipCount(int chipCount) 
	{
		this.chipCount = chipCount;
	}
	
	public Turn getCurrentTurn() 
	{
		return currentTurn;
	}
	
	
	// methods
	public void startTurn()
	{
		currentTurn = new Turn();
	}
	
	public void handleSkunk()
	{
		if (currentTurn.getLastRoll().isDoubleSkunk()) {
			playerScore = 0;
		}
		
		currentTurn.setScore(0);
	}
	
	public void endTurn()
	{
		setPlayerScore(playerScore + currentTurn.getScore());

	}
}
