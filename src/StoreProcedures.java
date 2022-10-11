import Exceptions.StoreProcedureException;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Types;

public class StoreProcedures {

    // IN Parameter
    public void callIncreaseSalariesForDepartmentSP (String department, Double increaseAmount) throws StoreProcedureException {
        try {
            PreparedStatement query = ConnectDatabase.currentConnection.prepareCall("{call increase_salaries_for_department(?,?)}");
            query.setString(1, department);
            query.setDouble(2, increaseAmount);

            System.out.println("Executing " + query);
            query.execute();
            System.out.println("Execute finished");
        }
        catch (Exception e) {
            throw new StoreProcedureException("There was an error trying to execute the increase_salaries_for_department Store Procedure " + e);
        }

    }

    // INOUT Parameter
    public void callGreetTheDepartmentSP (String department) throws StoreProcedureException {
        try {
            CallableStatement query = ConnectDatabase.currentConnection.prepareCall("{call greet_the_department(?)}");
            query.registerOutParameter(1, Types.VARCHAR);
            query.setString(1, department);

            System.out.println("Executing " + query);
            query.execute();
            System.out.println("Execute finished");
        }
        catch (Exception e) {
            throw new StoreProcedureException("There was an error trying to execute the increase_salaries_for_department Store Procedure " + e);
        }

    }

    // OUT Parameter
    public void callGetCountForDepartment (String department) throws StoreProcedureException {
        try {
            CallableStatement query = ConnectDatabase.currentConnection.prepareCall("{call get_count_for_department(?,?)}");

            query.setString(1, department);
            query.registerOutParameter(2, Types.INTEGER);

            System.out.println("Executing " + query);
            query.execute();
            int count = query.getInt(2); // Get the value of the OUT parameter
            System.out.println("Result: " + count);
        }
        catch (Exception e) {
            throw new StoreProcedureException("There was an error trying to execute the increase_salaries_for_department Store Procedure " + e);
        }

    }
}
