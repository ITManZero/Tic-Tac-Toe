package Utils;

import gameBoard.Board;
import gameBoard.Cell;
import gameStatus.TieStatus;

public class TieChecker{


    public TieStatus check(Board board) {
        if (fullBoard(board)) return new TieStatus();
        return null;
    }

    private boolean fullBoard(Board board) {
        for (Cell cell : board.getCells())
            if (cell.isEmpty()) return false;
        return true;
    }
}
