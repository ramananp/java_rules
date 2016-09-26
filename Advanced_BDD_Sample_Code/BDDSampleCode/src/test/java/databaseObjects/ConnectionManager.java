package databaseObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //URL to point to specific Workstation Server
	//private static String url = "";
	private static String url = "";
	private static String driverName = "com.sybase.jdbc3.jdbc.SybDriver"; //JDBC Driver Name
    private static String username = "";   
    //private static String password = ""; //DEV
    private static String password = ""; //SIT
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
