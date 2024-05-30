import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataOp {
    Statement statement;
    QueryCalls query = new QueryCalls();

    public void creatTable(Connection conn, String tableName) throws SQLException {
        try {
            String q = "CREATE TABLE IF NOT EXISTS " + tableName + "(id varchar(200), name varchar(200), email varchar(200));";
            statement = conn.createStatement();
            statement.execute(q);
            System.out.println("Table Successfully created.\n");
        } catch (Exception e) {
            System.out.println("Can not create a table " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error closing: " + e.getMessage());
                }
            }
        }
    }

    public void addEMPL(Connection conn, String tableName, int id, String name, String email) throws SQLException {
        try {
            String q = String.format(query.Insert(), tableName, id, name, email);
            statement = conn.createStatement();
            statement.execute(q);
            System.out.println("Employee added");
        } catch (Exception e) {
            System.out.println("Employee not added " + e.getMessage());
        }
        conn.close();
    }

    public void removeEMPL(Connection conn, String tableName, int id) throws SQLException {
        try {
            String q = String.format(query.Delete(), tableName, id);
            statement = conn.createStatement();
            statement.execute(q);
            System.out.println("Employee Removed");

        } catch (Exception e) {
            System.out.println("Employee not removed");
        }
        conn.close();
    }

    public void updateEMPL(Connection conn, String tableName, String newName, String oldName) throws SQLException {
        try {
            String q = String.format(query.Update(), tableName, newName, oldName);
            statement = conn.createStatement();
            statement.executeUpdate(q);
            System.out.println("Data Updated");
        } catch (Exception e) {
            System.out.println("Employee data updated");
        }
        conn.close();
    }

    public void readData(Connection conn, String tableName) throws SQLException {
        ResultSet rs = null;
        try {
            String q = String.format(query.Read(), tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(q);
            System.out.println("<------------------------------------->");
            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getString("email") + "");
            }
            System.out.println("<------------------------------------->");

        } catch (Exception e) {
            System.out.println("Cant read your data " + e.getMessage());
        }
        conn.close();
    }

}
