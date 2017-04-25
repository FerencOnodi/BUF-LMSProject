import java.sql.*;

public class DataInsertion {

    public void insertData (String table,String header, String value) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

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

    public void insertData (String table,String header, int value) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            String sql = "insert into " + table  + " (" + header + ")"
                    + " values (" + value +")";
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

    public void insertUser (String userName,String e_mail, String role, String pwd) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            String sql = "insert into user values" + " (NULL, "+'\'' + userName + '\'' + "," + '\'' + e_mail + '\'' +
                    ","+ '\'' + role + '\'' +"," + '\'' + pwd + '\'' + ")";
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