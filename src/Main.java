import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String testUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String testUser = "student";
        String testPassword = "student";
        try {
            ConnectDatabase connectDatabase = new ConnectDatabase();

            Connection currentConnection = connectDatabase.ConnectToDatabase(testUrl, testUser, testPassword);
            if (currentConnection != null) {
                // Init the query class after we know that we have a Database already connected and running
                QueryDatabase queryDatabase = new QueryDatabase();

                // We run Query against Database
                queryDatabase.runSelectQuery(currentConnection, "select * from employees");

                // We insert new registry
                queryDatabase.runInsertOrUpdateQuery(currentConnection, "insert into employees (last_name, first_name, email, department, salary)"
                       + "values ('Lemon', 'Denu', 'denulemon@empresa.com', 'Developer', 10000 )");
                queryDatabase.runSelectQuery(currentConnection, "select * from employees");

                // We update Deno Lemon registry
                queryDatabase.runInsertOrUpdateQuery(currentConnection, "update employees set email='denolemon@google.com where last_name='Lemon'");
                queryDatabase.runSelectQuery(currentConnection, "select * from employees");

                // We delete Deno Registry
                queryDatabase.runInsertOrUpdateQuery(currentConnection, "delete from employees set email='denolemon@google.com where last_name='Lemon'");
                queryDatabase.runSelectQuery(currentConnection, "select * from employees");
            }
        }
       catch (Exception e) {
           System.out.println("The execute ended due to an error");
       }
    }
}