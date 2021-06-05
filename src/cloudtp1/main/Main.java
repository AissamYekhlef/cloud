
package cloudtp1.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 *
 * @author IssamY
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
     Parent root = FXMLLoader.load(getClass().getResource("/cloudtp1/fxml/main.fxml"));
     Scene scene = new Scene(root);
     
     primaryStage.setTitle("CloudSim Generation");//title of primary stage
     primaryStage.setScene(scene);//put scene on Stage
     primaryStage.show(); // for show the stage
     
    }
    
}
