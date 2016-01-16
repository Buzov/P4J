/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.p4j.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author artur
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userId;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private Button login;
    @FXML
    private Label errorMessage;
    @FXML
    private ChoiceBox<String> choiceBox;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBox = new ChoiceBox(FXCollections.observableArrayList(
            "First", "Second", "Third")
        );
        System.out.println("lkdfjgldflgldfjgs");
        choiceBox.setTooltip(new Tooltip("Select the language"));
        choiceBox.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue ov, Number value, Number new_value) {
              System.out.println(new_value.intValue());
          }
        });
    }

    @FXML
    private void loginButtonMouseEntered(MouseEvent event) {
    }

    @FXML
    private void processLogin(ActionEvent event) {
    }

}
