package gameStatus;


import player.Side;

public class WonStatus extends GameStatus {

    private Side playerSide;
    private final int[] cells = new int[3];


    public WonStatus(final Side playerSide, final int... cells) {
        super(1000);
        this.playerSide = playerSide;
        for (int i = 0; i < cells.length; i++)
            this.cells[i] = cells[i];
    }

    public int[] getCells() {
        return cells;
    }

    public Side getPlayerSide() {
        return playerSide;
    }

    @Override
    public String getStatusLog() {
        return "Won status";
    }

    @Override
    public boolean gameIsOver() {
        return true;
    }

}
