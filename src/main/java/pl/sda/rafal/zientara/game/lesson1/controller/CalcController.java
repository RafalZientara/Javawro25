package pl.sda.rafal.zientara.game.lesson1.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.MathContext;

public class CalcController {
    @FXML
    private TextField pole;

    private BigDecimal value = new BigDecimal(0);
    private Operation currentOperation;
    private boolean shouldClearOnAppend = false;

    @FXML
    private void handlePlusPressed(ActionEvent event) {
        handleOperationPressed(Operation.ADD);
    }

    @FXML
    private void handleMinusPressed(ActionEvent event) {
        handleOperationPressed(Operation.MINUS);
    }

    @FXML
    private void handleMultPressed(ActionEvent event) {
        handleOperationPressed(Operation.MULT);
    }

    @FXML
    private void handleDivPressed(ActionEvent event) {
        handleOperationPressed(Operation.DIV);
    }

    private void handleOperationPressed(Operation operation) {
        value = getValueFromScreen();
        currentOperation = operation;
        shouldClearOnAppend = true;
    }

    private BigDecimal getValueFromScreen() {
        return new BigDecimal(pole.getText().replace(",", "."));
    }

    @FXML
    private void handleEqualsPressed() {
        BigDecimal secondValue = getValueFromScreen();
        BigDecimal output = calculate(secondValue);
        String text = String.valueOf(output);
        pole.setText(text);
        shouldClearOnAppend = true;
    }

    @FXML
    private void handleACPressed() {
        pole.clear();
        value = new BigDecimal(0);
        currentOperation = null;
    }

    private BigDecimal calculate(BigDecimal secondValue) {
        switch (currentOperation) {
            case ADD:
                return value.add(secondValue);
//                return value + secondValue;
            case MINUS:
                return value.subtract(secondValue);
//                return value - secondValue;
            case MULT:
                return value.multiply(secondValue);
//                return value * secondValue;
            case DIV:
                return value.divide(secondValue, MathContext.DECIMAL128);
//                return value / secondValue;
        }
        return new BigDecimal(0);
    }

    @FXML
    private void handleZeroPressed(ActionEvent event) {
        addToScreen("0");
    }

    @FXML
    private void handle1Pressed(ActionEvent event) {
        addToScreen("1");
    }

    @FXML
    private void handle2Pressed(ActionEvent event) {
        addToScreen("2");
    }

    @FXML
    private void handle3Pressed(ActionEvent event) {
        addToScreen("3");
    }

    @FXML
    private void handle4Pressed(ActionEvent event) {
        addToScreen("4");
    }

    @FXML
    private void handle5Pressed(ActionEvent event) {
        addToScreen("5");
    }

    @FXML
    private void handle6Pressed(ActionEvent event) {
        addToScreen("6");
    }

    @FXML
    private void handle7Pressed(ActionEvent event) {
        addToScreen("7");
    }

    @FXML
    private void handle8Pressed(ActionEvent event) {
        addToScreen("8");
    }

    @FXML
    private void handle9Pressed(ActionEvent event) {
        addToScreen("9");
    }

    @FXML
    private void handleComaPressed(ActionEvent event) {
        if (!pole.getText().contains(",") && !pole.getText().contains("."))
            addToScreen(",");
    }

    private void addToScreen(String appendText) {
        if (shouldClearOnAppend) {
            pole.clear();
            shouldClearOnAppend = false;
        }
        pole.appendText(appendText);
    }
}
