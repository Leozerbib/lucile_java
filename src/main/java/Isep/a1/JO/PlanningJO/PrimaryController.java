package Isep.a1.JO.PlanningJO;

import java.io.IOException;
import java.sql.SQLException;

import Isep.a1.JO.PlanningJO.Model.Services.CountryService;
import Isep.a1.JO.PlanningJO.Model.Services.SportService;
import javafx.fxml.FXML;

public class PrimaryController {
	
	private SportService sportService = new SportService();
	
	private CountryService countryService =  new CountryService();
	

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("util/login");
    }
    
    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("util/register");
    }
}
