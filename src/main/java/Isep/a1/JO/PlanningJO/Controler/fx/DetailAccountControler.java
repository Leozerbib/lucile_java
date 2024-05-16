package Isep.a1.JO.PlanningJO.Controler.fx;

import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailAccountControler {

    @FXML
    public Label nameLabel;

    @FXML
    public Label lastNameLabel;

    @FXML
    public Label genderLabel;

    @FXML
    public Label ageLabel;

    @FXML
    public Label sportLabel;

    @FXML
    public Label passwordLabel;

    public void setAthleteData(Athlete athlete) {
        nameLabel.setText(athlete.getName());
        lastNameLabel.setText(athlete.getLastName());
        genderLabel.setText(athlete.getGender());
        ageLabel.setText(String.valueOf(athlete.getAge()));
        sportLabel.setText(athlete.getSport().getSportName());
        passwordLabel.setText("********");
    }
}

