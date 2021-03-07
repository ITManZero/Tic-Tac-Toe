package gui;

import Utils.BoardUtil;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import player.Side;

import java.util.ArrayList;
import java.util.List;

public class BoardPane extends GridPane {

    private static final CellPane[] CELL_PANES = new CellPane[BoardUtil.BOARD_CELLS_NUMBER];

    public BoardPane() {
        this.setId("centerGridPane");
        int counter = 0;
        for (int i = 0; i < BoardUtil.BOARD_CELLS_NUMBER / 3; i++)
            for (int j = 0; j < BoardUtil.BOARD_CELLS_NUMBER / 3; j++) {
                CELL_PANES[counter] = new CellPane(counter);
                this.add(CELL_PANES[counter++], j, i);
            }
        this.setHgap(5);
        this.setVgap(5);
    }

    public CellPane[] getCellPanes() {
        return CELL_PANES;
    }

    public CellPane getCellPane(int id) {
        return CELL_PANES[id];
    }

    public void clearBoard() {
        for (CellPane cell : CELL_PANES)
            cell.toEmpty();
    }


    public class CellPane extends StackPane {

        private final int cellId;

        public CellPane(int cellId) {
            this.setId("cellStackPane");
            this.cellId = cellId;
        }

        public int getCellId() {
            return cellId;
        }

        public void draw(Side playerSide) {
            if (playerSide.isX()) {
                Timeline timeline = new Timeline();
                Line line1 = new Line(-70, -70, -70, -70);
                Line line2 = new Line(-70, 70, -70, 70);
                line1.setStrokeWidth(25);
                line2.setStrokeWidth(25);
                line1.setStroke(Color.GRAY);
                line2.setStroke(Color.GRAY);
                this.getChildren().add(line1);
                this.getChildren().add(line2);

                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3f),
                        new KeyValue(line1.endXProperty(), 70),
                        new KeyValue(line1.endYProperty(), 70)));

                timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.3f),
                        new KeyValue(line2.endXProperty(), 70),
                        new KeyValue(line2.endYProperty(), -70)));

                timeline.play();
            } else {

                Circle circle = new Circle(70);
                circle.setFill(Color.TRANSPARENT);
                circle.setStroke(Color.GRAY);
                circle.setStrokeWidth(25);
                this.getChildren().add(circle);
            }
        }

        public void wonEffect() {
            List<FadeTransition> transitionList = new ArrayList<>();
            for (Node node : getChildren()) {
                FadeTransition fade = new FadeTransition();
                fade.setDuration(Duration.millis(500));
                fade.setFromValue(10);
                fade.setToValue(0.4);
                fade.setCycleCount(6);
                fade.setAutoReverse(true);
                fade.setNode(node);
                transitionList.add(fade);
            }
            for (FadeTransition fadeTransition : transitionList)
                fadeTransition.play();
        }

        public void toEmpty() {
            this.getChildren().clear();
        }
    }
}
