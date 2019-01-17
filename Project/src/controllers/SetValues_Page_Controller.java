package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Stanza;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static DAO.SetValuesDAO.getValoriAssociati;
import static DAO.TestUpdateValue.updateValue;

public class SetValues_Page_Controller {

    private String stanza;

    @FXML
    private Label information;

    @FXML
    private TextField min_Temp;

    @FXML
    private TextField max_Temp;

    @FXML
    private TextField min_Um;

    @FXML
    private TextField max_Um;

    @FXML
    private TextField min_Pres;

    @FXML
    private TextField max_Pres;

    @FXML
    private TextField min_Lum;

    @FXML
    private TextField max_Lum;

    @FXML
    private Button salvaMin_Temp;

    @FXML
    private Button salvaMax_Temp;

    @FXML
    private Button salvaMin_Um;

    @FXML
    private Button salvaMax_Um;

    @FXML
    private Button salvaMin_Pres;

    @FXML
    private Button salvaMax_Pres;

    @FXML
    private Button salvaMin_Lum;

    @FXML
    private Button salvaMax_Lum;

    @FXML
    private Button esc_button;

    @FXML
    void initialize(){
        information.setStyle("-fx-text-fill: GREEN;");
        information.setStyle("-fx-font-size: 16px;");
        stanza = Building_Page_Controller.getNomeStanza();
        ArrayList<String> list = new ArrayList<String>(getValoriAssociati(stanza));
        min_Temp.setText(list.get(0));
        max_Temp.setText(list.get(1));
        min_Um.setText(list.get(2));
        max_Um.setText(list.get(3));
        min_Pres.setText(list.get(4));
        max_Pres.setText(list.get(5));
        min_Lum.setText(list.get(6));
        max_Lum.setText(list.get(7));
    }

    @FXML
    void salvaMin_TempIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValueTemperatura", Double.parseDouble(min_Temp.getText()));
            information.setText("Il valore minimo accettabile per la Temperatura è ora di " + min_Temp.getText() + " gradi");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_TempIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValueTemperatura", Double.parseDouble(max_Temp.getText()));
            information.setText("Il valore massimo accettabile per la Temperatura è ora di " + max_Temp.getText() + " gradi");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMin_UmIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValueUmidita", Double.parseDouble(min_Um.getText()));
            information.setText("Il valore minimo accettabile per l'Umidità è ora del " + min_Um.getText() + " %");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_UmIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValueUmidita", Double.parseDouble(max_Um.getText()));
            information.setText("Il valore massimo accettabile per l'Umidità è ora del " + max_Um.getText() + " %");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMin_PresIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValuePressione", Double.parseDouble(min_Pres.getText()));
            information.setText("Il valore minimo accettabile per la Pressione è ora del " + min_Pres.getText() + " hPa");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_PresIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValuePressione", Double.parseDouble(max_Pres.getText()));
            information.setText("Il valore massimo accettabile per la Pressione è ora di " + max_Pres.getText() + " hPa");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMin_LumIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValueLuminosita", Double.parseDouble(min_Lum.getText()));
            information.setText("Il valore minimo accettabile per la Luminosità è ora di " + min_Lum.getText() + " lumen");

        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_LumIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValueLuminosita", Double.parseDouble(min_Lum.getText()));
            information.setText("Il valore massimo accettabile per la Luminosità è ora di " + max_Lum.getText() + " lumen");
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void esc_ButtonIsFired(ActionEvent event){
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
