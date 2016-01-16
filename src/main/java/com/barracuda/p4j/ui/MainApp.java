package com.barracuda.p4j.ui;

import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        
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
        stage.show();
        
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
        launch(args);
    }

}
