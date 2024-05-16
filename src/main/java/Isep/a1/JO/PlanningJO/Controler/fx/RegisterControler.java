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
import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
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
import javafx.scene.control.Label;
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
    public Label nameError;

    @FXML
    public Label lastNameError;

    @FXML
    public Label ageError;

    @FXML
    public Label passwordError;
    
    @FXML
    public Label genderError;

    @FXML
    public Label sportError;

    @FXML
    public Label countryError;

    // ... la méthode initialize et les autres méthodes existantes ...

    private boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z]+");
    }

    private boolean isValidLastName(String lastName) {
        return lastName != null && lastName.matches("[a-zA-Z]+");
    }

    private boolean isValidGender(String gender) {
        return gender != null;
    }

    private boolean isValidSport(Sport sport) {
        return sport != null;
    }

    private boolean isValidCountry(Country country) {
        return country != null;
    }

    private boolean isValidAge(int age) {
        return age > 18;
    }

    private boolean isValidPassword(String password) {
        // Vous pouvez personnaliser cette méthode pour vérifier la sécurité du mot de passe
        return password.length() >= 8;
    }

    private void clearErrors() {
        nameError.setText("");
        lastNameError.setText("");
        ageError.setText("");
        passwordError.setText("");
    }

    @FXML
    public void createUser(ActionEvent event) throws SQLException, IOException {
        clearErrors();

        List<String> errors = new ArrayList<>();

        String name = nameField.getText();
        String lastName = lastNameField.getText();
        int age = 0;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            ageError.setText("Âge invalide");
            errors.add("Âge invalide");
        }
        String gender = genderBox.getValue();
        Sport sport = sportBox.getValue();
        Country country = countryBox.getValue();
        String password = passwordField.getText();

        if (!isValidName(name)) {
            nameError.setText("Nom invalide ou déjà existant");
            nameError.setFont(javafx.scene.text.Font.font("System", 3));
            nameError.setStyle("-fx-text-fill: red;");
            errors.add("Nom invalide ou déjà existant");
        }

        if (!isValidLastName(lastName)) {
            lastNameError.setText("Nom de famille invalide ou déjà existant");
            lastNameError.setFont(javafx.scene.text.Font.font("System", 3));
            lastNameError.setStyle("-fx-text-fill: red;");
            errors.add("Nom de famille invalide ou déjà existant");
        }

        if (!isValidAge(age)) {
            ageError.setText("L'âge doit être supérieur à 18");
            ageError.setFont(javafx.scene.text.Font.font("System", 3));
            ageError.setStyle("-fx-text-fill: red;");
            errors.add("L'âge doit être supérieur à 18");
        }

        if (!isValidGender(gender)) {
            genderError.setText("Genre invalide");
            genderError.setFont(javafx.scene.text.Font.font("System", 3));
            genderError.setStyle("-fx-text-fill: red;");
            errors.add("Genre invalide");
        }

        if (!isValidSport(sport)) {
            sportError.setText("Sport invalide");
            sportError.setFont(javafx.scene.text.Font.font("System", 3));
            sportError.setStyle("-fx-text-fill: red;");
            errors.add("Sport invalide");
        }

        if (!isValidCountry(country)) {
            countryError.setText("Pays invalide");
            countryError.setFont(javafx.scene.text.Font.font("System", 3));
            countryError.setStyle("-fx-text-fill: red;");
            errors.add("Pays invalide");
        }

        if (!isValidPassword(password)) {
            passwordError.setText("Mot de passe pas assez sécurisé");
            passwordError.setFont(javafx.scene.text.Font.font("System", 3));
            passwordError.setStyle("-fx-text-fill: red;");
            errors.add("Mot de passe pas assez sécurisé");
        }

		if (!errors.isEmpty()) {
			return;
		}
        CreateUser createUser = new CreateUser(name, lastName, age, gender, sport, country, PasswordEncoder.encryptPassword(password));
        System.out.println(createUser.toString());
        athleteService.insertAthlete(createUser);
        

        // Chargez les données de l'utilisateur
        loadUserData(createUser);

        // Changez de scène vers la main page
        
    }
    
    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    
    private void loadUserData(CreateUser createUser) throws SQLException, IOException {
        Athlete athlete = new Athlete();
        athlete	= athleteService.getAthleteByNameAndLastname(nameField.getText(), lastNameField.getText());
        FXMLLoader loader = new FXMLLoader(App.class.getResource("page/Main.fxml"));
        Parent root = loader.load();

        // Passez les données de l'utilisateur au contrôleur de la main page si nécessaire
        MainControler mainControler = loader.getController();
        mainControler.setUserData(athlete);

        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    public void cancel(ActionEvent event) throws IOException {
        App.setRoot("primary");

    }
}
