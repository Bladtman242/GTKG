package rental;

import java.sql.*;

/**
 * @author Linnéa Frisenette Rechter, Sigurt Bladt Dinesen, Michael Mungkol Storgaard
 * @version 2011-11-17
 *
 */
public class Dealer {
	
	private Connection conn;
	
	private void testDatabase() throws SQLException {
		DatabaseConnect connection = new DatabaseConnect();
		conn = connection.dbConnect();
        Statement s = conn.createStatement ();
        s.executeQuery ("SELECT id, name FROM Dealer;");
        ResultSet rs = s.getResultSet ();
        while (rs.next ()) {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id+": "+name);
        }
        rs.close();
        s.close();
	}

	/**
	 * Main class
	 * @param args
	 */
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		try {
			dealer.testDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}