package gameStatus;

public abstract class GameStatus {

    protected final int score;

    protected GameStatus(int score) {
        this.score = score;
    }

    public abstract String getStatusLog();

    public int getScore() {
        return score;
    }

    public abstract boolean gameIsOver();
}
