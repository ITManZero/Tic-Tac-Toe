package gameBoard;

import player.Player;

public class FilledCell extends Cell {


    public FilledCell(final int location, final Player player) {
        super(location, player);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return getPlayer().getPlayerSide().symbol() + "\t";
    }
}
