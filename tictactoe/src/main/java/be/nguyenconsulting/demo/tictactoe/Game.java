package be.nguyenconsulting.demo.tictactoe;


import be.nguyenconsulting.demo.tictactoe.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Game implements CommandLineRunner {


    public static final String FILLER = " ";
    private static final Logger LOG = LoggerFactory.getLogger(Game.class);
    private static int SIZE = 3;
    private String[][] board;
    private Player currentPlayer = null;

    private Player[] players =
            {new Player("Humain1", "X"), new Player("Humain2", "O")};


    public Game(int grid, String player1, String player2) {
        this(grid, player1);
        players[1] = new Player(player2, "O");
    }

    public Game(Integer grid, String player) {
        SIZE = grid < 3 ? 3 : grid;
        board = new String[SIZE][SIZE];
        players[0] = new Player(player, "X");
        currentPlayer = players[0];
        clearBoard();
    }

    public Game() {
        board = new String[SIZE][SIZE];
        players[0] = new Player("Humain1", "X");
        currentPlayer = players[0];
        clearBoard();

    }

    public String[][] getBoard() {
        return board;
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

        LOG.debug("Game ");
        start();


    }


    public void start() {
        LOG.debug("START");
        //       clearBoard();
        printBoard();
        currentPlayer.playMove(this);

    }

    private void changePlayer() {
        LOG.debug("change Player: currPlayer is " + currentPlayer.getName());
        currentPlayer = currentPlayer.equals(players[1]) ? players[0] : players[1];
    }

    public void move(int xPosition, int yPosition) {
        LOG.debug("move");
        board[xPosition][yPosition] = currentPlayer.getSymbol();
        changePlayer();
        printBoard();
        currentPlayer.playMove(this);
    }

}





}
