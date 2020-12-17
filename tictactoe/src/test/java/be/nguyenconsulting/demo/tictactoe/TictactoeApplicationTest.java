package be.nguyenconsulting.demo.tictactoe;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TictactoeApplicationTest {

	@Autowired
	public Game game;

	@Test
	void contextLoads() {
	}



//	@Test
//	public void whenUsingSpringBootTestArgs_thenCommandLineArgSet(@Autowired Environment env) {
//		assertTrue(env.getProperty("board.size").equalsIgnoreCase("4"));
//	}

	@Test
	public void printBoard(){
		game.printBoard();
	}
}
