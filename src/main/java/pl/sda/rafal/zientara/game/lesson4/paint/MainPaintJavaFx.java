package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainPaintJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass()
                .getResource("/paint2.fxml"));
        primaryStage.setTitle("Vector paint");
        primaryStage.setScene(new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}