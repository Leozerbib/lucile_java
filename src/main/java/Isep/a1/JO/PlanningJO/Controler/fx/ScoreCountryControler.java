package Isep.a1.JO.PlanningJO.Controler.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Isep.a1.JO.PlanningJO.Config.ConnectionDB;
import Isep.a1.JO.PlanningJO.Model.Entity.CountryScore;
import Isep.a1.JO.PlanningJO.Model.Repo.ScoreRepo;
import Isep.a1.JO.PlanningJO.Model.Services.ScoreService;

public class ScoreCountryControler {
    @FXML
    public TableView<CountryScore> scoreTable;
    @FXML
    public TableColumn<CountryScore, String> countryColumn;
    @FXML
    public TableColumn<CountryScore, Double> scoreColumn;

    public ScoreService scoreService;

    public void initialize() {
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("countryName"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("totalScore"));

        try {
            Connection connection = ConnectionDB.getConnection();
            ScoreRepo scoreRepository = new ScoreRepo(connection);
            scoreService = new ScoreService(scoreRepository);

            ObservableList<CountryScore> countryScores = FXCollections.observableArrayList(scoreService.getSumScoresByCountry());
            scoreTable.setItems(countryScores);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

