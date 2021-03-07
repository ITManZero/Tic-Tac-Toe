package transition;

import gameBoard.Board;
import gameStatus.GameStatus;


public class MoveTransition {

    private final Board fromBoard;
    private final Board toBoard;
    private final Move move;
    private GameStatus boardStatus;

    public MoveTransition(final Board fromBoard, final Board toBoard,
                          final Move move, final GameStatus boardStatus) {
        this.fromBoard = fromBoard;
        this.toBoard = toBoard;
        this.move = move;
        this.boardStatus = boardStatus;
    }

    public Board getFromBoard() {
        return fromBoard;
    }

    public Board getToBoard() {
        return toBoard;
    }

    public Move getMove() {
        return move;
    }


    public GameStatus getBoardStatus() {
        return boardStatus;
    }
}
