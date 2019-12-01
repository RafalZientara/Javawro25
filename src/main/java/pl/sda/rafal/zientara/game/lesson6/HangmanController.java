package pl.sda.rafal.zientara.game.lesson6;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;

import java.util.List;
import java.util.Random;


public class HangmanController {

    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private Line line3;
    @FXML
    private Line line4;
    @FXML
    private Line line5;
    @FXML
    private Line line6;
    @FXML
    private Group human;

    @FXML
    private Label hpLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField letterInput;
    @FXML
    private Button submitButton;

    private HangmanGame game;

    @FXML
    public void initialize() {
        System.out.println("jest");
        reset();
    }

    @FXML
    public void handleResetButton() {
        reset();
    }

    @FXML
    public void handleSubmitButton() {
        String text = letterInput.getText();
        try {
            game.guessLetter(text);
        }catch (GameOverException e){

        }
        letterInput.clear();
        refreshUI();
    }

    private void refreshUI() {
        passwordLabel.setText(game.getCurrentResult());
        hpLabel.setText(String.format("%d/%d HP", game.getHP(), 7));
        refreshHangman();
    }

    private void refreshHangman() {
        line1.setVisible(false);
        line2.setVisible(false);
        line3.setVisible(false);
        line4.setVisible(false);
        line5.setVisible(false);
        line6.setVisible(false);
        human.setVisible(false);
        switch (game.getHP()) {
            case 0:
                human.setVisible(true);
            case 1:
                line6.setVisible(true);
            case 2:
                line5.setVisible(true);
            case 3:
                line4.setVisible(true);
            case 4:
                line3.setVisible(true);
            case 5:
                line2.setVisible(true);
            case 6:
                line1.setVisible(true);
        }
        }

        private void reset () {
            game = new HangmanGame();
            List<String> data = Resources.DATA;
            int randomIndex = new Random().nextInt(data.size());
            String randomSecret = data.get(randomIndex);
            game.setSecret(randomSecret);
            refreshUI();
        }


    }


