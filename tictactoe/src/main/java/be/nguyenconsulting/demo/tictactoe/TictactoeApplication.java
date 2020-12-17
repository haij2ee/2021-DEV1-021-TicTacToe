package be.nguyenconsulting.demo.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TictactoeApplication implements CommandLineRunner {

    @Autowired
    private Environment env;

    @Value("${board.size}")
    public static int GRID;

    private static Logger LOG = LoggerFactory.getLogger(TictactoeApplication.class);

    @Autowired
    private Game game;

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");

        SpringApplication.run(Game.class, args);


        LOG.info("APPLICATION FINISHED");

    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("EXECUTING : command line runner");


        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }

    public Environment getEnv() {
        return env;
    }

    public int getGRID() {
        return GRID;
    }
}
