package by.bsuir.sum.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main1 extends Application {
    public Button ExitButton;

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/begincontroller.fxml"));
        AnchorPane load = (AnchorPane)loader.load();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Social Network");
        //-fx-background-image: url("../data/background.jpg");

        System.out.print("awsexdrcftvgybhunjimk,l.");
        scene.getStylesheets().add
                (Main1.class.getResource("../style/Styles.css").toExternalForm());

        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

//    public void onExit(ActionEvent actionEvent) {
//        Stage stage = (Stage) ExitButton.getScene().getWindow();
//        stage.close();
//    }


}
