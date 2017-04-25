import java.sql.*;

public class DataDeletion {

    public void deleteData(String table, String header, String value) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            String sql = "delete from " + table + " where " + header + "=" + "'"+ value + "'";
            myStmt.executeUpdate(sql);
            System.out.println("Delete complete.");
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

    public void deleteData(String table, String header, int value) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            String sql = "delete from " + table + " where " + header + "=" + value;
            myStmt.executeUpdate(sql);
            System.out.println("Delete complete.");
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