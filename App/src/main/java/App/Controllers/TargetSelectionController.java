package App.Controllers;

import App.MainApplication;
import App.Models.DataInfo;
import App.Models.Variable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TargetSelectionController  {


    @FXML
    TableView<Variable> tableView;
    @FXML
    private TableColumn<Variable,Variable> column;
    @FXML
    private TableColumn<Variable,Variable>  check;

    @FXML
    public void initialize() {
        column.setCellValueFactory(new PropertyValueFactory<>("name"));
        check.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        for(String elem : (String[]) DataInfo.info.get("colnames")){
            Variable var = new Variable(elem);
            tableView.getItems().add(var);
        }
        
        for(Variable elem : tableView.getItems()){
            elem.getCheckBox().setOnMouseClicked(mouseEvent -> {
                for(Variable others : tableView.getItems()) {
                    if(elem == others) continue;
                    others.getCheckBox().setSelected(false);
                }

            });
        }

    }

    @FXML
    private void back() throws IOException {
    Stage stage = (Stage) tableView.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("dataLoading-view.fxml"));
    Scene scene = new Scene(loader.load(), 800 , 600);
    stage.setTitle("Data import");
    stage.setScene(scene);
    }

    @FXML
    private void next() throws IOException{
        ObservableList<Variable> items = tableView.getItems();
        for(Variable item : items){
            if(item.getCheckBox().isSelected()){
                DataInfo.info.put("targetVar",item.getName());
            }
            
        }
        Stage stage = (Stage) tableView.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("columnSelectionManuel-view.fxml"));
    Scene scene = new Scene(loader.load(), 800 , 600);
    stage.setTitle("Data import");
    stage.setScene(scene);
        
    }


    
}
