package Isep.a1.JO.PlanningJO.Controler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

import Isep.a1.JO.PlanningJO.Config.PasswordEncoder;
import Isep.a1.JO.PlanningJO.Model.Constructeur.CreateUser;
import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
import Isep.a1.JO.PlanningJO.Model.Services.AthleteService;

public class AthleteControler {
	
	AthleteService athleteService = new AthleteService();
	
	Random random = new Random();

	
	public void register(CreateUser createUser) throws RegistrationException, SQLException {

        // Save username and encrypted password to database or any storage mechanism
        // Insert code here to save the username and encrypted password
    }
	

    // Method to authenticate athlete login
    public boolean login(String username, String password) throws LoginException {
        if (!isUsernameExists(username)) {
            throw new LoginException("Username does not exist");
        }

        String storedPassword = getEncryptedPassword(username);

        String encryptedPassword = PasswordEncoder.encryptPassword(password);

        // Compare stored password and provided password
        if (!storedPassword.equals(encryptedPassword)) {
            throw new LoginException("Incorrect password");
        }

        return true;
    }

    // Method to check if username already exists in the database
    private boolean isUsernameExists(String username) {
        return false;
    }

    // Method to retrieve encrypted password from the database
    private String getEncryptedPassword(String username) {
        return "";
    }

    // Method to encrypt password using SHA-256 algorithm
}

// Custom exception for registration errors
class RegistrationException extends Exception {
    public RegistrationException(String message) {
        super(message);
    }
}

// Custom exception for login errors
class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
	
	
	public void login() {
        // TODO - implement AthleteControler.login
    }
	
	public void logout() {
		// TODO - implement AthleteControler.logout
	}
	
	public void register() {
		// TODO - implement AthleteControler.register
	}
	
	public void update() {
		// TODO - implement AthleteControler.update
	}
	
	public void delete() {
		// TODO - implement AthleteControler.delete
	}
	
	public void viewEventOfAthlete() {
		// TODO - implement AthleteControler.view
	}
	
	public void viewScoreOfAthlete() {
		// TODO - implement AthleteControler.view
	}
	
	public void viewMedalOfAthlete() {
		// TODO - implement AthleteControler.view
	}
	
	public void viewAthlete() {
		// TODO - implement AthleteControler.view
	}
	
	
	
}
