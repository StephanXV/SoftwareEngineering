package model;

import controllers.Building_Page_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import static controllers.Login_Page_Controller.getUtente;

public class Etichetta {
    private static Button b;
    private String nome;

    public Etichetta(){}

    public void crea (String nome, String colore) {
        b = new Button();
        b.setStyle("-fx-background-color: " + colore);
        b.setPrefSize(230, 60);
        b.setFont(Font.font(24));
        b.setText(nome);
        b.setAlignment(Pos.CENTER_LEFT);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            }
        });
        b.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        DropShadow shadow = new DropShadow();
                        b.setEffect(shadow);
                    }
                });
        b.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        b.setEffect(null);
                    }
                });
    }


    public static Button getButton() {
        return b;
    }

    public void setButton(Button b) {
        this.b = b;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
