import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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
	public void roll_random_die()
	{
		Die die = new Die();
		
		for (int i = 1; i < 100000; i++) {
			
			die.roll();
			int roll = die.getLastRoll();
			
			assertTrue(roll >= 1 && roll <= 6);
			
        }
	}

}
