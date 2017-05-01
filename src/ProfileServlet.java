import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by ferenc on 2017.03.30..
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "";
        String role = "";
        String mail = "";
        String cookieName = "";
        String cookieRole = "";
        Cookie[] cookies = request.getCookies();

        cookieName = cookies[0].getValue().replace("_", " ");
        cookieRole = cookies[1].getValue();

        DataSelection dataSelection = new DataSelection();
        try {
            name = dataSelection.selectData(cookieName, "user", "UserName", cookieName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            role = dataSelection.selectData(cookieRole, "user", "UserName", cookieName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            mail = dataSelection.selectDataByHeader("Email", "user", "UserName", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("role", role);

        ProfilePage profilePage = new ProfilePage();
        PrintWriter out = response.getWriter();
        out.println(profilePage.generatePage(name, mail, role));
    }
}
