package Isep.a1.JO.PlanningJO.Controler.fx;

import java.io.IOException;

import Isep.a1.JO.PlanningJO.App;
import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class MainControler {

    Athlete athlete = new Athlete();

    @FXML
    public Label userLabel;

    @FXML
    public SubScene subSceneRoot;

    public void setUserData(Athlete athlete) {
        this.athlete = athlete;
        userLabel.setText(athlete.getFullName());
        loadDetailAccount();
    }

    @FXML
    public void loadDetailAccount() {
    	System.out.println("loadDetailAccount");
        try {
        	
            FXMLLoader loader = new FXMLLoader(App.class.getResource("page/DetailAccount.fxml"));
            Parent root = loader.load();
            
            DetailAccountControler detailAccountController = loader.getController();
            detailAccountController.setAthleteData(athlete);
            subSceneRoot.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadScoresView() {
        try {

            FXMLLoader loader = new FXMLLoader(App.class.getResource("page/Score.fxml"));
            System.out.println("ScoreControler initialize");
            Parent root = loader.load();
            SubScene subScene = new SubScene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
            subSceneRoot = subScene;
        } catch (IOException e) {
            System.err.println("Failed to load Score.fxml: " + e.getMessage());
            
            e.printStackTrace();
        }
    }
}
