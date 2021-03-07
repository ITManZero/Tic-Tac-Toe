package Utils;

import gameBoard.Board;
import gameBoard.EmptyCell;
import player.Side;
import static gameBoard.Board.*;

public class BoardUtil {


    public static final int BOARD_CELLS_NUMBER = 9;
    public static final int COL_NUMBER = 3;
    public static final WonChecker wonChecker = new WonChecker();
    public static final TieChecker tieChecker = new TieChecker();


    public static Board InitializeEmptyBoard() {
        Builder builder = new Builder();
        builder.setNextPlayer(Side.X);
        for (int i = 0; i < BOARD_CELLS_NUMBER; i++)
            builder.setCell(new EmptyCell(i), i);
        return builder.build();
    }


    public static int getRowSize(int cellLocation) {
        if (cellLocation < 3) return 3;
        if (cellLocation < 6) return 6;
        if (cellLocation < 9) return 9;
        return -1;
    }

    public static int getColSize(int cellLocation) {
        if (cellLocation % 3 == 0) return 7;
        if (cellLocation % 3 == 1) return 8;
        if (cellLocation % 3 == 2) return 9;
        return -1;
    }
}
