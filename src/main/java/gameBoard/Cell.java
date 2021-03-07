package gameBoard;

import player.Player;

import java.util.Objects;

public abstract class Cell {

    private final int location;
    private final Player player;

    public Cell(int location, Player player) {
        this.player = player;
        this.location = location;
    }

    public abstract boolean isEmpty();

    public Player getPlayer() {
        return player;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(player.getPlayerSide(), cell.player.getPlayerSide());
    }

}
