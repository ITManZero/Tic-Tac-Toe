package ai;

import gameBoard.Board;
import Utils.BoardUtil;
import gameBoard.Cell;
import player.Player;


public class SimpleEvaluator implements Evaluator {

    @Override
    public int evaluate(Board board, Player player) {

        int score = 0;

        for (Cell cell : board.getCells()) {
            if (cell.isEmpty() || !cell.getPlayer().equals(player)) continue;

            int emptyVertical = checkVertical(cell.getLocation(), board, Player.NullPlayer);
            int emptyHorizontal = checkHorizontal(cell.getLocation(), board, Player.NullPlayer);
            int emptyDiagonal = checkDiagonal(cell.getLocation(), board, Player.NullPlayer);
            int playerVertical = checkVertical(cell.getLocation(), board, player);
            int playerHorizontal = checkHorizontal(cell.getLocation(), board, player);
            int playerDiagonal = checkDiagonal(cell.getLocation(), board, player);

            if (playerHorizontal == 1 && emptyHorizontal == 2) score += 10;
            if (playerHorizontal == 2 && emptyHorizontal == 1) score += 100;

            if (playerVertical == 1 && emptyVertical == 2) score += 10;
            if (playerVertical == 2 && emptyVertical == 1) score += 100;

//            if (playerDiagonal == 1 && emptyDiagonal == 2) score += 10;
//            if (playerDiagonal == 2 && emptyDiagonal == 1) score += 100;

        }
        return score;
    }

    @Override
    public int checkDiagonal(int cellLocation, Board board, Player player) {
        return 0;
    }

    @Override
    public int checkHorizontal(int cellLocation, Board board, Player player) {
        int counter = 0;
        int rowSize = BoardUtil.getRowSize(cellLocation);
        for (int i = 0; cellLocation + i < rowSize; i++) {
            if (board.getCells()[cellLocation + i].getPlayer().equals(player)) counter++;
        }
        return counter;
    }

    @Override
    public int checkVertical(int cellLocation, Board board, Player player) {
        int counter = 0;
        int colSize = BoardUtil.getColSize(cellLocation);
        for (int i = 0; cellLocation + i < colSize; i += 3) {
            if (board.getCells()[cellLocation + i].getPlayer().equals(player)) counter++;
        }
        return counter;
    }

}
