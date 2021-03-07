package gameStatus;


public class RunningStatus extends GameStatus {


    public RunningStatus() {
        super(0);
    }

    public String getStatusLog() {
        return "Running status";
    }

    @Override
    public boolean gameIsOver() {
        return false;
    }

}
