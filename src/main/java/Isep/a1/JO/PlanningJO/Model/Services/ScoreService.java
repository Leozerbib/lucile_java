package Isep.a1.JO.PlanningJO.Model.Services;

import java.sql.SQLException;
import java.util.List;

import Isep.a1.JO.PlanningJO.Model.Entity.CountryScore;
import Isep.a1.JO.PlanningJO.Model.Repo.ScoreRepo;

public class ScoreService {
    private ScoreRepo scoreRepository;

    public ScoreService(ScoreRepo scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<CountryScore> getSumScoresByCountry() throws SQLException {
        return scoreRepository.getSumScoresByCountry();
    }
}

