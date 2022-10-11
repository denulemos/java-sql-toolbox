import Exceptions.FailedConnectionException;

import java.sql.*;

public class ConnectDatabase {

    public static Connection currentConnection;

    public void ConnectToDatabase (String url, String user, String pass) throws FailedConnectionException {
        try {
            Connection myConn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful");
            currentConnection = myConn;
        }
        catch (Exception e) {
            throw new FailedConnectionException("There was an error connecting to the Database");
        }
    }
}
