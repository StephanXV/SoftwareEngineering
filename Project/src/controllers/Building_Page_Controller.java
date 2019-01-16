package controllers;

import controllers.priorityController.AggiornaCitta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import model.Etichetta;
import model.Stanza;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static controllers.Login_Page_Controller.getUtente;
import static DAO.TestStanzeGet.getStanze;

public class Building_Page_Controller {

    @FXML   //fx:id="room_list"
    private Label stanzaCliccata;

    @FXML   //fx:id="room_list"
    private ListView<Button> room_list;

    @FXML   //fx:id="setValues_button"
    private Button setValues_button;

    @FXML   //fx:id="alert_button"
    private Button alert_button;

    @FXML   //  fx:id="colStatus"
    private TableColumn<Stanza, String> colStatus; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTemperatura"
    private TableColumn<Stanza, Double> colTemperatura; // Value injected by FXMLLoader

    @FXML   //  fx:id="colUmidità"
    private TableColumn<Stanza, Double> colUmidità; // Value injected by FXMLLoader

    @FXML   //  fx:id="colPressione"
    private TableColumn<Stanza, Integer> colPressione; // Value injected by FXMLLoader

    @FXML   //  fx:id="colLuminosità"
    private TableColumn<Stanza, Integer> colLuminosità; // Value injected by FXMLLoader

    @FXML   //  fx:id="colMalfunzionamenti"
    private TableColumn<Stanza, Integer> colMalfunzionamenti; // Value injected by FXMLLoader

    @FXML   // fx:id="table"
    private TableView<Stanza> table;

    @FXML
    void initialize() {
        Aggiornamento a = new Aggiornamento();
        a.start();
    }

    public static String getNomeStanza(){
        return stanzaCliccata.getText();
    }

    public class Aggiornamento extends Thread {
        boolean inizializzato = false;
        public void run() {
            while (true) {
                try {
                    String username = getUtente();
                    String color;
                    Etichetta e = new Etichetta();
                    AggiornaCitta a = new AggiornaCitta(username, "Edificio");
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
                            b.setPrefSize(230, 60);
                            b.setFont(Font.font(24));
                            b.setText(entry.getKey());
                            b.setAlignment(Pos.CENTER_LEFT);
                            b.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {
                                    stanzaCliccata.setText(b.getText());
                                    //System.out.println(b.getText());
                                }
                            });
                            room_list.getItems().add(b);

                        }
                        else {
                            System.out.println(color);
                            room_list.getItems().get(i).setStyle("-fx-background-color: "+color);
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