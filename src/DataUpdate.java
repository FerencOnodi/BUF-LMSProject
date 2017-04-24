import java.sql.*;

public class DataUpdate {

    public void updateData(String table, String header, String value, String reference, String referenceValue) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/LMS";
        String user = "root";
        String password = "@StudenT12345";
        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(url, user, password);

            myStmt = myConn.createStatement();

            String sql = "update " + table + " set " + header + "='" + value + "'" + " where " + reference + "=" + "'"+ referenceValue + "'";
            myStmt.executeUpdate(sql);
            System.out.println("Update complete.");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }
}