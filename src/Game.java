import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	private Player currentPlayer;
	
	
	// constructors
	public Game()
	{
		this.players = new ArrayList<Player>();
		this.currentPlayer = null;
	}
	
	// constructors
		public Game(Player player)
		{
			this.players = new ArrayList<Player>();
			
			this.players.add(player);
			this.currentPlayer = player;
		}
		
	
	// getters and setters
	public void setCurrentPlayer(Player player)
	{
		this.currentPlayer = player;
	}
	
	public ArrayList<Player> getPlayers()
	{
		return this.players;
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void addNewPlayer(String playerName)
	{
		Player player = new Player(playerName);
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
