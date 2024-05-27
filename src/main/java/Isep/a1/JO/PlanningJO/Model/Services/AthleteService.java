package Isep.a1.JO.PlanningJO.Model.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Isep.a1.JO.PlanningJO.Config.ConnectionDB;
import Isep.a1.JO.PlanningJO.Model.Constructeur.CreateUser;
import Isep.a1.JO.PlanningJO.Model.Entity.Athlete;
import Isep.a1.JO.PlanningJO.Model.Entity.Country;
import Isep.a1.JO.PlanningJO.Model.Repo.AthleteRepo;

public class AthleteService {
	
	
	public Athlete getAthleteById(Integer id) throws SQLException {
		String query = AthleteRepo.GET_BY_ID;
		Connection conn = ConnectionDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet obj = stmt.executeQuery();
		System.out.println(obj);
		return Athlete.mapper(obj.next() ? obj : null);
	}
	
	
	
	public Athlete getAthleteByNameAndLastname(String name,String lastname) throws SQLException {
		String query = AthleteRepo.GET_BY_NAME_LASTNAME;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, name);
        stmt.setString(2, lastname);
		ResultSet obj = stmt.executeQuery();
		return Athlete.mapper(obj.next() ? obj : null);
	}
	
	public ResultSet getAthleteByName(String name) throws SQLException {
		String query = AthleteRepo.GET_BY_NAME;
		Connection conn = ConnectionDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, name);
		ResultSet obj = stmt.executeQuery();
		System.out.println(obj);
		return obj;
	}
	
	public void getAthleteByCountry(String countryString) throws SQLException {
		String query = AthleteRepo.GET_BY_COUNTRY;
		Connection conn = ConnectionDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, countryString);
		ResultSet obj = stmt.executeQuery();
		System.out.println(obj);
	}
	
	public void getAthleteBySport(int sportId) throws SQLException {
		String query = AthleteRepo.GET_BY_SPORT;
		Connection conn = ConnectionDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, sportId);
		ResultSet obj = stmt.executeQuery();
		System.out.println(obj);
	}
	
	public void insertAthlete(CreateUser createUser) throws SQLException {
		String query = AthleteRepo.INSERT;
		Connection conn = ConnectionDB.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, createUser.getName());
		stmt.setString(2, createUser.getLastName());
		stmt.setInt(3, createUser.getAge());
		stmt.setString(4, createUser.getGender());
		stmt.setInt(5, createUser.getSport().getSportID());
		stmt.setString(6, createUser.getCountry().getCode());
		stmt.setString(7, createUser.getPassword());
		if (stmt.executeUpdate() == 1) {
			System.out.println("Athlete inserted successfully");
		}
		
	}
	
}
