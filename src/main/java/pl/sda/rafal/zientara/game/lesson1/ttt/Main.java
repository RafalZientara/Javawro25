package pl.sda.rafal.zientara.game.lesson1.ttt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/calc.fxml"));
        primaryStage.setTitle("Kalkulator");
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}