package controllers;

import controllers.priorityController.AggiornaCitta;
import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Map;

import static controllers.Login_Page_Controller.getUtente;

public class Zone_Page_Controller {

    @FXML   //fx:id="building_list"
    private ListView<Button> building_list;

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
    void initialize() {
        Aggiornamento a = new Aggiornamento();
        a.start();
    }


    public class Aggiornamento extends Thread {
        boolean inizializzato = false;
        public void run() {
            while (true) {
                try {
                    String username = getUtente();
                    String color;
                    Etichetta e = new Etichetta();
                    AggiornaCitta a = new AggiornaCitta(username, "Zona");
                    Map<String, Integer> map = a.run();
                    int i = 0;
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        switch (entry.getValue()) {
                            case 0:
                                color = "GREEN";
                                break;
                            case 1:
                                color = "YELLOW";
                                break;
                            case 2:
                                color = "ORANGE";
                                break;
                            case 3:
                                color = "RED";
                                break;
                            case 4:
                                color = "PURPLE";
                                break;
                            default:
                                color = "VERDE";
                        }
                        if (!inizializzato) {
                            e.crea(entry.getKey(), color);
                            building_list.getItems().add(Etichetta.getButton());

                        }
                        else {
                            System.out.println(color);
                            building_list.getItems().get(i).setStyle("-fx-background-color: "+color);
                        }
                        i++;
                    }
                    inizializzato = true;
                } catch (Exception e) {
                    e.getStackTrace();
                }

                try {

                    sleep(10000);
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
            }
        }
    }
}
