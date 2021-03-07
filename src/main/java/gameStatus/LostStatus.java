package gameStatus;

public class LostStatus extends GameStatus {

    public LostStatus() {
        super(-1);
    }

    @Override
    public String getStatusLog() {
        return "Lost status";
    }

    @Override
    public boolean gameIsOver() {
        return true;
    }
}
