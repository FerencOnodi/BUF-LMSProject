import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class DataParser {

    public List<List<String>> listDataParser(String role) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();
            ResultSet resultSet = null;

            if (role.equals("Mentor")) {
               resultSet = myStmt.executeQuery("SELECT * FROM user");
            } else if (role.equals("Student")) {
                resultSet = myStmt.executeQuery("SELECT * FROM user WHERE role='Student'");
            }

            List<List<String>> users = new ArrayList<>();

            while (resultSet.next()) {
                List<String> usersData = new ArrayList();
                usersData.add(resultSet.getString("UserName"));
                usersData.add(resultSet.getString("Email"));
                usersData.add(resultSet.getString("Role"));
                users.add(usersData);
            }

            return users;


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Ferkó
    public List<List<String>> assignmentDataParser() throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;

        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            myConn = DriverManager.getConnection(DataBaseEnums.URL.dbData, DataBaseEnums.USER.dbData,
                    DataBaseEnums.PASSWORD.dbData);

            myStmt = myConn.createStatement();
            ResultSet resultSet = null;

            resultSet = myStmt.executeQuery("SELECT * FROM assignment");


            List<List<String>> assignments = new ArrayList<>();

            while (resultSet.next()) {
                List<String> assData = new ArrayList();
                assData.add(resultSet.getString("Title"));
                assData.add(resultSet.getString("Content"));
                assData.add(resultSet.getString("MaxPoints"));
                assData.add(resultSet.getString("Score"));
                assData.add(resultSet.getString("SubmissionRequirement"));
                assData.add(resultSet.getString("Published"));
                assData.add(resultSet.getString("UserID"));
                assignments.add(assData);
            }

            return assignments;


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}