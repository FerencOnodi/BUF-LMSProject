import java.sql.SQLException;

/**
 * Created by vajni on 2017.04.24..
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        DataDeletion dd = new DataDeletion();
        dd.deleteData("assignment", "Title", "Kuka");
    }
}
