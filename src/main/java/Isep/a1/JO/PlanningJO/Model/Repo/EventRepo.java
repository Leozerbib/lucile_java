package Isep.a1.JO.PlanningJO.Model.Repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Isep.a1.JO.PlanningJO.Model.Entity.Event;

public class EventRepo {
    private Connection connection;

    public EventRepo(Connection connection) {
        this.connection = connection;
    }

    public List<Event> getAllEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = "SELECT s.sportname, e.eventdate, e.starttime, p.nomsite, p.pointgeo " +
                       "FROM public.event e " +
                       "JOIN public.sport s ON e.sportid = s.sportid " +
                       "JOIN public.paris p ON e.localization = p.codesite";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Event event = new Event();
            event.setSportame(rs.getString("sportname"));
            event.setEventDate(rs.getDate("eventdate"));
            event.setStartTime(rs.getTime("starttime"));
            event.setNomSite(rs.getString("nomsite"));
            event.setAdress(rs.getString("pointgeo"));
            events.add(event);
        }
        return events;
    }
    
    public List<Event> filterEvents(Date date, String sportName) throws SQLException {
        List<Event> events = new ArrayList<>();
        String query = "SELECT e.eventid, s.sportname, e.eventdate, e.starttime, p.nomsite, p.pointgeo " +
                       "FROM public.event e " +
                       "JOIN public.sport s ON e.sportid = s.sportid " +
                       "JOIN public.paris p ON e.localization = p.codesite " +
                       "WHERE e.eventdate = ? AND s.sportname = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setDate(1, date);
        stmt.setString(2, sportName);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Event event = new Event();
            event.setSportame(rs.getString("sportname"));
            event.setEventDate(rs.getDate("eventdate"));
            event.setStartTime(rs.getTime("starttime"));
            event.setNomSite(rs.getString("nomsite"));
            event.setAdress(rs.getString("pointgeo"));
            events.add(event);
        }
        return events;
    }

}
