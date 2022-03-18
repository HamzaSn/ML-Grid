package App.Controllers;

import App.MainApplication;
import R.RService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;

public class GridSearchController {


    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label info;
    @FXML
    private TextArea log;
    @FXML
    private Button goIDE;
    @FXML
    private Label finished;
    final RService service = new RService();
    @FXML
    private void initialize()  throws IOException{

        service.start();
        progressIndicator.visibleProperty().bind(service.runningProperty());
        info.visibleProperty().bind(service.runningProperty());

        File logFile = new File("./R/log.txt");
        logFile.delete();
        logFile.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(logFile));

        Thread thread = new Thread(() -> {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (progressIndicator != null){
                if(!progressIndicator.isVisible()) {
                    finished.setVisible(true);
                    goIDE.setVisible(true);
                    break;
                }
                if(line != null){
                    try {
                        while( line != null){
                            log.appendText(line +"\n");
                            line = br.readLine();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        line = br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    @FXML
    private void seeLog() {
        log.setVisible(!log.isVisible());
    }

    @FXML
    private void goIDE() throws IOException {
        Stage stage = (Stage) goIDE.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("IDE-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200 , 700);
        stage.setTitle("IDE");
        stage.setScene(scene);
        stage.show();
    }
}
