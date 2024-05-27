package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Athlete {
    private int athleteID; // Unique identifier for each athlete
    private String name; // Name of the athlete
    private String lastName; // Last name of the athlete
    private int age; // Age of the athlete
    private String gender; // Gender of the athlete
    private Date registrationDate; // Date of athlete registration
    private Sport sport; // Foreign key referencing Sport table
    private Country country; // Foreign key referencing Country table
    private String password;
    private String identifiant;
    
	public String getFullName() {
		return this.name + " " + this.lastName;
	}
	
    public static List<Integer> genererListeIdentifiants() {
        List<Integer> identifiants = new ArrayList<>();
        
        // Ajouter des identifiants de 8 chiffres
        identifiants.add(12345678);
        identifiants.add(23456789);
        identifiants.add(34567890);
        identifiants.add(45678901);
        identifiants.add(56789012);
        identifiants.add(67890123);
        identifiants.add(78901234);
        identifiants.add(89012345);
        identifiants.add(90123456);
        identifiants.add(12345679); // Ajouter autant d'identifiants que nécessaire
        
        return identifiants;
    }
    
    public static Athlete mapper(ResultSet resultSet) throws SQLException {
    	Country country = new Country(resultSet.getString(14), resultSet.getString(15), resultSet.getString(16));
		Sport sport = new Sport(resultSet.getInt(11), resultSet.getString(12), resultSet.getString(13));
		Athlete athlete = new Athlete(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getDate(6), sport, country, resultSet.getString(9), resultSet.getString(10));
    	System.out.println(athlete);
		return athlete;
    }
}

