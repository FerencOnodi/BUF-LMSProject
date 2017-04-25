import java.sql.SQLException;

/**
 * Created by vajni on 2017.04.24..
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        DataSelection dd = new DataSelection();
        System.out.println(dd.selectData("vajni@gmail.com","user",
                "Email", "vajni@gmail.com"));
    }
}
