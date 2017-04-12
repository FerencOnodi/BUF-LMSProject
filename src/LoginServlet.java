import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vajni on 2017.03.28..
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private String email;
    private String password;
    DataWriter dwri = new DataWriter();
    DataValidator dval = new DataValidator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.email = request.getParameter("email");
        this.password = request.getParameter("password");
        String path = request.getServletContext().getRealPath("/UserPassword.txt");
        boolean validate = dval.dataValidator(email,password, path);

        if (validate == false){
            response.sendRedirect("./LoginPageAlert.html");
        }else {
            request.setAttribute("email", this.email);
            RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");

            ProfileParser parser = new ProfileParser();
            parser.profileParser();
            String name;
            for (String[] data : parser.usersData) {
                if (data[1].equals(email)) {
                    name = data[0];
                    String role = data[3];

                    Cookie cookieUser = new Cookie("user", name.replace(" ","_"));
                    Cookie cookieRole = new Cookie("role", role);
                    cookieUser.setMaxAge(30*60);
                    response.addCookie(cookieUser);
                    response.addCookie(cookieRole);
                    rd.forward(request, response);
                    response.sendRedirect("./UserProfile.html");
                }

            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
