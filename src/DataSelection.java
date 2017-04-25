import java.sql.*;

public class DataSelection {

    public String selectData(String selectValue, String table, String header, String value) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT " + "\'" + selectValue + "\'" + " FROM " + table + " WHERE " + header + "=" + "\'" + value + "\'");

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