package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Etichetta;
import model.Gestore;
import model.Stanza;
import java.util.Map;
import static controllers.Login_Page_Controller.getUtente;
import static DAO.TestStanzeGet.getStanze;

public class Building_Page_Controller {

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
    void initialize(){
        try {
            String username = getUtente();
            String color;
            Etichetta e;
            Map<String, Integer> map = getStanze(username);
            for(Map.Entry<String, Integer> entry:map.entrySet()){
                switch (entry.getValue()){
                    case 0: color = "GREEN";
                            break;
                    case 1: color = "YELLOW";
                        break;
                    case 2: color = "ORANGE";
                        break;
                    case 3: color = "RED";
                        break;
                    case 4: color = "PURPLE";
                        break;
                    default: color = "VERDE";
                }
                e = new Etichetta(entry.getKey(),color);
                room_list.getItems().add(Etichetta.getButton());
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }

}