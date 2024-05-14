package Isep.a1.JO.PlanningJO.Controler.fx;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Isep.a1.JO.PlanningJO.App;
import Isep.a1.JO.PlanningJO.Config.PasswordEncoder;
import Isep.a1.JO.PlanningJO.Controler.AthleteControler;
import Isep.a1.JO.PlanningJO.Model.Constructeur.CreateUser;
import Isep.a1.JO.PlanningJO.Model.Entity.Country;
import Isep.a1.JO.PlanningJO.Model.Entity.Sport;
import Isep.a1.JO.PlanningJO.Model.Services.AthleteService;
import Isep.a1.JO.PlanningJO.Model.Services.CountryService;
import Isep.a1.JO.PlanningJO.Model.Services.SportService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterControler {

	private AthleteControler athleteControler = new AthleteControler();

    private SportService sportService = new SportService();
    private CountryService countryService = new CountryService();
    private AthleteService athleteService = new AthleteService();
    
    @FXML
    public TextField nameField;

    @FXML
    public TextField lastNameField;

    @FXML
    public TextField ageField;

    @FXML
    public ChoiceBox<String> genderBox;

    @FXML
    public ChoiceBox<Sport> sportBox;

    @FXML
    public ChoiceBox<Country> countryBox;

    @FXML
    public PasswordField passwordField;
    	
    public void initialize() throws SQLException {
        ObservableList<Sport> sports = FXCollections.observableArrayList(sportService.getAllSport());
        sportBox.setItems(sports);

        ObservableList<Country> countries = FXCollections.observableArrayList(countryService.getAllCountry());
        countryBox.setItems(countries);
    	
        List<String> gender = new ArrayList<String>();
        gender.add("homme");
        gender.add("femme");
        gender.add("not specify");
        ObservableList<String> genders = FXCollections.observableArrayList(gender);
        genderBox.setItems(genders);
        
    }

    @FXML
    public void createUser(ActionEvent event) throws SQLException {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderBox.getValue();
        Sport sport = sportBox.getValue();
        Country country = countryBox.getValue();
        String password = passwordField.getText();
        
        CreateUser createUser = new CreateUser(name, lastName, age, gender, sport, country, PasswordEncoder.encryptPassword(password));
        System.out.println(createUser.toString());
        athleteService.insertAthlete(createUser);
    }
    
    @FXML
    public void cancel(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }
}
