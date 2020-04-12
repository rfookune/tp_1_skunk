import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestTurn {

	@Test
	void outcome_single_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		Turn turn = new Turn();
		turn.roll(dice);
		
		assertEquals(turn.getPenality(), 1);
		assertTrue(turn.isSkunked());
		
	}
	
	@Test
	void outcome_deuce_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		Turn turn = new Turn();
		turn.roll(dice);
		
		assertEquals(turn.getPenality(), 2);
		assertTrue(turn.isSkunked());
		
	}
	
	@Test
	void outcome_double_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		Turn turn = new Turn();
		turn.roll(dice);
		
		assertEquals(turn.getPenality(), 4);
		assertTrue(turn.isSkunked());
		
	}
	
	
	@Test
	public void score_accumulation()
	{
		Turn turn = new Turn();
		
		int prevScore = 0;
		
		for (int i = 1; i < 100000; i++) {
			
			prevScore = turn.getScore();
			turn.roll();
			
			if (turn.getLastRoll().isDeuceSkunk()) {
				assertEquals(turn.getPenality(), 2);
			} else if (turn.getLastRoll().isDoubleSkunk()) {
				assertEquals(turn.getPenality(), 4);
			} else if (turn.getLastRoll().isSingleSkunk()) {
				assertEquals(turn.getPenality(), 1);
			}
			
			assertEquals(turn.getScore(), prevScore + turn.getLastRoll().getScore());
			
        }
	}
	
	@Test
	public void turn_to_string()
	{
		Turn turn = new Turn();
		
		assertTrue(turn.toString().equals("Your turn score is " + turn.getScore() + "."));
		
	}
	
	@Test
	public void get_turn_rolls()
	{
		Turn turn = new Turn();
		
		int count = 0;
		
		assertTrue(turn.getTurnRolls().size() == count);
		
		for (int i = 1; i < 1000; i++) {
			
			turn.roll();
			count++;
			
			assertTrue(turn.getTurnRolls().size() == count);
			
        }
	}
	
}
