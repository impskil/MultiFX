package com.multifx.multifx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML private Label labelDifficult;
    @FXML private Slider sliderDifficult;

    @FXML private TextField textFieldReponse;
    @FXML private Label labelCalcul;
    @FXML private Label labelResult;
    @FXML private Label labelMessage;

    @FXML private Label labelScore;
    @FXML private Label labelTotal;
    @FXML private Label labelRatio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        methodeNvCalcul();
        sliderDifficult.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                String label1 = String.valueOf( (int)sliderDifficult.getValue());
                labelDifficult.setText(label1);
                methodeNvCalcul();
            }
        });
    }
    public void OnSubmitReponse (ActionEvent event){
        if (textFieldReponse.getText() != null && textFieldReponse.getText().length() < 5 && textFieldReponse.getText().matches("\\d+")){
            //Saisie OK
            int verifResultat = Integer.parseInt(textFieldReponse.getText());
            int resultatAVerifier = Integer.parseInt(labelResult.getText());
            if (verifResultat == resultatAVerifier) {
                labelMessage.setText("Bien joué !");
                int Score = Integer.parseInt(labelScore.getText()) + 1 ;
                int Total = Integer.parseInt(labelTotal.getText()) + 1 ;
                labelScore.setText(Integer.toString(Score));
                labelTotal.setText(Integer.toString(Total));

            } else {
                //JOptionPane.showConfirmDialog(null, "C'est raté");
                labelMessage.setText("C'est raté");
                int Total = Integer.parseInt(labelTotal.getText()) + 1 ;
                labelTotal.setText(Integer.toString(Total));
            }
            methodeNvCalcul();
        }
        else {
            //saisie incorrecte
            labelMessage.setText("Saisie incorrecte");
        }
        float Ratio = Float.parseFloat(labelScore.getText()) / Float.parseFloat(labelTotal.getText()) * 100;
        labelRatio.setText(Float.toString(Math.round(Ratio)) + "%");
        textFieldReponse.setText(null);
    }
    public void OnResetButton (ActionEvent event) {
        labelScore.setText("0");
        labelTotal.setText("0");
        labelRatio.setText("--%");
        methodeNvCalcul();
    }

    void methodeNvCalcul() {
        int aMin = 1;
        int bMin = 1;
        int aMax = (int)sliderDifficult.getValue();
        int bMax = 10;
        int a = (int) (Math.random() * (aMax - aMin + 1) + aMin);
        int b = (int) (Math.random() * (bMax - bMin + 1) + bMin);
        int result = a * b;
        labelCalcul.setText(a + " x " + b);
        labelResult.setText(Integer.toString(result));
    }
}

