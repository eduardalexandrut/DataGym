package application.controller;

import entity.Allenamenti;
import entity.Esercizi;
import entity.Schede;
import entity.Utenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class SchedeController extends Controller {
    private Optional<Schede> scheda = Optional.empty();
    private Optional<Utenti> user = Optional.empty();
    private Optional<Esercizi> esercizio = Optional.empty();

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
    private BorderPane schedeDetailsBorder;

    //Allenamenti section.
    @FXML
    private TextArea commentField;
    @FXML
    private TextField startField;
    @FXML
    private TextField endField;

    void initialize() {
        if(getUser().isPresent()) {
            schedeChoiceBox.getItems().setAll(getQueryManager().getSchede(getUser().get().getUsername())
                    .stream()
                    .map(e -> e.getNomeScheda())
                    .collect(Collectors.toList()));
            schedeTable.getSelectionModel()
                    .selectedItemProperty()
                    .addListener( e -> setScheda(schedeTable.getSelectionModel().getSelectedItem()));
        }
        initSchedaAllenamenti();
        initSchedeTable();
        initSchedaDetails();
    }
    @FXML
    public void addScheda() {
        if (getUser().isPresent()) {
            super.getQueryManager().addScheda(schedaName.getText(), getUser().get().getUsername(), LocalDate.now());
            initSchedeTable();
        }
    }

    @FXML
    public void addAllenamento() {
        if (getUser().isPresent()) {
            final int codiceScheda = getQueryManager().getSchede(getUser().get().getUsername()).stream()
                    .filter(e -> e.getNomeScheda() == schedeChoiceBox.getValue())
                    .findAny()
                    .get()
                    .getCodiceScheda();
            Allenamenti allenamento = new Allenamenti();
            allenamento.setData(java.sql.Date.valueOf(LocalDate.now()));
            allenamento.setCommento(this.commentField.getText());
            allenamento.setOraInizio(convertStrToTime(this.startField.getText()));
            allenamento.setOraFine(convertStrToTime(this.endField.getText()));
            allenamento.setScheda(codiceScheda);
            allenamento.setUtente(getUser().get().getUsername());
            getQueryManager().addAllenamento(allenamento);
            initSchedaAllenamenti();
        }
    }
    public void initSchedeTable() {
        schedaNameCol.setCellValueFactory(new PropertyValueFactory<>("nomeScheda"));
        createdCol.setCellValueFactory(new PropertyValueFactory<>("dataCreazione"));
        if (getUser().isPresent()) {
            ObservableList<Schede> schede = FXCollections.observableArrayList(getQueryManager().getSchede(getUser().get().getUsername()));
            schedeTable.setItems(schede);
        }
    }

    public void initSchedaAllenamenti() {
        dateCol.setCellValueFactory(new PropertyValueFactory<>("data"));
        schedaCol.setCellValueFactory(new PropertyValueFactory<>("scheda"));
        startCol.setCellValueFactory(new PropertyValueFactory<>("oraInizio"));
        endCol.setCellValueFactory(new PropertyValueFactory<Allenamenti, Time>("oraFine"));
        commentCol.setCellValueFactory(new PropertyValueFactory<>("commento"));
        if (getUser().isPresent()) {
            final String userName = getUser().get().getUsername();
            ObservableList<Allenamenti> allenamenti =  FXCollections.observableArrayList(getQueryManager().getAllenamenti(userName));
            allenamentiTable.setItems(allenamenti);
        }
    }

    public void initSchedaDetails() {
        if(getScheda().isEmpty()) {
            this.schedeDetailsBorder.setCenter(new Label("Nessuna scheda selezionata."));
        }else {
            this.schedeDetailsBorder.setCenter(new Label(getScheda().get().getNomeScheda()));
        }
    }

    public void setScheda(final Schede scheda) {
        this.scheda = Optional.of(scheda);
        initSchedaDetails();
    }

    public Optional<Schede> getScheda() {
        return this.scheda;
    }
    public Optional<Utenti> getUser() {
        return user;
    }
    public void setUser(final Optional<Utenti> user) {
        this.user = user;
        initialize();
    }
    private Time convertStrToTime(final String s)  {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        Date date = null;
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Time time = new Time(date.getTime());
        return time;
    }
}
