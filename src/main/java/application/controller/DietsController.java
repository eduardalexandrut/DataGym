package application.controller;

import entity.Diete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DietsController extends Controller {
    @FXML
    private TableView dietsTable;
    @FXML
    private TableColumn nameCol;
    @FXML
    private TableColumn createdCol;
    @FXML
    private TableColumn recipeeCol;

    @FXML
    void initialize() {
        initDietsTable();
    }

    private void initDietsTable() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nomeDieta"));
        //createdCol.setCellValueFactory(new PropertyValueFactory<>("dataCreazione"));
        //recipeeCol.setCellValueFactory(new PropertyValueFactory<>("ricetta"));
        ObservableList<Diete> diets = FXCollections.observableArrayList(getQueryManager().getDiete("EduardT"));
        dietsTable.setItems(diets);
    }
}
