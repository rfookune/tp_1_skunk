
public class SkunkPlayer {

	String name;
	int playerScore;
	int chipCount;
	
	SkunkPlayer(String name)
	{
		this.name = name;
	}
	
	//constructor to set all variables, maybe for testing?
	SkunkPlayer(String name, int score, int chips)
	{
		this.name = name;
		this.playerScore = score;
		this.chipCount = chips;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getChipCount() {
		return chipCount;
	}

	public void setChipCount(int chipCount) {
		this.chipCount = chipCount;
	}
	
	
}
