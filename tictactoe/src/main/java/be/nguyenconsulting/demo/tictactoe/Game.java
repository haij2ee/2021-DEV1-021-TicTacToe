package be.nguyenconsulting.demo.tictactoe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;



@Component
public class Game implements CommandLineRunner {


    private static final Logger LOG = LoggerFactory.getLogger(Game.class);
    public static final String FILLER = " ";

    private String[][] board;

    private Integer SIZE = 3;


    public String[][] getBoard() {
        return board;
    }

    public Game(Integer grid) {
        SIZE = grid < 3 ? 3 : grid;
        board = new String[SIZE][SIZE];
        clearBoard();
    }

    public Game() {
        board = new String[SIZE][SIZE];
        clearBoard();

    }

    public void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = FILLER;
            }
        }
    }


    public void printBoard() {
        String header = "  ";
        for (int j = 0; j < SIZE; j++) {
            header += "|" + (j + 1);
        }
        System.out.println(header);
        for (int j = 0; j < SIZE * 3; j++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            String row = (i + 1) + " ";
            for (int j = 0; j < SIZE; j++) {
                row += "|" + board[i][j];
            }
            System.out.println(row);
            for (int j = 0; j < SIZE * 3; j++) {
                System.out.print("_");
            }
            System.out.println();
        }
        System.out.println(" Turn now");
    }

    @Override
    public void run(String... args) throws Exception {

        LOG.info("Game ");
        printBoard();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String typedText = scanner.nextLine();
            LOG.info("Game: " + typedText);
        }

    }


    public void start() {
        clearBoard();
        printBoard();
    }

}
