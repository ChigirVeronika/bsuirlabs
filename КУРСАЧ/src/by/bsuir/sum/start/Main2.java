package by.bsuir.sum.start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Вероника on 10.05.2015.
 */
public class Main2 {
    public  Main2() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/mainlogiccontroller.fxml"));
        AnchorPane load = (AnchorPane)loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Social Network");

        scene.getStylesheets().add
                (Main2.class.getResource("../style/Styles.css").toExternalForm());

        stage.show();
        //Main1.onExit();
    }

}
