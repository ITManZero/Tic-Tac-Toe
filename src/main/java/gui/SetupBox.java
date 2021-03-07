package gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import switchfx.SwitchButton;
import switchfx.constants.SwitchButtonStyle;

public class SetupBox extends HBox {

    private Button undoButton;
    private SwitchButton switchButton;


    public SetupBox() {
        undoButton = new Button("undo");
        switchButton = new SwitchButton(SwitchButtonStyle.SQUARE);
        Label aiText = new Label("AI");
        aiText.setId("aiText");
        Label multiPlayerText = new Label("MultiPlayer");
        multiPlayerText.setId("multiPlayerText");
        this.getChildren().addAll(undoButton, multiPlayerText, switchButton, aiText);
        this.setPadding(new Insets(40,0,0,50));
        this.setId("setupBox");
    }


    public SwitchButton getSwitchButton() {
        return switchButton;
    }


    public Button getUndoButton() {
        return undoButton;
    }
}
