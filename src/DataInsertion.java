import java.sql.*;

public class DataInsertion {

    public void insertData (String table,String header, String value) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/LMS";
        String user = "root";
        String password = "@StudenT12345";
        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(url, user, password);

            myStmt = myConn.createStatement();

            String sql = "insert into " + table  + " (" + header + ")"
                    + " values (" + '\'' + value + '\'' +")";
            myStmt.executeUpdate(sql);
            System.out.println("Insert complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myStmt != null) {
                myStmt.close();
            }
            if (myConn != null) {
                myConn.close();
            }
        }
    }
}