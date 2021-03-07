package player;

import gameBoard.Board;

public class OPlayer extends Player {

    public OPlayer(final Board board) {
        super(board);
    }


    @Override
    public Player getOpponent() {
        return this.board.getXPlayer();
    }


    @Override
    public Side getPlayerSide() {
        return Side.O;
    }
}
