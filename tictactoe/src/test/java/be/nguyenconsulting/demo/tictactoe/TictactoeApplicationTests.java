package be.nguyenconsulting.demo.tictactoe;


import org.assertj.core.api.Assert;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
@SpringBootTest
class TictactoeApplicationTests {


	@Test
	void contextLoads() {
	}



	@Test
	public void whenUsingSpringBootTestArgs_thenCommandLineArgSet(@Autowired Environment env) {
		assertTrue(env.getProperty("board.size").equalsIgnoreCase("4"));
	}


}
