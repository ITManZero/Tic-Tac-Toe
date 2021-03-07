package player;

import gameBoard.Board;

public class XPlayer extends Player {

    public XPlayer(Board board) {
        super(board);
    }

    @Override
    public Player getOpponent() {
        return this.board.getOPlayer();
    }


    @Override
    public Side getPlayerSide() {
        return Side.X;
    }
}
