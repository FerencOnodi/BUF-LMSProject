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
    public void testDelete() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        dd.deleteData("user","userName","testuser");
        String result = ds.selectData("testuser@test.test","user","userName","testuser");
        assertEquals("", result);
    }

    @Test
    public  void testDeleteInt() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        int userid = Integer.parseInt(ds.selectDataByHeader("UserID","user","Email","testuser@test.test"));
        di.insertAssignment("Test","This is a test",10,10,"yes","yes",userid);
        int firstCount = ds.countRows("assignment");
        dd.deleteData("assignment","MaxPoints",10);
        int secondCount = ds.countRows("assignment");
        try {
            assertEquals(firstCount-1,secondCount);
        } finally {
            dd.deleteData("assignment","Title","Test");
            dd.deleteData("user","userName","testuser");
        }
    }


}
