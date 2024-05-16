package Isep.a1.JO.PlanningJO.Model.Repo;

public class AthleteRepo {
	
	public static final String GET_ALL = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportID "
			+ "left join country c on c.Code = a.countryID ";
	
	public static final String GET_BY_ID = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportID "
			+ "left join country c on c.Code = a.countryID "
			+ "WHERE a.id = ? ";
	
	public static final String GET_BY_SPORT = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportID "
			+ "left join country c on c.Code = a.countryID "
			+ "WHERE a.sportID = ? ";
	
	public static final String GET_BY_NAME = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportID "
			+ "left join country c on c.code = a.countryID "
			+ "WHERE a.name = ? ";
	
	public static final String GET_BY_NAME_LASTNAME = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportid "
			+ "left join country c on c.code = a.countryid "
			+ "WHERE a.name = ? "
			+ "AND a.lastname = ? ";
	
	public static final String GET_BY_COUNTRY = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportID "
			+ "left join country c on c.Code = a.countryID "
			+ "WHERE a.countryID = ? ";
	
	public static final String GET_BY_IDENTIFIANT = 
			"SELECT * FROM athlete a "
			+ "left join sport s on a.sportid = s.sportID "
			+ "left join country c on c.Code = a.countryID "
			+ "WHERE a.identifiant = ? ";
	
	public static final String INSERT = 
			"INSERT INTO athlete "
			+ "(name,lastname, age, gender, sportid, countryid, password, identifiant) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, 'ooo') ";
	
	public static final String update = "UPDATE athlete SET name = ? ";
	public static final String delete = "DELETE FROM athlete WHERE id = ? ";
	
	
}
