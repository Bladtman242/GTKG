package rental;

import java.sql.*;

/**
 * @author Michael Storgaard
 * @version 2011-11-17
 *
 */
public class DatabaseConnect extends DatabaseSettings {
	
	private Connection conn;

    public Connection dbConnect() {
        try {
// Fra mysql-connector-java-5.1.5-bin.jar, lagt i /program files/java/jdk1.6.0_01/jre/lib/ext/
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+dbHost+"/"+dbName, dbUser, dbPass);
            return conn;
        } catch (SQLException exn) {
            System.out.println("Kan ikke åbne databaseforbindelsen: "+exn);
        } catch (ClassNotFoundException exn) {
            System.out.println("Kan ikke finde databasedriver: "+exn);
        }
        return null;
    }
}
