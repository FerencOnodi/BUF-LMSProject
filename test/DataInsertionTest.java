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
    public void testInsertion() throws SQLException {
        di.insertUser("testuser", "testuser@test.test","Student","123");
        String result = ds.selectData("testuser@testuser.test","user","userName","testuser");
        try {
            assertEquals("testuser@testuser.test",result);
        }
        finally {
            dd.deleteData("user","userName","testuser");
        }



    }




}
