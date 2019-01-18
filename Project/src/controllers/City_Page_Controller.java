package controllers;

import controllers.priorityController.AggiornaCitta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.Map;

import static DAO.CityDAO.*;
import static DAO.ZoneDAO.*;
import static controllers.Login_Page_Controller.getUtente;

public class City_Page_Controller {

    private static boolean notEmpty = false;

    @FXML   //fx:id="building_list"
    private ListView<Button> zone_list;

    @FXML   //fx:id="room_list"
    private Label titolo;

    @FXML   //  fx:id="colStatus"
    private TableColumn<ZonaTabella, String> colNome; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTemperatura"
    private TableColumn<ZonaTabella, Double> colTemperatura; // Value injected by FXMLLoader

    @FXML   //  fx:id="colUmidità"
    private TableColumn<ZonaTabella, Double> colUmidita; // Value injected by FXMLLoader

    @FXML   //  fx:id="colPressione"
    private TableColumn<ZonaTabella, Integer> colPressione; // Value injected by FXMLLoader

    @FXML   //  fx:id="colLuminosità"
    private TableColumn<ZonaTabella, Integer> colLuminosita; // Value injected by FXMLLoader

    @FXML   // fx:id="table"
    private TableView<ZonaTabella> table;

    @FXML
    void initialize() {
        try {
            titolo.setText("  Città visualizzata: " +getCittaMonitorata(getUtente()));;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        City_Page_Controller.Aggiornamento a = new City_Page_Controller.Aggiornamento();
        a.start();
    }


    public class Aggiornamento extends Thread {
        boolean inizializzato = false;
        public void run() {
            while (true) {
                try{
                    String username = getUtente();
                    String color;
                    AggiornaCitta a = new AggiornaCitta(username, "Citta");
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
                            Button b = new Button();
                            b.setStyle("-fx-background-color: " + color);
                            b.setPrefSize(320, 60);
                            b.setFont(Font.font(24));
                            b.setText(entry.getKey());
                            b.setAlignment(Pos.CENTER_LEFT);
                            b.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {
                                    try{
                                        if(notEmpty)
                                            table.getItems().remove(table.getItems().get(0));
                                        ZonaTabella zt = new ZonaTabella(b.getText(), avg_zona_temp(b.getText()), avg_zona_um(b.getText()), avg_zona_pres(b.getText()), avg_zona_lum(b.getText()));
                                        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
                                        colTemperatura.setCellValueFactory(new PropertyValueFactory<>("avg_temp"));
                                        colUmidita.setCellValueFactory(new PropertyValueFactory<>("avg_um"));
                                        colPressione.setCellValueFactory(new PropertyValueFactory<>("avg_pres"));
                                        colLuminosita.setCellValueFactory(new PropertyValueFactory<>("avg_lum"));
                                        ObservableList<ZonaTabella> list = FXCollections.observableArrayList(zt);
                                        table.setItems(list);
                                        notEmpty=true;

                                    } catch (Exception ex){
                                        ex.getStackTrace();
                                    }
                                }});
                            zone_list.getItems().add(b);

                        }
                        else {
                            System.out.println(color);
                            zone_list.getItems().get(i).setStyle("-fx-background-color: "+color);
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