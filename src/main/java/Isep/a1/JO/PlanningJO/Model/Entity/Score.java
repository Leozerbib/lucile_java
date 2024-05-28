package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.Date;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Score {
    public int scoreId; // Unique identifier for each score
    public int athleteId; // Foreign key referencing Athlete table
    public float Score; // Score achieved in the event
    public Date resultDate; // Date when the score/result was recorded

    // Getters and setters for private variables
    // Insert getters and setters here
}

