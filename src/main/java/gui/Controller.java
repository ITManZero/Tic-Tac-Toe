package gui;

import gameBoard.Board;
import gameBoard.Cell;
import gameStatus.TieStatus;
import gameStatus.WonStatus;
import logs.MoveLog;
import player.AIPlayer;
import transition.Move;
import transition.MoveTransition;

public class Controller {

    private final GamePane gamePane;
    private Board board;
    private boolean gameOver;
    private AIPlayer aiPlayer;

    public Controller() {
        this.gamePane = new GamePane();
        this.board = Board.EMPTY_BOARD;
        this.gameOver = false;

        for (BoardPane.CellPane cellPane : this.gamePane.getBoardPane().getCellPanes()) {
            cellPane.setOnMouseClicked(event -> {

                if (gameOver) {
                    resetGame();
                } else if (getCellBoard(cellPane).isEmpty()) {
                    cellPane.draw(board.getCurrentPlayer().getPlayerSide());
                    Move move = board.getCurrentPlayer().getMoveById(cellPane.getCellId());
                    MoveLog.addLog(move);
                    MoveTransition moveTransition = board.getCurrentPlayer().doMove(move);
                    this.board = moveTransition.getToBoard();

                    gameOver = moveTransition.getBoardStatus().gameIsOver();
                    updateScores(moveTransition);

                    if (aiPlayer != null && !gameOver) {
                        moveTransition = aiPlayer.doMove(board.getCurrentPlayer());
                        this.board = moveTransition.getToBoard();
                        this.gamePane.getBoardPane().getCellPanes()[moveTransition.getMove().getDrawingLocation()].draw(board.getCurrentPlayer().getOpponent().getPlayerSide());
                        gameOver = moveTransition.getBoardStatus().gameIsOver();
                        updateScores(moveTransition);
                    }
                }
            });
        }

        this.gamePane.getSetupBox().getUndoButton().setOnMouseClicked(event -> {
            if (!gameOver) {
                BoardPane.CellPane cellPane = this.gamePane.getBoardPane().getCellPanes()[board.getMoveMaker().getDrawingLocation()];
                cellPane.toEmpty();
                Move move = this.board.getMoveMaker();
                MoveLog.removeLastRecord();
                MoveTransition moveTransition = this.board.getCurrentPlayer().undoMove(move);
                this.board = moveTransition.getToBoard();
            }
        });

        this.gamePane.getSetupBox().getSwitchButton().setOnMouseClicked(event -> {
            if (this.gamePane.getSetupBox().getSwitchButton().isSwitchedOn())
                aiPlayer = new AIPlayer();
            else
                aiPlayer = null;
        });

    }

    public GamePane getGamePane() {
        return gamePane;
    }

    public void resetGame() {
        this.board = Board.EMPTY_BOARD;
        this.gamePane.getBoardPane().clearBoard();
        gameOver = false;
    }


    private void updateScores(MoveTransition moveTransition) {

        if (moveTransition.getBoardStatus() instanceof TieStatus) this.gamePane.getScoreBox().addToTieScore();

        else if (moveTransition.getBoardStatus() instanceof WonStatus) {
            if (moveTransition.getFromBoard().getCurrentPlayer().getPlayerSide().isX())
                this.gamePane.getScoreBox().addToXScore();
            else
                this.gamePane.getScoreBox().addToYScore();

            for (int id : ((WonStatus) moveTransition.getBoardStatus()).getCells())
                this.gamePane.getBoardPane().getCellPanes()[id].wonEffect();
        }
    }


    private Cell getCellBoard(final BoardPane.CellPane cellPane) {
        return board.getCells()[cellPane.getCellId()];
    }
}
