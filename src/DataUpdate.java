import java.sql.*;

public class DataUpdate {

    public void updateData(String table, String header, String value, String reference, String referenceValue) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

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

    public void updateData(String table, String header, String value, String reference, int referenceValue) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            String sql = "update " + table + " set " + header + "='" + value + "'" + " where " + reference + "=" + referenceValue;
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