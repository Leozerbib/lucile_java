package Isep.a1.JO.PlanningJO.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
    
	
	
	public static Connection getConnection() throws SQLException {
        Connection connection = null;
        String url = "jdbc:postgresql://dpg-cp1i1oect0pc73d104b0-a.frankfurt-postgres.render.com:5432/jo_calendar_db";
        String username = "jo_calendar_db_user";
        String password = "vmjalBryoKB8FhyvnYwXnspSxWQpRZL3";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("postgresql connected");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        }
        return connection;
    }
	
	
	public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
