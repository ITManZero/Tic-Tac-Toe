package gameBoard;

import player.Player;

public class EmptyCell extends Cell {


    public EmptyCell(int location) {
        super(location, Player.NullPlayer);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return "#\t";
    }
}
