import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        DbConnection db = new DbConnection();
        Connection conn = db.connectDb();
        DataOp t1 = new DataOp();

        //Initializing table
        String tableName = "EmployeeManagement";
        t1.creatTable(conn, tableName);

        //Taking input from user to operate CRUD
        Scanner scanner = new Scanner(System.in);
        System.out.println("1:Insert 2:Remove 3:Update 4:Read");
        int input = scanner.nextInt();

        //
        switch (input) {
            case 1:
                System.out.println("Please enter your id.");
                int id = scanner.nextInt();
                System.out.println("Please enter your name.");
                String name = scanner.next();
                System.out.println("Please enter your email.");
                String email = scanner.next();
                t1.addEMPL(conn,tableName, id, name, email);
                break;
            case 2:
                System.out.println("Please enter your id.");
                id = scanner.nextInt();
                t1.removeEMPL(conn, tableName, id);
                break;
            case 3:
                System.out.println("Please enter the new name");
                String newName = scanner.next();
                System.out.println("Please enter the old name");
                String oldName = scanner.next();
                t1.updateEMPL(conn,tableName,newName, oldName);
                break;
            case 4:
                t1.readData(conn, tableName);
                break;
        }
        scanner.close();
        if(conn != null)
        {
            conn.close();
        }
    }
}
