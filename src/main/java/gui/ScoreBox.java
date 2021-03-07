package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class ScoreBox extends HBox {

    private Label xScore;
    private Label tieScore;
    private Label yScore;

    public ScoreBox() {
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        VBox vBox3 = new VBox();
        Label playerX = new Label("Player(X)");
        Label tie = new Label("Tie");
        Label playerY = new Label("Player(O)");
        xScore = new Label("0");
        tieScore = new Label("0");
        yScore = new Label("0");
        xScore.setId("scoreBoxLabel");
        tieScore.setId("scoreBoxLabel");
        yScore.setId("scoreBoxLabel");
        playerX.setId("scoreBoxLabel");
        tie.setId("scoreBoxLabel");
        playerY.setId("scoreBoxLabel");
        vBox1.setId("scoreBoxVBoxl");
        vBox2.setId("scoreBoxVBox2");
        vBox3.setId("scoreBoxVBox3");
        this.setId("scoreBox");
        vBox1.getChildren().addAll(playerX, xScore);
        vBox2.getChildren().addAll(playerY, yScore);
        vBox3.getChildren().addAll(tie, tieScore);
        this.getChildren().addAll(vBox1, vBox2, vBox3);
    }


    public void addToXScore() {
        xScore.setText(String.valueOf(Integer.parseInt(xScore.getText()) + 1));
    }

    public void addToYScore() {
        yScore.setText(String.valueOf(Integer.parseInt(yScore.getText()) + 1));
    }

    public void addToTieScore() {
        tieScore.setText(String.valueOf(Integer.parseInt(tieScore.getText()) + 1));

    }
}
