package be.nguyenconsulting.demo.tictactoe;


import be.nguyenconsulting.demo.tictactoe.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class Game implements CommandLineRunner {


    public static final String FILLER = " ";
    private static final Logger LOG = LoggerFactory.getLogger(Game.class);
    public static int SIZE = 3;
    private String[][] board;
    private Player currentPlayer = null;

    private Player[] players =
            {new Player("The X player", "X"), new Player("The O player", "O")};


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
        players[0] = new Player("The X player", "X");
        currentPlayer = players[0];
        clearBoard();

    }

    public String[][] getBoard() {
        return board;
    }


    @Override
    public void run(String... args) throws Exception {

        start();
        printResult();
        while (true){
            System.out.println("Type C or R if you want to play another game, type S if you want to shutdown");
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();
                if (input.equalsIgnoreCase("C") || input.equalsIgnoreCase("R") )
                    reset();
                if (input.equalsIgnoreCase("S"))
                    break;
            }catch (Exception e){
                LOG.debug(e.getMessage());
            }
        }


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





    /* Reset the board as well as making the X player always starts first */
    public void reset() {
        LOG.debug("reset");
        clearBoard();
        printBoard();
        currentPlayer = players[0];
        currentPlayer.playMove(this);

    }

    public void start() {
        LOG.debug("START");
        printBoard();
        currentPlayer.playMove(this);

    }

    private void changePlayer() {
        LOG.debug("change Player: currPlayer is " + currentPlayer.getName());
        currentPlayer = currentPlayer.equals(players[1]) ? players[0] : players[1];
    }

    public void move(int xCoordination, int yCoordination) {
        LOG.debug("move");
        if (!isValidPoint(xCoordination, yCoordination) && isEmpty(xCoordination,yCoordination))
            currentPlayer.playMove(this);
        board[xCoordination][yCoordination] = currentPlayer.getSymbol();
        changePlayer();
        printBoard();

        // if the game is not yet over, there a no 3 consecutive points of the same symbol on a row, a column or diagonal
        if(!isGameOver()) {
            currentPlayer.playMove(this);
        }
    }

    /* Check to see if the move is to a valid point on the board or a full point */
    private boolean isValidPoint(int xCoordination, int yCoordination) {
        if (xCoordination >= SIZE || yCoordination >= SIZE || xCoordination < 0 || yCoordination < 0)
            return false;

        return true;
    }


    private  boolean isEmpty(int xCoordination, int yCoordination) {
        if (!board[xCoordination][yCoordination].equals(FILLER)) {
            return false;
        }

        return true;

    }



    private String checRow() {
        for (int i = 0; i < SIZE; i++) {
            String check = board[i][0];
            for (int j = 1; j < SIZE; j++) {
                if (!check.equals(board[i][j])) {
                    check = FILLER;
                    break;
                }
            }
            if (!check.equals(FILLER)) {
                return check;
            }
        }
        return FILLER;
    }

    private String checkColum() {
        for (int i = 0; i < SIZE; i++) {
            String check = board[0][i];
            for (int j = 1; j < SIZE; j++) {
                if (!check.equals(board[j][i])) {
                    check = FILLER;
                    break;
                }
            }
            if (!check.equals(FILLER)) {
                return check;
            }
        }
        return FILLER;
    }

    private String diagonalCrossed() {
        String check = board[0][0];
        for (int i = 1; i < SIZE; i++) {
            if (!check.equals(board[i][i])) {
                check = FILLER;
                break;
            }
        }
        if (!check.equals(FILLER)) {
            return check;
        }
        check = board[0][2];
        for (int i = 1; i < SIZE; i++) {
            if (!check.equals(board[i][SIZE - 1 - i])) {
                check = FILLER;
                break;
            }
        }
        if (!check.equals(FILLER)) {
            return check;
        }
        return FILLER;
    }



    public Player whoIsWinner() {
        String rowSymbol = checRow();
        String columnSymbol = checkColum();
        String diagonalSymbol = diagonalCrossed();
        for (Player player : players) {
            if (player.getSymbol().equals(rowSymbol)) return player;
            if (player.getSymbol().equals(columnSymbol)) return player;
            if (player.getSymbol().equals(diagonalSymbol)) return player;
        }
        System.out.println("no winner yet");
        return null;
    }


    private boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].equals(FILLER)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isGameOver() {
        return whoIsWinner() != null || isFull();
    }


    public void printResult(){

        Player player = whoIsWinner();
        if (player!=null) {
            System.out.println("Congratulation player " + player.getName());
        }

    }
}
