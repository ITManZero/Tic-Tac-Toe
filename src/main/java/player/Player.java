package player;

import Utils.TieChecker;
import Utils.WonChecker;
import gameBoard.Board;
import gameBoard.Cell;
import gameStatus.*;
import transition.Move;
import transition.MoveTransition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Player {

    private final static WonChecker wonChecker = new WonChecker();
    private final static TieChecker tieChecker = new TieChecker();
    public static final NullPlayer NullPlayer = new NullPlayer();
    protected final List<Move> legalMoves;
    protected final Board board;

    public Player() {
        this.board = null;
        this.legalMoves = null;
    }

    public Player(final Board board) {
        this.board = board;
        this.legalMoves = calculateLegalMoves();
    }

    private List<Move> calculateLegalMoves() {
        final List<Move> moves = new ArrayList<>();
        for (final Cell cell : board.getCells())
            if (cell.isEmpty())
                moves.add(new Move(cell.getLocation(), board));
        return moves;
    }

    public MoveTransition doMove(final Move move) {
        Board toBoard = move.execute();
        TieStatus tieStatus = tieChecker.check(toBoard);
        if (tieStatus != null)
            return new MoveTransition(board, toBoard, move, tieStatus);
        WonStatus wonStatus = wonChecker.check(toBoard);
        if (wonStatus != null) {
            if (wonStatus.getPlayerSide() == board.getCurrentPlayer().getPlayerSide())
                return new MoveTransition(board, toBoard, move, wonStatus);
            else
                return new MoveTransition(board, toBoard, move, new LostStatus());
        }
        return new MoveTransition(board, toBoard, move, new RunningStatus());
    }

    public Move getMoveById(int id) {
        for (Move move : legalMoves)
            if (move.getDrawingLocation() == id) return move;
        return Move.nullMove;
    }

    public MoveTransition undoMove(Move move) {
        return new MoveTransition(board, move.undo(), move, new RunningStatus());
    }

    public List<Move> getLegalMoves() {
        return legalMoves;
    }

    public Board getBoard() {
        return board;
    }

    public abstract Player getOpponent();


    public abstract Side getPlayerSide();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        if (player.getPlayerSide() != getPlayerSide()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalMoves, board);
    }

    @Override
    public String toString() {
        return "\nPlayer :" + getPlayerSide() +
                "\nLegalMoves " + legalMoves + "\n";
    }
}
