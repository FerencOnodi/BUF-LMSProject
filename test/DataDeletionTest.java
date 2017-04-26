import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by marton on 2017.04.26..
 */
public class DataDeletionTest {

    DataInsertion di = new DataInsertion();
    DataSelection ds = new DataSelection();
    DataDeletion dd = new DataDeletion();

    @Test
    public void testInsertion() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        dd.deleteData("user","userName","testuser");
        String result = ds.selectData("testuser@testuser.test","user","userName","testuser");
        assertEquals("", result);
    }

    public static void main(String[] args) throws SQLException {

        DataInsertion di = new DataInsertion();
        DataSelection ds = new DataSelection();
        DataDeletion dd = new DataDeletion();

        di.insertUser("testuser", "testuser@test.test","Student","123");
        dd.deleteData("user","userName","testuser");
        String result = ds.selectData("testuser@testuser.test","user","userName","testuser");
        System.out.println(result);
        System.out.println("That's all folks!");

    }
}
