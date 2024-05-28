package Isep.a1.JO.PlanningJO.Controler.fx;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import Isep.a1.JO.PlanningJO.Config.ConnectionDB;
import Isep.a1.JO.PlanningJO.Model.Entity.Event;
import Isep.a1.JO.PlanningJO.Model.Services.EventService;

public class EventController {
    @FXML
    public TableView<Event> eventTableView;
    @FXML
    public TableColumn<Event, String> sportNameColumn;
    @FXML
    public TableColumn<Event, Date> eventDateColumn;
    @FXML
    public TableColumn<Event, Time> startTimeColumn;
    @FXML
    public TableColumn<Event, String> nomSiteColumn;
    @FXML
    public TableColumn<Event, String> adressColumn;
    @FXML
    public DatePicker datePicker;
    @FXML
    public TextField sportTextField;

    public EventService eventService;

    public void initialize() throws SQLException {
        Connection connection = ConnectionDB.getConnection();
        eventService = new EventService(connection);
        loadEvents();

        // Initialize TableView columns
        sportNameColumn.setCellValueFactory(new PropertyValueFactory<>("sportame"));
        eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        nomSiteColumn.setCellValueFactory(new PropertyValueFactory<>("nomSite"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<>("adress"));
    }

    public void loadEvents() {
        List<Event> events = eventService.getAllEvents();
        ObservableList<Event> eventList = FXCollections.observableArrayList(events);
        eventTableView.setItems(eventList);
    }

    @FXML
    public void filterEvents() {
        Date date = Date.valueOf(datePicker.getValue());
        String sportName = sportTextField.getText();
        List<Event> events = eventService.filterEvents(date, sportName);
        ObservableList<Event> eventList = FXCollections.observableArrayList(events);
        eventTableView.setItems(eventList);
    }
}
