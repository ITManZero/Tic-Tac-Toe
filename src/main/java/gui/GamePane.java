package gui;

import javafx.scene.layout.*;

public class GamePane extends BorderPane {


    private final VBox leftVBox;
    private final VBox rightVBox;
    private final BoardPane boardPane;
    private final ScoreBox scoreBox;
    private final VBox bottomVBox;


    public GamePane() {
        this.setId("root");
        this.scoreBox = new ScoreBox();
        this.boardPane = initGameBoard();
        this.leftVBox = initLeftHBox();
        this.rightVBox = initRightHBox();
        this.bottomVBox = initBottomBBox();
        this.setLeft(leftVBox);
        this.setRight(rightVBox);
        this.setTop(scoreBox);
        this.setBottom(bottomVBox);
        this.setCenter(boardPane);
    }

    private VBox initBottomBBox() {
        VBox vBox = new VBox();
        SetupBox setupBox = new SetupBox();
        vBox.getChildren().add(setupBox);
        vBox.setId("bottomVBox");
        return vBox;
    }

    private VBox initLeftHBox() {
        VBox vBox = new VBox();
        vBox.setId("leftVBox");
        return vBox;
    }

    private VBox initRightHBox() {
        VBox vBox = new VBox();
        vBox.setId("rightVBox");
        return vBox;
    }

    private BoardPane initGameBoard() {
        BoardPane boardPane = new BoardPane();
        return boardPane;
    }

    public BoardPane getBoardPane() {
        return boardPane;
    }

    public SetupBox getSetupBox() {
        return (SetupBox) bottomVBox.getChildren().get(0);
    }

    public ScoreBox getScoreBox() {
        return scoreBox;
    }
}
