/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barracuda.p4j.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author artur
 */
public class LoginController extends AbstractController implements Initializable {
    

    @FXML
    private TextField userId;
    @FXML
    private PasswordField password1;
    @FXML
    private Label errorMessage;
    @FXML
    private Button button_login;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void loginButtonMouseEntered(MouseEvent event) {
    }

    @FXML
    private void processLogin(ActionEvent event) {
        application.goToPage(EnumPage.TABLE);
    }

    @Override
    public void init() {
        
    }


}
