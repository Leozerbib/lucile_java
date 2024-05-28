package Isep.a1.JO.PlanningJO.Controler.fx;

import java.io.IOException;

import Isep.a1.JO.PlanningJO.App;
import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class MainControler {

    Athlete athlete = new Athlete();

    @FXML
    public Label userLabel;

    @FXML
    public SubScene subSceneRoot;
    
    @FXML
    public Pane pane;

    public Group sub1Group;
    
    public void setUserData(Athlete athlete) {
        this.athlete = athlete;
        userLabel.setText(athlete.getFullName());
        sub1Group = new Group();
        sub1Group.setId("sub1GroupID");

        subSceneRoot.setRoot(sub1Group);
        loadDetailAccount();
    }

    public Node getNode(String idNode) {

    	for (Node node : pane.getChildren()) {
    	String id = node.getId();
    	if (id.equals(idNode)) {
    	return node;
    	}
    	}
    	System.out.println("Not here");
    	return null;
    	}
    
    @FXML
    public void loadDetailAccount() {
    	System.out.println("loadDetailAccount");
        try {
        	
            FXMLLoader loader = new FXMLLoader(App.class.getResource("page/DetailAccount.fxml"));
            Parent root = loader.load();
            
            DetailAccountControler detailAccountController = loader.getController();
            detailAccountController.setAthleteData(athlete);
            sub1Group.getChildren().clear();
            sub1Group.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadScoresView() {
        try {

            FXMLLoader loader = new FXMLLoader(App.class.getResource("page/Score.fxml"));
            System.out.println("ScoreControler initialize");
            Parent root = new Region();
            root = loader.load();
            sub1Group.getChildren().clear();
            sub1Group.getChildren().add(root);

        } catch (IOException e) {
            System.err.println("Failed to load Score.fxml: " + e.getMessage());
            
            e.printStackTrace();
        }
    }
}
