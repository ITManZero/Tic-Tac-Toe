package ai;

import gameBoard.Board;
import player.Player;
import player.Side;

public interface Evaluator {

    int evaluate(Board board,Player player);

    int checkDiagonal(int celLocation, Board board, Player player);

    int checkHorizontal(int celLocation, Board board, Player player);

    int checkVertical(int celLocation, Board board, Player player);
}
