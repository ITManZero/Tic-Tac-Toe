package player;

import transition.Move;
import transition.MoveTransition;

public class NullPlayer extends Player {

    @Override
    public MoveTransition undoMove(Move move) {
        return super.undoMove(Move.nullMove);
    }

    @Override
    public MoveTransition doMove(Move move) {
        return super.doMove(Move.nullMove);
    }

    @Override
    public Move getMoveById(int id) {
        return Move.nullMove;
    }

    @Override
    public Player getOpponent() {
        return null;
    }

    @Override
    public Side getPlayerSide() {
        return null;
    }
}
