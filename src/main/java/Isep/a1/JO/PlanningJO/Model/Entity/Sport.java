package Isep.a1.JO.PlanningJO.Model.Entity;

import java.security.Identity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sport {

    private int sportID; // Unique identifier for each sport
    private String sportName; // Name of the sport
    private String description; // Description of the sport

    // Getters and setters for private variables
    public static List<Sport> listmapper(ResultSet resultSet) throws SQLException {
    	int size = 0;
    	List<Sport> sports = new ArrayList<Sport>();
    	while (resultSet.next()) {
    		sports.add(mapper(resultSet));
		}
    	return sports;

    }
    
    public static Sport mapper(ResultSet resultSet) throws SQLException {
    	Sport sport = new Sport(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
		System.out.println(sport);
		return sport;
    }
    
}
