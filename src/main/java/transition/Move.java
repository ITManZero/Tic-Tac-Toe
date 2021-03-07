package transition;

import gameBoard.*;
import gameBoard.Board.Builder;

public class Move {

    private final Board board;
    private final int drawingLocation;
    public static final NullMove nullMove = NullMove.nullMove;

    public Move(final int drawingLocation, final Board board) {
        this.drawingLocation = drawingLocation;
        this.board = board;
    }


    public int getDrawingLocation() {
        return drawingLocation;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "FromPlayer:(" + board.getCurrentPlayer().getPlayerSide() + ")\tToLocation: " + drawingLocation;
    }

    public Board execute() {
        Builder builder = new Builder();
        for (final Cell cell : board.getCells()) {
            if (cell.getLocation() == drawingLocation && cell.isEmpty())
                builder.setCell(new FilledCell(cell.getLocation(), board.getCurrentPlayer()), cell.getLocation());
            else
                builder.setCell(cell, cell.getLocation());
        }
        builder.setNextPlayer(board.getCurrentPlayer().getOpponent().getPlayerSide());
        builder.setMoveMaker(this);
        return builder.build();
    }

    public Board undo() {
        Builder builder = new Builder();
        for (final Cell cell : board.getCells())
            builder.setCell(cell, cell.getLocation());
        builder.setMoveMaker(board.getMoveMaker());
        builder.setNextPlayer(board.getCurrentPlayer().getPlayerSide());
        return builder.build();
    }

    public static final class NullMove extends Move {

        private static final NullMove nullMove = new NullMove();

        private NullMove() {
            super(-1, null);
        }

        @Override
        public Board undo() {
            throw new RuntimeException("There is no executed move to undo it");
        }

        @Override
        public Board execute() {
            throw new RuntimeException("cannot execute null move!");
        }
    }


}
