import java.util.ArrayList;

import edu.princeton.cs.introcs.StdOut;

public class SkunkDomain {
	
	public Interface ui;
	private ArrayList<Player> players;
	private int kitty;
	
	private int TARGET_SCORE = 100;
	
	public SkunkDomain(Interface ui)
	{
		this.ui = ui;
		this.kitty = 0;
		this.players = new ArrayList<Player>();
	}
	
	public void run()
	{
		ui.welcomeMessage();
		
		Integer playerCount = ui.promptPlayerCount();
		StdOut.println("");
		
		for (int index = 1; index <= playerCount; index++) {
			String playerName = ui.promptPlayerName(index);
			this.addNewPlayer(playerName);
			StdOut.println("");
		}
		
		
		// Start a new game
		Game game = new Game(this.players);
		
		Boolean gameEnded = false;
		Player currentPlayer = null;
		
		while (!gameEnded) {
			
			// Start current player's turn
			currentPlayer = game.getCurrentPlayer();
			currentPlayer.startTurn();
			
			Turn turn = currentPlayer.getCurrentTurn();
			
			ui.turnStartedMessage(currentPlayer);
			
			String playerDecision = "";
			Boolean skunkRolled = false;
			
			// do while player chooses to roll
			do {
				
				// Ask player's to roll or pass
				playerDecision = ui.promptRollOrPass(currentPlayer.getName()).toLowerCase();
				StdOut.println("");
				
				// Handle player's decision
				switch (playerDecision) 
				{
					case "r":
						
						// Roll dice and handle roll
						turn.roll();
						
						// if skunk is rolled
						if (turn.isSkunked()) {
							skunkRolled = true;
							
							currentPlayer.handleSkunk();
							
							int penality = turn.getPenality();
							kitty = kitty + penality;
							currentPlayer.setChipCount(currentPlayer.getChipCount() - penality);
							
							game.endTurn();
							
							ui.skunkRolledMessage();
						}
						
						ui.turnRollReport(currentPlayer, turn);
						StdOut.println("");
						
						break;
						
					case "p":
						
						// End player's turn
						game.endTurn();
						ui.endTurnMessage(currentPlayer.getName());
						StdOut.println("");
						break;
					
					default: 
						
						// Handle invalid user input
						ui.invalidInputMessage();
						StdOut.println("");
				}
				
			} while (!playerDecision.equals("p") && !skunkRolled);
			
			
			// if player reached target score
			if (currentPlayer.getPlayerScore() >= TARGET_SCORE) {
				gameEnded = true;
				game.setWinner(currentPlayer);
				
				ui.targetScoreReachedMessage(currentPlayer);
			};
			
			boolean validSummaryInput = false;
			while (!validSummaryInput) {
				
				String showSummary = ui.promptShowTurnSummary().toLowerCase();
				StdOut.println("");
			
				switch (showSummary)
				{
					
					case "y":
						ui.turnReport(currentPlayer, turn);
						StdOut.println("");
						validSummaryInput = true;
						break;
						
					case "n":
						validSummaryInput = true;
						break;
					
					default: 
						
						// Handle invalid user input
						ui.invalidInputMessage();
						StdOut.println("");
				}
				
			};
			
			
			// StdOut.println("Player chip " + currentPlayer.getChipCount());
			// StdOut.println("Kitty chip " + kitty);
			// StdOut.println("");
			
			game.setNextPlayer();
			
		}
		
		// last turn for each player that is not the first winner
		while (game.getCurrentPlayer() != game.getFirstWinner()) {
			
			currentPlayer = game.getCurrentPlayer();
			currentPlayer.startTurn();
			
			Turn turn = currentPlayer.getCurrentTurn();
			
			ui.lastTurnStartedMessage(currentPlayer);
			
			String playerDecision = "";
			Boolean skunkRolled = false;
			
			// do while player chooses to roll
			do {
				
				// Ask player's to roll or pass
				playerDecision = ui.promptRollOrPass(currentPlayer.getName()).toLowerCase();
				StdOut.println("");
				
				// Handle player's decision
				switch (playerDecision) 
				{
					case "r":
						
						// Roll dice and handle roll
						turn.roll();
						
						// if skunk is rolled
						if (turn.isSkunked()) {
							skunkRolled = true;
							
							currentPlayer.handleSkunk();
							
							int penality = turn.getPenality();
							kitty = kitty + penality;
							currentPlayer.setChipCount(currentPlayer.getChipCount() - penality);
							
							game.endTurn();
							
							ui.skunkRolledMessage();
						}
						
						ui.turnRollReport(currentPlayer, turn);
						StdOut.println("");
						
						break;
						
					case "p":
						
						// End player's turn
						game.endTurn();
						ui.endTurnMessage(currentPlayer.getName());
						StdOut.println("");
						break;
					
					default: 
						
						// Handle invalid user input
						ui.invalidInputMessage();
						StdOut.println("");
				}
				
			} while (!playerDecision.equals("p") && !skunkRolled);
			
			
			// if player reached target score
			if (currentPlayer.getPlayerScore() > game.getWinner().getPlayerScore()) {
				Player previousWinner = game.getWinner();
				game.setWinner(currentPlayer);
				ui.newWinnerMessage(currentPlayer, previousWinner);
			};

			game.setNextPlayer();
		}
		
		Player winner = game.getWinner();
		winner.setChipCount(winner.getChipCount() + kitty);
		kitty = 0;
		
		ui.displayWinnerMessage(winner);
		
		// Game ended
		StdOut.println("Game ended!");
		
	}
	
	public void addNewPlayer(String playerName)
	{
		Player player = new Player(playerName);
		players.add(player);
	}
	
}
