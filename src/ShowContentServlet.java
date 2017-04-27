import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "ShowContentServlet")
public class ShowContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = "";
        DataParser dataParser = new DataParser();
        List<List<String>> contentData = null;
        String title = request.getParameter("title");

        try {
            contentData = dataParser.assignmentDataParser();
            for (List element: contentData) {
                if(title.equals(element.get(0))) {
                content += "<p>" + element.get(1) + "</p>";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        ShowContentPage showContentPage = new ShowContentPage();
        out.println(showContentPage.generatePage(title, content));
    }
}
