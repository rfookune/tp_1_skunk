import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	
	private Player currentPlayer;
	private int currentPlayerIndex;
	
	private Player firstWinner = null;
	private Player winner = null;
	
	
	// constructors
	public Game()
	{
		this.players = new ArrayList<Player>();
		this.currentPlayer = null;
	}
	
	public Game(ArrayList<Player> players)
	{
		this.players = players;
		this.currentPlayerIndex = 0;
		this.currentPlayer = this.players.get(this.currentPlayerIndex);
	}
		
	
	// getters and setters
	public ArrayList<Player> getPlayers()
	{
		return this.players;
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void setWinner(Player player)
	{
		this.winner = player;
		if (this.firstWinner == null) {
			this.firstWinner = player;
		}
	}
	
	public Player getWinner()
	{
		return this.winner;
	}
	
	public Player getFirstWinner()
	{
		return this.firstWinner;
	}
	
	public void addNewPlayer(String playerName)
	{
		Player player = new Player(playerName);
		players.add(player);
		
		// if first player added - set as current player
		if (players.size() == 1) {
			currentPlayerIndex = 0;
			currentPlayer = this.players.get(currentPlayerIndex);
		}
	}
	
	
	// methods
	public void endTurn()
	{
		currentPlayer.endTurn();
	}
	
	public void setNextPlayer()
	{
		currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
		currentPlayer = players.get(currentPlayerIndex);
	}
}
