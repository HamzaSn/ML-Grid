package App.Controllers;

import App.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label info;

    @FXML
    private void handleSubmitButtonAction(ActionEvent actionEvent) throws IOException {
        System.out.println(passwordField.getText());
        if( userNameField.getText().equals("root") && passwordField.getText().equals("hamza")){
           Stage stage = (Stage) userNameField.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800 , 600);
            stage.setResizable(false);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        } else {
            info.setText("wrong password!");
        }
    }
}