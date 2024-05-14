package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Country {
    private String code; // Name of the country
    private String country; // Continent to which the country belongs
    private String flag_url; // Flag of the country

    // Getters and setters for private variables
    // Insert getters and setters here
    public static List<Country> listmapper(ResultSet resultSet) throws SQLException {
    	List<Country> countrys = new ArrayList<Country>();
    	while (resultSet.next()) {
    		countrys.add(mapper(resultSet));
		}
    	return countrys;

    }
    
    public static Country mapper(ResultSet resultSet) throws SQLException {
    	Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
		System.out.println(country);
		return country;
    }
}

