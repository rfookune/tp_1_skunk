/**
 * Test for Die, CrookedDie1 and CrookedDie2
 * 
 * @author John Luukkonen, Rhyan Foo Kune
 *
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

public class TestDie
{
	@Test
	public void crooked_die_roll_a_1()
	{
		Die die = new CrookedDie1();
		
		assertEquals(die.getLastRoll(), 1);
	}
	
	@Test
	public void crooked_die_roll_a_2()
	{
		Die die = new CrookedDie2();
		
		assertEquals(die.getLastRoll(), 2);
	}
	
	@Test
	public void random_die_roll_between_1_and_6()
	{
		Die die = new Die();
		
		for (int i = 1; i < 100000; i++) {
			
			die.roll();
			int roll = die.getLastRoll();
			
			assertTrue(roll >= 1 && roll <= 6);
			
        }
	}

}
