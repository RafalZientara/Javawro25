package pl.sda.rafal.zientara.game.lesson2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import pl.sda.rafal.zientara.game.lesson1.ttt.FieldStatus;
import pl.sda.rafal.zientara.game.lesson1.ttt.TTTGame;
import pl.sda.rafal.zientara.game.lesson1.ttt.TTTPosition;

public class TTTController {

    @FXML
    private Button actionTopLeft;
    @FXML
    private Button actionTopCenter;
    @FXML
    private Button actionTopRight;
    @FXML
    private Button actionCenterLeft;
    @FXML
    private Button actionCenter;
    @FXML
    private Button actionCenterRight;
    @FXML
    private Button actionBottomLeft;
    @FXML
    private Button actionBottomCenter;
    @FXML
    private Button actionBottomRight;
    @FXML
    private GridPane grid;
    @FXML
    private Label label;

    private TTTGame game;

    @FXML
    public void initialize() {
        System.out.println("Hello");
        game = new TTTGame();
    }

    @FXML
    private void handleClick(ActionEvent event) {
        Object object = event.getSource();
        if (object instanceof Button) {
            Button button = (Button) object;
            Node n = (Node) object;
            int col = GridPane.getColumnIndex(button);
            int row = GridPane.getRowIndex(button);
            performAction(new TTTPosition(col, row), button);
        }
    }

    //todo dodaj opcję reset do gry. Dodaj przycisk i zresetuj stan TTTGame oraz widoku by wygladalo jak po uruchomieniu

    private void performAction(TTTPosition position, Button button) {
        game.action(position.column, position.row);
        System.out.println(position);
        FieldStatus status = game.getFieldStatus(position.column, position.row);
        button.setText(status.getStatus());
        button.setDisable(true);
        //todo wyświetl stan gry (game.checkResult()) w label
    }

}
