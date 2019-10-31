import Data.ArrangementData;
import Data.PersonData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("loginnskjerm.fxml"));
            Parent loginnSkjerm = fxmlLoader.load();
            Scene hovedScene = new Scene(loginnSkjerm, 600, 400);
            primaryStage.setTitle("THEltager");
            primaryStage.setScene(hovedScene);
            primaryStage.show();

            PersonData.genererBrukere();
            ArrangementData.genererArrangement();
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }


    }





    public static void main(String[] args) {
        launch(args);
    }
}