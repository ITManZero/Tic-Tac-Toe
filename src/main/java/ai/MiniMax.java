package ai;

import gameBoard.Board;
import gameStatus.RunningStatus;
import player.Side;
import transition.Move;
import transition.MoveTransition;

public class MiniMax {

    private int depth = 2;
    private Evaluator evaluator;
    private Side aiSide;

    public MiniMax(Side aiSide, Evaluator evaluator) {
        this.evaluator = evaluator;
        this.aiSide = aiSide;
    }

    public Move bestMove(Board board) {
        int bestScore = Integer.MAX_VALUE;
        Move bestMove = Move.nullMove;
        for (Move move : board.getCurrentPlayer().getLegalMoves()) {
            int miniMaxScore = miniMax(board.getCurrentPlayer().doMove(move), depth, true);
            System.out.println("location: " + move.getDrawingLocation() + "\t score: " + miniMaxScore);
            if (miniMaxScore < bestScore) {
                bestMove = move;
                bestScore = miniMaxScore;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        return bestMove;
    }

    private int miniMax(MoveTransition moveTransition, int depth, boolean isMaximizing) {
        Board board = moveTransition.getToBoard();

        if (!(moveTransition.getBoardStatus() instanceof RunningStatus))
            if (moveTransition.getFromBoard().getCurrentPlayer().getPlayerSide() == aiSide)
                return -moveTransition.getBoardStatus().getScore();
            else
                return moveTransition.getBoardStatus().getScore();


        if (depth == 0)
            if (moveTransition.getFromBoard().getCurrentPlayer().getPlayerSide() == aiSide)
                return -evaluator.evaluate(board, board.getCurrentPlayer().getOpponent());
            else
                return evaluator.evaluate(board, board.getCurrentPlayer().getOpponent());

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (Move move : board.getCurrentPlayer().getLegalMoves())
                bestScore = Math.max(miniMax(board.getCurrentPlayer().doMove(move), depth - 1, false), bestScore);
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (Move move : board.getCurrentPlayer().getLegalMoves())
                bestScore = Math.min(miniMax(board.getCurrentPlayer().doMove(move), depth - 1, true), bestScore);
            return bestScore;
        }
    }
}
