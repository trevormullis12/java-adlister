import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/employees?serverTimezone=UTC&useSSL=false",
                "root",
                "codeup"
        );
        Statement stmt = connection.createStatement();
        String selectQuery = "SELECT * FROM employees.employees";
        ResultSet rs = stmt.executeQuery(selectQuery);

        System.out.println(getEmployeeFirstNames(rs));
        System.out.println(getEmployeeFirstNames(rs, 2));
        System.out.println(getEmployeeFirstNames(rs, 11));
    }
    private static List<String> getEmployeeFirstNames(ResultSet rs) throws SQLException{
        List<String> names = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            rs.next();
            names.add(rs.getString("First_Name"));
        }
        return names;
    }

    private static List<String> getEmployeeFirstNames(ResultSet rs, int length) throws SQLException{
        List<String> names = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            rs.next();
            names.add(rs.getString("First_Name"));
        }
        return names;
    }
}
