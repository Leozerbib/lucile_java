package Isep.a1.JO.PlanningJO.Model.Repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Isep.a1.JO.PlanningJO.Model.Entity.CountryScore;
import Isep.a1.JO.PlanningJO.Model.Entity.Score;

public class ScoreRepo {
    private Connection connection;

    public ScoreRepo(Connection connection) {
        this.connection = connection;
    }

    public List<Score> getScores() throws SQLException {
        String query = "SELECT * FROM score";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Score> scores = new ArrayList<>();
        while (resultSet.next()) {
            Score score = new Score(
                resultSet.getInt("scoreid"),
                resultSet.getInt("athleteid"),
                resultSet.getFloat("score"),
                resultSet.getDate("resultdate"),
                resultSet.getString("countryid")
            );
            scores.add(score);
        }
        return scores;
    }

    public List<CountryScore> getSumScoresByCountry() throws SQLException {
        String query = "SELECT c.country, SUM(s.score) AS totalScore " +
                       "FROM score s JOIN country c ON s.countryid = c.code " +
                       "GROUP BY c.country";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<CountryScore> countryScores = new ArrayList<>();
        while (resultSet.next()) {
            CountryScore countryScore = new CountryScore(
                resultSet.getString("Country"),
                resultSet.getDouble("totalScore")
            );
            countryScores.add(countryScore);
        }
        return countryScores;
    }
}
