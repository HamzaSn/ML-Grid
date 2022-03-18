package App.Controllers;


import R.RCaller;
import App.Models.DataInfo;
import App.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataLoadingController {

    private RCaller R = new RCaller();
    @FXML
    private Label title;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Label infoProgress;
    @FXML
    private Label timeInfo;
    @FXML
    private Label pathInfo;
    @FXML
    private TextField dataPath;
    @FXML
    private Button chooseButton;
    @FXML
    private Text hint1Info;
    @FXML
    private Label targetVarInfo;
    @FXML
    private TextField targetVar;
    @FXML
    private Label columnSelectionInfo;
    @FXML
    private CheckBox automaticSelection;
    @FXML
    private CheckBox manuelSelection;
    @FXML
    private Label warnings;
    @FXML
    private Button nextButton;
    @FXML
    private Button backButton;
    @FXML 
    private Button goBack;
    @FXML
    private Label help1;
    @FXML 
    private Label manuelColumnSelection;
    @FXML
    private Polygon polygonChoose;
    @FXML
    private Button nextButton2;
    @FXML
    private Button nextButton3;
    @FXML
    private Button backButton3;
    



    @FXML
    private void initialize(){

        automaticSelection.setOnMouseClicked(MouseEvent -> {
            manuelSelection.setSelected(false);
            nextButton3.setText("Launch");
        });
        manuelSelection.setOnMouseClicked(MouseEvent -> {
            automaticSelection.setSelected(false);
            nextButton3.setText("Next");
        });
       
    }


    @FXML
    private void getCsvPath() throws IOException {
        warnings.setText("");
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(dataPath.getScene().getWindow());
        DataInfo.info.put("dataPath", file.getAbsolutePath());
        dataPath.setText((String) DataInfo.info.get("dataPath"));
    }


    @FXML
    private void next(ActionEvent actionEvent) throws IOException {
        File file = new File(dataPath.getText());
        if(file.getName().contains(".csv")){
            DataInfo.info.putIfAbsent("dataPath",dataPath.getText());
            BufferedReader reader = new BufferedReader( new FileReader(file));
        String[] colnames = reader.readLine().split(",");
        for(int i = 0; i < colnames.length ; i++){
            colnames[i] = colnames[i].replaceAll("\"","");
        }
        
        DataInfo.info.put("colnames",colnames);
        pathInfo.setVisible(false);
        dataPath.setVisible(false);
        chooseButton.setVisible(false);
        hint1Info.setVisible(false);
        warnings.setVisible(false);
        nextButton.setVisible(false);
        backButton.setVisible(false);
        polygonChoose.setVisible(false);

        targetVarInfo.setVisible(true);
        targetVar.setVisible(true);
        goBack.setVisible(true);
        help1.setVisible(true);
        manuelColumnSelection.setVisible(true);
        nextButton2.setVisible(true);
        
        } else {
            warnings.setVisible(true);
            warnings.setText("The process requires a .csv file, please provide a valid .csv data file");
        }
        
    }



    @FXML
    private void back() throws IOException{
        Stage stage = (Stage) dataPath.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800 , 600);
        stage.setResizable(false);
        stage.setTitle("Home");
        stage.setScene(scene);
    }


    @FXML
    private void goBack(){
        pathInfo.setVisible(true);
        dataPath.setVisible(true);
        chooseButton.setVisible(true);
        hint1Info.setVisible(true);
        targetVarInfo.setVisible(false);
        targetVar.setVisible(false);
        nextButton.setVisible(true);
        goBack.setVisible(false);
        backButton.setVisible(true);
    }


    @FXML
    private void next2(){
        String[] x = (String[]) DataInfo.info.get("colnames");
        ArrayList<String> colnames = new ArrayList<>(Arrays.asList(x));
        if(colnames.contains(targetVar.getText())){
            DataInfo.info.putIfAbsent("targetVar",targetVar.getText());
            targetVarInfo.setVisible(false);
            targetVar.setVisible(false);
            goBack.setVisible(false);
            help1.setVisible(false);
            manuelColumnSelection.setVisible(false);
            nextButton2.setVisible(false);
            title.setVisible(false);

            columnSelectionInfo.setVisible(true);
            automaticSelection.setVisible(true);
            manuelSelection.setVisible(true);
            nextButton3.setVisible(true);
            backButton3.setVisible(true);
        } else {
            warnings.setVisible(true);
            warnings.setText("Invalid target variable name");
        }

        
    }

    @FXML
    private void manuelColumnSelection() throws IOException{
        Stage stage = (Stage) help1.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("targetSelection-view.fxml"));
        Scene scene = new Scene(loader.load(), 800 , 600);
        stage.setTitle("Column selection");
        stage.setScene(scene);
    }

    @FXML
    private void next3() throws IOException{

        if(manuelSelection.isSelected()){
                Stage stage = (Stage) help1.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("columnSelectionManuel-view.fxml"));
                Scene scene = new Scene(loader.load(), 800 , 600);
                stage.setTitle("Column selection");
                stage.setScene(scene);
        }
    }

    @FXML
    private void back3(){

    }

    /*
     *
     * @FXML
     *     private void launchGridSearching() throws InterruptedException {
     *         final RService service = new RService();
     *
     *         DataInfo.info.put("targetVar",targetVariable.getText());
     *         service.start();
     *         progressBar.visibleProperty().bind(service.runningProperty());
     *         File result = new File("R/all_in_one.pdf");
     *         info.setText("Process finished");
     *
     *     }
     */




}
