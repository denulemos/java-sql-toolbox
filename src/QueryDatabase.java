import Exceptions.FailedPreparedStatementException;
import Exceptions.FailedSelectQueryException;
import Exceptions.FailedUpdateException;

import java.sql.*;

public class QueryDatabase {

    public void runSelectQuery (String query) throws  FailedSelectQueryException {
        System.out.println("Running Select Query...");
        try {
            Statement myStatement = ConnectDatabase.currentConnection.createStatement();
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
        catch (Exception e) {
            throw new FailedSelectQueryException("There was an error trying to run the Select query on the Database");
        }

    }

    // It can Insert, Update and Delete, it shows the amount of rows affected
    public void runInsertOrUpdateQuery (String query) throws  FailedUpdateException {
        System.out.println("Running Update Query...");
        try {
            Statement myStatement = ConnectDatabase.currentConnection.createStatement();
            System.out.println("Rows affected " + myStatement.executeUpdate(query));
        }
        catch (Exception e) {
            throw new FailedUpdateException("There was an error trying to run the following query on the DB: " + query);
        }

    }

    // This only works with the Employee table structure, make sure to adapt it to your own table if necessary
    public void preparedStatements (Double salary, String department) throws FailedPreparedStatementException {
        System.out.println("Running Prepared Query...");
        try {
            PreparedStatement queryToRun = ConnectDatabase.currentConnection.prepareStatement("select * from employees where salary > ? and department = ?");
            queryToRun.setDouble(1, salary);
            queryToRun.setString(2, department);

            ResultSet result = queryToRun.executeQuery();
            System.out.println(result);
        } catch (Exception e) {
            throw new FailedPreparedStatementException("There was an error trying to run the prepared Statement");
        }

    }
}
