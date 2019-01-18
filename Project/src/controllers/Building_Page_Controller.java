package controllers;

import controllers.priorityController.AggiornaCitta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Etichetta;
import model.SensoreTabella;
import model.Stanza;
import model.StanzaTabella;

import java.sql.SQLException;
import java.util.Map;

import static DAO.BuildingDAO.getEdificioMonitorato;
import static DAO.TestCreaListaSensori.creaListSensori;
import static DAO.TestMedia.average;
import static controllers.Login_Page_Controller.getUtente;

public class Building_Page_Controller {

    private static boolean notEmpty = false;
    private static Stanza stanza = new Stanza();

    @FXML   //fx:id="room_list"
    private Label stanzaCliccata;

    @FXML   //fx:id="room_list"
    private Label titolo;

    @FXML   //fx:id="room_list"
    private Label errors;

    @FXML   //fx:id="room_list"
    private ListView<Button> room_list;

    @FXML   //fx:id="setValues_button"
    private Button setValues_button;

    @FXML   //fx:id="alert_button"
    private Button alert_button;

    @FXML   //  fx:id="colStatus"
    private TableColumn<StanzaTabella, String> colNome; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTemperatura"
    private TableColumn<StanzaTabella, Double> colTemperatura; // Value injected by FXMLLoader

    @FXML   //  fx:id="colUmidità"
    private TableColumn<StanzaTabella, Double> colUmidita; // Value injected by FXMLLoader

    @FXML   //  fx:id="colPressione"
    private TableColumn<StanzaTabella, Integer> colPressione; // Value injected by FXMLLoader

    @FXML   //  fx:id="colLuminosità"
    private TableColumn<StanzaTabella, Integer> colLuminosita; // Value injected by FXMLLoader

    @FXML   // fx:id="table"
    private TableView<StanzaTabella> table;

    @FXML
    private TableView<SensoreTabella> sensorTable;

    @FXML   //  fx:id="colCodice"
    private TableColumn<SensoreTabella, Double> colCodice; // Value injected by FXMLLoader

    @FXML   //  fx:id="colTipo"
    private TableColumn<SensoreTabella, Integer> colTipo; // Value injected by FXMLLoader

    @FXML   //  fx:id="colValore"
    private TableColumn<SensoreTabella, Double> colValore; // Value injected by FXMLLoader

    @FXML   //  fx:id="colStato"
    private TableColumn<SensoreTabella,Integer> colStato; // Value injected by FXMLLoader

    @FXML   //  fx:id="colAnomalia"
    private TableColumn<SensoreTabella,String> colAnomalia; // Value injected by FXMLLoader

    @FXML
    void initialize() {
        try {
            titolo.setText("  Edificio visualizzato: " +getEdificioMonitorato(getUtente()));;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Aggiornamento a = new Aggiornamento();
        a.start();
    }

    public Label getStanzaCliccata(){
        return stanzaCliccata;
    }

    @FXML
    void setValues_ButtonIsFired(ActionEvent event){
        try {
            if (stanzaCliccata.getText() == "")
                errors.setText("Seleziona prima una stanza!");
            else {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../layouts/SetValues_Page.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 600);
                Stage stage = new Stage();
                stage.setTitle(stanzaCliccata.getText());
                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            System.out.println("Can't load SetValues Page");
        }
    }

    @FXML
    void alert_ButtonIsFired(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../layouts/Alert_Page.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
            Stage stage = new Stage();
            stage.setTitle("Allerta Autorità");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Can't load Alert Page");
        }
    }

    public class Aggiornamento extends Thread {
        boolean inizializzato = false;
        public void run() {
            while (true) {
                try {
                    String username = getUtente();
                    String color;
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
                                        errors.setText("");
                                        stanzaCliccata.setText("Hai selezionato la stanza: "+b.getText());
                                        stanza.setRoom_name(b.getText());
                                        StanzaTabella st = average(creaListSensori(stanza.getRoom_name()));
                                        st.setNome(b.getText());
                                        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
                                        colTemperatura.setCellValueFactory(new PropertyValueFactory<>("avg_temp"));
                                        colUmidita.setCellValueFactory(new PropertyValueFactory<>("avg_um"));
                                        colPressione.setCellValueFactory(new PropertyValueFactory<>("avg_pres"));
                                        colLuminosita.setCellValueFactory(new PropertyValueFactory<>("avg_lum"));
                                        ObservableList<StanzaTabella> list = FXCollections.observableArrayList(st);
                                        table.setItems(list);
                                        notEmpty=true;

                                        colCodice.setCellValueFactory(new PropertyValueFactory<>("codice1"));
                                        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo1"));
                                        colValore.setCellValueFactory(new PropertyValueFactory<>("last_data1"));
                                        colStato.setCellValueFactory(new PropertyValueFactory<>("state1"));
                                        colAnomalia.setCellValueFactory(new PropertyValueFactory<>("anomalia"));
                                        ObservableList<SensoreTabella> listSensori = FXCollections.observableArrayList(creaListSensori(stanza.getRoom_name()));
                                        sensorTable.setItems(listSensori);
                                    } catch (Exception ex){
                                        ex.getStackTrace();
                                    }
                            }});
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
    public static String getNomeStanza(){
        return stanza.getRoom_name();
    }
}