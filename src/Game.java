import java.util.ArrayList;

public class Game {

	private ArrayList<SkunkPlayer> players;
	private SkunkPlayer currentPlayer;
	
	
	// constructors
	public Game()
	{
		this.players = new ArrayList<SkunkPlayer>();
		this.currentPlayer = null;
	}
	
	// constructors
		public Game(SkunkPlayer player)
		{
			this.players = new ArrayList<SkunkPlayer>();
			
			this.players.add(player);
			this.currentPlayer = player;
		}
		
	
	// getters and setters
	public void setCurrentPlayer(SkunkPlayer player)
	{
		this.currentPlayer = player;
	}
	
	public ArrayList<SkunkPlayer> getPlayers()
	{
		return this.players;
	}
	
	public SkunkPlayer getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void addNewPlayer(String playerName)
	{
		SkunkPlayer player = new SkunkPlayer(playerName);
		players.add(player);
		
		// if first player added - set as current player
		if (players.size() == 1) {
			this.setCurrentPlayer(players.get(0));
		}
	}
	
	
	// methods
	public void endTurn()
	{
		currentPlayer.endTurn();
		// currentPlayer = next player
	}
}
