package be.nguyenconsulting.demo.tictactoe.entity;


import be.nguyenconsulting.demo.tictactoe.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Component
public class Player {

    private static final Logger LOG = LoggerFactory.getLogger(Player.class);
    @Getter  private String name;


    @Getter private String symbol;


    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(symbol, player.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol);
    }

    public void playMove(Game game) {
        LOG.debug("playMove");
        System.out.println("Enter your x,y positions -> For first row and first column enter 1,1");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            String[] moves = input.split(",");
            game.move(Integer.parseInt(moves[0]) - 1, Integer.parseInt(moves[1]) - 1);
        } catch (Exception e) {
            playMove(game);
        }
    }

}
