package application.controller;

import entity.Schede;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

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
    void initialize() {
        initSchedeTable();
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
        createdCol.setCellValueFactory(new PropertyValueFactory<>("data_creazione"));
        ObservableList<Schede> schede = FXCollections.observableArrayList(getQueryManager().getSchede("EduardT"));
        schedeTable.setItems(schede);
    }

    public void setScheda(final Schede scheda) {
        this.scheda = scheda;
        System.out.println(this.scheda);
    }

    public Schede getScheda() {
        return this.scheda;
    }
}
