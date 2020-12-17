package be.nguyenconsulting.demo.tictactoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TictactoeApplication implements CommandLineRunner {

	@Autowired
	private Environment env;

	public  int GRID = 3;

	private static Logger LOG = LoggerFactory.getLogger(TictactoeApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");

		SpringApplication.run(TictactoeApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		String x = scanner.nextLine();
		LOG.info("x" +x);

		LOG.info("APPLICATION FINISHED");

	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");


		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}


}
