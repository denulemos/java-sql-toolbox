import java.sql.*;

public class QueryDatabase {

    public void runSelectQuery (Connection myConn, String query) throws SQLException {

        try {
            Statement myStatement = myConn.createStatement();
            ResultSet myResultSet = myStatement.executeQuery(query);
            ResultSetMetaData rsmd = myResultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (myResultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(" | ");
                    System.out.print(myResultSet.getString(i));
                }
                System.out.println("");
            }
        }
        catch (SQLException e) {
            System.out.println("There was an error trying to run a Select against the DB: " + e);
        }

    }

    // It can Insert and Update
    public void runInsertOrUpdateQuery (Connection myConn, String query) throws SQLException {

        try {
            Statement myStatement = myConn.createStatement();
            int myResultSet = myStatement.executeUpdate(query);
            System.out.println("Rows affected " + myResultSet);
        }
        catch (SQLException e) {
            System.out.println("There was an error trying to Update or Insert to the DB:  " + e);
        }

    }
}
