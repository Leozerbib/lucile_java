package Isep.a1.JO.PlanningJO.Config.fx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class fxConfig {

	public void changeScene(String scenePath) {
	    try {
	        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(scenePath));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage stage = (Stage) root.getScene().getWindow();
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	        System.out.println("Erreur lors du chargement de la scène : " + e.getMessage());
	    }
	}

}
