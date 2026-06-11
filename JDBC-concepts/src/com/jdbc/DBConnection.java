import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {

    static final String URL =
            "jdbc:mysql://localhost:3306/jdbc_demo";

    static final String USER = "root";

    static final String PASSWORD = "Akshat@2905";

    public static void main(String[] args) {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            System.out.println("Connected Successfully");

            // // INSERT
            // String insertQuery =
            //         "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)";

            // PreparedStatement insertStmt =
            //         conn.prepareStatement(insertQuery);

            // insertStmt.setString(1, "Akshat");
            // insertStmt.setString(2, "SDET");
            // insertStmt.setDouble(3, 50000);

            // int rows =
            //         insertStmt.executeUpdate();

            // System.out.println(rows + " row inserted");

            // // READ
            // String selectQuery =
            //         "SELECT * FROM employee";

            // Statement stmt =
            //         conn.createStatement();

            // ResultSet rs =
            //         stmt.executeQuery(selectQuery);

            // System.out.println("\nEmployees:");

            // while(rs.next()) {

            //     System.out.println(
            //             rs.getInt("id") + " "
            //             + rs.getString("name") + " "
            //             + rs.getString("department") + " "
            //             + rs.getDouble("salary")
            //     );
            // }

            // UPDATE
            // String updateQuery =
            //         "UPDATE employee SET salary=? WHERE id=?";

            // PreparedStatement updateStmt =
            //         conn.prepareStatement(updateQuery);

            // updateStmt.setDouble(1, 70000);
            // updateStmt.setInt(2, 1);

            // updateStmt.executeUpdate();

            // System.out.println("\nEmployee Updated");

            // DELETE
            String deleteQuery =
                    "DELETE FROM employee WHERE id=?";

            PreparedStatement deleteStmt =
                    conn.prepareStatement(deleteQuery);

            deleteStmt.setInt(1, 1);

            deleteStmt.executeUpdate();

            System.out.println("Employee Deleted");

            conn.close();

        }
        catch(Exception e) {

            e.printStackTrace();
        }
    }
}