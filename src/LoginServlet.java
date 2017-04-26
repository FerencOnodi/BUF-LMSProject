import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by vajni on 2017.03.28..
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private String email;
    private String password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.email = request.getParameter("email");
        this.password = request.getParameter("password");
        DataSelection dataSelection = new DataSelection();
        String emailValidator = "";
        String passwordValidator = "";
        try {
            emailValidator = dataSelection.selectData(email,"user", "Email", email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            passwordValidator = dataSelection.selectData(password,"user",
                    "Email", email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!email.equals(emailValidator) || !password.equals(passwordValidator)){
            response.sendRedirect("./LoginPageAlert.html");
        }else {
            request.setAttribute("email", this.email);
            RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");

            String userName = "";
            String role = "";

            try {
                userName = dataSelection.selectDataByHeader("UserName","user", "Email", email);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                role = dataSelection.selectDataByHeader("Role","user", "Email", email);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Cookie cookieUser = new Cookie("user", userName.replace(" ","_"));
            Cookie cookieRole = new Cookie("role", role);
            cookieUser.setMaxAge(30*60);
            cookieRole.setMaxAge(30*60);
            response.addCookie(cookieUser);
            response.addCookie(cookieRole);
            rd.forward(request, response);
            response.sendRedirect("./UserProfile.html");

                }

            }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
