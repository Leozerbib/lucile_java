package Isep.a1.JO.PlanningJO.Model.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import Isep.a1.JO.PlanningJO.Config.ConnectionDB;
import Isep.a1.JO.PlanningJO.Model.Entity.Sport;
import Isep.a1.JO.PlanningJO.Model.Repo.SportRepo;


public class SportService {

	private SportRepo sportRepo;

	public List<Sport> getAllSport() throws SQLException {
		String query = sportRepo.GET_ALL_SPORT;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet obj = stmt.executeQuery();
		return Sport.listmapper(obj);

		


		

	}
	
	public void getById(int id) throws SQLException {
		String query = SportRepo.GET_BY_ID;
		
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(SportRepo.GET_BY_ID);
		stmt.setInt(1, id);
		Object obj = stmt.executeQuery(query);
		System.out.println(obj);
	}
	
	public void getBySportName(String name) throws SQLException {
		String query = SportRepo.GET_BY_SPORTNAME;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, name);
		Object obj = stmt.executeQuery(query);
		System.out.println(obj);
	}
	
	public void getIdBySportName(String lastName) throws SQLException {
		String query = SportRepo.GET_ID_BY_SPORTNAME;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, lastName);
		Object obj = stmt.executeQuery(query);
		System.out.println(obj);
	}

}
