package gameBoard;

import Utils.BoardUtil;
import transition.Move;
import player.OPlayer;
import player.Player;
import player.Side;
import player.XPlayer;

import static transition.Move.*;

public class Board {

    private final Cell[] cells;
    private final OPlayer oPlayer;
    private final XPlayer xPlayer;
    private final Player currentPlayer;
    private final Move moveMaker;

    public static final Board EMPTY_BOARD = BoardUtil.InitializeEmptyBoard();

    private Board(final Cell[] cells, final Side nextPlayer, final Move moveMaker) {
        this.cells = cells;
        this.oPlayer = new OPlayer(this);
        this.xPlayer = new XPlayer(this);
        this.currentPlayer = nextPlayer.isX() ? xPlayer : oPlayer;
        this.moveMaker = moveMaker != null ? moveMaker : nullMove;
    }

    public Cell[] getCells() {
        return cells;
    }

    public OPlayer getOPlayer() {
        return oPlayer;
    }

    public XPlayer getXPlayer() {
        return xPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Move getMoveMaker() {
        return moveMaker;
    }

    public void printBoard() {
        int i = 0;
        for (final Cell cell : cells) {
            if (i % 3 == 0) System.out.println();
            System.out.print(cell);
            i++;
        }
        System.out.println();
    }




    public static final class Builder {

        private Cell[] cells;
        private Side nextPlayer;
        private Move moveMaker;

        public Builder() {
            cells = new Cell[BoardUtil.BOARD_CELLS_NUMBER];
        }

        public Board build() {
            return new Board(cells, nextPlayer, moveMaker);
        }

        public Builder setCell(final Cell cell, final int location) {
            cells[location] = cell;
            return this;
        }

        public void setMoveMaker(Move moveMaker) {
            this.moveMaker = moveMaker;
        }

        public Builder setNextPlayer(Side nextPlayer) {
            this.nextPlayer = nextPlayer;
            return this;
        }
    }

}
