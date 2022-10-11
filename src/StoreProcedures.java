import Exceptions.StoreProcedureException;

import java.sql.PreparedStatement;

public class StoreProcedures {

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
}
