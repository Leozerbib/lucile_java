package Isep.a1.JO.PlanningJO.Model.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import Isep.a1.JO.PlanningJO.Config.ConnectionDB;
import Isep.a1.JO.PlanningJO.Model.Entity.Country;
import Isep.a1.JO.PlanningJO.Model.Entity.Sport;
import Isep.a1.JO.PlanningJO.Model.Repo.CountryRepo;

public class CountryService {
	
	public List<Country> getAllCountry() throws SQLException {
		String query = CountryRepo.GET_ALL_COUNTRY;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet obj = stmt.executeQuery();
		return Country.listmapper(obj);
	}
	
	public void getByCode(String code) throws SQLException {
		String query = CountryRepo.GET_BY_CODE;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, code);
		Object obj = stmt.executeQuery(query);
		System.out.println(obj);
	}
	
	public void getByCountry(String country) throws SQLException {
		String query = CountryRepo.GET_BY_COUNTRY;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, country);
		Object obj = stmt.executeQuery(query);
		System.out.println(obj);
	}
	
	public void getCodeByCountry(String country) throws SQLException {
		String query = CountryRepo.GET_CODE_BY_COUNTRY;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setString(1, country);
		Object obj = stmt.executeQuery(query);
		System.out.println(obj);
	}
}
