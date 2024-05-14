package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.Date;
import java.sql.ResultSet;
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
    private int CodeCountry;
    private int SportId;
    private Sport sport; // Foreign key referencing Sport table
    private Country country; // Foreign key referencing Country table
    private String password;
    private String identifiant;
    
    public static void mapper(ResultSet objet) {

    }
}

