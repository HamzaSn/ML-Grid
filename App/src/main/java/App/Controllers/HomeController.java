package App.Controllers;

import App.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeController {
    
    @FXML
    private Label newButton;

    
    @FXML
    private void newAnalysis() throws IOException{
        Stage stage = (Stage) newButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dataLoading-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800 , 600);
            stage.setResizable(false);
            stage.setTitle("Data import");
            stage.setScene(scene);
            stage.show();
    }



}
