import edu.princeton.cs.introcs.StdOut;

public class SkunkDomain {
	
	public SkunkInterface ui;
	private int kitty;
	
	public SkunkDomain(SkunkInterface ui)
	{
		this.ui = ui;
		this.kitty = 0;
	}
	
	public void run()
	{
		// Start a new game
		Game game = new Game();

		ui.welcomeMessage();
		
		
		// Add a new player
		String playerName = ui.askPlayerName();
		game.addNewPlayer(playerName);
		StdOut.println("");
		
		// Start current player's turn
		SkunkPlayer currentPlayer = game.getCurrentPlayer();
		currentPlayer.startTurn();
		
		Turn turn = currentPlayer.getCurrentTurn();
		
		String playerDecision = "";
		Boolean skunkRolled = false;
		
		// do while player chooses to roll
		do {
			
			// Ask player's to roll or pass
			playerDecision = ui.askRollOrPass(currentPlayer.getName());
			StdOut.println("");
			
			// Handle player's decision
			switch (playerDecision)
			{
				case "R":
					
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
					
				case "P":
					
					// End player's turn
					game.endTurn();
					ui.endTurnMessage(currentPlayer.getName());
					StdOut.println("");
					break;
				
				default: 
					
					// Handle invalid user input
					ui.invalidPlayerDecisionMessage();
					StdOut.println("");
			}
			
		} while (!playerDecision.equals("P") && !skunkRolled);
		
		ui.turnReport(currentPlayer, turn);
		StdOut.println("");
		
		StdOut.println("Kitty chip " + currentPlayer.getChipCount());
		StdOut.println("Player chip " + kitty);
		StdOut.println("");
		
		
		
		// Game ended
		StdOut.println("Game ended!");
		
	}
	
}
