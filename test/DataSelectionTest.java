import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marton on 2017.04.26..
 */
public class DataSelectionTest {

    DataInsertion di = new DataInsertion();
    DataSelection ds = new DataSelection();
    DataDeletion dd = new DataDeletion();

    @Test
    public void testSelection() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        String result = ds.selectData("testuser@test.test","user","userName","testuser");
        try {

            assertEquals("testuser@test.test", result);
        }
        finally {

            dd.deleteData("user","userName","testuser");
        }
    }

    @Test
    public void testRowsCount() throws SQLException {
        int firstCount = ds.countRows("user");
        di.insertUser("countTest","count@test.test","Student","test");
        int secondCount = ds.countRows("user");
        try {
            assertEquals(firstCount + 1,secondCount);
        } finally {
            dd.deleteData("user","Email","count@test.test");
        }
    }
    @Test
    public void testSelectionByHeader() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        String result = ds.selectDataByHeader("Email","user","UserName","testuser");
        try {
            assertEquals("testuser@test.test",result);
        } finally {
            dd.deleteData("user","Email","testuser@test.test");
        }
    }

}
