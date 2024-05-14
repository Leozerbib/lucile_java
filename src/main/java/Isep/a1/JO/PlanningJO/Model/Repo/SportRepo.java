package Isep.a1.JO.PlanningJO.Model.Repo;

public class SportRepo {
	
	public static final String GET_ALL_SPORT = 
			"Select * from sport s ";
	
	public static final String GET_BY_ID = 
			"Select * from sport s "
			+ "where s.sportid = ?";
	
	public static final String GET_BY_SPORTNAME = 
			"Select * from sport s "
			+ "where s.sportname = ?";
	
	public static final String GET_ID_BY_SPORTNAME = 
			"Select sportid from sport s "
			+ "where s.sportname = ?";

}
