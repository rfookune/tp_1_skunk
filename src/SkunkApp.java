
public class SkunkApp {

	public SkunkInterface ui;
	public SkunkDomain skunkDomain;;
	
	
	public SkunkApp()
	{
		// Create UI layer
		ui = new SkunkInterface();
		
		// Create domain layer
		skunkDomain = new SkunkDomain(ui);
	}
	
	public void run()
	{
		skunkDomain.run();
	}
	
	public static void main(String[] args) 
	{
		new SkunkApp().run();
	}

}
