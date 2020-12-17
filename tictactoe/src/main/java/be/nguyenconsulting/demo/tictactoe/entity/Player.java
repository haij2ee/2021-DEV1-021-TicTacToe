package be.nguyenconsulting.demo.tictactoe.entity;


import be.nguyenconsulting.demo.tictactoe.Game;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;


@Component
public class Player {
    private String name;

    private String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
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


}
