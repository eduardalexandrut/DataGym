package application.controller;

import entity.Diete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Optional;

public class DietsController extends Controller {
    private Optional<Diete> diet =  Optional.empty();

    @FXML
    void initialize() {
        initDietsTable();
    }

    private void initDietsTable() {
        //nameCol.setCellValueFactory(new PropertyValueFactory<>("nomeDieta"));
        //createdCol.setCellValueFactory(new PropertyValueFactory<>("dataCreazione"));
        //recipeeCol.setCellValueFactory(new PropertyValueFactory<>("ricetta"));
        ObservableList<Diete> diets = FXCollections.observableArrayList(getQueryManager().getDiete("EduardT"));
        //dietsTable.setItems(diets);
    }

    public Optional<Diete> getDiet() {
        return diet;
    }

    public void setDiet(final Optional<Diete> diet) {
        this.diet = diet;
    }
}
