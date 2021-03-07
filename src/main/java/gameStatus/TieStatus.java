package gameStatus;

public class TieStatus extends GameStatus {

    public TieStatus() {
        super(0);
    }

    public String getStatusLog() {
        return "Tie Status";
    }

    @Override
    public boolean gameIsOver() {
        return true;
    }

}
