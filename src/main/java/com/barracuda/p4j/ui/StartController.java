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

/**
 * FXML Controller class
 *
 * @author artur
 */
public class StartController extends AbstractController implements Initializable {
    @FXML
    private Button button_existing_client;
    @FXML
    private Button button_register;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void goToStartPage(ActionEvent event) {
        application.goToPage(EnumPage.LOGIN);
    }

    @FXML
    private void goToRegisterPage(ActionEvent event) {
    }

    @Override
    public void setApp(MainApp application) {
        this.application = application;
    }

    @Override
    public void init() {
        System.out.println("Hello!");
    }
    
}
