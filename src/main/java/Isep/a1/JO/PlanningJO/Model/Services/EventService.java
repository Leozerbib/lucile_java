package Isep.a1.JO.PlanningJO.Model.Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import Isep.a1.JO.PlanningJO.Model.Entity.Event;
import Isep.a1.JO.PlanningJO.Model.Repo.EventRepo;

public class EventService {
    private EventRepo eventRepository;

    public EventService(Connection connection) {
        this.eventRepository = new EventRepo(connection);
    }

    public List<Event> getAllEvents() {
        try {
            return eventRepository.getAllEvents();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Event> filterEvents(Date date, String sportName) {
        try {
            return eventRepository.filterEvents(date, sportName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

