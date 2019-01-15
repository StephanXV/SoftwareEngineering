package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import static controllers.Login_Page_Controller.getUtente;

public class Etichetta {
    private static Button b;
    private String nome;
    private String color;

    public Etichetta(){}

    public void crea (String nome, String colore){
        b = new Button();
        b.setStyle("-fx-background-color: "+colore);
        b.setPrefSize(230,60);
        b.setFont(Font.font(24));
        b.setText(nome);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println(nome);
            }});
        b.setAlignment(Pos.CENTER_LEFT);

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        b.setStyle("-fx-background-color: "+color);
    }

}
