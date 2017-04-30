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
 * Created by ferenc on 2017.04.27..
 */
@WebServlet(name = "CVServlet")
public class CVServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String cookieRole = cookies[1].getValue();
        DataParser dataParser = new DataParser();
        List<List<String>> assData = null;

        String content = "";

        try {
            assData = dataParser.assignmentDataParser();
            for (List element: assData) {
                content += "<li><a href=" + "\"ShowContentServlet?" + "title=" + element.get(0) + "\"" + "target=\"_blank\">"
                        + element.get(0) + "</a></li>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        CVPage cvPage = new CVPage();

        if (cookieRole.equals("Mentor")) {
            out.println(cvPage.generateMentorPage(content));
        } else {
            out.println(cvPage.generateStudentPage(content));
        }
    }
}
