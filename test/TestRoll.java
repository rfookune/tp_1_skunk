import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRoll {

	@Test
	void outcome_single_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		assertEquals(roll.getPenality(), 1);
		assertTrue(roll.isSingleSkunk());
		
		assertTrue(roll.toString().equals("You rolled a Single Skunk => 1 and 3."));
		
	}
	
	@Test
	void outcome_deuce_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		assertEquals(roll.getPenality(), 2);
		assertTrue(roll.isDeuceSkunk());
		
		assertTrue(roll.toString().equals("You rolled a Deuce Skunk => 1 and 2."));
		
	}
	
	@Test
	void outcome_double_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		assertEquals(roll.getPenality(), 4);
		assertTrue(roll.isDoubleSkunk());
		
		assertTrue(roll.toString().equals("You rolled a Double Skunk => 1 and 1."));
		
	}
	
	@Test
	void outcome_no_skunked_rolled() {
		
		Die die1 = new CrookedDie3();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		assertEquals(roll.getPenality(), 0);
		
	}
	
	@Test
	void roll_score_is_dice_outcome() {
		
		Roll roll = new Roll();
		assertEquals(roll.getScore(), roll.getDice().getLastRoll());
		
	}
}
