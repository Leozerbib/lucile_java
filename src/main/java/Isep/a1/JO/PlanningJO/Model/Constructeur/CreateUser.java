package Isep.a1.JO.PlanningJO.Model.Constructeur;

import java.sql.Date;

import Isep.a1.JO.PlanningJO.Model.Entity.Country;
import Isep.a1.JO.PlanningJO.Model.Entity.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUser {
	
    private String name; // Name of the athlete
    private String lastName; // Last name of the athlete
    private int age; // Age of the athlete
    private String gender; // Gender of the athlete
    private Sport sport; // Foreign key referencing Sport table
    private Country country; // Foreign key referencing Country table
    private String password;
    private int identifiant;

}
