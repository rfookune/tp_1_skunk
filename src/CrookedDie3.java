/**
 * A crooked die rolling a 3 every time
 * 
 * @author John Luukkonen, Rhyan Foo Kune
 *
 */
public class CrookedDie3 extends Die
{
	public CrookedDie3()
	{
		
	}
	
	@Override
	public int getLastRoll()
	{
		return 3;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie3 always rolling 3";
	}

}
