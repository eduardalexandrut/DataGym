package application.controller;

import entity.Utenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class MainController extends Controller {
    private Utenti user;
    public Utenti getUser() {
        return this.user;
    }
    public void setUser(final Utenti user) {
        this.user = user;
    }
}
