package App.Controllers;

import App.MainApplication;
import App.Models.DataInfo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class HomeController {



    @FXML
    private Label infoSessionName;
    @FXML
    private TextField infoSessionInput;
    @FXML
    private Label goButton;
    @FXML
    private Rectangle rect;
    @FXML
    private Label historyButton;
    @FXML
    private ChoiceBox<String> choiceBoxHistory;
    @FXML
    private Label goHistoryButton;
    @FXML
    private Label warnings;
    @FXML
    private  ImageView warningImage;

    ArrayList<File> directories;

    @FXML
    private void initialize(){
        directories = new ArrayList<>(
                Arrays.asList(
                        Objects.requireNonNull(new File("./analysis_history").listFiles(File::isDirectory))
                )
        );
        ObservableList<String> history_dir = FXCollections.observableArrayList();
        for(File dir : directories){
            history_dir.add(dir.getName());
        }
        choiceBoxHistory.setStyle("-fx-font-color:black;-fx-font-size : 16;-fx-background-color : transparent;");
        choiceBoxHistory.setValue("Analysis History");
        choiceBoxHistory.setItems(history_dir);
        choiceBoxHistory.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                infoSessionInput.setVisible(false);
                infoSessionName.setVisible(false);
                goButton.setVisible(false);
                goHistoryButton.setVisible(true);
                rect.setVisible(true);
            }
        });
    }

    @FXML
    private void newAnalysis() {
        warnings.setVisible(false);
        warningImage.setVisible(false);
        infoSessionInput.setVisible(true);
        infoSessionName.setVisible(true);
        goButton.setVisible(true);
        goHistoryButton.setVisible(false);
        rect.setVisible(true);
       
    }

    @FXML
    private void choiceBoxSelected(){
        warnings.setVisible(false);
        warningImage.setVisible(false);
    }

    @FXML
    private void go() throws IOException{
    if(!infoSessionInput.getText().equals("")){
        boolean exists = false;
        for(File dir : directories){
            if(dir.getName().equals(infoSessionInput.getText())){
                exists = true;
            }
        }
        if(exists){
            warnings.setVisible(true);
            warningImage.setVisible(true);
            warnings.setText("Session name already exists");
        } else {
            DataInfo.info.put("session_name",infoSessionInput.getText());
            DataInfo.info.put("instance_name","./analysis_history/"+infoSessionInput.getText());
            Stage stage = (Stage) goButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dataLoading-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setResizable(false);
            stage.setTitle("Data import");
            stage.setScene(scene);
            stage.show();

        }

    } else {
        DataInfo.info.put("session_name","");
        DataInfo.info.put("instance_name","");
        Stage stage = (Stage) goButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dataLoading-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Data import");
        stage.setScene(scene);
        stage.show();
    }

    }


    @FXML
    private void goHistory() throws IOException {
        int ind = choiceBoxHistory.getSelectionModel().getSelectedIndex();
        DataInfo.info.put("instance_name",directories.get(ind).toString());
        Stage stage = (Stage) goHistoryButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("IDE-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setTitle("IDE");
        stage.setScene(scene);
        stage.show();
    }
}
