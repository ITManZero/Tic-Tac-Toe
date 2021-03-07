package player;

import ai.MiniMax;
import ai.SimpleEvaluator;
import transition.MoveTransition;

public class AIPlayer {

    public MoveTransition doMove(Player player) {
        MiniMax miniMax = new MiniMax(player.getPlayerSide(), new SimpleEvaluator());
        return player.doMove(miniMax.bestMove(player.board));
    }


    public MoveTransition undoMove(Player player) {
        return player.undoMove(player.board.getMoveMaker());
    }

}
