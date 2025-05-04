//Insert -
// first create a database in mysql work bench using followimg code:
CREATE DATABASE TUTORIALSPOINT;

USE TUTORIALSPOINT;

CREATE TABLE Registration (
    id INT,
    first VARCHAR(255),
    last VARCHAR(255),
    age INT
);
// then create java project in eclipse.after that make a package having 2 classes : JDBCInsertExample and JDBCSelectExample. paste the follwing code for the classes:
// ALSO ADD JAR FILE IN YOUR BUILD PATH.
//JDBCInsertExample:

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertExample {
    static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
    static final String USER = "root";
    static final String PASS = "arnav";

    public static void main(String[] args) {
        // Open a connection
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute insert queries
            System.out.println("Inserting records into the table...");

            String sql = "INSERT INTO Registration VALUES (100, 'Sachin', 'Tendulkar', 18)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Registration VALUES (101, 'Virat', 'Kohli', 25)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Registration VALUES (102, 'Mahendra Singh', 'Dhoni', 30)";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Registration VALUES (103, 'Rohit', 'Sharma', 28)";
            stmt.executeUpdate(sql);

            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//JDBCSelectExample:
package exp5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelectExample {
    static final String DB_URL = "jdbc:mysql://localhost/TUTORIALSPOINT";
    static final String USER = "root";
    static final String PASS = "arnav";
    static final String QUERY = "SELECT id, first, last, age FROM Registration";

    public static void main(String[] args) {
        // Open a connection
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            // Extract and print data
            while (rs.next()) {
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
// now simply execute javainsertexample class first, and then execute javaselect example. MAKE SURE THE ADMIN AND PASS IN BOTH CODES MATCHES TO YOUR ADMIN AND PASS OF MYSQL!
