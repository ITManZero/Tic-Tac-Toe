package Utils;

import gameBoard.Board;
import gameBoard.Cell;
import gameStatus.WonStatus;

public class WonChecker {


    public WonStatus check(Board board) {

        for (Cell cell : board.getCells()) {
            if (cell.isEmpty()) continue;
            if (cell.getLocation() == 0 && checkDiagonalLeft(cell, board))
                return new WonStatus(cell.getPlayer().getPlayerSide(), cell.getLocation(), cell.getLocation() + 4, cell.getLocation() + 8);
            else if (cell.getLocation() == 2 && checkDiagonalRight(cell, board))
                return new WonStatus(cell.getPlayer().getPlayerSide(), cell.getLocation(), cell.getLocation() + 2, cell.getLocation() + 4);

            if ((cell.getLocation() == 0 || cell.getLocation() == 3 || cell.getLocation() == 6)
                    && checkHorizontal(cell, board))
                return new WonStatus(cell.getPlayer().getPlayerSide(), cell.getLocation(), cell.getLocation() + 1, cell.getLocation() + 2);
            else if ((cell.getLocation() == 0 || cell.getLocation() == 1 || cell.getLocation() == 2)
                    && checkVertical(cell, board))
                return new WonStatus(cell.getPlayer().getPlayerSide(), cell.getLocation(), cell.getLocation() + 3, cell.getLocation() + 6);
        }
        return null;
    }

    private boolean checkHorizontal(Cell cell, Board board) {
        int counter = 1;
        int location = cell.getLocation();
        int pointer = 1;
        int offset = location + pointer;
        while (pointer < BoardUtil.COL_NUMBER) {
            if (!cell.equals(board.getCells()[offset])) return false;
            counter++;
            offset = location + ++pointer;
        }
        return counter == 3 ? true : false;
    }

    private boolean checkVertical(Cell cell, Board board) {
        int counter = 1;
        int location = cell.getLocation();
        int pointer = 1;
        int offset = location + (pointer * BoardUtil.COL_NUMBER);
        while (offset < BoardUtil.BOARD_CELLS_NUMBER) {
            if (!cell.equals(board.getCells()[offset])) return false;
            counter++;
            offset = location + (++pointer * BoardUtil.COL_NUMBER);
        }
        return counter == 3 ? true : false;
    }

    private boolean checkDiagonalLeft(Cell cell, Board board) {
        int counter = 1;
        int pointer = 1;
        int location = cell.getLocation();
        int offset = location + (pointer * BoardUtil.COL_NUMBER) + pointer;
        while (offset < BoardUtil.BOARD_CELLS_NUMBER && pointer < 3) {
            if (!cell.equals(board.getCells()[offset])) return false;
            counter++;
            offset = location + (++pointer * BoardUtil.COL_NUMBER) + pointer;
        }
        return counter == 3 ? true : false;
    }

    private boolean checkDiagonalRight(Cell cell, Board board) {
        int counter = 1;
        int pointer = 1;
        int location = cell.getLocation();
        int offset = location + (pointer * BoardUtil.COL_NUMBER) - pointer;
        while (offset < BoardUtil.BOARD_CELLS_NUMBER && pointer < 3) {
            if (!cell.equals(board.getCells()[offset])) return false;
            counter++;
            offset = location + (++pointer * BoardUtil.COL_NUMBER) - pointer;
        }
        return counter == 3 ? true : false;
    }
}
