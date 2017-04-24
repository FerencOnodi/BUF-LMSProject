import java.sql.*;

public class DataSelection {

    public void selectData(String value, String table) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/LMS";
        String user = "root";
        String password = "@StudenT12345";
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection(url, user , password);

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("select " + value + " from " + table);

            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

}