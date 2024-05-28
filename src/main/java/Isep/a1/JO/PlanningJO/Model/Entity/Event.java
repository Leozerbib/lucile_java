package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.Date;
import java.sql.Time;
import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {

    private String sportame; // Foreign key referencing Sport table
    private Date eventDate; // Date of the event
    private Time startTime; // Start time of the event
    private String nomSite; // Venue of the event
    private String adress; // Address of the venue

}
