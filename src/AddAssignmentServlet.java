import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by ferenc on 2017.04.27..
 */
@WebServlet(name = "AddAssignmentServlet")
public class AddAssignmentServlet extends HttpServlet {

    String title;
    String content;
    int maxPoints;
    int score;
    String subReq;
    String published;
    DataInsertion dataInsertion = new DataInsertion();
    DataSelection dataSelection = new DataSelection();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

        Cookie[] cookies = request.getCookies();
        String username = cookies[1].getValue().replace("_", " ");

        int id = 0;
        try {
            id = Integer.parseInt(dataSelection.selectDataByHeader("UserID", "user", "UserName", username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.title = request.getParameter("title");
        this.content = request.getParameter("content");
        String strPoints = request.getParameter("point");
        this.maxPoints = Integer.parseInt(strPoints);
        this.score = 0;
        if (this.maxPoints > 0) {
            this.subReq = "yes";
        } else {
            this.subReq = "no";
        }
        this.published = request.getParameter("published");

        
        try {
            dataInsertion.insertAssignment(title, content, maxPoints, score, subReq, published, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("/CVPage.html");
    }
}
