package com.barracuda.p4j.ui;

/**
 *
 * @author artur
 */
public enum EnumPage {
    START("/fxml/start.fxml"),
    LOGIN("/fxml/login.fxml"),
    TABLE("/fxml/table.fxml"),
    REGISTER("/fxml/register.fxml");
    
    private String file;
    
    private EnumPage(String file) {
        this.file = file;
    }
    
    public String getFilePath() {
        return file;
    }
    
}
