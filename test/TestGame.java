import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestGame {

	@Test
	void add_player_to_game() {
		
		Game game = new Game();
		
		for (int i = 1; i < 100; i++) {
			
			game.addNewPlayer(Integer.toString(i));
			assertEquals(game.getPlayers().size(), i);
			
        }
		
	}


}
