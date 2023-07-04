package application.controller;

import entity.Allenamenti;
import entity.Schede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Time;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class SchedeController extends Controller {
    private Schede scheda;

    @FXML
    private TextField schedaName;
    @FXML
    private TableView<Schede> schedeTable;
    @FXML
    private TableColumn schedaNameCol;
    @FXML
    private TableColumn createdCol;

    @FXML
    private TableView allenamentiTable;
    @FXML
    private TableColumn dateCol;
    @FXML
    private TableColumn schedaCol;
    @FXML
    private TableColumn startCol;
    @FXML
    private TableColumn endCol;
    @FXML
    private TableColumn commentCol;
    @FXML
    private ChoiceBox schedeChoiceBox;

    @FXML
    void initialize() {
        initSchedeTable();
        initSchedaAllenamenti();
        schedeChoiceBox.getItems().setAll(getQueryManager().getSchede("EduardT")
                .stream()
                .map(e -> e.getNomeScheda())
                .collect(Collectors.toList()));
        schedeTable.getSelectionModel()
                .selectedItemProperty()
                .addListener( e -> setScheda(schedeTable.getSelectionModel().getSelectedItem()));
    }
    @FXML
    public void addScheda() {
        super.getQueryManager().addScheda(schedaName.getText(), "EduardT", LocalDate.now());
        initSchedeTable();
    }

    public void initSchedeTable() {
        schedaNameCol.setCellValueFactory(new PropertyValueFactory<>("nomeScheda"));
        createdCol.setCellValueFactory(new PropertyValueFactory<>("dataCreazione"));
        ObservableList<Schede> schede = FXCollections.observableArrayList(getQueryManager().getSchede("EduardT"));
        schedeTable.setItems(schede);
    }

    public void initSchedaAllenamenti() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("data"));
        schedaCol.setCellValueFactory(new PropertyValueFactory<>("scheda"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("oraInizio"));
        endCol.setCellValueFactory(new PropertyValueFactory<Allenamenti, Time>("oraFine"));
        commentCol.setCellValueFactory(new PropertyValueFactory<>("commento"));
        ObservableList<Allenamenti> allenamenti =  FXCollections.observableArrayList(getQueryManager().getAllenamenti("EduardT"));
        allenamentiTable.setItems(allenamenti);
    }

    public void setScheda(final Schede scheda) {
        this.scheda = scheda;
    }

    public Schede getScheda() {
        return this.scheda;
    }
}
