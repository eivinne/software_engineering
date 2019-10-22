import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("arrangorView.fxml"));

        Parent loginnSkjerm = fxmlLoader.load();

        Scene hovedScene = new Scene(loginnSkjerm, 600, 400);

        primaryStage.setScene(hovedScene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}