import java.sql.*;

public class DataInsertion {

    public void insertData (String table,String header, String value) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user = "Vajni";
        String password = "Driller1986va7";
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

    public void insertData (String table,String header, int value) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user = "Vajni";
        String password = "Driller1986va7";
        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(url, user, password);

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

    public void insertUser (int id, String userName,String e_mail, String role, String pwd) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lms";
        String user = "Vajni";
        String password = "Driller1986va7";
        Connection myConn = null;
        Statement myStmt = null;
        try {

            myConn = DriverManager.getConnection(url, user, password);

            myStmt = myConn.createStatement();

            String sql = "insert into user values" + " ("+ id +  "," + '\'' + userName + '\'' + "," + '\'' + e_mail + '\'' +
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