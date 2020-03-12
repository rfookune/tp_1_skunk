import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class TestDice {

	@Test
	public void dice_with_random_die() {
		Dice dice = new Dice();
		
		for (int i = 1; i < 100000; i++) {
			
			dice.roll();
			int roll = dice.getLastRoll();
			
			assertTrue(roll >= 2 && roll <= 12);
			
        }
	}
	
	@Test
	public void dice_with_crookedDie1_and_crookedDie2() {
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		assertEquals(dice.getLastRoll(), 3);
	}
	
	@Test
	public void dice_with_two_crookedDie1() {
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		assertEquals(dice.getLastRoll(), 2);
	}
	
	@Test
	public void dice_with_two_crookedDie2() {
		Die die1 = new CrookedDie2();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		assertEquals(dice.getLastRoll(), 4);
	}
	
	
	@Test
	public void dice_with_one_crookedDie1() {
		Die die1 = new CrookedDie1();
		Die die2 = new Die();
		Dice dice = new Dice(die1, die2);
		
		for (int i = 1; i < 100000; i++) {
			
			dice.roll();
			int roll = dice.getLastRoll();
			
			assertTrue(roll >= 2 && roll <= 7);
			
        }
	}
	
	@Test
	public void dice_with_one_crookedDie2() {
		Die die1 = new CrookedDie2();
		Die die2 = new Die();
		Dice dice = new Dice(die1, die2);
		
		for (int i = 1; i < 100000; i++) {
			
			dice.roll();
			int roll = dice.getLastRoll();
			
			assertTrue(roll >= 3 && roll <= 8);
			
        }
	}

}
