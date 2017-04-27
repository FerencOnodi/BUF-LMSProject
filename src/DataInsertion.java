import java.sql.*;

public class DataInsertion {



    public void insertUser (String userName,String e_mail, String role, String pwd) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
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

    public void insertAssignment (String Title, String Content, int MaxPoints, int Score, String SubmissionRequirement,
                                  String Published, int id) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData ,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();

            String sql = "insert into assignment values" + "(" + '\'' + Title + '\'' + "," + '\'' + Content + '\'' +
                    ","+ '\'' + MaxPoints + '\'' + "," + '\'' + Score + '\'' + "," + '\'' + SubmissionRequirement + '\''
                    + "," + '\'' + Published + '\'' + ","  +  id +")";
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