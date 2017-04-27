import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marton on 2017.04.26..
 */
public class DataInsertionTest {

    DataInsertion di = new DataInsertion();
    DataSelection ds = new DataSelection();
    DataDeletion dd = new DataDeletion();

    @Test
        public void testUserInsertion() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        String result = ds.selectData("testuser@test.test","user","userName","testuser");
        try {
            assertEquals("testuser@test.test",result);
        }
        finally {
            dd.deleteData("user","userName","testuser");
        }




    }

    @Test
    public void testAssignmentInsertion() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        int userid = Integer.parseInt(ds.selectDataByHeader("UserID","user","Email","testuser@test.test"));
        int firstCount = ds.countRows("assignment");
        di.insertAssignment("Test","This is a test",10,10,"yes","yes",userid);
        int secondCount = ds.countRows("assignment");
        try {
            assertEquals(firstCount + 1, secondCount);
        } finally {
            dd.deleteData("assignment","Title","Test");
            dd.deleteData("user","userName","testuser");
        }

    }



}
