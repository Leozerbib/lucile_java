package Isep.a1.JO.PlanningJO.Controler.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Isep.a1.JO.PlanningJO.Model.Entity.Score;

public class ScoreControler {

    @FXML
    public ComboBox<Integer> sportFilterComboBox;
    @FXML
    public TableView<Score> scoresTableView;
    @FXML
    public TableColumn<Score, Integer> athleteIdColumn;
    @FXML
    public TableColumn<Score, Integer> IdColumn;
    @FXML
    public TableColumn<Score, Float> scoreColumn;
    @FXML
    public TableColumn<Score, Date> resultDateColumn;

    public ObservableList<Score> scoresList;

    public void initialize() {
    	System.out.println("ScoreControler initialize");
    	IdColumn.setCellValueFactory(new PropertyValueFactory<>("scoreId"));
        athleteIdColumn.setCellValueFactory(new PropertyValueFactory<>("athleteId"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
        resultDateColumn.setCellValueFactory(new PropertyValueFactory<>("resultDate"));

        loadSportIds();
        loadScores(null);
    }

    public void loadSportIds() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DISTINCT sport_id FROM public.identifiant")) {

            ObservableList<Integer> sportIds = FXCollections.observableArrayList();
            while (rs.next()) {
                sportIds.add(rs.getInt("sport_id"));
            }
            System.out.println(sportIds);
            sportFilterComboBox.setItems(sportIds);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadScores(Integer sportId) {
        scoresList = FXCollections.observableArrayList();
        String query = "SELECT s.scoreid,s.athleteid, s.score, s.resultdate " +
                       "FROM public.score s " +
                       "JOIN public.identifiant i ON s.athleteid = i.identifiant";

        if (sportId != null) {
            query += " WHERE i.sport_id = " + sportId;
        }

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
        	System.out.println(rs);
            while (rs.next()) {
                scoresList.add(new Score(
                		rs.getInt("scoreid"),
                        rs.getInt("athleteid"),
                        rs.getFloat("score"),
                        rs.getDate("resultdate")
                ));
            }
            scoresTableView.setItems(scoresList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void filterScores() {
        Integer selectedSportId = sportFilterComboBox.getValue();
        loadScores(selectedSportId);
    }

    public Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://dpg-cp1i1oect0pc73d104b0-a.frankfurt-postgres.render.com:5432/jo_calendar_db";
        String user = "jo_calendar_db_user";
        String password = "vmjalBryoKB8FhyvnYwXnspSxWQpRZL3";
        return DriverManager.getConnection(url, user, password);
    }
}
