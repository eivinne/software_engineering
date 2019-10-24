import Model.Arrangor;
import Model.Deltager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

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

        System.out.println(Main.this);

    }
    Deltager bruker = new Deltager("Sander","Kander",12,"kulKar123@hiof.no","Bruker","passord123");
    Arrangor arrangor = new Arrangor("Maria","Casino",14,"minsLike@kul.no","Arrangør","drossap123","Gamblers");

    public static void main(String[] args) {
        launch(args);
    }
}