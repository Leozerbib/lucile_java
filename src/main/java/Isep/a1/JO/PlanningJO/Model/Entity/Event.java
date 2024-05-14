package Isep.a1.JO.PlanningJO.Model.Entity;

import java.sql.Date;
import java.sql.Time;
import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Event {

    private int eventID; // Unique identifier for each event
    private int sportID; // Foreign key referencing Sport table
    private String eventName; // Name of the event
    private Date eventDate; // Date of the event
    private Time startTime; // Start time of the event
    private String localization; // Venue of the event


}
