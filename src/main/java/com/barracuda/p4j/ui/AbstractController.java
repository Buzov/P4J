package com.barracuda.p4j.ui;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author artur
 */
public abstract class AbstractController extends AnchorPane{
        
    protected MainApp application;
    
    public void setApp(MainApp application) {
        this.application = application;
        init();
    }
    
    public abstract void init();
}
