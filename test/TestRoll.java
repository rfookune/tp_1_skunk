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
		
	}
	
	@Test
	void outcome_deuce_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		assertEquals(roll.getPenality(), 2);
		assertTrue(roll.isDeuceSkunk());
		
	}
	
	@Test
	void outcome_double_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		assertEquals(roll.getPenality(), 4);
		assertTrue(roll.isDoubleSkunk());
		
	}
	
	@Test
	void roll_score_is_dice_outcome() {
		
		Roll roll = new Roll();
		assertEquals(roll.getScore(), roll.getDice().getLastRoll());
		
	}
	
	

}
