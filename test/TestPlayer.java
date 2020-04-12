import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestPlayer {

	@Test
	void player_constructor() {
		
		String name = "John Doe";
		
		Player player = new Player(name);
		assertEquals(player.getName(), name);
		assertEquals(player.getPlayerScore(), 0);
		assertEquals(player.getChipCount(), 50);
		
		Player player2 = new Player(name, 0, 50);
		assertEquals(player2.getName(), name);
		assertEquals(player2.getPlayerScore(), 0);
		assertEquals(player2.getChipCount(), 50);
		
	}
	
	
	@Test
	void handle_single_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		String name = "John Doe";
		Player player = new Player(name);
		
		player.startTurn();
		player.getCurrentTurn().roll(dice);
		
		player.handleSkunk();
		
		assertTrue(player.getCurrentTurn().getScore() == 0);
	}
	
	@Test
	void handle_deuce_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		String name = "John Doe";
		Player player = new Player(name);
		
		player.startTurn();
		player.getCurrentTurn().roll(dice);
		
		player.handleSkunk();
		
		assertTrue(player.getCurrentTurn().getScore() == 0);
	}
	
	@Test
	void handle_double_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		String name = "John Doe";
		Player player = new Player(name);
		
		player.startTurn();
		player.getCurrentTurn().roll(dice);
		
		player.handleSkunk();
		
		assertTrue(player.getCurrentTurn().getScore() == 0);
		assertTrue(player.getPlayerScore() == 0);
	}
	
	@Test
	public void end_turn()
	{

		String name = "John Doe";
		Player player = new Player(name);
		
		int score = 0;
		
		player.startTurn();
		
		Turn turn = player.getCurrentTurn();
		
		for (int i = 1; i < 5; i++) {
		
			turn.roll();
			score = score + turn.getLastRoll().getScore();
			
        }
		
		player.endTurn();
		
		assertEquals(player.getPlayerScore(), score);

	}
	
	@Test
	void update_player_name() {
		
		String name = "John Doe";
		Player player = new Player(name);
		
		String nameUpdate = "Mary Johnson";
		
		player.setName(nameUpdate);
		
		assertEquals(player.getName(), nameUpdate);
		
	}
	
	
	@Test
	void update_player_chip_count() {
		
		String name = "John Doe";
		Player player = new Player(name, 0, 50);
		
		assertTrue(player.getChipCount() == 50);
		
		player.setChipCount(40);
		
		assertTrue(player.getChipCount() == 40);
		
	}

}
