import java.sql.*;

public class DataSelection {

    public String selectData(String selectValue, String header, String table, String value) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/lms";
        String user = "Vajni";
        String password = "Driller1986va7";
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = DriverManager.getConnection(url, user , password);

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT " + selectValue + " FROM " + table + " WHERE " + header + "=" + "\'" + value + "\'");

            String returnString = "";

            while (myRs.next()) {
                returnString += myRs.getString(selectValue);
                }
            return returnString;
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
        return null;
    }

}