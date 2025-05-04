//Insert -

package practical4;

import java.sql.*;

public class JDBCExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        // Step 1: Create database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String SQL = "CREATE DATABASE IF NOT EXISTS STUDENTS";
            stmt.executeUpdate(SQL);
            System.out.println("Database created successfully...");

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Connect to the STUDENTS database and insert records
        try (Connection conn = DriverManager.getConnection(DB_URL + "STUDENTS", USER, PASS);
             Statement stmt = conn.createStatement()) {

            System.out.println("Inserting records into the table...");

            // Optional: Create table if not exists
            String createTable = "CREATE TABLE IF NOT EXISTS Registration " +
                                 "(id INT, first VARCHAR(255), last VARCHAR(255), age INT)";
            stmt.executeUpdate(createTable);

            String sql = "INSERT INTO Registration VALUES (100, 'Sachin', 'Tendulkar', 18)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES (101, 'Virat', 'Kohli', 25)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES (102, 'Mahendra', 'Singh Dhoni', 30)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Registration VALUES (103, 'Rohit', 'Sharma', 28)";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//Select -
package practical4;
import java.sql.*;
public class JDBCSelect {
	static final String DB_URL = "jdbc:mysql://localhost:3306/STUDENTS"; 
	static final String USER = "root";
	static final String PASS = "root";
	static final String QUERY = "SELECT id, first, last, age FROM Registration";

	public static void main(String[] args) {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery(QUERY)) {

			while (rs.next()) {
				// Display values
				System.out.print("ID: " + rs.getInt("id"));
				System.out.print(", Age: " + rs.getInt("age"));
				System.out.print(", First: " + rs.getString("first"));
				System.out.println(", Last: " + rs.getString("last"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
