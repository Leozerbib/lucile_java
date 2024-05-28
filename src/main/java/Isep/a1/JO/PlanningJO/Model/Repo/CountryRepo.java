package Isep.a1.JO.PlanningJO.Model.Repo;


public class CountryRepo {
	
	public static final String GET_ALL_COUNTRY = 
			"Select * from country c ";
	
	public static final String GET_BY_COUNTRY = 
			"Select * from counrty c "
			+ "where c.country = ?";
	
	public static final String GET_BY_CODE = 
			"Select * from country c "
			+ "where c.Code = ?";
	
	public static final String GET_CODE_BY_COUNTRY = 
			"Select Code from country c "
			+ "where c.country = ?";

	
}
