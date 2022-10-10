import java.sql.*;

public class ConnectDatabase {

    public Connection ConnectToDatabase (String url, String user, String pass) throws SQLException {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
            return myConn;
        }
        catch (SQLException e) {
            System.out.println("There was an error trying to connect to the database: " + e);
            return null;
        }
    }
}
