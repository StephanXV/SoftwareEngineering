package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Stanza;

import static DAO.TestUpdateValue.updateValue;
import static controllers.Building_Page_Controller.getNomeStanza;


public class SetValues_Page_Controller {

    private String stanza = getNomeStanza();

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
    void salvaMin_TempIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValueTemperatura", Double.parseDouble(min_Temp.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_TempIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValueTemperatura", Double.parseDouble(max_Temp.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMin_UmIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValueUmidita", Double.parseDouble(min_Um.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_UmIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValueUmidita", Double.parseDouble(max_Um.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMin_PresIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValuePressione", Double.parseDouble(min_Pres.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_PresIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValuePressione", Double.parseDouble(max_Pres.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMin_LumIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Min_ValueLuminosita", Double.parseDouble(min_Lum.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void salvaMax_LumIsFired(ActionEvent event){
        try {
            updateValue(stanza, "Max_ValueLuminosita", Double.parseDouble(min_Lum.getText()));
        } catch (Exception ex){
            ex.getStackTrace();
        }
    }

    @FXML
    void annulla(){}

}
