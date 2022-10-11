public class Main {
    public static void main(String[] args) {
        String testUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String testUser = "student";
        String testPassword = "student";
        try {
            ConnectDatabase connectDatabase = new ConnectDatabase();

            connectDatabase.ConnectToDatabase(testUrl, testUser, testPassword);
            if (ConnectDatabase.currentConnection != null) {
                // Init the query class after we know that we have a Database already connected and running
                QueryDatabase queryDatabase = new QueryDatabase();

                // We run Query against Database
                queryDatabase.runSelectQuery("select * from employees");

                // We insert new registry
                queryDatabase.runInsertOrUpdateQuery("insert into employees (last_name, first_name, email, department, salary)"
                       + "values ('Lemon', 'Denu', 'denulemon@empresa.com', 'Developer', 10000 )");
                queryDatabase.runSelectQuery("select * from employees");

                // We update Deno Lemon registry
                queryDatabase.runInsertOrUpdateQuery( "update employees set email='denolemon@google.com' where last_name='Lemon'");
                queryDatabase.runSelectQuery( "select * from employees");

                // We delete Deno Registry
                queryDatabase.runInsertOrUpdateQuery( "delete from employees where last_name='Lemon'");
                queryDatabase.runSelectQuery( "select * from employees");

                // We run the prepared Statement
                queryDatabase.preparedStatements(1000.0, "HR");

                // We run the Store procedures
                StoreProcedures storeProcedures = new StoreProcedures();
                storeProcedures.callGreetTheDepartmentSP("Engineering");
                storeProcedures.callGetCountForDepartment("Engineering");
                storeProcedures.callIncreaseSalariesForDepartmentSP("Engineering", 1000.0);
            }
        }
       catch (Exception e) {
           System.out.println("The execute ended due to an error: " + e);
       }
    }
}