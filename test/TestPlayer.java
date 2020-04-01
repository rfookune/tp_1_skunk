import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestPlayer {

	@Test
	void player_constructor() {
		
		String name = "John Doe";
		SkunkPlayer player = new SkunkPlayer(name);
		
		assertEquals(player.getName(), name);
		assertEquals(player.getChipCount(), 50);
		assertEquals(player.getPlayerScore(), 0);
		
	}
	
	
	@Test
	void handle_single_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		String name = "John Doe";
		SkunkPlayer player = new SkunkPlayer(name);
		
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
		SkunkPlayer player = new SkunkPlayer(name);
		
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
		SkunkPlayer player = new SkunkPlayer(name);
		
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
		SkunkPlayer player = new SkunkPlayer(name);
		
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

}
