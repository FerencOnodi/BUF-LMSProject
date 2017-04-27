import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
/**
 * Created by marton on 2017.04.27..
 */
public class DataParserTest {

    DataInsertion di = new DataInsertion();
    DataDeletion dd = new DataDeletion();
    DataParser dp = new DataParser();
    DataSelection ds = new DataSelection();


    @Test
    public void listUsersAsMentor() throws SQLException {
        int rows = ds.countRows("user");
        di.insertUser("TestStudent","student@test.email","Student","1234");
        di.insertUser("TestMentor","mentor@test.email","Mentor","asdf");
        List<List<String>> result = dp.listDataParser("Mentor");
        try {
            assertEquals(rows + 2,result.size());
        } finally {
            dd.deleteData("user","userName","TestStudent");
            dd.deleteData("user","userName","TestMentor");
        }
    }

    @Test
    public void listUsersAsStudent() throws SQLException {
        int rows = ds.countRows("user");
        di.insertUser("TestStudent","student@test.email","Student","1234");
        di.insertUser("TestMentor","mentor@test.email","Mentor","asdf");
        List<List<String>> result = dp.listDataParser("Student");
        try {
            assertEquals(rows + 1,result.size());
        } finally {
            dd.deleteData("user","userName","TestStudent");
            dd.deleteData("user","userName","TestMentor");
        }
    }

}
