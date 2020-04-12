import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;


class TestGame {

	@Test
	void add_player_to_game() {
		
		Game game = new Game();
		
		for (int i = 1; i < 100; i++) {
			
			game.addNewPlayer(Integer.toString(i));
			assertEquals(game.getPlayers().size(), i);
			
        }
		
	}
	
	@Test
	void new_game_with_players_constructor() {
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 1; i < 100; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		Game game = new Game(players);
		
		assertTrue(game.getPlayers().size() == players.size());
		assertEquals(game.getCurrentPlayer(), players.get(0));
		
	}
	
	
	@Test
	void set_game_winner() {
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 1; i <= 100; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		Game game = new Game(players);
		
		int winnerPlayerIndex = (int)(Math.random()*100);
		Player firstWinner = game.getPlayers().get(winnerPlayerIndex); 
		game.setWinner(firstWinner);
		
		assertEquals(game.getWinner(), firstWinner);
		
		for (int i = 1; i <= 10000; i++) {
			
			winnerPlayerIndex = (int)(Math.random()*100);
			Player winner = game.getPlayers().get(winnerPlayerIndex); 
			game.setWinner(winner);
			
			assertEquals(game.getWinner(), winner);
			assertEquals(game.getFirstWinner(), firstWinner);
			
        }
	}
	
	@Test
	void get_next_player_for_this_game() {
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 1; i <= 100; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		Game game = new Game(players);
		
		Player currentPlayer = players.get(0);
		
		for (int i = 0; i <= 1000; i++) {
			game.setNextPlayer();
			currentPlayer = players.get((i+1) % players.size());
			assertEquals(game.getCurrentPlayer(), currentPlayer);
        }
	}
	
	
	@Test
	void end_players_turn() {
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 1; i <= 100; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		Game game = new Game(players);
		game.getCurrentPlayer().startTurn();
		
		int turnScore = 20;
		
		game.getCurrentPlayer().getCurrentTurn().setScore(turnScore);
		
		game.endTurn();
		
		assertEquals(game.getCurrentPlayer().getPlayerScore(), turnScore);
		
	}
}
