package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.Date;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Score {
    private int scoreID; // Unique identifier for each score
    private int eventID; // Foreign key referencing Event table
    private int athleteID; // Foreign key referencing Athlete table
    private float score; // Score achieved in the event
    private Date resultDate; // Date when the score/result was recorded

    // Getters and setters for private variables
    // Insert getters and setters here
}

