package com.barracuda.p4j.ui;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    private static final String NAME_PROGRAMM = "P4J";
    
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
                try {
            stage = primaryStage;
            //stage.setResizable(false);
            //stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            //stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            goToPage(EnumPage.START);
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        
        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("P4J");
        File f = new File("d:\\workspace\\NetBeansProjects\\P4J\\src\\main\\resources\\icon\\skull.png");
        System.out.println(f.exists());
        Image ix = new Image(f.toURI().toString());
        stage.getIcons().add(ix);
        //stage.getIcons().add(new Image(MainApp.class.getResource("skull.png").toExternalForm()));
        //stage.getIcons().add(new Image(MainApp.class.getResourceAsStream("skull.png")));
        stage.setScene(scene);
        stage.show();*/
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(MainApp.class, (java.lang.String[])null);
        //launch(args);
    }
    
    public void goToSelectPage() {
        try {
            StartController select = (StartController) replaceSceneContent("/fxml/start.fxml");
            select.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void goToLoginPage() {
        try {
            LoginController select = (LoginController) replaceSceneContent("/fxml/login.fxml");
            select.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void goToPage(EnumPage page) {
        try {
            ((AbstractController) replaceSceneContent(page.getFilePath())).setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.sizeToScene();
        Image ix = new Image("/icon/lock.png");
        stage.getIcons().add(ix);
        stage.setTitle(NAME_PROGRAMM);
        return (Initializable) loader.getController();
    }

}
