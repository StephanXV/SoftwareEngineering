package controllers;

import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class City_Page_Controller {

    @FXML   //fx:id="zone_list"
    private ListView<Button> zone_list;

    @FXML   //  fx:id="colStatus"
    private TableColumn<Zona, String> colStatus; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTemperatura"
    private TableColumn<Zona, Double> colTemperatura; // Value injected by FXMLLoader

    @FXML   //  fx:id="colUmidità"
    private TableColumn<Zona, Double> colUmidità; // Value injected by FXMLLoader

    @FXML   //  fx:id="colPressione"
    private TableColumn<Zona, Integer> colPressione; // Value injected by FXMLLoader

    @FXML   //  fx:id="colLuminosità"
    private TableColumn<Zona, Integer> colLuminosità; // Value injected by FXMLLoader

    @FXML   //  fx:id="colMalfunzionamenti"
    private TableColumn<Zona, Integer> colMalfunzionamenti; // Value injected by FXMLLoader

    @FXML   // fx:id="table"
    private TableView<Zona> table;

    @FXML
    void initialize(){
        //zone_list.getItems().add();
    }


}
