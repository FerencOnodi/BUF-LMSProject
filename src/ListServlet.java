import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ferenc on 2017.03.30..
 */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = "";

        Cookie[] cookies = request.getCookies();
        String cookieRole = cookies[2].getValue();
        DataParser dd = new DataParser();
        List<List<String>> usersData = null;

        if (cookieRole.equals("Mentor")) {
            try {
                usersData = dd.listDataParser("Mentor");
                for (List element : usersData) {
                    content += "<tr><td>" + element.get(0) + "</td><td>" + element.get(1) +
                            "</td><td>" + element.get(2) + "</td></tr><br>";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            try {
                usersData = dd.listDataParser("Student");
                for (List element : usersData) {
                    content += "<tr><td>" + element.get(0) + "</td><td>" + element.get(1) +
                            "</td><td>" + element.get(2) + "</td></tr><br>";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        PrintWriter out = response.getWriter();

        ListPage listPage = new ListPage();
        out.println(listPage.generateListPage(content));
    }
}
