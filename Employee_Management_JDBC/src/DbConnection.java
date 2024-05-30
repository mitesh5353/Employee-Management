import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    Dbcreds creds = new Dbcreds();
    public Connection connectDb() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(creds.getUrl(), creds.getUserName(), creds.getPass());
            if (conn != null) {
                System.out.println("Database Connected!");
            }
        } catch (Exception e) {
            System.out.println("Database Connection Failed!!");
        }
        return conn;
    }
}
