import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by vajni on 2017.04.24..
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        DataParser dd = new DataParser();
        List<List<String>> dicsak = dd.listDataParser("Student");
        for (List item : dicsak){
            System.out.println(item.get(1));
            }
        }

    }
