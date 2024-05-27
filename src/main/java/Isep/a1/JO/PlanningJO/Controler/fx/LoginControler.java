package Isep.a1.JO.PlanningJO.Controler.fx;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Isep.a1.JO.PlanningJO.App;
import Isep.a1.JO.PlanningJO.Config.PasswordEncoder;
import Isep.a1.JO.PlanningJO.Model.Constructeur.CreateUser;
import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
import Isep.a1.JO.PlanningJO.Model.Services.AthleteService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControler {
    @FXML
    public TextField idField;
    @FXML
    public PasswordField passwordField;

    private AthleteService athleteService = new AthleteService();


    @FXML
    public void login(ActionEvent event) throws SQLException, IOException {
        int identifiant = Integer.parseInt(idField.getText());
        System.out.println(identifiant);
        String password = passwordField.getText();

        if (identifiant == 0 || !Athlete.genererListeIdentifiants().contains(identifiant)|| password.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.", Alert.AlertType.ERROR);
            return;
        }
        
        
        Athlete athlete = athleteService.getAthleteById(identifiant);
        if (athlete == null) {
            showAlert("Erreur", "Identifiant incorrect.", Alert.AlertType.ERROR);
            return;
		
		}
		if (!athlete.getPassword().equals(PasswordEncoder.encryptPassword(password))) {
			showAlert("Erreur", "Mot de passe incorrect.", Alert.AlertType.ERROR);
			return;
		}
        // TODO : vérifier les informations de connexion auprès du serveur

        // Si la connexion réussit, passer à la fenêtre principale de l'application
		loadUserData(athlete);
    }
    
    private void loadUserData(Athlete athlete) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("page/Main.fxml"));
        Parent root = loader.load();

        // Passez les données de l'utilisateur au contrôleur de la main page si nécessaire
        MainControler mainControler = loader.getController();
        mainControler.setUserData(athlete);

        Stage stage = (Stage) idField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
