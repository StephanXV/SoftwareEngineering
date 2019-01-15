package controllers;

import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Zone_Page_Controller {

    @FXML   //fx:id="building_list"
    private ListView<Edificio> building_list;

    @FXML   //  fx:id="colStatus"
    private TableColumn<Edificio, String> colStatus; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTemperatura"
    private TableColumn<Edificio, Double> colTemperatura; // Value injected by FXMLLoader

    @FXML   //  fx:id="colUmidità"
    private TableColumn<Edificio, Double> colUmidità; // Value injected by FXMLLoader

    @FXML   //  fx:id="colPressione"
    private TableColumn<Edificio, Integer> colPressione; // Value injected by FXMLLoader

    @FXML   //  fx:id="colLuminosità"
    private TableColumn<Edificio, Integer> colLuminosità; // Value injected by FXMLLoader

    @FXML   //  fx:id="colMalfunzionamenti"
    private TableColumn<Edificio, Integer> colMalfunzionamenti; // Value injected by FXMLLoader

    @FXML   // fx:id="table"
    private TableView<Edificio> table;

    @FXML
    void initialize(){}

}