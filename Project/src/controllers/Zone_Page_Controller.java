package controllers;

import controllers.priorityController.AggiornaCitta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.EdificioTabella;

import java.sql.SQLException;
import java.util.Map;

import static DAO.ZoneDAO.*;
import static controllers.Login_Page_Controller.getUtente;

public class Zone_Page_Controller {

    private static boolean notEmpty = false;

    @FXML   //fx:id="building_list"
    private ListView<Button> building_list;

    @FXML   //fx:id="room_list"
    private Label titolo;

    @FXML   //  fx:id="colStatus"
    private TableColumn<EdificioTabella, String> colNome; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTemperatura"
    private TableColumn<EdificioTabella, Double> colTemperatura; // Value injected by FXMLLoader

    @FXML   //  fx:id="colUmidità"
    private TableColumn<EdificioTabella, Double> colUmidita; // Value injected by FXMLLoader

    @FXML   //  fx:id="colPressione"
    private TableColumn<EdificioTabella, Integer> colPressione; // Value injected by FXMLLoader

    @FXML   //  fx:id="colLuminosità"
    private TableColumn<EdificioTabella, Integer> colLuminosita; // Value injected by FXMLLoader

    @FXML   // fx:id="table"
    private TableView<EdificioTabella> table;

    @FXML
    void initialize() {
        try {
            titolo.setText("  Zona visualizzata: " +getZonaMonitorata(getUtente()));;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Aggiornamento a = new Aggiornamento();
        a.start();
    }


    public class Aggiornamento extends Thread {
        boolean inizializzato = false;
        public void run() {
            while (true) {
                try{
                String username = getUtente();
                String color;
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
                                    EdificioTabella zt = new EdificioTabella(b.getText(), avg_edificio_temp(b.getText()), avg_edificio_um(b.getText()), avg_edificio_pres(b.getText()), avg_edificio_lum(b.getText()));
                                    colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
                                    colTemperatura.setCellValueFactory(new PropertyValueFactory<>("avg_temp"));
                                    colUmidita.setCellValueFactory(new PropertyValueFactory<>("avg_um"));
                                    colPressione.setCellValueFactory(new PropertyValueFactory<>("avg_pres"));
                                    colLuminosita.setCellValueFactory(new PropertyValueFactory<>("avg_lum"));
                                    ObservableList<EdificioTabella> list = FXCollections.observableArrayList(zt);
                                    table.setItems(list);
                                    notEmpty=true;

                                } catch (Exception ex){
                                    ex.getStackTrace();
                                }
                            }});
                         building_list.getItems().add(b);

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
