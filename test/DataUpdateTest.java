import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marton on 2017.04.26..
 */
public class DataUpdateTest {

    DataInsertion di = new DataInsertion();
    DataUpdate du = new DataUpdate();
    DataSelection ds = new DataSelection();
    DataDeletion dd = new DataDeletion();

    @Test
    public void testUpdate() throws SQLException {
        di.insertUser("testuser", "testuser@test.test", "Student", "123");
        String result = ds.selectData("testuser", "user", "Email", "testuser@test.test");
        du.updateData("user","userName","updateduser","Password","123");
        String updatedResult = ds.selectData("updateduser", "user", "Email", "testuser@test.test");
        try {
            assertEquals(false,result.equals(updatedResult));
        } finally {
            dd.deleteData("user", "userName", "updateduser");
        }
    }

    @Test
    public void testUpdateInt() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        int userid = Integer.parseInt(ds.selectDataByHeader("UserID","user","Email","testuser@test.test"));
        di.insertAssignment("Test","This is a test",10,10,"yes","yes",userid);
        du.updateData("assignment","Title","TestUpdated","MaxPoints",10);
        String result = ds.selectDataByHeader("Title","assignment","Content","This is a test");
        try {
            assertEquals("TestUpdated",result);

        } finally {
            dd.deleteData("assignment","Content","This is a test");
            dd.deleteData("user","userName","testuser");
        }
    }



}
