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
import java.util.ArrayList;

public class ManuelSelectionController  {


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
            if(elem.equals(DataInfo.info.get("targetVar"))) continue;
            tableView.getItems().add(var);
        }


    }

    @FXML
    private void launch() throws IOException {

        ArrayList<String> chosen_vars = new ArrayList<>();
        ObservableList<Variable> items =   tableView.getItems();
        for(Variable item : items){
            if(item.getCheckBox().isSelected()){
                chosen_vars.add(item.getName());
            }
            Object[] x =  chosen_vars.toArray();
            DataInfo.info.put("chosen_vars",x);
        }

    Stage stage = (Stage) tableView.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("loading-view.fxml"));
    Scene scene = new Scene(loader.load(), 800 , 600);
    stage.setTitle("Column selection");
    stage.setScene(scene);
    }
    @FXML
    private void back() throws IOException {
    Stage stage = (Stage) tableView.getScene().getWindow();
    FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("dataLoading-view.fxml"));
    Scene scene = new Scene(loader.load(), 800 , 600);
    stage.setTitle("Column selection");
    stage.setScene(scene);
    }

    @FXML
    private void selectAll() {
        ObservableList<Variable> items =   tableView.getItems();
        for(Variable item : items){
            item.getCheckBox().setSelected(true);
        }
    }
    @FXML
    private void deselectAll() {
        ObservableList<Variable> items =   tableView.getItems();
        for(Variable item : items){
            item.getCheckBox().setSelected(false);
        }
    }
}
